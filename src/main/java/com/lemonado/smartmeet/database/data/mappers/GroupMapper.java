package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.group.GroupModel;
import com.lemonado.smartmeet.core.data.models.group.builder.GroupModelBuilder;
import com.lemonado.smartmeet.database.data.modes.GroupEntity;

public class GroupMapper {

    public static GroupEntity toEntity(GroupModel groupModel) {
        if (groupModel == null)
            return null;
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(groupModel.id());
        groupEntity.setName(groupModel.name());
        groupEntity.setCreator(UserMapper.toEntity(groupModel.creator()));
        groupEntity.setCode(groupModel.code());

        return groupEntity;
    }

    public static GroupModel toModel(GroupEntity groupEntity) {
        return toModel(groupEntity, 3);
    }

    public static GroupModel toModel(GroupEntity groupEntity, int depth) {
        if (groupEntity == null || depth-- == 0)
            return null;

        var creator = UserMapper.toModel(groupEntity.getCreator(), depth);

        final var d = depth;
        var users = ListMapper.mapToSet(groupEntity.getUsers(), user -> GroupUserMapper.toModel(user, d));

        return new GroupModelBuilder()
                .withId(groupEntity.getId())
                .withName(groupEntity.getName())
                .withCreator(creator)
                .withCode(groupEntity.getCode())
                .withUsers(users)
                .build();
    }

}
