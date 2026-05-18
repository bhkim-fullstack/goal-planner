package com.toy_project.goal_planner.goal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.toy_project.goal_planner.domain.goal.Goal;
import com.toy_project.goal_planner.domain.goal.GoalRepository;
import com.toy_project.goal_planner.domain.user.User;
import com.toy_project.goal_planner.domain.user.UserRepository;

import jakarta.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class GoalRepositoryTest {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveGoal() {
        // given
        User user = User.builder()
        .email("test@test.com")
        .password("1234")
        .nickname("tester")
        .build();

        userRepository.save(user);

        Goal goal = Goal.builder()
            .title("백엔드 개발자 되기")
            .description("꾸준히 성장하기")
            .progress(0)
            .user(user)
            .build();

        // when
        goalRepository.save(goal);

        Goal findGoal = goalRepository.findById(goal.getId())
            .orElseThrow();

        // then
        assertThat(findGoal.getTitle())
            .isEqualTo("백엔드 개발자 되기");
    }

}