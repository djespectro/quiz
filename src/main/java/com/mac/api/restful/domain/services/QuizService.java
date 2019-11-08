package com.mac.api.restful.domain.services;

import com.mac.api.restful.web.model.QuizDto;

import java.util.List;

public interface QuizService {

    QuizDto addQuiz(String cloudProvider);

    List<QuizDto> getQuiz();

}
