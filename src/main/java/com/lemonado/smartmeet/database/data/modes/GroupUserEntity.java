package com.lemonado.smartmeet.database.data.modes;


import com.lemonado.smartmeet.core.data.models.group.AddedUserStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_users")
@IdClass(GroupUserId.class)
public class GroupUserEntity {

    @Id
    @Column(name = "group_id")
    public long groupId;

    @Id
    @Column(name = "user_id")
    public long userId;

    @ManyToOne
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    public GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public UserEntity user;

    @Column
    public AddedUserStatus status;

    @Column
    public LocalDateTime inviteTime;

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public GroupEntity getGroup() {
        return group;
    }



    public UserEntity getUser() {
        return user;
    }



    public AddedUserStatus getStatus() {
        return status;
    }

    public void setStatus(AddedUserStatus status) {
        this.status = status;
    }

    public LocalDateTime getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(LocalDateTime inviteTime) {
        this.inviteTime = inviteTime;
    }
}
