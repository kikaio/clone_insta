package com.clone.insta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clone.insta.Entities.InstaUser;
import com.clone.insta.repositories.Dsl.InstaUserSearch;

public interface InstaUserRepository
 extends JpaRepository<Long, InstaUser>
 , InstaUserSearch 
{
    
}
