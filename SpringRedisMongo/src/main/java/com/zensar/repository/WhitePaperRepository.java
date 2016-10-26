package com.zensar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zensar.model.WhitePaper;

@Repository
public interface WhitePaperRepository extends MongoRepository<WhitePaper,String>{
	
	WhitePaper findByTitle(String title);
    void delete(String title);

}
