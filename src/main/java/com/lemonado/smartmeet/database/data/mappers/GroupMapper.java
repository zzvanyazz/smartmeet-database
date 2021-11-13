package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.group.GroupModel;
import com.lemonado.smartmeet.core.data.models.group.GroupModelBuilder;
import com.lemonado.smartmeet.database.data.modes.GroupEntity;

public class GroupMapper {

    public static GroupEntity toEntity(GroupModel groupModel) {
        if (groupModel == null)
            return null;
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(groupModel.id());
        groupEntity.setName(groupModel.name());

        var creator = UserMapper.toEntity(groupModel.creator());
        groupEntity.setCreator(creator);

        groupEntity.setCode(groupModel.code());
        groupEntity.setUsers(ListMapper.mapToSet(groupModel.users(), UserMapper::toEntity));

        return groupEntity;
    }

    public static GroupModel toModel(GroupEntity groupEntity) {
        if (groupEntity == null)
            return null;
        return new GroupModelBuilder()
                .withId(groupEntity.getId())
                .withName(groupEntity.getName())
                .withCreator(UserMapper.toModel(groupEntity.getCreator()))
                .withCode(groupEntity.getCode())
                .withUsers(ListMapper.mapToSet(groupEntity.getUsers(), UserMapper::toModel))
                .build();
    }

}
