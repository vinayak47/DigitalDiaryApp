package com.digitaldiary.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaldiary.entities.Entries;
import com.digitaldiary.repository.DiaryRepo;
import com.digitaldiary.service.DiaryEntrieService;

@Service
public class EntriesServiceImpl implements DiaryEntrieService{
	
	@Autowired
	private DiaryRepo diaryRepo;

	@Override
	public Entries addNewEntries(Entries entries) {
		entries.setDateCreated(LocalDateTime.now());
		entries.setDateModified(LocalDateTime.now());
		Entries entry = this.diaryRepo.save(entries);
		return entry;
	}

	@Override
	public List<Entries> getAllEntries() {
		List<Entries> list = this.diaryRepo.findAll();
		return list;
	}

	@Override
	public Entries updateEntries(Integer id, Entries entries) {
		Optional<Entries> findById = this.diaryRepo.findById(id);
		Entries entries2 = findById.get();
		if(findById.isPresent()) {
			
			
			entries2.setTitle(entries.getTitle());
			entries2.setContent(entries.getContent());
			entries2.setDateModified(LocalDateTime.now());
			this.diaryRepo.save(entries2);
		}
		return entries2;
	}

	@Override
	public Entries findSingleEntries(Integer id) {
		Entries entries = this.diaryRepo.findById(id).orElseThrow();
		return entries;
	}

	@Override
	public void deleteEntry(Integer id) {
		Entries entries = this.diaryRepo.findById(id).orElseThrow();
		this.diaryRepo.delete(entries);
		
	}

}
