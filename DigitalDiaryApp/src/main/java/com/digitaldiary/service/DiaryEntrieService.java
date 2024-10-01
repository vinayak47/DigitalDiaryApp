package com.digitaldiary.service;

import java.util.List;

import com.digitaldiary.entities.Entries;

public interface DiaryEntrieService {
	
	Entries addNewEntries(Entries entries);
	
	List<Entries> getAllEntries();
	
	Entries updateEntries(Integer id, Entries entries);
	
	Entries findSingleEntries(Integer id);
	
	void deleteEntry(Integer id);

}
