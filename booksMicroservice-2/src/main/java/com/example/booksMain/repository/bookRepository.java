package com.example.booksMain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.booksMain.Model.bookModel;

@Repository
public interface bookRepository extends JpaRepository<bookModel,Integer>{

}
