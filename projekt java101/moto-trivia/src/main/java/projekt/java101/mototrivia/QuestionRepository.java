package projekt.java101.mototrivia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class QuestionRepository extends JpaRepository<Question, Long>{
    Optional<Question> findQuestionById(Long id);
}
