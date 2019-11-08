package com.mac.api.restful.repository;

import com.mac.api.restful.domain.entity.QuizEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<QuizEntity, Integer> {

}
