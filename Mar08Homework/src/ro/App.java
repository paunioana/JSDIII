package ro;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App {


        public static void main(String args[]) {
            // load the Spring configuration file
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

            // retrieve bean from the Spring container

            Masina myCar = context.getBean("masina", Masina.class);
            myCar.getMotor().setNume("vasile");
            myCar.getMotor().setPutere(220);
            myCar.getMotor().setNumarCilindri(14);
            myCar.automatedCleanUp();
            Motocicleta myMoto = context.getBean("motocicleta", Motocicleta.class);
            myMoto.getMotor().setNumarCilindri(8);
            myMoto.getMotor().setNume("ion");
            myMoto.getMotor().setPutere(130);

            if(myCar.motor == myMoto.motor) {
                System.out.println("Motor is the same!");
            } else {
                System.out.println("Motor is different!");
            }
            Garage myGarage = context.getBean("garage", Garage.class);
            myGarage.listGarageItems();


            // close the context
            context.close();
        }
    }

