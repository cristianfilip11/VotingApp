package com.example.demo.Votant.Services;

import com.example.demo.Command;
import com.example.demo.Exceptions.ErrorMessages;
import com.example.demo.Exceptions.VotantNotValidException;
import com.example.demo.Votant.Model.Votant;
import com.example.demo.Votant.Model.VotantDTO;
import com.example.demo.Votant.Validators.VotantValidator;
import com.example.demo.Votant.VotantRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateVotantService implements Command<Votant, VotantDTO> {

    private final VotantRepository votantRepository;

    public CreateVotantService(VotantRepository votantRepository) {
        this.votantRepository = votantRepository;
    }

    @Override
    public ResponseEntity<VotantDTO> execute(Votant votant) {
        //validate before saving

        //validareVotant(votant);
        VotantValidator.execute(votant);

        Votant savedVotant = votantRepository.save(votant);
        return ResponseEntity.status(HttpStatus.CREATED).body(new VotantDTO(savedVotant));
    }

}
