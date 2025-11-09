package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.WorkoutSession;
import com.service.UserService;
import com.service.WorkoutSessionService;

@RestController
@RequestMapping("api/workoutsession")
public class WorkoutSessionController {
	
	
	@Autowired
	WorkoutSessionService workoutSessionService;
	
	
	@PostMapping("/savesession")
	public ResponseEntity<WorkoutSession> saveWorkoutSession(@RequestBody WorkoutSession workoutSession)
	
	{
		return ResponseEntity.ok(workoutSessionService.saveWorkoutSession(workoutSession));
	}
	
	@GetMapping("/getallsessions")
	public ResponseEntity<?> getAllWorkoutSessions()
	{
		return ResponseEntity.ok(workoutSessionService.getAllWorkoutSessions());
	}

}
