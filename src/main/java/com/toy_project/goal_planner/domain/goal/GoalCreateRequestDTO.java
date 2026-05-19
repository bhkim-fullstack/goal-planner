package com.toy_project.goal_planner.domain.goal;

import jakarta.validation.constraints.NotBlank;

public class GoalCreateRequestDTO {
    @NotBlank
    private String title;

    private String description;
}
