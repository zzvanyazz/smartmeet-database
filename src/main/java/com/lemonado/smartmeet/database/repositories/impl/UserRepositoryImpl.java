package com.lemonado.smartmeet.database.repositories.impl;

import com.lemonado.smartmeet.core.data.models.users.UserModel;
import com.lemonado.smartmeet.core.repositories.UserRepository;
import com.lemonado.smartmeet.core.repositories.events.OnNewEventListening;
import com.lemonado.smartmeet.database.data.mappers.UserMapper;
import com.lemonado.smartmeet.database.repositories.db.UserDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDatabaseRepository userDatabaseRepository;

    @Override
    public List<UserModel> getAll() {
        var allUsersIterable = userDatabaseRepository.findAll();
        return StreamSupport
                .stream(allUsersIterable.spliterator(), false)
                .map(UserMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserModel> findLive(String email) {
        return userDatabaseRepository.findAlive(email)
                .map(UserMapper::toModel);
    }

    @Override
    public Optional<UserModel> findActive(Long id) {
        return userDatabaseRepository.findActiveById(id)
                .map(UserMapper::toModel);
    }

    @Override
    public boolean existsById(long id) {
        return userDatabaseRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userDatabaseRepository.existsByEmail(email);
    }


    @Override
    public Optional<UserModel> getUser(long userId) {
        return userDatabaseRepository.findById(userId).map(UserMapper::toModel);
    }


    @Override
    @OnNewEventListening
    public UserModel save(UserModel data) {
        var userEntity = UserMapper.toEntity(data);
        userEntity = userDatabaseRepository.save(userEntity);
        return UserMapper.toModel(userEntity);
    }

   /* @Override
    public UserModel update(UserModel data) {
        var userEntity = UserMapper.toEntity(data);
        userEntity = userDatabaseRepository.save(userEntity);
        return UserMapper.toModel(userEntity);
    }

    @Override
    public void remove(UserModel data) {
        var userEntity = UserMapper.toEntity(data);
        userDatabaseRepository.delete(userEntity);
    }*/
}
