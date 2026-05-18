package com.toy_project.goal_planner.domain.record;

import com.toy_project.goal_planner.domain.goal.Goal;
import com.toy_project.goal_planner.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "progress_records")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ProgressRecord extends BaseEntity {

    // 기록 고유 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기록 제목
    @Column(nullable = false)
    private String title;

    // 기록 내용 (최대 2000자)
    @Column(length = 2000)
    private String content;

    // 기록 시점의 목표 달성률 (0~100)
    @Builder.Default
    private int progress = 0;

    // 기록 날짜
    private LocalDate recordDate;

    // 기록이 속한 목표
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id")
    private Goal goal;
}