package com.clone.insta.Entities;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Profile {

    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @Column
    private Long accountId;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column
    @ColumnDefault("0")
    private Integer postCnt;

    @Column
    @ColumnDefault("0")
    private Integer followerCnt;

    @Column
    @ColumnDefault("0")
    private Integer followeeCnt;

}
