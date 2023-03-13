package ro;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class Motocicleta extends VehicleComponents implements Automobil{
    int power;
    String name;
    public Motocicleta(Motor motor){
        this.motor = motor;
    }
    @Override
    public void travel() {
        System.out.println(this.name + ":Am fost pana la mare si inapoi!");

    }

    @Override
    public void maxDrivingSpeed() {
        System.out.println(this.name + ":I can roll with 40 miles per hour!");

    }

    public void powerIncrease() {
        this.power += 5;
    }

    public String makeSomeNoise(){
        return "Vruuuum";
    }
}
