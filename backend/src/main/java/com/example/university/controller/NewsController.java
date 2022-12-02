package com.example.university.controller;

import com.example.university.exception.ResourceNotFoundException;
import com.example.university.model.News;
import com.example.university.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin("http://localhost:5173")
public class NewsController {

    private final NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping()
    public ResponseEntity<List<News>> getAllNews() {
        List<News> newsList = newsService.getNewsList();
        if (newsList.isEmpty()) {
            return new ResponseEntity<>(newsList, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(newsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable("id") long id){
        News news = newsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> createNews(@RequestBody News news){
        newsService.saveNews(news);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateNews(@PathVariable("id") long id, @RequestBody News news){
        News updatedNews = newsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        updatedNews.setTitle(news.getTitle());
        updatedNews.setDescription(news.getDescription());
        updatedNews.setImgSrc(news.getImgSrc());
        updatedNews.setDate(news.getDate());

        newsService.saveNews(updatedNews);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteNews(@PathVariable("id") long id){
        newsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/sortByNew")
    public ResponseEntity<List<News>> sortByNew(){
        List<News> orderedList = newsService.sortByNew();
        if (orderedList.isEmpty()) {
            return new ResponseEntity<>(orderedList, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderedList, HttpStatus.OK);
    }

    @GetMapping("/sortByOld")
    public ResponseEntity<List<News>> sortByOld(){
        List<News> orderedList = newsService.sortByOld();
        if (orderedList.isEmpty()) {
            return new ResponseEntity<>(orderedList, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orderedList, HttpStatus.OK);
    }
}

