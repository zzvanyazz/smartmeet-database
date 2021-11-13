package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.users.UserModel;
import com.lemonado.smartmeet.core.data.models.users.builders.UserModelBuilder;
import com.lemonado.smartmeet.database.data.modes.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserModel model) {
        if (model == null)
            return null;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(model.id());
        userEntity.setUsername(model.username());
        userEntity.setPasswordHash(model.passwordHash());
        userEntity.setEmail(model.email());
        userEntity.setDeleteTimestamp(model.deleteTimestamp());
        userEntity.setValidTokenTimestamp(model.validTokenTimestamp());
        return userEntity;
    }

    public static UserModel toModel(UserEntity entity) {
        if (entity == null)
            return null;
        var userModelBuilder = new UserModelBuilder();
        userModelBuilder.withId(entity.getId());
        userModelBuilder.withUsername(entity.getUsername());
        userModelBuilder.withPasswordHash(entity.getPasswordHash());
        userModelBuilder.withEmail(entity.getEmail());
        userModelBuilder.withDeleteTimestamp(entity.getDeleteTimestamp());
        userModelBuilder.withValidTokenTimestamp(entity.getValidTokenTimestamp());
        return userModelBuilder.build();
    }

}
