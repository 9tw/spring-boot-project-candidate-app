package com.candidateApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidateApp.entity.Candidate;
import com.candidateApp.repo.CandidateRepo;

import jakarta.transaction.Transactional;

@Service("candidateService")
@Transactional
public class CandidateService {
    
    @Autowired
    private CandidateRepo repo;

    public Candidate insert(Candidate candidate){
        return repo.save(candidate);
    }

    public List<Candidate> findAll(){
        return repo.findAllCandidate();
    }

    public List<Candidate> findByName(String name){
        return repo.findByName(name);
    }

    public boolean delete(Long id){
        repo.deleteById(id);
        return true;
    }
}
