package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.EmployeeDetails;

public interface Repository extends JpaRepository<EmployeeDetails, Integer> {

}
