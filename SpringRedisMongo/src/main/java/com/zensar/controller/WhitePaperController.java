package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.WhitePaper;
import com.zensar.repository.WhitePaperRepository;

@RestController
public class WhitePaperController {

	@Autowired
    WhitePaperRepository repository;
    
	@Autowired
    MongoTemplate mongoTemplate;
	
    @RequestMapping(value = "/whitePaper", method = RequestMethod.POST)
    public WhitePaper saveWhitePaper(WhitePaper whitePaper){
    	/*whitePaper = new WhitePaper();
    	whitePaper.setAuthor("Hello");
    	whitePaper.setDescription("Description");
    	whitePaper.setTitle("Hey");
    	
    	repository.save(whitePaper);
    	
    	whitePaper.setAuthor("author");
    	whitePaper.setDescription("description");
    	whitePaper.setTitle("title");
    	System.out.println("++++++++++++++++++++++++++"+whitePaper);*/
        return repository.save(whitePaper);
    }
    
    @RequestMapping(value = "/whitePaper/{title}", method = RequestMethod.GET)
    @Cacheable(value = "whitePaper", key = "#title")
    public WhitePaper findWhitePaperByTitle(@PathVariable String title) 
    {
    	System.out.println("Whitepaper find by title!");
    	WhitePaper insertedWhitePaper = repository.findByTitle(title);
        return insertedWhitePaper;
    }
    
    @RequestMapping(value = "/updateByTitle/{title}/{author}", method = RequestMethod.GET)
    @CachePut(value = "whitePaper", key = "#title")
    public WhitePaper updateByTitle(@PathVariable(value = "title") String title,
            @PathVariable(value = "author") String author)
    {
        Query query = new Query(Criteria.where("title").is(title));
        Update update = new Update().set("author", author);
        WhitePaper result = mongoTemplate.findAndModify(query, update,
                new FindAndModifyOptions().returnNew(true).upsert(false), WhitePaper.class);
        return result;
    }

	
}
