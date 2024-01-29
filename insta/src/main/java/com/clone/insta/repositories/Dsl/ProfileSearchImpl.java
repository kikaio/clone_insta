package com.clone.insta.repositories.Dsl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.clone.insta.Entities.Profile;
import com.clone.insta.Entities.QProfile;
import com.querydsl.jpa.JPQLQuery;

public class ProfileSearchImpl extends QuerydslRepositorySupport implements ProfileSearch{

    public ProfileSearchImpl()
    {
        super(Profile.class);
    }

    public Profile searchProfile(Long id)
    {
        return null;
    }

    public Page<Profile> searchProfiles(Pageable pageable, String nickname)
    {
        QProfile profile = QProfile.profile;
        JPQLQuery query = from(profile);
        if(nickname != null && nickname != "")
        {
            query.where(profile.nickname.contains(nickname));
        }
        else
        {
            query.where(profile.id.gt(0));
        }
        this.getQuerydsl().applyPagination(pageable, query);
        var retList = query.fetch();
        return null;
    }
    
}
