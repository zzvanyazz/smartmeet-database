package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.group.GroupUserModel;
import com.lemonado.smartmeet.core.data.models.group.builder.GroupUserBuilder;
import com.lemonado.smartmeet.database.data.modes.GroupUserEntity;
import com.lemonado.smartmeet.database.data.modes.GroupUserId;
import com.lemonado.smartmeet.database.data.options.MappingOptions;

public class GroupUserMapper {

    public static GroupUserEntity toEntity(GroupUserModel groupUserModel) {
        var group = groupUserModel.groupModel();
        var user = groupUserModel.user();
        GroupUserEntity groupUserEntity = new GroupUserEntity();
        groupUserEntity.setId(new GroupUserId(user.id(), group.id()));
        groupUserEntity.setStatus(groupUserModel.status());
        groupUserEntity.setInviteTime(groupUserModel.inviteTime());
        return groupUserEntity;
    }

    public static GroupUserModel toModel(GroupUserEntity groupUserEntity) {
        return toModel(groupUserEntity, MappingOptions.DEFAULT_MAPPING_DEPTH);
    }

    public static GroupUserModel toModel(GroupUserEntity groupUserEntity, int depth) {
        if (groupUserEntity == null || depth-- == 0)
            return null;

        return GroupUserBuilder.builder()
                .withGroupModel(GroupMapper.toModel(groupUserEntity.getGroup(), depth))
                .withUser(UserMapper.toModel(groupUserEntity.getUser(), depth))
                .withStatus(groupUserEntity.getStatus())
                .withInviteTime(groupUserEntity.getInviteTime())
                .build();
    }

}
