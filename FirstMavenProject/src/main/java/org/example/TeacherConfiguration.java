package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("file.properties")
public class TeacherConfiguration {
    @Autowired
    WisdomWordsService myWisdomWordsService;

    @Autowired
    HomeworkService myHomeworkService;

    @Bean
    public JavaTeacher myTeacher(){
        JavaTeacher myTeacher = new JavaTeacher(myWisdomWordsService, myHomeworkService);
        //myTeacher.setAge(27);
        myTeacher.setWorkPlace("DevMind");
        return myTeacher;
    }

    @Bean
    public MathTeacher myMathTeacher(){
        return new MathTeacher();
    }


}
