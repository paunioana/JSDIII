package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
        public static void main(String args[]) {
            // load the Spring configuration file
            //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TeacherConfiguration.class);

            // retrieve bean from the Spring container

            JavaTeacher javaTeacher = context.getBean("myTeacher", JavaTeacher.class);
            ITeacher mathTeacher = context.getBean("myMathTeacher", MathTeacher.class);


            // call methods on the bean
            System.out.println(javaTeacher.getWisdom());
            System.out.println(javaTeacher.getHomeWork());
            System.out.println("Age: " + javaTeacher.getAge());
            System.out.println("Work place: " + javaTeacher.getWorkPlace());
            System.out.println(mathTeacher.getWisdom());



            // close the context
            context.close();
        }
    }

