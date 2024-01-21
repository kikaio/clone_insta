package com.clone.insta.repositories.Dsl;

import java.util.List;

import com.clone.insta.Entities.InstaUser;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InstaUserSearchImpl implements InstaUserSearch{

    private final JPAQueryFactory queryFactory;

    public List<InstaUser> searchUser(Long id)
    {
        return null;
    }

}
