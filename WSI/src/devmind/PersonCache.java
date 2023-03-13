package devmind;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class PersonCache {
    private ArrayList<Person> people;

    public PersonCache() {
        people = new ArrayList<>();
        // gets people from a database
    }

    public Person findByName(String name) {
        Optional<Person> result = people.stream().findAny().filter(p -> p.getName().equals(name));
        return result.orElse(null);
    }
}
