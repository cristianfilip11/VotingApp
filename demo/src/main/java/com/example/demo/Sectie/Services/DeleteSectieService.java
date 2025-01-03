package com.example.demo.Sectie.Services;

import com.example.demo.Command;
import com.example.demo.Exceptions.SectieNotFoundException;
import com.example.demo.Exceptions.VotantNotFoundException;
import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.SectieRepository;
import com.example.demo.Votant.Model.Votant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteSectieService implements Command<Integer, Void> {
    private final SectieRepository sectieRepository;

    public DeleteSectieService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Sectie> sectieOptional = sectieRepository.findById(id);
        if(sectieOptional.isPresent()){
            sectieRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new SectieNotFoundException();
    }
}
