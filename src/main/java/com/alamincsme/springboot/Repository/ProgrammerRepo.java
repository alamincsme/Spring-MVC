package com.alamincsme.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alamincsme.springboot.Programmer;


@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer, Integer> {
	
}
