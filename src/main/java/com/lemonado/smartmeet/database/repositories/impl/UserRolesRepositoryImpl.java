package com.lemonado.smartmeet.database.repositories.impl;

import com.lemonado.smartmeet.core.data.models.users.UserRoleModel;
import com.lemonado.smartmeet.core.repositories.UserRolesRepository;
import com.lemonado.smartmeet.database.data.mappers.UserRoleMapper;
import com.lemonado.smartmeet.database.repositories.db.UserRoleDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRolesRepositoryImpl implements UserRolesRepository {

    @Autowired
    private UserRoleDatabaseRepository userRoleDatabaseRepository;

    @Override
    public List<UserRoleModel> findByUserId(long userId) {
        return userRoleDatabaseRepository.findAllByUserId(userId)
                .stream()
                .map(UserRoleMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void saveAssign(long userId, long roleId) {
        var entity = UserRoleMapper.toEntity(userId, roleId);
        userRoleDatabaseRepository.save(entity);
    }

    @Override
    public void removeAssign(long userId, long roleId) {
        var entity = UserRoleMapper.toEntity(userId, roleId);
        userRoleDatabaseRepository.delete(entity);
    }

    @Override
    public boolean isExists(long userId, long roleId) {
        var key = UserRoleMapper.toKey(userId, roleId);
        return userRoleDatabaseRepository.existsById(key);
    }

}
