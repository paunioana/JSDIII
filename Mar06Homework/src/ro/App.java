package ro;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {



        public static void main(String args[]) {
            // load the Spring configuration file
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

            // retrieve bean from the Spring container

            JavaTeacher javaTeacher = context.getBean("myTeacher", JavaTeacher.class);
            System.out.println(javaTeacher.getWisdom());
            System.out.println(javaTeacher.getHomeWork());
            System.out.println("Age: " + javaTeacher.getAge());
            System.out.println("Work place: " + javaTeacher.getWorkPlace());

            Task myTask = context.getBean("singletonTask", Task.class);
            myTask.setTaskId(101);
            myTask.setExecutionTime(2);
            System.out.println(myTask.getExecutionTime());
            System.out.println(myTask.toString());

            ITeacher ex2 = context.getBean("mathTeacher", ITeacher.class);
            System.out.println(ex2.getWisdom());




            // close the context
            context.close();
        }
    }

