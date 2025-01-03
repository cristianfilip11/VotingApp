package com.example.demo.Sectie;

import com.example.demo.Sectie.Model.Sectie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectieRepository extends JpaRepository<Sectie, Integer> {

    List<Sectie> findByNumeContaining(String nume);
    List<Sectie> findByAdresaContaining(String adresa);

}
