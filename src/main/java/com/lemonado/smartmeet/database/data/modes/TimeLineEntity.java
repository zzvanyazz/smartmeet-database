package com.lemonado.smartmeet.database.data.modes;

import com.lemonado.smartmeet.core.data.models.timeline.TimeLineType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "time_lines")
public class TimeLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @ManyToOne
    private GroupEntity group;

    @ManyToOne
    private UserEntity user;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TimeLineType timeLineType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity groupModel) {
        this.group = groupModel;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TimeLineType getTimeLineType() {
        return timeLineType;
    }

    public void setTimeLineType(TimeLineType timeLineType) {
        this.timeLineType = timeLineType;
    }
}
