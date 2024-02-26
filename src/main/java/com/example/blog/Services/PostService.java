package com.example.blog.Services;

import com.example.blog.Models.Articles;
import com.example.blog.Repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {
    @Autowired
    ArticlesRepository articlesRepository;

    @Transactional
    public String saveArticle(String nickname, String text) {
        articlesRepository.save(new Articles(nickname, text));
        return "redirect:/articles";
    }
}