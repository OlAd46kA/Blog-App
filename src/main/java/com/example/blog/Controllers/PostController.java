package com.example.blog.Controllers;

import com.example.blog.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/blog")
    public String post (Model model){
        return "post";
    }

    @PostMapping("/post")
    public String post (@RequestParam String nickname, @RequestParam("text") String text){
        postService.saveArticle(nickname, text);
        return "redirect:/articles";
    }
}