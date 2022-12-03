package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.Model;
import com.example.university.model.News;
import com.example.university.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController extends BaseController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        super(newsService);
        this.newsService = newsService;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Model> getById(@PathVariable("id") long id) {
        News news = (News) newsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + News.class + " with id = " + id));
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable long id, @RequestBody Model model) {
        News updatedNews = (News) newsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found " + News.class + " with id = " + id));
        News news = (News) model;

        updatedNews.setTitle(news.getTitle());
        updatedNews.setDescription(news.getDescription());
        updatedNews.setImgSrc(news.getImgSrc());
        updatedNews.setDate(news.getDate());

        newsService.save(updatedNews);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/sortByNew")
    public ResponseEntity<List<News>> sortByNew() {
        List<News> orderedList = newsService.sortByNew();
        if (orderedList.isEmpty()) {
            return new ResponseEntity<>(orderedList, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderedList, HttpStatus.OK);
    }

    @GetMapping("/sortByOld")
    public ResponseEntity<List<News>> sortByOld() {
        List<News> orderedList = newsService.sortByOld();
        if (orderedList.isEmpty()) {
            return new ResponseEntity<>(orderedList, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderedList, HttpStatus.OK);
    }
}

