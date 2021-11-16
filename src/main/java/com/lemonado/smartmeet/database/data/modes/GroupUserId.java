package com.lemonado.smartmeet.database.data.modes;

import java.io.Serializable;

public class GroupUserId implements Serializable {
    private long userId;
    private long groupId;

    public GroupUserId() {
    }

    public GroupUserId(long groupId, long userId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
