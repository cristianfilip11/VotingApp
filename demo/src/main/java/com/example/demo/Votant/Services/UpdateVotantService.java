package com.example.demo.Votant.Services;

import com.example.demo.Command;
import com.example.demo.Exceptions.SectieNotFoundException;
import com.example.demo.Exceptions.VotantNotFoundException;
import com.example.demo.Sectie.Model.Sectie;
import com.example.demo.Sectie.SectieRepository;
import com.example.demo.Votant.Model.UpdateVotantCommand;
import com.example.demo.Votant.Model.Votant;
import com.example.demo.Votant.Model.VotantDTO;
import com.example.demo.Votant.Validators.VotantValidator;
import com.example.demo.Votant.VotantRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateVotantService implements Command<UpdateVotantCommand, VotantDTO> {

    private final VotantRepository votantRepository;
    private final SectieRepository sectieRepository;

    public UpdateVotantService(VotantRepository votantRepository, SectieRepository sectieRepository) {
        this.votantRepository = votantRepository;
        this.sectieRepository = sectieRepository;
    }


    @Override
    @Transactional
    public ResponseEntity<VotantDTO> execute(UpdateVotantCommand command) {
        Votant votant = votantRepository.findById(command.getId())
                .orElseThrow(VotantNotFoundException::new);


        votant.setNume(command.getVotant().getNume());
       // votant.setAdresa(command.getVotant().getAdresa());
        votant.setCnp(command.getVotant().getCnp());
        votant.setVarsta(command.getVotant().getVarsta());

        // Update Sectie association
        Sectie sectie = sectieRepository.findById(command.getVotant().getSectieId())
                .orElseThrow((SectieNotFoundException::new));
        votant.setSectie(sectie);

        // Validate updated votant
        VotantValidator.execute(votant);

        // Save updated votant
        votant = votantRepository.save(votant);

        return ResponseEntity.ok(new VotantDTO(votant));
    }
}
