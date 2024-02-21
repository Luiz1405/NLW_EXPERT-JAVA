package com.LuizKubaszewski.NLW_EXPERT.Modulos.questions.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LuizKubaszewski.NLW_EXPERT.Modulos.questions.entities.QuestionEntity;

public interface QuestionRepository  extends JpaRepository<QuestionEntity, UUID>{

    List<QuestionEntity> findByTechnology(String technology);

    

    
}
