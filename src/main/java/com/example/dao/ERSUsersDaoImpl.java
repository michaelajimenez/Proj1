package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.ERSUsers;

public class ERSUsersDaoImpl implements ERSUsersDao {

	@Override
	public void insertERSUser(ERSUsers eU) {
	}

	@Override
	public List<ERSUsers> selectAllERSUsers() {
		List<ERSUsers> users = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {
			String sql = "SELECT * FROM ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				users.add(new ERSUsers(rs.getLong("ers_users_id"), rs.getString("ers_username"),
						rs.getString("ers_password"), rs.getString("user_first_name"), rs.getString("user_last_name"),
						rs.getString("user_email"), rs.getLong("user_role_id")));
				MyLoggerFactory.logger.info("Successfully selected all users from DB. Returning...");
			}
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			//e.printStackTrace();
		}
		return users;
	}

	@Override
	public ERSUsers selectERSUserByID(ERSUsers eU) {
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, eU.getUserID());
			ResultSet rs = ps.executeQuery();

			ERSUsers returnUser = null;

			while (rs.next()) {
				returnUser = new ERSUsers(rs.getLong("ers_users_id"), rs.getString("ers_username"),
						rs.getString("ers_password"), rs.getString("user_first_name"), rs.getString("user_last_name"),
						rs.getString("user_email"), rs.getLong("user_role_id"));
			}
			MyLoggerFactory.logger.info("Successfully selected a user by ID from DB. Returning...");
			return returnUser;
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			//e.printStackTrace();
		}
		return null;
	}

	@Override
	public ERSUsers selectERSUserByUsername(ERSUsers eU) {
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {
			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, eU.getUsername());
			ResultSet rs = ps.executeQuery();

			ERSUsers returnUser = null;

			while (rs.next()) {
				returnUser = new ERSUsers(rs.getLong("ers_users_id"), rs.getString("ers_username"),
						rs.getString("ers_password"), rs.getString("user_first_name"), rs.getString("user_last_name"),
						rs.getString("user_email"), rs.getLong("user_role_id"));
			}
			System.out.println(returnUser.toString());
			MyLoggerFactory.logger.info("Successfully selected a user by username from DB. Returning...");
			return returnUser;
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			//e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateERSUser(ERSUsers eU) {
	}

	@Override
	public void deleteERSUser(ERSUsers eU) {
	}
}
