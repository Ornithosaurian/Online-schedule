package com.example.university.controller;

import com.example.university.models.News;
import com.example.university.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class NewsController {

    private final NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public List<News> fetchNews() {
        return newsService.getNewsList();
    }

    @GetMapping("/news/{id}")
    public Optional<News> getNewsById(@PathVariable("id") long id){
        return newsService.findById(id);
    }

    @PostMapping("/news")
    public void createNews(@RequestBody News news){
        newsService.addNews(news);
    }

    @PutMapping("/news/{id}")
    public void updateNews(@PathVariable("id") long id, @RequestBody News news){
        Optional<News> newsData = newsService.findById(id);

        News updatedNews = newsData.get();
        updatedNews.setTitle(news.getTitle());
        updatedNews.setDescription(news.getDescription());
        updatedNews.setImgSrc(news.getImgSrc());
        updatedNews.setDate(news.getDate());

        newsService.addNews(updatedNews);
    }

    @DeleteMapping("/news/{id}")
    public void deleteNews(@PathVariable("id") long id){
        newsService.deleteById(id);
    }
}

