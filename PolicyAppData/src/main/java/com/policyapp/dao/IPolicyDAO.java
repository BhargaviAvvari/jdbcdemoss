package com.policyapp.dao;

import java.util.List;

import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;

public interface IPolicyDAO {
	
	void addPolicy(Policy policy);
	void deletePolicy( int policyId);
	void updatePolicy(int policyID,String Coverage);
	List<Policy> findAll();
	List<Policy> findByType(String type)throws PolicyNotFoundException;
	List<Policy>findByCategory(String category)throws PolicyNotFoundException;
	List<Policy> findByHighSumAssured(double sumAssured)throws PolicyNotFoundException;
	List<Policy> findByCoverage(String coverage)throws PolicyNotFoundException;
	List<Policy> findByLessPremium(double premium)throws PolicyNotFoundException;
	List<Policy> findByBrand(String brand)throws PolicyNotFoundException;
	Policy findById(int policyId)throws IdNotFoundException;
}
