package dev;

import dev.HomeworkService;
import dev.JavaTeacher;
import dev.MathTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class TeacherConfiguration {
    @Autowired
    WisdomWordsService myWisdomWordsService;

    @Autowired
    HomeworkService myHomeworkService;

    @Bean
    public JavaTeacher myTeacher(){
        JavaTeacher myTeacher = new JavaTeacher(myWisdomWordsService, myHomeworkService);
        myTeacher.setAge(27);
        myTeacher.setWorkPlace("DevMind");
        return myTeacher;
    }

    @Bean
    public MathTeacher myMathTeacher(){
        return new MathTeacher();
    }


}
