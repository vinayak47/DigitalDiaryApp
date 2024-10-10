package com.digitaldiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitaldiary.entities.User;
import com.digitaldiary.service.DiaryEntrieService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private DiaryEntrieService diaryEntrieService;

	@PostMapping
	public User createUser(@RequestBody User user) {
		return diaryEntrieService.addUser(user);
	}
	
	@GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return diaryEntrieService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return diaryEntrieService.getUserByUsername(username);
    }
}
