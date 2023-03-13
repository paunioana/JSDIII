package ro;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class VehicleComponents {
    @Autowired
    Motor motor;

    public Motor getMotor(){
        return this.motor;
    }

}
