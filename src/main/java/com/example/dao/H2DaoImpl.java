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

public class H2DaoImpl implements H2Dao {

	private static String url = "jdbc:h2:./h2Folder/h2Data";
	private static String username = "sa";
	private static String password = "sa";

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void insertERSReimbursement(ERSReimbursement eR) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "INSERT INTO reimb_reimbursement VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM reimb_reimbursement";
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
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "SELECT * FROM reimb_reimbursement where reimb_id = ?";
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
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "UPDATE reimb_reimbursement SET reimb_amount = ?, reimb_resolved = ?, reimb_description = ?, "
					+ "reimb_reciept = ?, reimb_author = ?, reimb_resolver = ?, reimb_status_id = ?, reimb_type_id = ? "
					+ "WHERE reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, eR.getReimbAmount());
			Timestamp time = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(2, Timestamp.valueOf(sdf.format(time)));
			ps.setString(3, eR.getReimDescription());
			ps.setObject(4, eR.getReimbReciept());
			ps.setLong(5, eR.getReimbAuthor());
			ps.setLong(6, 2);
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
		try (Connection conn = DriverManager.getConnection(url, username, password)) {

			String sql = "DELETE FROM reimb_reimbursement WHERE reimb_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, eR.getReimbID());

			MyLoggerFactory.logger.info("Successfully denied reimbursement from DB. Returning...");
			ps.executeUpdate();

		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			// e.printStackTrace();
		}
	}

	@Override
	public void h2InitDao() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "" + "CREATE TABLE reimb_reimbursement( " + "reimb_id BIGSERIAL NOT NULL, "
					+ "reimb_amount FLOAT(2) NOT NULL, " + "reimb_submitted TIMESTAMP NOT NULL, "
					+ "reimb_resolved TIMESTAMP DEFAULT '0001-01-01 00:00:00', " + "reimb_description VARCHAR(250), "
					+ "reimb_reciept BYTEA, " + "reimb_author BIGINT NOT NULL, " + "reimb_resolver BIGINT NULL, "
					+ "reimb_status_id BIGINT, " + "reimb_type_id BIGINT" + " ); "
					+ "INSERT INTO reimb_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)\r\n"
					+ " values(773.21, '2020-12-07 14:32:01', '2020-12-11 11:41:19', 'Conference in Seattle the previous weekend', NULL, 2, 1, 3, 2); "
					+ "INSERT INTO reimb_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)\r\n"
					+ " values(121.54, '2020-12-12 17:02:53', '2020-12-15 15:16:38', 'Financial Dept team building dine-out', NULL, 3, 1, 2, 3);\r\n"
					+ "INSERT INTO reimb_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)\r\n"
					+ " values(186.87, '2020-12-14 19:54:43', '2020-12-15 15:16:38', 'Chuck E. Cheese night out', NULL, 4, 1, 2, 4);\r\n"
					+ "INSERT INTO reimb_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)\r\n"
					+ " values(78.13, '2020-12-17 13:12:33', null, 'Dinner in Atlanta with COO', NULL, 5, null, 1, 3);\r\n"
					+ "INSERT INTO reimb_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)\r\n"
					+ " values(201.21, '2020-12-07 14:32:01', '2020-12-10 10:26:12', 'Hotel in Seattle for Conference', NULL, 6, 1, 3, 1);\r\n"
					+ "INSERT INTO reimb_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)\r\n"
					+ " values(1874.71, '2020-12-16 14:32:01', null, 'Shibuya District expansion project', NULL, 7, NULL, 1, 2);";

			Statement state = conn.createStatement();
			state.execute(sql);
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			// e.printStackTrace();
		}
	}

	@Override
	public void h2DestroyDao() {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "" + "DROP TABLE reimb_reimbursement; ";

			Statement state = conn.createStatement();
			state.execute(sql);
		} catch (SQLException e) {
			MyLoggerFactory.logger.error("An error occurred", e);
			// e.printStackTrace();
		}
	}

}
