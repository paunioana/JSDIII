package ro;

import lombok.Getter;
import org.springframework.stereotype.Component;
import ro.HomeworkService;
import ro.ITeacher;

@Getter
@Component("myTeacher")
public class JavaTeacher implements ITeacher {
    private WisdomWordsService wisdomService;
    private HomeworkService homeworkService;
    private int age;
    private String workPlace;
    @Override
    public String getMessage() {
        return "Code is pain";
    }

    // constructor unic care primeste ca parametru un obiect de tipul ro.WisdomWordsService
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


    public void setAge(int age) {
        this.age = age;
    }


    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }
}
