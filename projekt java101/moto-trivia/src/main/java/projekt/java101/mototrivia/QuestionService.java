package projekt.java101.mototrivia;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private Scanner scanner;
    private int score;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.scanner = new Scanner(System.in);
        this.score = 0;
    }

    public void startQuiz(){
        List<Question> questions = getQuestions();
        for (Question question : questions) {
            printQuestion(question);
            String answer = scanner.nextLine();
            if (answer.equals(question.getAnswer())){
                System.out.println("Poprawna odpowiedź!");
                score++;
            } else {
                System.out.println("Zła odpowiedź!");
            }
        }
        System.out.println("Twój wynik to: " + score + "/" + questions.size());
    }

    public List<Question> getQuestions(){
        List<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        return questions;
    }

    private void printQuestion(Question question){
        System.out.println(question.getQuestionText());
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

        if (questionText != null && questionText.length() > 0 && !Objects.equals(question.getQuestionText(), questionText)) {
            question.setQuestionText(questionText);
        }
        if (answer != null && answer.length() > 0 && !Objects.equals(question.getAnswer(), answer)){
            question.setAnswer(answer);
        }
    }
}
