package org.nini.controller;

import java.util.List;
import java.util.Optional;

import org.nini.bean.Voiture;
import org.nini.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class VoitureController {

	 @Autowired
	    private VoitureRepository voitureRepository;

	    @GetMapping("/voitures")
	    public List<Voiture> getAllVoiture() {
	        return voitureRepository.findAll();
	    }
	    
	    @GetMapping("/voitures/{id}")
	    public Voiture getVoiture(@PathVariable(value = "id") Long idVoiture) {
	    	
	    	Optional<Voiture> voiture = voitureRepository.findById(idVoiture);
	    	
	        return voiture.get();
	    }
}
