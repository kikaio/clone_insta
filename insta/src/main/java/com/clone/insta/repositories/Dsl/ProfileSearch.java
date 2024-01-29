package com.clone.insta.repositories.Dsl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.clone.insta.Entities.Profile;

public interface ProfileSearch {
    Profile searchProfile(Long id);

    Page<Profile> searchProfiles(Pageable pageable, String nickname);
}
