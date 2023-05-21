package projekt.java101.mototrivia;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

public class Question {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
}
