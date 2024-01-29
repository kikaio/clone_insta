package com.clone.insta.repositories.Dsl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.clone.insta.Entities.InstaUser;
import com.clone.insta.Entities.QInstaUser;
import com.querydsl.jpa.JPQLQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InstaUserSearchImpl extends QuerydslRepositorySupport implements InstaUserSearch{

    public InstaUserSearchImpl()
    {
        super(InstaUser.class);
    }

    public InstaUser searchUser(Long id)
    {
        QInstaUser user = QInstaUser.instaUser;
        JPQLQuery<InstaUser> query = from(user);

        if(id == 0)
        {
            return null;
        }

        query.where(user.id.eq(id));
        var retList = query.fetch();
        if(retList.size() == 0)
            return null;
        else 
        {
            if(retList.size() > 1)
            {
                log.error("user must have unique id...[%d]".formatted(id));
                for (InstaUser instaUser : retList) {
                    log.error(
                        "duplicated user : [%s], provider : [%s]".formatted(instaUser.getEmail(), instaUser.getSignProvider()
                    ));
                }
            }
            return retList.get(0);
        }
    }
}
