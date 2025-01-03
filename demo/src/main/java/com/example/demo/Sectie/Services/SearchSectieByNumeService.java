package com.example.demo.Sectie.Services;

import com.example.demo.Query;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.SectieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchSectieByNumeService implements Query<String, List<SectieDTO>> {
    private final SectieRepository sectieRepository;

    public SearchSectieByNumeService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }


    @Override
    public ResponseEntity<List<SectieDTO>> execute(String nume) {
        return ResponseEntity.ok(sectieRepository.findByNumeContaining(nume)
                .stream()
                .map(SectieDTO::new)
                .toList());

    }


}
