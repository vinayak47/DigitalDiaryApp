package com.digitaldiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitaldiary.entities.Categories;

public interface CategoryRepo extends JpaRepository<Categories,Integer>{

}
