package com.example.university.service;

import com.example.university.model.News;
import com.example.university.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getNewsList() {
        return newsRepository.findAll();
    }

    public void saveNews(News news) {
        newsRepository.save(news);
    }

    public Optional<News> findById(long id) {
        return newsRepository.findById(id);
    }

    public void deleteById(long id) {
        newsRepository.deleteById(id);
    }

    public List<News> sortByNew(){
        return newsRepository.selectByNew();
    }

    public List<News> sortByOld(){
        return newsRepository.selectByOld();
    }
 }
