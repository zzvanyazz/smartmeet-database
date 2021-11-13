package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.timeline.TimeLineModel;
import com.lemonado.smartmeet.core.data.models.timeline.bilders.TimeLineBuilder;
import com.lemonado.smartmeet.database.data.modes.TimeLineEntity;

public class TimeLineMapper {

    public static TimeLineModel toModel(TimeLineEntity entity) {
        if (entity == null)
            return null;
        var group = GroupMapper.toModel(entity.getGroup());
        var user = UserMapper.toModel(entity.getUser());
        return TimeLineBuilder.builder()
                .withId(entity.getId())
                .withStartDate(entity.getStartDate())
                .withEndDate(entity.getEndDate())
                .withGroupModel(group)
                .withUser(user)
                .withTimeLineType(entity.getTimeLineType())
                .build();
    }

    public static TimeLineEntity toEntity(TimeLineModel model) {
        if (model == null)
            return null;
        TimeLineEntity timeLineEntity = new TimeLineEntity();
        timeLineEntity.setId(model.id());
        timeLineEntity.setStartDate(model.startDate());
        timeLineEntity.setEndDate(model.endDate());
        timeLineEntity.setGroup(GroupMapper.toEntity(model.groupModel()));
        timeLineEntity.setUser(UserMapper.toEntity(model.user()));
        timeLineEntity.setTimeLineType(model.timeLineType());
        return timeLineEntity;
    }

}
