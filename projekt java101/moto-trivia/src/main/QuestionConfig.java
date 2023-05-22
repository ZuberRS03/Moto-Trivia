package projekt.java101.mototrivia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class QuestionConfig {
    @Bean
    CommandLineRunner commandLineRunner(QuestionRepository questionrepository) {
        return args -> {
            Question Question001 = new Question(
                    1L,
                    "Ile koni ma Nissan GTR R35?",
                    "550"
            );
            Question Question002 = new Question(
                    2L,
                    "Ile koni ma Ford Mustang?",
                    "450"
            );
            questionrepository.saveAll(
                    List.of(Question001, Question002)
            );
        };
    }
}
