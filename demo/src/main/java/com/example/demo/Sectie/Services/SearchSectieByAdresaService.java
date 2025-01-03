package com.example.demo.Sectie.Services;

import com.example.demo.Query;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.SectieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchSectieByAdresaService implements Query<String, List<SectieDTO>> {

    private final SectieRepository sectieRepository;

    public SearchSectieByAdresaService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }


    @Override
    public ResponseEntity<List<SectieDTO>> execute(String adresa) {
        return ResponseEntity.ok(sectieRepository.findByAdresaContaining(adresa)
                .stream()
                .map(SectieDTO::new)
                .toList());
    }
}
