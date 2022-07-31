package com.zahra.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zahra.lookify.models.Lookify;
import com.zahra.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	private final LookifyRepository lookfiyRespository;
	
	public LookifyService(LookifyRepository lookfiyRespository) {
		this.lookfiyRespository = lookfiyRespository;
	}

	public List<Lookify> allLookifies() {
		return lookfiyRespository.findAll();
	}
	
    public Lookify createLookify(Lookify l) {
        return lookfiyRespository.save(l);
    }
    
    public Lookify findLookify(Long id) {
        Optional<Lookify> optionalLookify = lookfiyRespository.findById(id);
        if(optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }
    }
    
    public void deleteLookify(Long id) {
    	if (findLookify(id) != null) {
    		lookfiyRespository.deleteById(id);
    	}
    }
    
    public List<Lookify> artistAllSongs(String artist){
    	return lookfiyRespository.findByArtist(artist);
    }
    
    public List<Lookify> findTopTen (){
    	return lookfiyRespository.findTop10ByOrderByRatingDesc();
    }
    
}
