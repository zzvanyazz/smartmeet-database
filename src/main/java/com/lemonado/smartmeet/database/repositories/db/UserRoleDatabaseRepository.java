package com.lemonado.smartmeet.database.repositories.db;

import com.lemonado.smartmeet.database.data.modes.UserRoleEntity;
import com.lemonado.smartmeet.database.data.modes.UserRoleKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDatabaseRepository extends CrudRepository<UserRoleEntity, UserRoleKey> {
    List<UserRoleEntity> findAllByUserId(Long userName);

}
