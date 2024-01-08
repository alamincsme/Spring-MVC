package com.alamincsme.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alamincsme.springboot.Programmer;


@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer, Integer> {


	
    @Query("from Programmer where pName = ?1")
	List<Programmer> findP(String pName);

	
	
}
