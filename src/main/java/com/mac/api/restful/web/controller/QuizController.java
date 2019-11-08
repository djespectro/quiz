package com.mac.api.restful.web.controller;

import com.mac.api.restful.domain.services.QuizService;
import com.mac.api.restful.web.model.QuizDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/api/v1")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/quiz")
    public ResponseEntity saveQuiz(@RequestBody String provider){
        quizService.addQuiz(provider);
        return new ResponseEntity<>(quizService.getQuiz(), HttpStatus.CREATED);
    }

    @GetMapping("/quiz")
    public ResponseEntity<List<QuizDto>> getQuiz(){
        return new ResponseEntity<>(quizService.getQuiz(), HttpStatus.OK);
    }

}
