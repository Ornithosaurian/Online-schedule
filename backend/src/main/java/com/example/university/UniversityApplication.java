package com.example.university;

import com.example.university.model.Department;
import com.example.university.model.Faculty;
import com.example.university.model.News;
import com.example.university.service.DepartmentService;
import com.example.university.service.FacultyService;
import com.example.university.service.GroupService;
import com.example.university.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    // test data for News, Faculty, Department
    @Autowired
    public UniversityApplication(NewsService newsService, FacultyService facultyService, DepartmentService departmentService, GroupService groupService) {
        this.newsService = newsService;
        this.facultyService = facultyService;
        this.departmentService = departmentService;
        this.groupService = groupService;
    }

    private final NewsService newsService;
    private final FacultyService facultyService;
    private final DepartmentService departmentService;
    private final GroupService groupService;

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

        Department department1 = Department.builder()
                .name("test1ForFaculty1")
                .shortName("T1FF1")
                .description("firsts description for department_faculty1")
                .imgSrc("./img/faculty/test1.png")
                .build();

        Department department2 = Department.builder()
                .name("test1ForFaculty2")
                .shortName("T1FF2")
                .description("first description for department_faculty2")
                .imgSrc("./img/faculty/test2.png")
                .build();

        Department department3 = Department.builder()
                .name("test2ForFaculty1")
                .shortName("T2FF1")
                .description("second description for department_faculty1")
                .imgSrc("./img/faculty/test1.png")
                .build();


        departmentService.save(department1);
        departmentService.save(department2);
        departmentService.save(department3);

        List<Department> forFaculty1 = new ArrayList<>();
        List<Department> forFaculty2 = new ArrayList<>();

        forFaculty1.add(department1);
        forFaculty1.add(department2);
        forFaculty2.add(department3);

        Faculty faculty1 = Faculty.builder()
                .name("test1")
                .shortName("T1")
                .description("firsts description for faculty")
                .imgSrc("./img/faculty/test1.png")
                .departments(forFaculty1)
                .build();

        Faculty faculty2 = Faculty.builder()
                .name("test2")
                .shortName("T2")
                .description("second description for faculty")
                .imgSrc("./img/faculty/test2.png")
                .departments(forFaculty2)
                .build();

        facultyService.save(faculty1);
        facultyService.save(faculty2);

//        Group group = Group.builder()
//                .name("Test-1")
//                .course("1 magistrate")
//                .build();
//        groupService.save(group);
    }
}
