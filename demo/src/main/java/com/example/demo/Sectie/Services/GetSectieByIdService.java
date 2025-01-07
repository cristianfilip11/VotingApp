package com.example.demo.Sectie.Services;

import com.example.demo.Exceptions.SectieNotFoundException;
import com.example.demo.Query;
import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.SectieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetSectieByIdService implements Query<Integer, SectieDTO> {

    private final SectieRepository sectieRepository;

    public GetSectieByIdService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }

    @Override
    public ResponseEntity<SectieDTO> execute(Integer id){
        Optional<Sectie> sectieOptional = sectieRepository.findById(id);
        if(sectieOptional.isPresent()){
            return ResponseEntity.ok(new SectieDTO(sectieOptional.get()));
        }
        throw new SectieNotFoundException();
    }
}
