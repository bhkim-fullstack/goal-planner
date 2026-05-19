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

// 실제 스프링 컨텍스트를 로드해 DB까지 통합 테스트
@SpringBootTest
// 테스트 후 DB 변경사항을 롤백해 데이터 오염 방지
@Transactional
class GoalRepositoryTest {

    @Autowired
    private GoalRepository goalRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveGoal() {
        // given: Goal 저장에 필요한 User를 먼저 생성 후 저장 (FK 제약조건 충족)
        User user = User.builder()
        .email("test@test.com")
        .password("1234")
        .nickname("tester")
        .build();

        userRepository.save(user);

        // given: 저장할 Goal 객체 생성
        Goal goal = Goal.builder()
            .title("백엔드 개발자 되기")
            .description("꾸준히 성장하기")
            .progress(0)
            .user(user)
            .build();

        // when: Goal 저장 후 반환된 ID로 다시 조회
        goalRepository.save(goal);

        Goal findGoal = goalRepository.findById(goal.getId())
            .orElseThrow();

        // then: 저장한 title과 조회한 title이 일치하는지 검증
        assertThat(findGoal.getTitle())
            .isEqualTo("백엔드 개발자 되기");
    }

}
