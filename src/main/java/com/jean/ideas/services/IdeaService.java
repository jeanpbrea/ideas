package com.jean.ideas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jean.ideas.models.Idea;
import com.jean.ideas.models.User;
import com.jean.ideas.repositories.IdeaRepository;
import com.jean.ideas.repositories.UserRepository;



@Service
public class IdeaService {
	private final UserRepository userRepository;
	private final IdeaRepository ideaRepository;
	
	public IdeaService(UserRepository userRepository, IdeaRepository ideaRepository) {
        this.userRepository = userRepository;
        this.ideaRepository = ideaRepository;

    }
	 public List<User> allUser() {
	    	return (List<User>) userRepository.findAll();
	}
	 public List<Idea> allIdea() {
	    	return (List<Idea>) ideaRepository.findAll();
	}
	 public Idea createIdea(Idea idea) {
	    	return ideaRepository.save(idea);
	}
	 
	 public Idea findIdea(Long id) {
	    	Optional<Idea> optionalIdea = ideaRepository.findById(id);
	    	if(optionalIdea.isPresent()) {
	    		return optionalIdea.get();
	    	} else {
	    		return null;
	    	}
	 }
	 public Idea updateIdea(Idea idea) {
	    	return ideaRepository.save(idea);
	    }
	 public Idea updateIdea(Long id, String ideaname, String creator) {
	    	Idea updateIdea = ideaRepository.findById(id).get();
	    	updateIdea.setIdeaname(ideaname);
	    	updateIdea.setCreator(creator);
	    	return ideaRepository.save(updateIdea);
	 }
	 public void deleteIdea(Long id) {
	    	ideaRepository.deleteById(id);
	    }
	 
//	 public List<Object[]> howMany(Long id){
//			return courseRepository.countPeople(id);
//		}
}
