package com.toy_project.goal_planner.domain.user;

import com.toy_project.goal_planner.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    // 사용자 고유 식별자
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 이메일 (로그인 ID)
    @Column(nullable = false, unique = true)
    private String email;

    // 사용자 비밀번호 (암호화 저장)
    @Column(nullable = false)
    private String password;

    // 사용자 닉네임
    @Column(nullable = false)
    private String nickname;
}