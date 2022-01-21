package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedingService {
	
	@Autowired
	FeedingRepository feedingRepository;
	
	
    public List<Feeding> getAll(){
        return feedingRepository.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return feedingRepository.findAllFeedingTypes();
    }

    public void save2(Feeding p) {
        feedingRepository.save(p);       
    }
    
    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
    	if(p.getFeedingType().getPetType()==null)
    		throw new UnfeasibleFeedingException();
    	else
    		return feedingRepository.save(p);
    }

    public FeedingType getFeedingType(String typeName) {
        return feedingRepository.findFeedingType(typeName);
    }
    
}
