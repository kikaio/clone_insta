package com.clone.insta.repositories.Dsl;

import java.util.List;

import com.clone.insta.Entities.InstaUser;

public interface InstaUserSearch {
    List<InstaUser> searchUser(Long id);
}
