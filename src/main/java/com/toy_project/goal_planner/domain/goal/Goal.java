package com.toy_project.goal_planner.domain.goal;

import com.toy_project.goal_planner.domain.milestone.Milestone;
import com.toy_project.goal_planner.domain.record.ProgressRecord;
import com.toy_project.goal_planner.domain.user.User;
import com.toy_project.goal_planner.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goals")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Goal extends BaseEntity {

    // 목표 고유 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 목표 제목
    @Column(nullable = false)
    private String title;

    // 목표 상세 설명 (최대 1000자)
    @Column(length = 1000)
    private String description;

    // 목표 달성률 (0~100)
    @Builder.Default
    private int progress = 0;

    // 목표 진행 상태
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private GoalStatus status = GoalStatus.NOT_STARTED;

    // 목표 시작일
    private LocalDate startDate;

    // 목표 완료 예정일
    private LocalDate targetDate;

    // 목표를 소유한 사용자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "goal")
    @Builder.Default
    private List<Milestone> milestones = new ArrayList<>();

    @OneToMany(mappedBy = "goal")
    @Builder.Default
    private List<ProgressRecord> progressRecords = new ArrayList<>();
}
