package com.candidateApp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.candidateApp.entity.Candidate;

public interface CandidateRepo extends CrudRepository<Candidate, Long> {
    
    @Query("SELECT c FROM Candidate c")
    public List<Candidate> findAllCandidate();

    @Query("SELECT c FROM Candidate c WHERE LOWER(c.fullname) LIKE LOWER(:name)")
    public List<Candidate> findByName(@Param("name") String name);
}
