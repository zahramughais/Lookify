package com.zahra.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zahra.lookify.models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
	
    List<Lookify> findAll();
    
    List<Lookify> findByArtist(String artist);
    
    List<Lookify> findTop10ByOrderByRatingDesc();

}
