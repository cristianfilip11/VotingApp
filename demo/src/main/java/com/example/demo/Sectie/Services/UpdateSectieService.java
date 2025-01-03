package com.example.demo.Sectie.Services;

import com.example.demo.Command;
import com.example.demo.Exceptions.SectieNotFoundException;
import com.example.demo.Exceptions.SectieNotValidException;
import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.Model.UpdateSectieCommand;
import com.example.demo.Sectie.SectieRepository;
import com.example.demo.Sectie.Validators.SectieValidator;
import com.example.demo.Votant.Model.VotantDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateSectieService implements Command<UpdateSectieCommand, SectieDTO> {
    private final SectieRepository sectieRepository;

    public UpdateSectieService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }

    @Override
    public ResponseEntity<SectieDTO> execute(UpdateSectieCommand command) {
        Optional<Sectie> sectieOptional = sectieRepository.findById(command.getId());

        if(sectieOptional.isPresent()){
            Sectie sectie = command.getSectie();
            sectie.setId(command.getId());
            SectieValidator.execute(sectie);
            sectieRepository.save(sectie);
            return ResponseEntity.ok(new SectieDTO(sectie));
        }
        throw new SectieNotFoundException();
    }
}
