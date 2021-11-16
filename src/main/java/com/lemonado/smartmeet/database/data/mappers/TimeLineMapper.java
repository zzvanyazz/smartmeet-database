package com.lemonado.smartmeet.database.data.mappers;

import com.lemonado.smartmeet.core.data.models.timeline.TimeLineModel;
import com.lemonado.smartmeet.core.data.models.timeline.bilders.TimeLineBuilder;
import com.lemonado.smartmeet.database.data.modes.TimeLineEntity;
import com.lemonado.smartmeet.database.data.options.MappingOptions;

public class TimeLineMapper {


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


    public static TimeLineModel toModel(TimeLineEntity entity) {
        return toModel(entity, MappingOptions.DEFAULT_MAPPING_DEPTH);
    }

    public static TimeLineModel toModel(TimeLineEntity entity, int groupId) {
        if (entity == null || groupId-- == 0)
            return null;

        var group = GroupMapper.toModel(entity.getGroup(), groupId);
        var user = UserMapper.toModel(entity.getUser(), groupId);

        return TimeLineBuilder.builder()
                .withId(entity.getId())
                .withStartDate(entity.getStartDate())
                .withEndDate(entity.getEndDate())
                .withGroupModel(group)
                .withUser(user)
                .withTimeLineType(entity.getTimeLineType())
                .build();
    }


}
