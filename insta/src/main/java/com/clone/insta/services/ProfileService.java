package com.clone.insta.services;

import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Triple;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clone.insta.dto.PostThumbnailDTO;
import com.clone.insta.dto.ProfileDTO;
import com.clone.insta.dto.SimplePagerDTO;
import com.clone.insta.repositories.ProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public Triple<ProfileDTO, ArrayList<PostThumbnailDTO>, SimplePagerDTO> getUserPostDetails(Long accountId, Pageable pageable)
    {
        profileRepository.findByNickname(null)
        return null;
    }
}
