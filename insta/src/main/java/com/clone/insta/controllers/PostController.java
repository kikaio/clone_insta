package com.clone.insta.controllers;

import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    public String getPosts(
        @RequestParam PageRequestDto paeReq 
    )
    {
        return "";
    }

    @GetMapping("/{id}")
    public String getPostDetail(
        @PathVariable(name="id", required = true) Long id
        , @RequestParam(name="link", required = true) String prevLink
    ) {
        return "";
    }
    
}
