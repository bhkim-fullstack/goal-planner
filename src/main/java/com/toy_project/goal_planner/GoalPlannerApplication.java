package com.toy_project.goal_planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GoalPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoalPlannerApplication.class, args);
	}

}
