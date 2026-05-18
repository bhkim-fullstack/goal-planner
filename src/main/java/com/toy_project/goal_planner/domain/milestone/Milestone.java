package com.toy_project.goal_planner.domain.milestone;

import com.toy_project.goal_planner.domain.goal.Goal;
import com.toy_project.goal_planner.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "milestones")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Milestone extends BaseEntity {

    // 마일스톤 고유 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 마일스톤 제목
    @Column(nullable = false)
    private String title;

    // 마일스톤 상세 설명 (최대 1000자)
    @Column(length = 1000)
    private String description;

    // 마일스톤 순서 (목표 내 정렬 기준)
    private int sequence;

    // 마일스톤 완료 여부
    @Builder.Default
    private boolean completed = false;

    // 마일스톤 완료 일시
    private LocalDateTime completedAt;

    // 마일스톤이 속한 목표
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    private Goal goal;
}