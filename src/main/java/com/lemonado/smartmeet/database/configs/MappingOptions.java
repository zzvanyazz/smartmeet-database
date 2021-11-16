package com.lemonado.smartmeet.database.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MappingOptions {

    @Value("${mapping.depth}")
    private int depth;

    public int getDepth() {
        return depth;
    }
}
