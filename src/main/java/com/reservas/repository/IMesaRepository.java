package com.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservas.model.Mesa;

@Repository
public interface IMesaRepository extends JpaRepository<Mesa,Long> {
}
