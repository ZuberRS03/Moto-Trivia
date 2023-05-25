package projekt.java101.mototrivia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionControler {

        private final QuestionService questionService;

        @Autowired
        public QuestionControler(QuestionService questionService) {

                this.questionService = questionService;
        }

        @GetMapping("/all")
        public List<Question> getQuestions(){

                return questionService.getQuestions();
        }

        @PostMapping("/")
        public void cerateNewQuestion(@RequestBody Question question){

                questionService.addNewQuestion(question);
        }

        @DeleteMapping(path = "/{questionId}")
        public void deleteQuestion(@PathVariable("questionId") Long questionId){
                questionService.deleteQuestion(questionId);
        }

        @PutMapping(path = "/{questionId}")
        public void updateQuestion(
                @PathVariable("questionId") Long questionId,
                @RequestParam(required = false) String questionText,
                @RequestParam(required = false) String answer
        )  {
                questionService.updateQuestion(questionId, questionText, answer);

        }
}
