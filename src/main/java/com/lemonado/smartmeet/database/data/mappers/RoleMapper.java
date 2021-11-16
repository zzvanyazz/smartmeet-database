package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.roles.RoleModel;
import com.lemonado.smartmeet.database.data.modes.RoleEntity;

public class RoleMapper {

    public static RoleModel toModel(RoleEntity entity) {
        if (entity == null)
            return null;
        return RoleModel.builder()
                .withId(entity.getId())
                .withName(entity.getName())
                .withDescription(entity.getDescription())
                .withCreateTimestamp(entity.getCreateTimestamp())
                .withUpdateTimestamp(entity.getUpdateTimestamp())
                .build();
    }

    public static RoleEntity toEntity(RoleModel model) {
        if (model == null)
            return null;
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setId(model.id());
        roleEntity.setName(model.name());
        roleEntity.setDescription(model.description());
        roleEntity.setCreateTimestamp(model.createTimestamp());
        roleEntity.setUpdateTimestamp(model.updateTimestamp());
        return roleEntity;
    }

}
