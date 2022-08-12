package com.policyapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl implements IPolicyService {
	IPolicyDAO policyDao=new PolicyDAOImpl();

	@Override
	public void addPolicy(Policy policy) {
             policyDao.addPolicy(policy);	
	}

	@Override
	public void deletePolicy(int policyId) {
policyDao.deletePolicy(policyId);	
System.out.println("policy deleted");
	}

	@Override
	public void updatePolicy(int policyId, String category) {
policyDao.updatePolicy(policyId, category);		
	}

	@Override
	public List<Policy> getAll() {
		// TODO Auto-generated method stub
		return policyDao.findAll();
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByType(type).stream()
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policies.isEmpty()) {
			throw new PolicyNotFoundException("policy not found exception");
		}
		return policies;
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByCategory(category).stream()
		.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
		.collect(Collectors.toList());
if(policies.isEmpty())
{
	throw new PolicyNotFoundException("policy not found");
}
return policies;
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByHighSumAssured(sumAssured).stream()
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policies;
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByCoverage(coverage).stream()
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policies;
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByLessPremium(premium).stream()
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policies;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policyById=policyDao.findById(policyId);
		if(policyById !=null) {
			return policyById;
		}
throw new IdNotFoundException("id not exception");
	}

	@Override
	public List<Policy> getByBrand(String brand) throws PolicyNotFoundException {
		List<Policy>policies=policyDao.findByBrand(brand).stream()
				.sorted((p1,p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		if(policies.isEmpty())
		{
			throw new PolicyNotFoundException("policy not found");
		}
		return policies;
	}



}
