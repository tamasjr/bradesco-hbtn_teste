package src;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;

public class PersonTest {
    private Person person;

    @Before
    public void setup() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2000);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date birthDate = cal.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200f);
        assertEquals(14400f, person.calculateYearlySalary(), 0.01f);
    }

    @Test
    public void person_is_MEI() {
        person.setSalary(1000f);
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1990);
        person.setBirthDate(cal.getTime());

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        person.setSalary(15000f);
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2010);
        person.setBirthDate(cal.getTime());

        assertFalse(person.isMEI());
    }
}
