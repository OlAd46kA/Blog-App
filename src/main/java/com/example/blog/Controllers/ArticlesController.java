package com.example.blog.Controllers;

import com.example.blog.Models.Articles;
import com.example.blog.Repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticlesController {
    @Autowired
    ArticlesRepository articlesRepository;

    @GetMapping("/articles")
    public String articles(Model model){
        List<Articles> articlesList = articlesRepository.findAll();
        model.addAttribute("articles", articlesList);
        return "articles";
    }

    @PostMapping("/deleteArticle")
    public String deleteArticle (@RequestParam("articleId") Long id){
        articlesRepository.deleteById(id);
        return "redirect:/articles";
    }

}