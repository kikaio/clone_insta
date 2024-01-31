package com.clone.insta.dto;

import com.clone.insta.Entities.Profile;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileDTO {
    //profile img
    //
    //nickname
    private String nickname;
    //post cnt
    private Long postCnt;
    //follower cnt
    private Long followerCnt;
    //followee cnt
    private Long followeeCnt;

    public void fromEntity(Profile entity, Long postCnt, Long followerCnt, Long followeeCnt)
    {
        this.nickname = entity.getNickname();
        this.postCnt = postCnt;
        this.followeeCnt = followeeCnt;
        this.followerCnt = followerCnt;
    }
}
