package com.policyapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mysql.cj.jdbc.ConnectionImpl;
import com.policyapp.exception.IdNotFoundException;
import com.policyapp.exception.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.util.DbConnection;

public class PolicyDAOImpl implements IPolicyDAO {

	@Override
	public void addPolicy(Policy policy) {
		String sql = "insert into policy( policy_Name,premium, type,duration,coverage, brand,category, sum_assured)values(?,?,?,?,?,?,?,?) ";
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, policy.getPolicyName());
			preparedstatement.setDouble(2, policy.getPremium());
			preparedstatement.setString(3, policy.getType());

			preparedstatement.setInt(4, policy.getDuration());
			preparedstatement.setString(5, policy.getCoverage());
			preparedstatement.setString(6, policy.getBrand());
			preparedstatement.setString(7, policy.getCategory());
			preparedstatement.setDouble(8, policy.getSumAssured());
			preparedstatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.openConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void deletePolicy(int policyId) {
		String sql = "delete from policy where policy_id=" + policyId;
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.openConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
			}
		}

	}

	@Override
	public void updatePolicy(int policyId, String category) {
		String sql = "update policy set category=?  where policy_id=?";
		Connection connection = DbConnection.openConnection();
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, category);
			preparedstatement.setInt(2, policyId);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DbConnection.openConnection();
				if (preparedstatement != null)
					preparedstatement.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public List<Policy> findAll() {
		List<Policy> Policy = new ArrayList<Policy>();
		String sql = "select * from policy";
		Connection connection = DbConnection.openConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* Policy policy = new Policy(); */
				String policyName = rs.getString("policy_name");
				int policyNumber = rs.getInt("policy_id");
				double premium = rs.getDouble("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String category = rs.getString("category");
				String brand = rs.getString("brand");
				double sumAssured = rs.getDouble("sum_assured");
				Policy policy = new Policy(policyName, policyNumber, premium, type, duration, coverage, category, brand,sumAssured);
				/*
				 * policy.setPolicyName(policyName); policy.setPolicyNum(policyNumber);
				 * policy.setPremium(premium); policy.setType(type);
				 * policy.setDuration(duration); policy.setCoverage(coverage);
				 * policy.setCategory(category); policy.setBrand(brand);
				 * policy.setSumAssured(sumAssured);
				 */

				Policy.add(policy);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.connection();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}
		return Policy;
	}

	@Override
	public List<Policy> findByType(String ntype) throws PolicyNotFoundException {
		List<Policy> policies = new ArrayList<Policy>();
		String sql = "select * from policy where type=?";
		Connection connection = DbConnection.openConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ntype);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* Policy policy = new Policy(); */
				String policyName = rs.getString("policy_name");
				int policyNumber = rs.getInt("policy_id");
				double premium = rs.getDouble("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String category = rs.getString("category");
				String brand = rs.getString("brand");
				double sumAssured = rs.getDouble("sum_assured");
				Policy policy = new Policy(policyName, policyNumber, premium, type, duration, coverage, category, brand,sumAssured);
				policies.add(policy);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.connection();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}
		return policies;
	}
	

	@Override
	public List<Policy> findByCategory(String ncategory) throws PolicyNotFoundException {
		List<Policy> Policy = new ArrayList<Policy>();
		String sql = "select * from policy where category=?";
		Connection connection = DbConnection.openConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ncategory);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* Policy policy = new Policy(); */
				String policyName = rs.getString("policy_name");
				int policyNumber = rs.getInt("policy_id");
				double premium = rs.getDouble("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String category = rs.getString("category");
				String brand = rs.getString("brand");
				double sumAssured = rs.getDouble("sum_assured");
				Policy policy = new Policy(policyName, policyNumber, premium, type, duration, coverage, category, brand,sumAssured);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.connection();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}
		return Policy;
	}

	@Override
	public List<Policy> findByHighSumAssured(double nsumAssured) throws PolicyNotFoundException {
		List<Policy> Policy = new ArrayList<Policy>();
		String sql = "select * from policy where sumAssured=?";
		Connection connection = DbConnection.openConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, nsumAssured);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* Policy policy = new Policy(); */
				String policyName = rs.getString("policy_name");
				int policyNumber = rs.getInt("policy_id");
				double premium = rs.getDouble("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String category = rs.getString("category");
				String brand = rs.getString("brand");
				double sumAssured = rs.getDouble("sum_assured");
				Policy policy = new Policy(policyName, policyNumber, premium, type, duration, coverage, category, brand,sumAssured);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.connection();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}
		return Policy;
	}

	@Override
	public List<Policy> findByCoverage(String ncoverage) throws PolicyNotFoundException {
		List<Policy> Policy = new ArrayList<Policy>();
		String sql = "select * from policy where coverage=?";
		Connection connection = DbConnection.openConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ncoverage);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* Policy policy = new Policy(); */
				String policyName = rs.getString("policy_name");
				int policyNumber = rs.getInt("policy_id");
				double premium = rs.getDouble("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String category = rs.getString("category");
				String brand = rs.getString("brand");
				double sumAssured = rs.getDouble("sum_assured");
				Policy policy = new Policy(policyName, policyNumber, premium, type, duration, coverage, category, brand,sumAssured);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.connection();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}
		return Policy;
	}

	@Override
	public List<Policy> findByLessPremium(double npremium) throws PolicyNotFoundException {
		List<Policy> Policy = new ArrayList<Policy>();
		String sql = "select * from policy where premium=?";
		Connection connection = DbConnection.openConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, npremium);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* Policy policy = new Policy(); */
				String policyName = rs.getString("policy_name");
				int policyNumber = rs.getInt("policy_id");
				double premium = rs.getDouble("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String category = rs.getString("category");
				String brand = rs.getString("brand");
				double sumAssured = rs.getDouble("sum_assured");
				Policy policy = new Policy(policyName, policyNumber, premium, type, duration, coverage, category, brand,sumAssured);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.connection();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}
		return Policy;
	}

	@Override
	public Policy findById(int npolicyId) throws IdNotFoundException {
		/* List<Policy> Policy = new ArrayList<Policy>(); */
		String sql = "select * from policy where policy_id=?";
		Connection connection = DbConnection.openConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		Policy policyy=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, npolicyId);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* Policy policy = new Policy(); */
				String policyName = rs.getString("policy_name");
				int policyNumber = rs.getInt("policy_id");
				double premium = rs.getDouble("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String category = rs.getString("category");
				String brand = rs.getString("brand");
				double sumAssured = rs.getDouble("sum_assured");
				Policy policy = new Policy(policyName, policyNumber, premium, type, duration, coverage, category, brand,sumAssured);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.connection();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}
		return policyy;
	}

	@Override
	public List<Policy> findByBrand(String nbrand) throws PolicyNotFoundException {
		List<Policy> Policy = new ArrayList<Policy>();
		String sql = "select * from policy where brand=?";
		Connection connection = DbConnection.openConnection();
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nbrand);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				/* Policy policy = new Policy(); */
				String policyName = rs.getString("policy_name");
				int policyNumber = rs.getInt("policy_id");
				double premium = rs.getDouble("premium");
				String type = rs.getString("type");
				int duration = rs.getInt("duration");
				String coverage = rs.getString("coverage");
				String category = rs.getString("category");
				String brand = rs.getString("brand");
				double sumAssured = rs.getDouble("sum_assured");
				Policy policy = new Policy(policyName, policyNumber, premium, type, duration, coverage, category, brand,sumAssured);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbConnection.connection();
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {

			}
		}
		return Policy;
	}

}
