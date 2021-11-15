package com.lemonado.smartmeet.database.data.modes;


import com.lemonado.smartmeet.core.data.models.group.AddedUserStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_users")
@IdClass(GroupUserId.class)
public class GroupUserEntity {

    @Id
    public GroupUserId id;

    @ManyToOne
    public GroupEntity group;

    @ManyToOne
    public UserEntity user;

    @Column
    public AddedUserStatus status;

    @Column
    public LocalDateTime inviteTime;

    public GroupUserId getId() {
        return id;
    }

    public void setId(GroupUserId id) {
        this.id = id;
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
