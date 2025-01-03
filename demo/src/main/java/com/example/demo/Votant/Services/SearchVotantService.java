package com.example.demo.Votant.Services;

import com.example.demo.Query;
import com.example.demo.Votant.Model.VotantDTO;
import com.example.demo.Votant.VotantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchVotantService implements Query<String, List<VotantDTO>> {
    private final VotantRepository votantRepository;

    public SearchVotantService(VotantRepository votantRepository) {
        this.votantRepository = votantRepository;
    }

    @Override
    public ResponseEntity<List<VotantDTO>> execute(String input) {
        return ResponseEntity.ok(votantRepository.findByNumeContaining(input)
                .stream()
                .map(VotantDTO::new)
                .toList());
    }
}
