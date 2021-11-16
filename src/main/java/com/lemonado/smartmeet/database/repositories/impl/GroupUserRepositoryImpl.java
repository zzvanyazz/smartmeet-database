package com.lemonado.smartmeet.database.repositories.impl;

import com.lemonado.smartmeet.core.data.models.group.GroupUserModel;
import com.lemonado.smartmeet.core.repositories.GroupUsersRepository;
import com.lemonado.smartmeet.database.data.mappers.GroupUserMapper;
import com.lemonado.smartmeet.database.data.modes.GroupUserId;
import com.lemonado.smartmeet.database.repositories.db.GroupUserDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GroupUserRepositoryImpl implements GroupUsersRepository {

    @Autowired
    public GroupUserDatabaseRepository repository;

    @Override
    public GroupUserModel save(GroupUserModel groupUserModel) {
        var entity = GroupUserMapper.toEntity(groupUserModel);
        entity =  repository.save(entity);
        return GroupUserMapper.toModel(entity);
    }

    @Override
    public GroupUserModel remove(GroupUserModel groupUserModel) {
        var entity = GroupUserMapper.toEntity(groupUserModel);
        repository.delete(entity);
        return GroupUserMapper.toModel(entity);
    }

    @Override
    public Optional<GroupUserModel> getByGroupAndUser(long groupId, long userId) {
        var id = new GroupUserId(groupId, userId);
        return repository.findById(id)
                .map(GroupUserMapper::toModel);
    }

    @Override
    public List<GroupUserModel> findAllByGroup(long groupId) {
        return repository.findAllByGroup_Id(groupId)
                .stream()
                .map(GroupUserMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupUserModel> findAllByUser(long userId) {
        return repository.findAllByUser_Id(userId)
                .stream()
                .map(GroupUserMapper::toModel)
                .collect(Collectors.toList());
    }
}
