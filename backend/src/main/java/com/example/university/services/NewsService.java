package com.example.university.services;

import com.example.university.models.News;
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

    public List<News> getNewsList(){
        return newsRepository.findAll();
    }

    public void addNews(News news) {
        newsRepository.save(news);
    }

    public Optional<News> findById(long id) {
        return newsRepository.findById(id);
    }

    public void deleteById(long id) {
        newsRepository.deleteById(id);
    }
}
