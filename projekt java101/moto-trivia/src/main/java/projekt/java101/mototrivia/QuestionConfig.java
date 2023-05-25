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
    CommandLineRunner commandLineRunner(QuestionRepository questionRepository) {
        return args -> {
            Question Question001 = new Question(
                    "Ile koni ma Nissan GTR R35?",
                    "550"
            );
            Question Question002 = new Question(
                    "Ile koni ma Ford Mustang?",
                    "450"
            );
//            System.out.println(Question001.toString());
//            System.out.println(Question002.toString());
            questionRepository.saveAll(
                    List.of(Question001, Question002)
            );
        };
    }
}
