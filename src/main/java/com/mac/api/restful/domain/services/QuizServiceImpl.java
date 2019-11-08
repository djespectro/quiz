package com.mac.api.restful.domain.services;

import com.mac.api.restful.domain.entity.CloudProvider;
import com.mac.api.restful.domain.entity.QuizEntity;
import com.mac.api.restful.repository.QuizRepository;
import com.mac.api.restful.web.model.QuizDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class QuizServiceImpl implements QuizService {

    private final QuizRepository repository;

    public QuizServiceImpl(QuizRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuizDto addQuiz(String provider) {
        CloudProvider cloudProvider = CloudProvider.getValue(provider);
        QuizEntity quizEntity = new QuizEntity();
        quizEntity.setCloudProvider(cloudProvider);
        return mapEntityToDto(repository.save(quizEntity));
    }

    @Override
    public List<QuizDto> getQuiz() {
        List<QuizDto> dtoList = new ArrayList<>();

        Iterable<QuizEntity> quizEntities = repository.findAll();

        List<CloudProvider> tempQuizDtos = new ArrayList<>();
        quizEntities.forEach(quizEntity -> tempQuizDtos.add(quizEntity.getCloudProvider()));

        Long awsCount = tempQuizDtos.stream().filter(provider -> CloudProvider.AWS == provider).count();
        long azureCount = tempQuizDtos.stream().filter(provider -> CloudProvider.AZURE == provider).count();
        long googleCount = tempQuizDtos.stream().filter(provider -> CloudProvider.GOOGLE == provider).count();

        dtoList.add(QuizDto.builder().provider(CloudProvider.AWS).count(awsCount).build());
        dtoList.add(QuizDto.builder().provider(CloudProvider.AZURE).count(azureCount).build());
        dtoList.add(QuizDto.builder().provider(CloudProvider.GOOGLE).count(googleCount).build());

        return dtoList;
    }

    private QuizDto mapEntityToDto(QuizEntity entity) {
        log.debug(entity.toString());
        QuizDto dto = new QuizDto();
        dto.setProvider(entity.getCloudProvider());
        return dto;
    }

}
