package com.lemonado.smartmeet.database.repositories.impl;

import com.lemonado.smartmeet.core.data.models.timeline.TimeLineModel;
import com.lemonado.smartmeet.core.repositories.TimeLineRepository;
import com.lemonado.smartmeet.database.data.mappers.TimeLineMapper;
import com.lemonado.smartmeet.database.repositories.db.TimeLineDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TimeLineRepositoryImpl implements TimeLineRepository {

    @Autowired
    private TimeLineDatabaseRepository timeLineRepository;

    @Override
    public List<TimeLineModel> findByGroupAndUser(long groupId, long userId) {
        return timeLineRepository.findAllByGroup_IdAndUser_Id(groupId, userId)
                .stream()
                .map(TimeLineMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<TimeLineModel> findByGroup(long groupId) {
        return timeLineRepository.findAllByGroup_Id(groupId)
                .stream()
                .map(TimeLineMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(TimeLineModel timeLineModel) {
        var entity = TimeLineMapper.toEntity(timeLineModel);
        timeLineRepository.delete(entity);
    }

    @Override
    public TimeLineModel update(TimeLineModel timeLineModel) {
        return save(timeLineModel);
    }

    @Override
    public TimeLineModel save(TimeLineModel model) {
        var entity = TimeLineMapper.toEntity(model);
        entity = timeLineRepository.save(entity);
        return TimeLineMapper.toModel(entity);
    }
}
