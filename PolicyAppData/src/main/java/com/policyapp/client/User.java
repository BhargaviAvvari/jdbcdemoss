package com.policyapp.client;

import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.service.IPolicyService;
import com.policyapp.service.PolicyServiceImpl;

public class User {

	public static void main(String[] args) {
		IPolicyService policyService = new PolicyServiceImpl();
		/*
		 * Policy policy=new
		 * Policy("acko",1002,20000,"vechile",10,"accident","motor","suzuki",2000000);
		 * Policy policy1=new
		 * Policy("jeevan sathi",1003,30000,"mutual",10,"divorce","marriage","life",
		 * 2000000);
		 * 
		 * //policyService.addPolicy(policy1); policyService.deletePolicy(1);
		 */
		/* policyService.updatePolicy(2, "shadi"); */
		/*
		 * try { policyService.getByType("marriage").forEach(System.out::println); }
		 * catch (PolicyNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println("policy deleted");
		 */

		policyService.getAll().forEach(System.out::println);
	}
}
