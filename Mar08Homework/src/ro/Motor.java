package ro;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Motor {
    int putere;
    String nume;
    int numarCilindri;
}
