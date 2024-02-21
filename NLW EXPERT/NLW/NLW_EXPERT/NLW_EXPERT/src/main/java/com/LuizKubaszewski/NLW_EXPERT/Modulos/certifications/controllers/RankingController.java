package com.LuizKubaszewski.NLW_EXPERT.Modulos.certifications.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LuizKubaszewski.NLW_EXPERT.Modulos.Entidades.CertificationStudentEntity;
import com.LuizKubaszewski.NLW_EXPERT.Modulos.certifications.useCases.Top10RankingUseCase;
import com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.repositories.CertificationStudentRepository;


@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private Top10RankingUseCase top10RankingUseCase;

    @GetMapping("/top10")
    public List<CertificationStudentEntity> top10() {
        //return this.top10RankingUseCase.execute();
        return this.top10RankingUseCase.execute();
    }
} 

