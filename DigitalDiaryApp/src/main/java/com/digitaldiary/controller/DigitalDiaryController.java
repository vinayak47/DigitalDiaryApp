package com.digitaldiary.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.digitaldiary.entities.Categories;
import com.digitaldiary.entities.Entries;
import com.digitaldiary.service.DiaryEntrieService;

@RestController
public class DigitalDiaryController {

	
	@Autowired
	private DiaryEntrieService entrieService;
	
	
	@PostMapping("/addEntry")
	public ResponseEntity<Entries> addNewEntry(@RequestBody Entries entries) throws Exception{
		
		Entries addNewEntries = this.entrieService.addNewEntries(entries);
		return new ResponseEntity<Entries>(addNewEntries,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/updateEntry/{id}")
	public ResponseEntity<Entries> updateEntry(@PathVariable Integer id,@RequestBody Entries entries){
		
		Entries updateEntries = this.entrieService.updateEntries(id, entries);
		return new ResponseEntity<Entries>(updateEntries,HttpStatus.OK);
		
	}
	
	@GetMapping("/getListEntries")
	public ResponseEntity<List<Entries>> getallEntry(){
		
		List<Entries> allEntries = this.entrieService.getAllEntries();
		return new ResponseEntity<List<Entries>>(allEntries,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEntry/{id}")
	public ResponseEntity<String> deleteEntry(@PathVariable Integer id){
		
		this.entrieService.deleteEntry(id);
		return new ResponseEntity<String>("Entry deleted successfully for id "+id,HttpStatus.OK);
	}
	
	@PostMapping("/addCategoryName")
	public ResponseEntity<Categories> addNewCategory(@RequestBody Categories categories){
		
		Categories addNewCategories = this.entrieService.addNewCategories(categories);
		return new ResponseEntity<Categories>(addNewCategories,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<Categories>> getallCategory(){
		
		List<Categories> categories = this.entrieService.getAllCategories();
		return new ResponseEntity<List<Categories>>(categories,HttpStatus.OK);
	}
}
