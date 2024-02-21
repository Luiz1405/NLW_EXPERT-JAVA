package com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.VerifyhasCertificationDTO;
import com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.repositories.CertificationStudentRepository;
@Service
public class VerifyIfHasCertificationUseCases {

    @Autowired
    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyhasCertificationDTO dto){

        var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if (!result.isEmpty()) {
            return true;
        }
        return false;
    }   
    
    
}   
