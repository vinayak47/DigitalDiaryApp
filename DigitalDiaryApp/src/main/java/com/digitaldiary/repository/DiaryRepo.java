package com.digitaldiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitaldiary.entities.Entries;

public interface DiaryRepo extends JpaRepository<Entries,Integer>{

}
