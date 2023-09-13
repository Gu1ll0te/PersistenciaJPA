package com.utn.persistenciajpa.repositorios;

import com.utn.persistenciajpa.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository <Domicilio,Long> {
}
