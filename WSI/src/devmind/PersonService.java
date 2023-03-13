package devmind;

import org.springframework.stereotype.Component;

@Component
public class PersonService {
    private PersonCache personCache;

    public PersonService(PersonCache personCache) {
        this.personCache = personCache;
    }

    public String getPersonInfoByName(String name) {
        Person resPerson =  personCache.findByName(name);
        StringBuilder sb = new StringBuilder();
        sb.append("This person is named: ").append(resPerson.getName());
        sb.append("\n It works at: ").append(resPerson.getJob());
        sb.append("\n And is: ").append(resPerson.getAge()).append(" years old");
        return sb.toString();
    }

    public boolean isPersonOfAge(String name) {
        Person resPerson =  personCache.findByName(name);
        return resPerson.getAge() >= 18;
    }
}
