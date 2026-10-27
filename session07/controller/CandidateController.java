
package com.example.session07.controller;

import com.example.session07.dto.CandidateCreateDTO;
import com.example.session07.entity.Candidate;
import com.example.session07.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateRepository repository;

    public CandidateController(CandidateRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Candidate create(@Valid @RequestBody CandidateCreateDTO dto) {
        Candidate candidate = new Candidate();
        candidate.setFullName(dto.getFullName());
        candidate.setEmail(dto.getEmail());
        candidate.setAge(dto.getAge());
        candidate.setYearsOfExperience(dto.getYearsOfExperience());

        return repository.save(candidate);
    }
}
