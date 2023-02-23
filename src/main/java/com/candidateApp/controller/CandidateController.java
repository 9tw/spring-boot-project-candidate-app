package com.candidateApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.candidateApp.dto.SearchData;
import com.candidateApp.entity.Candidate;
import com.candidateApp.service.CandidateService;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
    
    @Autowired
    private CandidateService candidateService;

    @RequestMapping(method = RequestMethod.POST)
    public Candidate insert(@RequestBody Candidate candidate){
            return candidateService.insert(candidate);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Candidate> findAll(){
        return candidateService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public List<Candidate> search(@RequestBody SearchData searchData){
        return candidateService.findByName(searchData.getSearchKey());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean delete(@PathVariable Long id){
        return candidateService.delete(id);
    }
}
