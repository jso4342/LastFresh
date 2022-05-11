package com.example.lastfresh.domain.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER")
@Getter
@ToString
@NoArgsConstructor
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NUM")
    private Long userNum;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "USER_PW")
    private String userPw;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_EMAIL")
    private String userEmail;
    @Column(name = "USER_ADDRESS")
    private String userAddress;
    @Column(name = "USER_ADDRESS_DETAIL")
    private String userAddressDetail;
    @Column(name = "USER_ADDRESS_POST_NUM")
    private String userAddressPostNum;
    @Column(name = "USER_PHONE")
    private String userPhone;
    @Column(name = "USER_KAKAO")
    private String userKakao;
    /* 1. 판매자, 2. 회원, 3. 라이더, -1. 탈퇴*/
    @Column(name = "USER_STATUS")
    private String userStatus;

    @Builder
    public UserVO(Long userNum, String userId, String userPw, String userName, String userEmail, String userAddress, String userAddressDetail, String userAddressPostNum, String userPhone, String userKakao, String userStatus) {
        this.userNum = userNum;
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userAddressDetail = userAddressDetail;
        this.userAddressPostNum = userAddressPostNum;
        this.userPhone = userPhone;
        this.userKakao = userKakao;
        this.userStatus = userStatus;
    }
}
