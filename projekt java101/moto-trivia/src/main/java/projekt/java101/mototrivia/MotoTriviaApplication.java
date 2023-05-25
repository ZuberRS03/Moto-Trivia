package projekt.java101.mototrivia;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class MotoTriviaApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(MotoTriviaApplication.class, args);

		QuestionService questionService = context.getBean(QuestionService.class);
		questionService.startQuiz();

	}
}
