package com.example.demo.Votant;

import com.example.demo.Exceptions.VotantNotFoundException;
import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Votant.Model.*;
import com.example.demo.Votant.Services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VotantController {


    private final CreateVotantService createVotantService;

    private final GetVotantiService getVotantiService;

    private final UpdateVotantService updateVotantService;

    private final DeleteVotantService deleteVotantService;

    private final GetVotantService getVotantService;

    private final SearchVotantService searchVotantService;


    public VotantController(CreateVotantService createVotantService,
                            GetVotantiService getVotantiService,
                            UpdateVotantService updateVotantService,
                            GetVotantService getVotantService,
                            SearchVotantService searchVotantService,
                            DeleteVotantService deleteVotantService) {
        this.createVotantService = createVotantService;
        this.getVotantiService = getVotantiService;
        this.updateVotantService = updateVotantService;
        this.deleteVotantService = deleteVotantService;
        this.getVotantService = getVotantService;
        this.searchVotantService = searchVotantService;
    }

    @PostMapping("/votant")
    //public String createVotant(@ModelAttribute Votant votant, RedirectAttributes redirectAttributes){
    public String createVotant(@ModelAttribute VotantRequestDTO votantRequestDTO, RedirectAttributes redirectAttributes) {
        try {
            createVotantService.execute(votantRequestDTO);
            redirectAttributes.addFlashAttribute("successMessage", "Votant adaugat cu succes!");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Eroare: " + e.getMessage());
        }
        return "redirect:/adminpanel";


    }

    @GetMapping("/votanti")
    public ResponseEntity<List<VotantDTO>> getVotanti(){
        return getVotantiService.execute(null);
    }

    //new get mapping for find by id
    @GetMapping("/votant/{id}")
    public ResponseEntity<VotantDTO> getVotantById(@PathVariable Integer id){
        return getVotantService.execute(id);
    }

    //mapping to search by name
    @GetMapping("/votant/search")
    public ResponseEntity<List<VotantDTO>> searchProductByName(@RequestParam String nume){
        return searchVotantService.execute(nume);
    }
    @PutMapping("/votant/{id}")
    public ResponseEntity<VotantDTO> updateVotant(@PathVariable Integer id, @RequestBody Votant votant){
        return updateVotantService.execute(new UpdateVotantCommand(id, votant));
    }


    @DeleteMapping("/votant/{id}")
    public ResponseEntity<Void> deleteVotant(@PathVariable Integer id){
        return deleteVotantService.execute(id);
    }


}
