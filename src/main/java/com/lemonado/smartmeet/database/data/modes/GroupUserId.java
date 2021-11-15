package com.lemonado.smartmeet.database.data.modes;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GroupUserId implements Serializable{

    private long userId;

    private long groupId;

    public GroupUserId(long userId, long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }

    public GroupUserId() {

    }
}
