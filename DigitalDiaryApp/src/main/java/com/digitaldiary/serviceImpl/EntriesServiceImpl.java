package com.digitaldiary.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitaldiary.entities.Categories;
import com.digitaldiary.entities.Entries;
import com.digitaldiary.entities.User;
import com.digitaldiary.exception.DataException;
import com.digitaldiary.repository.CategoryRepo;
import com.digitaldiary.repository.DiaryRepo;
import com.digitaldiary.repository.UserRepository;
import com.digitaldiary.service.DiaryEntrieService;

@Service
public class EntriesServiceImpl implements DiaryEntrieService {

	@Autowired
	private DiaryRepo diaryRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private UserRepository repository;
	

	@Override
	public Entries addNewEntries(Entries entries) throws Exception {
		Optional<Categories> findById = categoryRepo.findById(entries.getCategoryId());
		
		Optional<User> findById2 = repository.findById(entries.getUserId());
	//	Categories categories = findById.get();
		entries.setDateCreated(LocalDateTime.now());
		entries.setDateModified(LocalDateTime.now());
		if(findById.isPresent() && findById2.isPresent()) {
			
			entries.setCategoryId(entries.getCategoryId());
			entries.setUserId(entries.getUserId());
		}else {
			
			throw new DataException("category not found or user not found !!!");
		}
		
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
		if (findById.isPresent()) {

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

	@Override
	public Categories addNewCategories(Categories categories) {
	
		Categories save = this.categoryRepo.save(categories);
		return save;
	}

	@Override
	public List<Categories> getAllCategories() {
		List<Categories> findAll = this.categoryRepo.findAll();
		return findAll;
	}

	@Override
	public Categories getCategoriesById(Integer id) {
		Categories orElseThrow = this.categoryRepo.findById(id).orElseThrow();
		return orElseThrow;
	}

	@Override
	public User addUser(User user) {
		  return repository.save(user);
	
	}

	@Override
	public User getUserById(int id) {
		Optional<User> findById = this.repository.findById(id);
		User user = findById.get();
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
	User findByUsername = this.repository.findByUsername(username);
		return findByUsername;
	}

}
