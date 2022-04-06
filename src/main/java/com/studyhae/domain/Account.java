package com.studyhae.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickname;

    private String password;

    // 이메일을 인증할 것이기 때문에
    private boolean emailVerified;

    // 이메일을 검증할 때 사용할 토큰값
    private String emailCheckToken;

    // 인증 거친 날 = 가입날짜
    private LocalDateTime joinedAt;

    // 프로필 관련 - 자기소개
    private String bio;

    // 프로필 관련 - 웹페이지
    private String url;

    // 프로필 관련 - 직업
    private String occupation;

    private String location;

    // string들은 varchar2(255자)로 매핑이 된다
    // @Lob : text타입에 매핑해 준다.
    @Lob @Basic(fetch=FetchType.EAGER)
    private String profileImage;

    private boolean studyCreatedByEmail;

    private boolean studyCreatedByWeb;

    private boolean studyEnrollmentResultByEmail;

    private boolean studyEnrollmentResultByWeb;

    private boolean studyUpdatedByEmail;

    private boolean studyUpdatedByWeb;

}
