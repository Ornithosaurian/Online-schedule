package com.example.university;

import com.example.university.model.*;
import com.example.university.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    // test data for News, Faculty, Department, UnGroup, Discipline, Teacher
    @Autowired
    public UniversityApplication(NewsService newsService, FacultyService facultyService, DepartmentService departmentService, GroupService groupService, StudentService studentService, DisciplineService disciplineService, TeacherService teacherService, ScheduleService scheduleService) {
        this.newsService = newsService;
        this.facultyService = facultyService;
        this.departmentService = departmentService;
        this.groupService = groupService;
        this.studentService = studentService;
        this.disciplineService = disciplineService;
        this.teacherService = teacherService;
        this.scheduleService = scheduleService;
    }

    private final NewsService newsService;
    private final FacultyService facultyService;
    private final DepartmentService departmentService;
    private final GroupService groupService;
    private final StudentService studentService;
    private final DisciplineService disciplineService;
    private final TeacherService teacherService;
    private final ScheduleService scheduleService;

    @Override
    public void run(String... arg) throws Exception {



        News news1 = News.builder()
                .title("New_1")
                .description("Phasellus nisl purus, pellentesque sit amet malesuada eget, condimentum nec metus. Donec eu lectus vel nisi pulvinar fringilla at quis lectus. Ut dignissim ipsum turpis, ut lacinia enim sodales eu. Nulla vel erat sem. Aliquam rhoncus magna sit amet tellus vestibulum, ut efficitur purus efficitur. Integer egestas varius pharetra. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.")
                .imgSrc("https://static8.depositphotos.com/1168775/947/i/950/depositphotos_9471146-stock-photo-rss-news-logo-word.jpg")
                .date(Date.valueOf(LocalDate.of(2022,12,10)))
                .build();

        News news2 = News.builder()
                .title("New_2")
                .description("little text")
                .imgSrc("https://static8.depositphotos.com/1168775/947/i/950/depositphotos_9471146-stock-photo-rss-news-logo-word.jpg")
                .date(Date.valueOf(LocalDate.of(2022,12,1)))
                .build();
        News news3 = News.builder()
                .title("New_3")
                .description("some text really some")
                .imgSrc("https://static8.depositphotos.com/1168775/947/i/950/depositphotos_9471146-stock-photo-rss-news-logo-word.jpg")
                .date(Date.valueOf(LocalDate.of(2022,12,4)))
                .build();

        News news4 = News.builder()
                .title("New_4")
                .description("little text")
                .imgSrc("https://static8.depositphotos.com/1168775/947/i/950/depositphotos_9471146-stock-photo-rss-news-logo-word.jpg")
                .date(Date.valueOf(LocalDate.of(2022,12,16)))
                .build();
        News news5 = News.builder()
                .title("New_5")
                .description("some text really some")
                .imgSrc("https://static8.depositphotos.com/1168775/947/i/950/depositphotos_9471146-stock-photo-rss-news-logo-word.jpg")
                .date(Date.valueOf(LocalDate.of(2022,12,20)))
                .build();

        News news6 = News.builder()
                .title("New_6")
                .description("little text")
                .imgSrc("https://static8.depositphotos.com/1168775/947/i/950/depositphotos_9471146-stock-photo-rss-news-logo-word.jpg")
                .date(Date.valueOf(LocalDate.of(2022,12,7)))
                .build();

        newsService.save(news1);
        newsService.save(news2);
        newsService.save(news3);
        newsService.save(news4);
        newsService.save(news5);
        newsService.save(news6);

        Student student1 = Student.builder()
                .name("Name_1")
                .surname("Surname_1")
                .patronymic("Patronymic_1")
                .email("test1@gmail.com")
                .phone("+380784216875")
                .build();

        Student student2 = Student.builder()
                .name("Name_2")
                .surname("Surname_2")
                .patronymic("Patronymic_2")
                .email("test2@gmail.com")
                .phone("+380561427852")
                .build();
        Student student3 = Student.builder()
                .name("Name_3")
                .surname("Surname_3")
                .patronymic("Patronymic_3")
                .email("test3@gmail.com")
                .phone("+380784216875")
                .build();

        Student student4 = Student.builder()
                .name("Name_4")
                .surname("Surname_4")
                .patronymic("Patronymic_4")
                .email("test4@gmail.com")
                .phone("+380561427852")
                .build();
        Student student5 = Student.builder()
                .name("Name_5")
                .surname("Surname_5")
                .patronymic("Patronymic_5")
                .email("test5@gmail.com")
                .phone("+380784216875")
                .build();

        Student student6 = Student.builder()
                .name("Name_6")
                .surname("Surname_6")
                .patronymic("Patronymic_6")
                .email("test6@gmail.com")
                .phone("+380561427852")
                .build();
        Student student7 = Student.builder()
                .name("Name_7")
                .surname("Surname_7")
                .patronymic("Patronymic_7")
                .email("test7@gmail.com")
                .phone("+380784216875")
                .build();

        Student student8 = Student.builder()
                .name("Name_8")
                .surname("Surname_8")
                .patronymic("Patronymic_8")
                .email("test2@gmail.com")
                .phone("+380561427852")
                .build();

        studentService.save(student1);
        studentService.save(student2);
        studentService.save(student3);
        studentService.save(student4);
        studentService.save(student5);
        studentService.save(student6);
        studentService.save(student7);
        studentService.save(student8);

        List<Student> students1 = new ArrayList<>();
//        List<Student> students2 = new ArrayList<>();
//
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);
        students1.add(student4);
        students1.add(student5);
        students1.add(student6);
        students1.add(student7);
        students1.add(student8);

        UnGroup group1= UnGroup.builder()
                .name("Group_1")
                .course("1 bachelor")
                .students(students1)
                .build();
        UnGroup group2 = UnGroup.builder()
                .name("Group_2")
                .course("1 bachelor")
//                .students(students1)
                .build();
        UnGroup group3 = UnGroup.builder()
                .name("Group_3")
                .course("1 bachelor")
//                .students(students1)
                .build();
        UnGroup group4 = UnGroup.builder()
                .name("Group_4")
                .course("1 bachelor")
//                .students(students1)
                .build();
//
//        UnGroup group2 = UnGroup.builder()
//                .name("Test-2")
//                .course("3 magistrate")
//                .students(students2)
//                .build();
//
        groupService.save(group1);
        groupService.save(group2);
        groupService.save(group3);
        groupService.save(group4);
//
        List<UnGroup> groups1 = new ArrayList<>();
//        List<UnGroup> groups2 = new ArrayList<>();
//
        groups1.add(group1);
        groups1.add(group2);
        groups1.add(group3);
        groups1.add(group4);
//        groups2.add(group2);

        Department department1 = Department.builder()
                .name("Test1ForFaculty1")
                .shortName("T1FF1")
                .description("Description for department1 faculty1.  Cras ornare ultrices metus, id blandit nulla scelerisque a. Quisque dapibus, ligula vehicula posuere egestas, metus elit pharetra justo, ac efficitur leo nisi a magna. Aenean dignissim egestas nisl, a mattis ex vulputate at. Curabitur accumsan tristique massa, ut fermentum nisl mattis et. Fusce quis enim maximus, consequat augue sit amet, mollis enim. Donec bibendum aliquam leo, et sodales dui auctor dapibus. Aenean gravida convallis vehicula. Nulla pellentesque tempus diam, ut aliquam neque venenatis id. In tempor accumsan eros sit amet ultrices. Sed at varius tortor. Nulla euismod justo a mauris commodo hendrerit. Suspendisse potenti.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/17/01/academy-vector-41571701.jpg")
                .groups(groups1)
                .build();

        Department department2 = Department.builder()
                .name("Test2ForFaculty1")
                .shortName("T2FF1")
                .description("Description  for department1 faculty1. Cras ornare ultrices metus, id blandit nulla scelerisque a. Quisque dapibus, ligula vehicula posuere egestas, metus elit pharetra justo, ac efficitur leo nisi a magna. Aenean dignissim egestas nisl, a mattis ex vulputate at. Curabitur accumsan tristique massa, ut fermentum nisl mattis et. Fusce quis enim maximus, consequat augue sit amet, mollis enim. Donec bibendum aliquam leo, et sodales dui auctor dapibus. Aenean gravida convallis vehicula. Nulla pellentesque tempus diam, ut aliquam neque venenatis id. In tempor accumsan eros sit amet ultrices. Sed at varius tortor. Nulla euismod justo a mauris commodo hendrerit. Suspendisse potenti.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/17/01/academy-vector-41571701.jpg")
                .build();

        Department department3 = Department.builder()
                .name("Test3ForFaculty1")
                .shortName("T3FF1")
                .description("Description for department1 faculty1. Cras ornare ultrices metus, id blandit nulla scelerisque a. Quisque dapibus, ligula vehicula posuere egestas, metus elit pharetra justo, ac efficitur leo nisi a magna. Aenean dignissim egestas nisl, a mattis ex vulputate at. Curabitur accumsan tristique massa, ut fermentum nisl mattis et. Fusce quis enim maximus, consequat augue sit amet, mollis enim. Donec bibendum aliquam leo, et sodales dui auctor dapibus. Aenean gravida convallis vehicula. Nulla pellentesque tempus diam, ut aliquam neque venenatis id. In tempor accumsan eros sit amet ultrices. Sed at varius tortor. Nulla euismod justo a mauris commodo hendrerit. Suspendisse potenti.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/17/01/academy-vector-41571701.jpg")
//                .groups(groups2)
                .build();
//        Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();
//        Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();Department department1 = Department.builder()
//                .name("test1ForFaculty1")
//                .shortName("T1FF1")
//                .description("firsts description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups1)
//                .build();
//
//        Department department2 = Department.builder()
//                .name("test1ForFaculty2")
//                .shortName("T1FF2")
//                .description("first description for department_faculty2")
//                .imgSrc("./img/faculty/test2.png")
//                .build();
//
//        Department department3 = Department.builder()
//                .name("test2ForFaculty1")
//                .shortName("T2FF1")
//                .description("second description for department_faculty1")
//                .imgSrc("./img/faculty/test1.png")
//                .groups(groups2)
//                .build();


        departmentService.save(department1);
        departmentService.save(department2);
        departmentService.save(department3);

        List<Department> forFaculty1 = new ArrayList<>();
//        List<Department> forFaculty2 = new ArrayList<>();

        forFaculty1.add(department1);
        forFaculty1.add(department2);
        forFaculty1.add(department3);

        Faculty faculty1 = Faculty.builder()
                .name("f1")
                .shortName("Faculty_1")
                .description("Faculty_1 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
                .departments(forFaculty1)
                .build();

        Faculty faculty2 = Faculty.builder()
                .name("f2")
                .shortName("Faculty_2")
                .description("Faculty_2 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty2)
                .build();
        Faculty faculty3 = Faculty.builder()
                .name("f3")
                .shortName("Faculty_3")
                .description("Faculty_3 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty1)
                .build();

        Faculty faculty4 = Faculty.builder()
                .name("f4")
                .shortName("Faculty_4")
                .description("Факультет_4 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty2)
                .build();
        Faculty faculty5 = Faculty.builder()
                .name("f5")
                .shortName("Faculty_5")
                .description("Faculty_5 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty1)
                .build();

        Faculty faculty6 = Faculty.builder()
                .name("f6")
                .shortName("Faculty_6")
                .description("Faculty_6 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty2)
                .build();
        Faculty faculty7 = Faculty.builder()
                .name("f7")
                .shortName("Faculty_7")
                .description("Faculty_7 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty1)
                .build();

        Faculty faculty8 = Faculty.builder()
                .name("f8")
                .shortName("Faculty_8")
                .description("Faculty_8 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty2)
                .build();
        Faculty faculty9 = Faculty.builder()
                .name("f9")
                .shortName("Faculty_9")
                .description("Faculty_9 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty1)
                .build();

        Faculty faculty10 = Faculty.builder()
                .name("f6")
                .shortName("Faculty_10")
                .description("Faculty_10 description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut egestas consectetur egestas. Aliquam varius vehicula lectus id suscipit. Nunc aliquet vulputate elit at tincidunt. Duis lacinia placerat massa, at posuere sem commodo quis. Proin maximus ac mauris scelerisque hendrerit. In interdum lectus in justo tincidunt, non tincidunt risus lacinia. Mauris viverra tincidunt dignissim. Vivamus sit amet interdum mauris. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam hendrerit condimentum vestibulum. Suspendisse vitae purus et nunc dapibus placerat in ac ex. Integer mollis, neque a finibus malesuada, nibh nibh bibendum nulla, vitae egestas diam massa eu leo.")
                .imgSrc("https://cdn.vectorstock.com/i/preview-1x/60/27/scholar-student-success-logo-icon-brand-identity-vector-44606027.jpg")
//                .departments(forFaculty2)
                .build();

        facultyService.save(faculty1);
        facultyService.save(faculty2);
        facultyService.save(faculty3);
        facultyService.save(faculty4);
        facultyService.save(faculty5);
        facultyService.save(faculty6);
        facultyService.save(faculty7);
        facultyService.save(faculty8);
        facultyService.save(faculty9);
        facultyService.save(faculty10);

        Discipline discipline1 = Discipline.builder()
                .name("Discipline_1")
                .build();

        Discipline discipline2 = Discipline.builder()
                .name("Discipline_2")
                .build();
        Discipline discipline3 = Discipline.builder()
                .name("Discipline_3")
                .build();

        Discipline discipline4 = Discipline.builder()
                .name("Discipline_4")
                .build();
        Discipline discipline5 = Discipline.builder()
                .name("Discipline_5")
                .build();

        Discipline discipline6 = Discipline.builder()
                .name("Discipline_6")
                .build();
        Discipline discipline7 = Discipline.builder()
                .name("Discipline_7")
                .build();

        Discipline discipline8 = Discipline.builder()
                .name("Discipline_8")
                .build();
        Discipline discipline9 = Discipline.builder()
                .name("Discipline_9")
                .build();

        Discipline discipline10 = Discipline.builder()
                .name("Discipline_10")
                .build();
        Discipline discipline11 = Discipline.builder()
                .name("Discipline_11")
                .build();

        Discipline discipline12 = Discipline.builder()
                .name("Discipline_12")
                .build();

        disciplineService.save(discipline1);
        disciplineService.save(discipline2);
        disciplineService.save(discipline3);
        disciplineService.save(discipline4);
        disciplineService.save(discipline5);
        disciplineService.save(discipline6);
        disciplineService.save(discipline7);
        disciplineService.save(discipline8);
        disciplineService.save(discipline9);
        disciplineService.save(discipline10);
        disciplineService.save(discipline11);
        disciplineService.save(discipline12);

        Teacher teacher1 = Teacher.builder()
                .name("Teacher_1")
                .surname("Last_name_1")
                .patronymic("Patronymic_1")
                .email("teacher1@gmail.com")
                .phone("+380784216875")
                .build();

        Teacher teacher2 = Teacher.builder()
                .name("Teacher_2")
                .surname("Last_name_2")
                .patronymic("Patronymic_2")
                .email("teacher2@gmail.com")
                .phone("+380561427852")
                .build();
        Teacher teacher3 = Teacher.builder()
                .name("Teacher_3")
                .surname("Last_name_3")
                .patronymic("Patronymic_3")
                .email("teacher3@gmail.com")
                .phone("+380784216875")
                .build();

        Teacher teacher4 = Teacher.builder()
                .name("Teacher_4")
                .surname("Last_name_4")
                .patronymic("Patronymic_4")
                .email("teacher4@gmail.com")
                .phone("+380561427852")
                .build();
        Teacher teacher5 = Teacher.builder()
                .name("Teacher_5")
                .surname("Last_name_5")
                .patronymic("Patronymic_5")
                .email("teacher5@gmail.com")
                .phone("+380784216875")
                .build();

        Teacher teacher6 = Teacher.builder()
                .name("Teacher_6")
                .surname("Last_name_6")
                .patronymic("Patronymic_6")
                .email("teacher6@gmail.com")
                .phone("+380561427852")
                .build();
        Teacher teacher7 = Teacher.builder()
                .name("Teacher_7")
                .surname("Last_name_7")
                .patronymic("Patronymic_7")
                .email("teacher7@gmail.com")
                .phone("+380784216875")
                .build();

        Teacher teacher8 = Teacher.builder()
                .name("Teacher_8")
                .surname("Last_name_8")
                .patronymic("Patronymic_8")
                .email("teacher8@gmail.com")
                .phone("+380561427852")
                .build();
        Teacher teacher9 = Teacher.builder()
                .name("Teacher_9")
                .surname("Last_name_9")
                .patronymic("Patronymic_9")
                .email("teacher9@gmail.com")
                .phone("+380784216875")
                .build();

        Teacher teacher10 = Teacher.builder()
                .name("Teacher_10")
                .surname("Last_name_10")
                .patronymic("Patronymic_10")
                .email("teacher10@gmail.com")
                .phone("+380561427852")
                .build();


        teacherService.save(teacher1);
        teacherService.save(teacher2);
        teacherService.save(teacher3);
        teacherService.save(teacher4);
        teacherService.save(teacher5);
        teacherService.save(teacher6);
        teacherService.save(teacher7);
        teacherService.save(teacher8);
        teacherService.save(teacher9);
        teacherService.save(teacher10);

//        Schedule schedule1 = Schedule.builder()
//                .name("schedule1")
//                .teacher(teacher1)
//                .discipline(discipline1)
//                .group(group1)
//                .time("12:00")
//                .classroom("56")
//                .day("Monday")
//                .build();
//
//        Schedule schedule2 = Schedule.builder()
//                .name("schedule2")
//                .teacher(teacher2)
//                .discipline(discipline2)
//                .group(group2)
//                .time("13:00")
//                .classroom("67")
//                .day("Sunday")
//                .build();
//
//        studentService.save(schedule1);
//        studentService.save(schedule2);
    }
}
