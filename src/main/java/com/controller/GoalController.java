package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.ResourceNotFoundException;
import com.model.Goal;
import com.model.User;
import com.service.GoalService;

@RestController
@RequestMapping("api/goals")
public class GoalController {
	
	
	
	  @Autowired 
	  GoalService goalService;
	 
	 
	
	
	/*
	 * private final GoalService goalService;
	 * 
	 * public GoalController(GoalService goalService) { this.goalService =
	 * goalService; }
	 */
	 
	
	@PostMapping("/savegoal")
	public ResponseEntity<Goal> saveUserGoal(@RequestBody Goal goal)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(goalService.saveGoal(goal));
	}
	
	@GetMapping("/user/{userId}")
    public ResponseEntity<List<Goal>> getGoalsByUserId(@PathVariable Long userId) {
		List<Goal> goallist = goalService.getGoalsByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(goallist);
    }
	
	@PutMapping("updategoal/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long id,@RequestBody Goal goals) {
		
		try {
			return ResponseEntity.ok(goalService.updateGoal(id, goals));
			
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(goals);
		}
        
    }
	
	@DeleteMapping("deletegoal/{id}")
    public ResponseEntity<String> deleteGoal(@PathVariable Long id) {
		
		try {
			goalService.deleteGoal(id);
	        return ResponseEntity.ok("Goal Deleted Successfully");
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.status(404).body("Goal not Found");
		}
        
    }
	
	@GetMapping("/getAllGoals")
    public ResponseEntity<List<Goal>> getAllGoals() {
        List<Goal> goals = goalService.getAllGoals();
        return ResponseEntity.ok(goals);
    }

}
