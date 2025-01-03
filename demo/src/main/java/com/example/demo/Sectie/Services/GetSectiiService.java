package com.example.demo.Sectie.Services;

import com.example.demo.Query;
import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.SectieRepository;
import com.example.demo.Votant.Model.VotantDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSectiiService implements Query<Void, List<SectieDTO>> {

    private final SectieRepository sectieRepository;

    public GetSectiiService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }

    @Override
    public ResponseEntity<List<SectieDTO>> execute(Void input) {
        List<Sectie> sectii = sectieRepository.findAll();
        List<SectieDTO> sectiiDTO = sectii.stream().map(SectieDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(sectiiDTO);
        //return ResponseEntity.status(HttpStatus.OK).body(votantiDTO);
    }
}
