package ro;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("----- Before context initialization");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("----- Before getBean calls");

        Task protoTask = context.getBean("protoTask", Task.class);
        Task singletonTask = context.getBean("singletonTask", Task.class);
        singletonTask.run();
        protoTask.run();



        System.out.println("----- After getBean calls");
        System.out.println("Current number of instances: " + Task.numberOfTasks);


        // close the context
        context.close();
        System.out.println("----- After context closed");

    }
}