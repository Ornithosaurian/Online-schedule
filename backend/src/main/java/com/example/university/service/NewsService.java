package com.example.university.service;

import com.example.university.model.News;
import com.example.university.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService extends BaseService<News, NewsRepository> {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        super(newsRepository);
        this.newsRepository = newsRepository;
    }

    public List<News> sortByNew() {
        return newsRepository.selectByNew();
    }

    public List<News> sortByOld() {
        return newsRepository.selectByOld();
    }
}
