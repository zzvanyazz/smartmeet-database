package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.registration.StartRegistrationModel;
import com.lemonado.smartmeet.core.data.models.registration.builders.StartRegistrationModelBuilder;
import com.lemonado.smartmeet.database.data.modes.RegistrationCodeEntity;

public class RegistrationCodeMapper {

    public static RegistrationCodeEntity toEntity(String email, String code, long roleId) {
        RegistrationCodeEntity registrationCodeEntity = new RegistrationCodeEntity();
        registrationCodeEntity.setRegistrationCode(code);
        registrationCodeEntity.setEmail(email);
        registrationCodeEntity.setRoleId(roleId);
        return registrationCodeEntity;
    }

    public static StartRegistrationModel toModel(RegistrationCodeEntity entity) {
        if (entity == null)
            return null;
        return new StartRegistrationModelBuilder()
                .withRegistrationCode(entity.getRegistrationCode())
                .withEmail(entity.getEmail())
                .withRoleId(entity.getRoleId())
                .build();
    }

}
