package myormpractical;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    private final String name;
    private final int age;
    private final float salary;
    private final String position;
    private final LocalDate dateOfBirth;

}
