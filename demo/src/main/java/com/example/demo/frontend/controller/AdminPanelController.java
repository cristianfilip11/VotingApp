package com.example.demo.frontend.controller;

import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Sectie.Services.CreateSectieService;
import com.example.demo.Sectie.Services.GetSectiiService;
import com.example.demo.Votant.Services.GetVotantiService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminPanelController {

    private final CreateSectieService createSectieService;
    private final GetSectiiService getSectiiService;
    private final GetVotantiService getVotantiService;

    public AdminPanelController(CreateSectieService createSectieService, GetSectiiService getSectiiService, GetVotantiService getVotantiService) {
        this.createSectieService = createSectieService;
        this.getSectiiService = getSectiiService;
        this.getVotantiService = getVotantiService;
    }

    @GetMapping("/adminpanel")
    public String showAdminPanelPage(Model model){
        ResponseEntity<List<SectieDTO>> sectiiResponse = getSectiiService.execute(null);
        model.addAttribute("sectii", sectiiResponse.getBody());
        model.addAttribute("sectie", new Sectie());
        model.addAttribute("votanti", getVotantiService.execute(null).getBody());
        return "adminpanel";
    }
}
