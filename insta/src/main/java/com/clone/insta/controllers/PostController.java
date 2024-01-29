package com.clone.insta.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    public String getPosts(@RequestParam PageRequest pageReq) {
        //todo : get all post using page info
        return "";
    }

    @GetMapping("/{id}")
    public String getPostDetail(@PathVariable(name = "id", required = true) Long id,@RequestParam(name = "link", required = true) String prevLink) {
        //get post detail, and comments about this post using pager.
        return "";
    }

    @GetMapping("/create")
    public String getPostCreatePage() {
        //return page for post creating
        return "";
    }

    @PostMapping("/create")
    public String createPost() {
        // do job for post creating, and return 
        return "";
    }

    @GetMapping("/update")
    public String getPostUpdatePage() {
        // get page for updating post
        return "";
    }

    @PostMapping("/update")
    public String updatePost() {
        return "";
    }
    
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable(name="id", required = true) Long id)
    {
        //do delete this post.
        return "";
    }
}
