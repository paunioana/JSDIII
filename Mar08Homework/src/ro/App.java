package ro;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {


        public static void main(String args[]) {
            // load the Spring configuration file
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

            // retrieve bean from the Spring container

            Masina myCar = context.getBean("masina", Masina.class);
            myCar.automatedCleanUp();
            Garage myGarage = context.getBean("garage", Garage.class);
            myGarage.listGarageItems();









            // close the context
            context.close();
        }
    }

