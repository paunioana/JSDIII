package devmind.springinitializr.model;

import com.github.javafaker.Faker;
import com.github.javafaker.HarryPotter;
import org.springframework.stereotype.Component;

@Component
public class HPService {
    private static Faker f = new Faker();
    public String getRandomCharacter(){

        HarryPotter hp = f.harryPotter();
        return hp.character();
    }
}
