package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.dao.WorkoutSessionRepository;
import com.model.User;
import com.model.WorkoutSession;

@Service
public class WorkoutSessionServiceImpl implements WorkoutSessionService{
	
	@Autowired
	public WorkoutSessionRepository workoutSessionRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Override
	public WorkoutSession saveWorkoutSession(WorkoutSession workoutSession) {
		
		Long UserId = workoutSession.getUser().getId();
		
		User user = userRepository.findById(UserId).orElseThrow(() -> new RuntimeException("User Not found with Id= "+UserId));
		
		workoutSession.setUser(user);
		return workoutSessionRepository.save(workoutSession);
	}

	@Override
	public List<WorkoutSession> getAllWorkoutSessions() {
		
		return workoutSessionRepository.findAll();
	}

}
