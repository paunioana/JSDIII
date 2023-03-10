package ro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Autocar implements Automobil{
    @Autowired
    Motor motor;
    @Override
    public void travel() {
        System.out.println("Planned a trip to Greece with 50 people");

    }

    @Override
    public void maxDrivingSpeed() {
        System.out.println("I can roll with 70 miles per hour!");

    }


    public String presentTourists(){
        return "Dear passengers, look on the right side for the sea";
    }
}
