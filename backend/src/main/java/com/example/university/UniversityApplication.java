package com.example.university;

import com.example.university.models.News;
import com.example.university.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

// test data for News
    public UniversityApplication(NewsService newsService) {
        this.newsService = newsService;
    }
    private final NewsService newsService;

    @Override
    public void run(String... arg) throws Exception {

        long millis = System.currentTimeMillis();
        Date curDate = new Date(millis);

        News news1 = News.builder()
                .title("test")
                .description("some text really some")
                .imgSrc("./img/test.png")
                .date(curDate)
                .build();

        News news2 = News.builder()
                .title("test2")
                .description("little text")
                .imgSrc("./img/test2.png")
                .date(curDate)
                .build();

        newsService.addNews(news1);
        newsService.addNews(news2);
    }
}
