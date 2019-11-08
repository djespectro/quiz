package com.mac.api.restful.web.model;

import com.mac.api.restful.domain.entity.CloudProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizDto {

    private Long count;
    private CloudProvider provider;

}
