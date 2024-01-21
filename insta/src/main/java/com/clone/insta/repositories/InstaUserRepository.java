package com.clone.insta.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clone.insta.Entities.InstaUser;
import com.clone.insta.repositories.Dsl.InstaUserSearch;

public interface InstaUserRepository
        extends JpaRepository<InstaUser, Long>, InstaUserSearch {

    Optional<InstaUser> findByEmail(String email);
}
