package com.clone.insta.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.clone.insta.services.ProfileService;

import lombok.RequiredArgsConstructor;




@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;



    @GetMapping("/{id}")
    public String getUserPostsPage(@PathVariable(required = true) Long id, PageRequest pageRequest, Model model) {
        //todo : priofile info get
        //todo : {id} user's post list get
        //todo : return user psots page
        Pageable pageable = null;
        var ret = profileService.getUserPostDetails(id, pageable);
        model.addAttribute("profile", ret.getLeft());
        model.addAttribute("postThumbnails", ret.getMiddle());
        model.addAttribute("simplePager", ret.getRight());
        return "";
    }
}
