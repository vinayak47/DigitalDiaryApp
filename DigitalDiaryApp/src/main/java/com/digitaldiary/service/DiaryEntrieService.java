package com.digitaldiary.service;

import java.util.List;

import com.digitaldiary.entities.Categories;
import com.digitaldiary.entities.Entries;
import com.digitaldiary.entities.User;

public interface DiaryEntrieService {
	
	Entries addNewEntries(Entries entries)throws Exception;
	
	List<Entries> getAllEntries();
	
	Entries updateEntries(Integer id, Entries entries);
	
	Entries findSingleEntries(Integer id);
	
	void deleteEntry(Integer id);
	
	
	Categories addNewCategories(Categories categories);
	
	List<Categories> getAllCategories();
	
	Categories getCategoriesById(Integer id);
	
	
	 User addUser(User user);
	 User getUserById(int id);
	 User getUserByUsername(String username);

}
