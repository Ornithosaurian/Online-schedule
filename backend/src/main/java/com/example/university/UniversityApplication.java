package com.example.university;

import com.example.university.model.*;
import com.example.university.service.*;
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

    // test data for News, Faculty, Department, UnGroup, Discipline, Teacher
    @Autowired
    public UniversityApplication(NewsService newsService, FacultyService facultyService, DepartmentService departmentService, GroupService groupService, StudentService studentService, DisciplineService disciplineService, TeacherService teacherService) {
        this.newsService = newsService;
        this.facultyService = facultyService;
        this.departmentService = departmentService;
        this.groupService = groupService;
        this.studentService = studentService;
        this.disciplineService = disciplineService;
        this.teacherService = teacherService;
    }

    private final NewsService newsService;
    private final FacultyService facultyService;
    private final DepartmentService departmentService;
    private final GroupService groupService;
    private final StudentService studentService;
    private final DisciplineService disciplineService;
    private final TeacherService teacherService;

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

        Student student1 = Student.builder()
                .name("Arkadii")
                .surname("Momot")
                .patronymic("Romanovych")
                .email("test@gmail.com")
                .phone("+380784216875")
                .build();

        Student student2 = Student.builder()
                .name("test")
                .surname("testerenko")
                .patronymic("testuvovych")
                .email("test1@gmail.com")
                .phone("+380561427852")
                .build();

        studentService.save(student1);
        studentService.save(student2);

        List<Student> students1 = new ArrayList<>();
        List<Student> students2 = new ArrayList<>();

        students1.add(student1);
        students2.add(student2);

        UnGroup group1 = UnGroup.builder()
                .name("Test-1")
                .course("1 magistrate")
                .students(students1)
                .build();

        UnGroup group2 = UnGroup.builder()
                .name("Test-2")
                .course("3 magistrate")
                .students(students2)
                .build();

        groupService.save(group1);
        groupService.save(group2);

        List<UnGroup> groups1 = new ArrayList<>();
        List<UnGroup> groups2 = new ArrayList<>();

        groups1.add(group1);
        groups2.add(group2);

        Department department1 = Department.builder()
                .name("test1ForFaculty1")
                .shortName("T1FF1")
                .description("firsts description for department_faculty1")
                .imgSrc("./img/faculty/test1.png")
                .groups(groups1)
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
                .groups(groups2)
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

        Discipline discipline1 = Discipline.builder()
                .name("Something1")
                .build();

        Discipline discipline2 = Discipline.builder()
                .name("Something2")
                .build();

        disciplineService.save(discipline1);
        disciplineService.save(discipline2);

        Teacher teacher1 = Teacher.builder()
                .name("Teacher1")
                .surname("Teacherenko")
                .patronymic("Teacherovych")
                .email("teacher1@gmail.com")
                .phone("+380784216875")
                .build();

        Teacher teacher2 = Teacher.builder()
                .name("Teacher2")
                .surname("Teacherenko")
                .patronymic("Teacherovych")
                .email("teacher2@gmail.com")
                .phone("+380561427852")
                .build();

        teacherService.save(teacher1);
        teacherService.save(teacher2);
    }
}
