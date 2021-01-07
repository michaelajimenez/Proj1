package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.controller.LoginController;
import com.example.model.ERSReimbursement;

public class ERSReimbursementDaoImpl implements ERSReimbursementDao {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void insertERSReimbursement(ERSReimbursement eR) {
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "INSERT INTO ers_reimbursement VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, eR.getReimbID());
			ps.setDouble(2, eR.getReimbAmount());
			Timestamp time = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(3, Timestamp.valueOf(sdf.format(time)));
			ps.setTimestamp(4, null);
			ps.setString(5, eR.getReimDescription());
			ps.setObject(6, eR.getReimbReciept());
			ps.setLong(7, eR.getReimbAuthor());
			ps.setNull(8, java.sql.Types.BIGINT);
			ps.setLong(9, eR.getReimbStatusID());
			ps.setLong(10, eR.getReimbTypeID());

			MyLoggerFactory.logger.info("Successfully inserted reimbursement in DB. Returning...");
			ps.executeUpdate();
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			// e.printStackTrace();
		}
	}

	@Override
	public List<ERSReimbursement> selectAllERSReimbursements() {
		List<ERSReimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "SELECT * FROM ers_reimbursement";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				reimbs.add(new ERSReimbursement(rs.getLong("reimb_id"), rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"), rs.getString("reimb_resolved"),
						rs.getString("reimb_description"), rs.getObject("reimb_reciept"), rs.getLong("reimb_author"),
						rs.getLong("reimb_resolver"), rs.getLong("reimb_status_id"), rs.getLong("reimb_type_id")));
			}
			MyLoggerFactory.logger.info("Successfully selected all reimbursements from DB. Returning...");
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			// e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public ERSReimbursement selectERSReimbursementByID(ERSReimbursement eR) {
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "SELECT * FROM ers_reimbursement where reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, eR.getReimbID());
			ResultSet rs = ps.executeQuery();

			ERSReimbursement returnReimbursement = null;
			while (rs.next()) {
				returnReimbursement = new ERSReimbursement(rs.getLong("reimb_id"), rs.getDouble("reimb_amount"),
						rs.getString("reimb_submitted"), rs.getString("reimb_resolved"),
						rs.getString("reimb_description"), rs.getObject("reimb_reciept"), rs.getLong("reimb_author"),
						rs.getLong("reimb_resolver"), rs.getLong("reimb_status_id"), rs.getLong("reimb_type_id"));
			}
			MyLoggerFactory.logger.info("Successfully selected a reimbursement by ID from DB. Returning...");
			return returnReimbursement;
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			// e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateERSReimbursement(ERSReimbursement eR) {
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "UPDATE ers_reimbursement SET reimb_amount = ?, reimb_resolved = ?, reimb_description = ?, "
					+ "reimb_reciept = ?, reimb_author = ?, reimb_resolver = ?, reimb_status_id = ?, reimb_type_id = ? "
					+ "WHERE reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, eR.getReimbAmount());
			Timestamp time = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(2, Timestamp.valueOf(sdf.format(time)));
			ps.setString(3, eR.getReimDescription());
			ps.setObject(4, eR.getReimbReciept());
			ps.setLong(5, eR.getReimbAuthor());
			ps.setLong(6, LoginController.loggedID);
			ps.setLong(7, eR.getReimbStatusID());
			ps.setLong(8, eR.getReimbTypeID());
			ps.setLong(9, eR.getReimbID());

			MyLoggerFactory.logger.info("Successfully updated reimbursement in DB. Returning...");
			ps.executeUpdate();
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			// e.printStackTrace();
		}
	}

	@Override
	public void deleteERSReimbursement(ERSReimbursement eR) {
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "DELETE FROM ers_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, eR.getReimbID());

			MyLoggerFactory.logger.info("Successfully denied reimbursement from DB. Returning...");
			ps.executeUpdate();

		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			// e.printStackTrace();
		}
	}
}