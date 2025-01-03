package com.example.demo.Votant;

import com.example.demo.Votant.Model.Votant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotantRepository extends JpaRepository<Votant, Integer> {


    List<Votant> findByNumeContaining(String nume);

    //@Query("SELECT v FROM votant WHERE v.adresa LIKE %:keyword")
    //List<Votant> findByAddressContaining(@Param("keyword") String adresa);
}
