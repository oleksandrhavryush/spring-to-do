package com.havriush.controller;

import com.havriush.domain.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRequestDTO {
    private String description;
    private Status status;
}
