package com.lemonado.smartmeet.database.repositories.db;

import com.lemonado.smartmeet.database.data.modes.RegistrationCodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationCodesDatabaseRepository extends CrudRepository<RegistrationCodeEntity, String> {

    Optional<RegistrationCodeEntity> getByRegistrationCode(String code);

    void deleteByRegistrationCode(String registrationCode);

    void deleteAllByEmail(String email);

    boolean existsByEmail(String email);

}
