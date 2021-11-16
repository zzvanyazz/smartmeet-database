package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.users.UserModel;
import com.lemonado.smartmeet.core.data.models.users.builders.UserModelBuilder;
import com.lemonado.smartmeet.database.data.modes.UserEntity;
import com.lemonado.smartmeet.database.data.options.MappingOptions;

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
        return toModel(entity, MappingOptions.DEFAULT_MAPPING_DEPTH);
    }

    public static UserModel toModel(UserEntity entity, int depth) {
        if (entity == null || depth == 0)
            return null;
        var userModelBuilder = UserModelBuilder.builder()
                .withId(entity.getId())
                .withUsername(entity.getUsername())
                .withPasswordHash(entity.getPasswordHash())
                .withEmail(entity.getEmail())
                .withDeleteTimestamp(entity.getDeleteTimestamp())
                .withValidTokenTimestamp(entity.getValidTokenTimestamp());
        return userModelBuilder.build();
    }

}
