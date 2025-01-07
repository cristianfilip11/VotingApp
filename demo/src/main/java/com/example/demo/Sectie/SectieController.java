package com.example.demo.Sectie;

import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.Model.UpdateSectieCommand;
import com.example.demo.Sectie.Services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SectieController {

    private final CreateSectieService createSectieService;
    private final GetSectiiService getSectiiService;
    private final SearchSectieByNumeService searchSectieByNumeService;
    private final SearchSectieByAdresaService searchSectieByAdresaService;
    private final DeleteSectieService deleteSectieService;
    private final UpdateSectieService updateSectieService;
    private final GetSectieByIdService getSectieByIdService;

    public SectieController(
            CreateSectieService createSectieService,
            GetSectiiService getSectiiService,
            SearchSectieByNumeService searchSectieByNumeService,
            SearchSectieByAdresaService searchSectieByAdresaService,
            DeleteSectieService deleteSectieService,
            UpdateSectieService updateSectieService, GetSectieByIdService getSectieByIdService
    ){
        this.createSectieService = createSectieService;
        this.getSectiiService = getSectiiService;
        this.searchSectieByNumeService = searchSectieByNumeService;
        this.searchSectieByAdresaService = searchSectieByAdresaService;
        this.deleteSectieService = deleteSectieService;
        this.updateSectieService = updateSectieService;
        this.getSectieByIdService = getSectieByIdService;
    }

    /*@PostMapping("/sectie")
    //public ResponseEntity<SectieDTO> createSectie(@ModelAttribute Sectie sectie, Model model)
    public String createSectie(@ModelAttribute Sectie sectie, Model model){
        //return createSectieService.execute(sectie);

        try {
            createSectieService.execute(sectie);
            model.addAttribute("successMessage", "Sectie adaugata cu succes!");
        }
        //TO DO: EXCEPTIE CUSTOM, VALIDARE IN SERVICE NU AM INCA
        catch (Exception e){
            model.addAttribute("errorMessage", "Eroare" + e.getMessage());
        }
        return "adminpanel";
    }*/

    /*@PostMapping("/sectie")
    public ResponseEntity<SectieDTO> createSectie(@RequestBody Sectie sectie){
        return createSectieService.execute(sectie);
    }*/

    @PostMapping("/sectie")
    public String createSectie(@ModelAttribute Sectie sectie, RedirectAttributes redirectAttributes) {
        try {
            createSectieService.execute(sectie);
            redirectAttributes.addFlashAttribute("successMessage", "Sectie adaugata cu succes!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Eroare: " + e.getMessage());

        }
        return "redirect:/adminpanel";
    }


   /* @GetMapping("/sectii")
    public ResponseEntity<List<SectieDTO>> getSectii(){
        return getSectiiService.execute(null);
    }*/

    @GetMapping("/sectii")
    public ResponseEntity<List<SectieDTO>> getSectii(){
        return getSectiiService.execute(null);
    }


    //search by name
    @GetMapping("/sectii/search/by-name")
    public String searchSectieByName(@RequestParam String nume, Model model){
        List<SectieDTO> sectieDTOS = searchSectieByNumeService.execute(nume).getBody();
        model.addAttribute("sectiiSearch", sectieDTOS);
        return "adminpanel";
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


    //new

    @GetMapping("/sectie/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        SectieDTO sectieDTO = getSectieByIdService.execute(id).getBody();
        model.addAttribute("sectieToEdit", sectieDTO);
        // Add all other necessary attributes for the main page
        model.addAttribute("sectii", getSectiiService.execute(null).getBody());
        return "adminpanel";
    }

    @PostMapping("/sectie/{id}/update")
    public String updateSectie(@PathVariable Integer id, @ModelAttribute Sectie sectie,
                               RedirectAttributes redirectAttributes) {
        try {
            updateSectieService.execute(new UpdateSectieCommand(id, sectie));
            redirectAttributes.addFlashAttribute("successMessage", "Sectie updated successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error updating sectie: " + e.getMessage());
        }
        return "redirect:/adminpanel";
    }
    @GetMapping("/sectie/{id}/confirm-delete")
    public String showDeleteConfirmation(@PathVariable Integer id, Model model) {
        SectieDTO sectieDTO = getSectieByIdService.execute(id).getBody();
        model.addAttribute("sectieToDelete", sectieDTO);
        // Add all other necessary attributes for the main page
        model.addAttribute("sectii", getSectiiService.execute(null).getBody());
        return "adminpanel";
    }

    @PostMapping("/sectie/{id}/delete")
    public String deleteSectie(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            deleteSectieService.execute(id);
            redirectAttributes.addFlashAttribute("successMessage", "Sectie deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting sectie: " + e.getMessage());
        }
        return "redirect:/adminpanel";
    }





}
