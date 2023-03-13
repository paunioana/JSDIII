package ro;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;
import ro.HomeworkService;
import ro.ITeacher;

@Data
@Component(value="myTeacher")
public class JavaTeacher implements ITeacher {
    private final WisdomWordsService wisdomService;
    private final HomeworkService homeworkService;
    private int age;
    private String workPlace;
    @Override
    public String getMessage() {
        return "Code is pain";
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
