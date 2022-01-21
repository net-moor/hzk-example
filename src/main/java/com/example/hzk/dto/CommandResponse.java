package com.example.hzk.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nikolay_Batov on 21.01.2022
 */
@Getter
@Setter
public class CommandResponse {

    private final String value;

    public CommandResponse(String value) {
        this.value = value;
    }
}
