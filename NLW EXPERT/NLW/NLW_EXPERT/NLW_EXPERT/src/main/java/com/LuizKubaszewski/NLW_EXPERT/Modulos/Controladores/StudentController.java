package com.LuizKubaszewski.NLW_EXPERT.Modulos.Controladores;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LuizKubaszewski.NLW_EXPERT.Modulos.Entidades.CertificationStudentEntity;
import com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.StudentCertificationAnswerDTO;
import com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.VerifyhasCertificationDTO;
import com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.useCases.StudentCertificationAnswersUseCase;
import com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.useCases.VerifyIfHasCertificationUseCases;

@RestController
@RequestMapping("/Estudantes")
public class StudentController {
    @Autowired
    private VerifyIfHasCertificationUseCases VerifyIfHasCertificationUseCases;


    @Autowired
    private StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

    @PostMapping("/verifyifHasCertification")
    public String verifyHasCertification(@RequestBody VerifyhasCertificationDTO verifyhasCertificationDTO){

        var result = this.VerifyIfHasCertificationUseCases.execute(verifyhasCertificationDTO);
        if(result){
            return "Usuário já fez a prova";
        }

        return "Usuário pode fazer a prova";
    }
    @PostMapping("/certification/answer")
    public ResponseEntity<Object> certificationAnswer(
            @RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
        try {
            var result = studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    
    }
    
}
