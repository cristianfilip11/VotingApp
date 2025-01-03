package com.example.demo.Sectie.Services;


import com.example.demo.Command;
import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.SectieRepository;
import com.example.demo.Sectie.Validators.SectieValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateSectieService implements Command<Sectie, SectieDTO> {
    private final SectieRepository sectieRepository;

    public CreateSectieService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }

    @Override
    public ResponseEntity<SectieDTO> execute(Sectie sectie){
        //validare
        SectieValidator.execute(sectie);

        Sectie savedSectie = sectieRepository.save(sectie);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SectieDTO(savedSectie));
    }

}
