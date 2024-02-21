package com.LuizKubaszewski.NLW_EXPERT.Modulos.Estudantes.Dto.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LuizKubaszewski.NLW_EXPERT.Modulos.Entidades.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {

    public Optional<StudentEntity> findByEmail(String email);
}
