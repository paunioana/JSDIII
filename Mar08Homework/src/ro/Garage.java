package ro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Garage {
    @Autowired
    @Qualifier("masina")
    Automobil myCar;
    Motocicleta myMoto;
    Autocar myAutocar;

    public Garage(Motocicleta myMoto){
        this.myMoto = myMoto;
    }

    @Autowired
    public void setMyAutocar(Autocar myAutocar){
        this.myAutocar = myAutocar;
    }

    public void listGarageItems(){
        System.out.println(this.toString());
    }

}
