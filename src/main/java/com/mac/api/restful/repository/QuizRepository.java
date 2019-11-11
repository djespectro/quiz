package com.mac.api.restful.repository;

import com.mac.api.restful.domain.entity.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz, Integer> {

}
