package com.example.demo.Votant.Services;

import com.example.demo.Query;
import com.example.demo.Sectie.Model.SectieDTO;
import com.example.demo.Votant.Model.Votant;
import com.example.demo.Votant.Model.VotantDTO;
import com.example.demo.Votant.VotantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchVotantByCnpService  implements Query<String, List<VotantDTO>> {

    private final VotantRepository votantRepository;

    public SearchVotantByCnpService(VotantRepository votantRepository) {
        this.votantRepository = votantRepository;
    }

    @Override
    public ResponseEntity<List<VotantDTO>> execute(String cnp) {
        return ResponseEntity.ok(votantRepository.findByCnpContaining(cnp)
                .stream()
                .map(VotantDTO::new)
                .toList());
    }
}
