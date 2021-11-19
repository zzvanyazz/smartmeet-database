package com.lemonado.smartmeet.database.repositories.impl;

import com.lemonado.smartmeet.core.data.models.group.GroupModel;
import com.lemonado.smartmeet.core.repositories.GroupRepository;
import com.lemonado.smartmeet.core.repositories.events.OnNewEventListening;
import com.lemonado.smartmeet.core.repositories.events.OnUpdateEventListening;
import com.lemonado.smartmeet.database.data.mappers.GroupMapper;
import com.lemonado.smartmeet.database.data.mappers.ListMapper;
import com.lemonado.smartmeet.database.repositories.db.GroupDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired
    public GroupDatabaseRepository groupRepository;


    @Override
    @OnNewEventListening
    public GroupModel save(GroupModel groupModel) {
        var groupEntity = GroupMapper.toEntity(groupModel);
        groupEntity = groupRepository.save(groupEntity);
        return GroupMapper.toModel(groupEntity);
    }

    @Override
    public boolean existsById(long id) {
        return groupRepository.existsById(id);
    }

    @Override
    public boolean existsInGroup(long groupId, long userId) {
        return groupRepository.existsByIdAndCreator_Id(groupId, userId);
    }

    @Override
    public Optional<GroupModel> getGroupById(long id) {
        return groupRepository.findById(id)
                .map(GroupMapper::toModel);
    }

    @Override
    public Optional<GroupModel> getGroupByCode(String code) {
        return groupRepository.findByCode(code)
                .map(GroupMapper::toModel);
    }

    @Override
    @OnUpdateEventListening
    public GroupModel update(GroupModel groupModel) {
        return save(groupModel);
    }

    @Override
    public Set<GroupModel> getGroupsByUser(long userId) {
        return ListMapper.mapToSet(
                groupRepository.findAllByCreator_Id(userId),
                GroupMapper::toModel);
    }

}
