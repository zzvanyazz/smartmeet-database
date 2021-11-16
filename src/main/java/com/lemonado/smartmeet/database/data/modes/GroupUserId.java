package com.lemonado.smartmeet.database.data.modes;

import java.io.Serializable;

public record GroupUserId(
        long userId,
        long groupId) implements Serializable {

}
