package projekt.java101.mototrivia;

import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    public void addNewQuestion(Question question) {
        Optional<Question> questionOptional = questionRepository.findQuestionById(question.getId());

        questionRepository.save(question);
    }

    public void deleteQuestion(Long questionId) {
        boolean exists = questionRepository.existsById(questionId);

        if (!exists){
            throw new IllegalStateException("Question with id " + questionId + " does not exist!");
        } else {
            questionRepository.deleteById(questionId);
        }
    }

    @Transactional
    public void updateQuestion(Long questionId, String questionText, String answer) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + questionId + " does not exist!"));

        if (questionText != null && questionText.length() > 0 && !Objects.equals(question.getQuestion(), questionText)) {
            question.setQuestion(questionText);
        }
        if (answer != null && answer.length() > 0 && !Objects.equals(question.getAnswer(), answer)){
            question.setAnswer(answer);
        }
    }
}
