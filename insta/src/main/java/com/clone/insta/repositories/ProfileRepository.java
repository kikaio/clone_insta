package com.clone.insta.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.insta.Entities.InstaUser;
import com.clone.insta.Entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByNickname(String nickName);

    Optional<Profile> findByAccountId(InstaUser user);
}
