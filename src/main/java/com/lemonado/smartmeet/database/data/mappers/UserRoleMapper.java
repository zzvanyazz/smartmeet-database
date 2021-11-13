package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.users.UserRoleModel;
import com.lemonado.smartmeet.database.data.modes.UserRoleEntity;
import com.lemonado.smartmeet.database.data.modes.UserRoleKey;

public class UserRoleMapper {


    public static UserRoleKey toKey(long userId, long roleId) {
        UserRoleKey userRoleKey = new UserRoleKey();
        userRoleKey.setUserId(userId);
        userRoleKey.setRoleId(roleId);
        return userRoleKey;
    }


    public static UserRoleEntity toEntity(long userId, long roleId) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUserId(userId);
        userRoleEntity.setRoleId(roleId);
        return userRoleEntity;
    }

    public static UserRoleModel toModel(UserRoleEntity entity) {
        return new UserRoleModel(entity.getUserId(), entity.getRoleId());
    }

    public static UserRoleEntity toEntity(UserRoleModel model) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setUserId(model.userId());
        userRoleEntity.setRoleId(model.roleId());
        return userRoleEntity;
    }

}
