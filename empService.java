package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.EmployeeDetails;
import com.example.demo.Repository;

@Service
@Transactional
public class empService {
	@Autowired
	private Repository repo;
	
	public List<EmployeeDetails> listAll() {
		return repo.findAll();
	}
	
	public void save(EmployeeDetails emp) {
		repo.save(emp);
	}
	
	public EmployeeDetails get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}

}
