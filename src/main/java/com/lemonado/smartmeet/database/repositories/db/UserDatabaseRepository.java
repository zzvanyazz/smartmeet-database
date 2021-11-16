package com.lemonado.smartmeet.database.repositories.db;

import com.lemonado.smartmeet.database.data.modes.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDatabaseRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.deleteTimestamp IS NULL")
    Optional<UserEntity> findAlive(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.deleteTimestamp IS NULL")
    Optional<UserEntity> findActiveByName(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.id = :id AND u.deleteTimestamp IS NULL")
    Optional<UserEntity> findActiveById(long id);

    boolean existsByUsername(String userName);

    boolean existsByEmail(String email);

}
