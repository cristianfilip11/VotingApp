package com.example.demo.Sectie;

import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.Model.UpdateSectieCommand;
import com.example.demo.Sectie.Services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectieController {

    private final CreateSectieService createSectieService;
    private final GetSectiiService getSectiiService;
    private final SearchSectieByNumeService searchSectieByNumeService;
    private final SearchSectieByAdresaService searchSectieByAdresaService;
    private final DeleteSectieService deleteSectieService;
    private final UpdateSectieService updateSectieService;

    public SectieController(
            CreateSectieService createSectieService,
            GetSectiiService getSectiiService,
            SearchSectieByNumeService searchSectieByNumeService,
            SearchSectieByAdresaService searchSectieByAdresaService,
            DeleteSectieService deleteSectieService,
            UpdateSectieService updateSectieService
    ){
        this.createSectieService = createSectieService;
        this.getSectiiService = getSectiiService;
        this.searchSectieByNumeService = searchSectieByNumeService;
        this.searchSectieByAdresaService = searchSectieByAdresaService;
        this.deleteSectieService = deleteSectieService;
        this.updateSectieService = updateSectieService;
    }

    @PostMapping("/sectie")
    public ResponseEntity<SectieDTO> createSectie(@RequestBody Sectie sectie){
        return createSectieService.execute(sectie);
    }

    @GetMapping("/sectii")
    public ResponseEntity<List<SectieDTO>> getSectii(){
        return getSectiiService.execute(null);
    }

    //poate un getSectieById

    //search by name
    @GetMapping("/sectii/search/by-name")
    public ResponseEntity<List<SectieDTO>> searchSectieByName(@RequestParam String nume){
        return searchSectieByNumeService.execute(nume);
    }

    @GetMapping("/sectii/search/by-address")
    public ResponseEntity<List<SectieDTO>> searchSectieByAdresa(@RequestParam String adresa){
        return searchSectieByAdresaService.execute(adresa);
    }

    @DeleteMapping("/sectie/{id}")
    public ResponseEntity<Void> deleteSectie(@PathVariable Integer id){
        return deleteSectieService.execute(id);
    }

    @PutMapping("/sectie/{id}")
    public ResponseEntity<SectieDTO> updateSectie(@PathVariable Integer id, @RequestBody Sectie sectie){
        return updateSectieService.execute(new UpdateSectieCommand(id, sectie));
    }




}
