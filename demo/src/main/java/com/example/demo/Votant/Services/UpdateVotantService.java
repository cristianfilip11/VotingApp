package com.example.demo.Votant.Services;

import com.example.demo.Command;
import com.example.demo.Exceptions.VotantNotFoundException;
import com.example.demo.Votant.Model.UpdateVotantCommand;
import com.example.demo.Votant.Model.Votant;
import com.example.demo.Votant.Model.VotantDTO;
import com.example.demo.Votant.Validators.VotantValidator;
import com.example.demo.Votant.VotantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateVotantService implements Command<UpdateVotantCommand, VotantDTO> {

    private final VotantRepository votantRepository;

    public UpdateVotantService(VotantRepository votantRepository) {
        this.votantRepository = votantRepository;
    }


    @Override
    public ResponseEntity<VotantDTO> execute(UpdateVotantCommand command) {
        Optional<Votant> votantOptional = votantRepository.findById(command.getId());

        if(votantOptional.isPresent()){
            Votant votant = command.getVotant();
            votant.setId(command.getId());
            VotantValidator.execute(votant);

            votantRepository.save(votant);
            return ResponseEntity.ok(new VotantDTO(votant));
        }
        throw new VotantNotFoundException();
    }
}
