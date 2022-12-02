package com.example.university;

import com.example.university.model.Faculty;
import com.example.university.model.News;
import com.example.university.service.FacultyService;
import com.example.university.service.NewsService;
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

    // test data for News, Faculty
    @Autowired
    public UniversityApplication(NewsService newsService, FacultyService facultyService) {
        this.newsService = newsService;
        this.facultyService = facultyService;
    }

    private final NewsService newsService;
    private final FacultyService facultyService;

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

        newsService.save(news1);
        newsService.save(news2);

        Faculty faculty1 = Faculty.builder()
                .name("test1")
                .shortName("T1")
                .description("firsts description for faculty")
                .imgSrc("./img/faculty/test1.png")
                .build();

        Faculty faculty2 = Faculty.builder()
                .name("test2")
                .shortName("T2")
                .description("second description for faculty")
                .imgSrc("./img/faculty/test2.png")
                .build();

        facultyService.save(faculty1);
        facultyService.save(faculty2);
    }
}
