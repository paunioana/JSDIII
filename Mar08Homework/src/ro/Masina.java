package ro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Masina extends VehicleComponents implements Automobil{

    @Override
    public void travel() {
        System.out.println("Am fost la munte si mi-a placut");

    }

    @Override
    public void maxDrivingSpeed() {
        System.out.println("I can roll with 80 miles per hour!");

    }


    public String automatedCleanUp(){
        return "Your car is now fresh and clean!";
    }

    @Autowired
    public void setMotor(Motor motor) {
        this.motor = motor;
    }


}
