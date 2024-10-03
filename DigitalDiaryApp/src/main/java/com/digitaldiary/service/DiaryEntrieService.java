package com.digitaldiary.service;

import java.util.List;

import com.digitaldiary.entities.Categories;
import com.digitaldiary.entities.Entries;

public interface DiaryEntrieService {
	
	Entries addNewEntries(Entries entries)throws Exception;
	
	List<Entries> getAllEntries();
	
	Entries updateEntries(Integer id, Entries entries);
	
	Entries findSingleEntries(Integer id);
	
	void deleteEntry(Integer id);
	
	
	Categories addNewCategories(Categories categories);
	
	List<Categories> getAllCategories();
	
	Categories getCategoriesById(Integer id);
	

}
