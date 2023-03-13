package test;

import devmind.Person;
import devmind.PersonCache;
import devmind.PersonService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @Mock
    PersonCache personCache;

    @Mock
    PersonService personService;

    @Test
    public void testIsPersonOfAge_whenPersonIsOfAge_expectTrue() {
        Person person = new Person();
        person.setAge(18);
        personService = new PersonService(personCache);

        Mockito.when(personCache.findByName(Mockito.anyString())).thenReturn(person);

        Assert.assertTrue(personService.isPersonOfAge("Random string does not matter"));
    }
}
