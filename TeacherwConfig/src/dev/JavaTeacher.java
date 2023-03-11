package dev;

import dev.HomeworkService;
import dev.ITeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class JavaTeacher implements ITeacher {
    private WisdomWordsService wisdomService;
    private HomeworkService homeworkService;
    private int age;
    private String workPlace;
    @Override
    public String getMessage() {
        return "Code is pain";
    }

    // constructor unic care primeste ca parametru un obiect de tipul dev.WisdomWordsService
    @Autowired
    public JavaTeacher(WisdomWordsService wisdomService, HomeworkService homeworkService) {
        this.wisdomService = wisdomService;
        this.homeworkService = homeworkService;
    }

    @Override
    public String getHomeWork() {
        return homeworkService.getHomework();
    }

    @Override
    public String getWisdom() {
        return wisdomService.getMessage();
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }
}
