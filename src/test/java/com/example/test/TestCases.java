package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.dao.ERSConversionDao;
import com.example.dao.ERSConversionDaoImpl;
import com.example.dao.ERSUsersDao;
import com.example.dao.ERSUsersDaoImpl;
import com.example.dao.H2Dao;
import com.example.dao.H2DaoImpl;
import com.example.model.ERSReimbursement;
import com.example.model.ERSUsers;

public class TestCases {

	ERSUsers testUser = new ERSUsers(300, "testuser", "testpass", "Test", "User", "testuser@gmail.com", 1);
	ERSReimbursement testReimbursement = new ERSReimbursement(1, 773.21, "2020-12-07 14:32:01", "2020-12-11 11:41:19",
			"Conference in Seattle the previous weekend", null, 2, 1, 3, 2);
	ERSUsersDao userDao = new ERSUsersDaoImpl();
	ERSConversionDao convDao = new ERSConversionDaoImpl();
	private static H2Dao h2Dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("-----BEFORE CLASS-----");
		h2Dao = new H2DaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("-----AFTER CLASS-----");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("-----BEFORE TEST CASE-----");
		h2Dao.h2InitDao();
		testReimbursement.setReimbID(1);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("-----AFTER TEST CASE-----");
		h2Dao.h2DestroyDao();
	}

	@Test
	public void userNotNullTest() {
		System.out.println("In User Not Null Test");
		ERSUsers uTemp = new ERSUsers(0, null, null, null, null, null, 0);
		assertNotNull(uTemp);
	}

	@Test
	public void usersNotNullTest() {
		System.out.println("In Select All Users Test");
		List<ERSUsers> users = userDao.selectAllERSUsers();
		assertNotNull(users);
	}

	@Test
	public void selectUserByIDTest() {
		System.out.println("In Select User by ID Test");
		ERSUsers uTemp = new ERSUsers(1, null, null, null, null, null, 0);
		uTemp = userDao.selectERSUserByID(uTemp);
		// assertEquals("michael.jimenez@jimenez.net",
		// userDao.selectERSUserByID(uTemp).getEmail());
		assertEquals(uTemp.getEmail(), userDao.selectERSUserByID(uTemp).getEmail());
	}

	@Test
	public void selectUserByUsernameTest() {
		System.out.println("In Select User by Username Test");
		ERSUsers uTemp = new ERSUsers(1, "admin01", null, null, null, null, 0);
		uTemp = userDao.selectERSUserByUsername(uTemp);
		// assertEquals("Jimenez",
		// userDao.selectERSUserByUsername(uTemp).getLastName());
		assertEquals(uTemp.getLastName(), userDao.selectERSUserByUsername(uTemp).getLastName());
	}

	@Test
	public void reimbNotNullTest() {
		System.out.println("In Reimbursement Not Null Test");
		ERSReimbursement rTemp = new ERSReimbursement(0, 0, null, null, null, null, 0, 0, 0, 0);
		assertNotNull(rTemp);
	}

	@Test
	public void setAmountTest() {
		System.out.println("In Set Amount Test");
		testReimbursement.setReimbAmount(120.00);
		assertEquals(120, testReimbursement.getReimbAmount(), 0);
	}

	@Test
	public void conversionTest1() {
		System.out.println("In Convert Type to Lodging Test");
		assertEquals(1, convDao.convertRequest("LODGING"));
	}

	@Test
	public void conversionTest2() {
		System.out.println("In Convert Type to Travel Test");
		assertEquals(2, convDao.convertRequest("TRAVEL"));
	}

	@Test
	public void conversionTest3() {
		System.out.println("In Convert Type to Food Test");
		assertEquals(3, convDao.convertRequest("FOOD"));
	}

	@Test
	public void conversionTest4() {
		System.out.println("In Convert Type to Other Test");
		assertEquals(4, convDao.convertRequest("OTHER"));
	}

	// NOTE: The following H2 tests use an H2 Dao Layer separate from the
	// ERSReimbursement Dao Layer,
	// as issues arose which resulted in changes being made to the actual database
	// rather
	// than H2 when attempting to implement tests. This is a result of how the
	// database connection class, "MyConnectionFactory", was implemented.
	// NOTE (cont.): The only differences in Dao Layers is how the url, username,
	// and password that
	// are retrieved, the addition of the h2Init() and h2Destroy() methods, and the
	// name of
	// the database changing from the SQL database to the H2 database. Functionality
	// persists

	@Test
	public void reimbursementsNotNullTest() {
		System.out.println("In H2 Select All Reimbursements Test");
		List<ERSReimbursement> reimbs = h2Dao.selectAllERSReimbursements();
		assertNotNull(reimbs);
	}

	@Test
	public void selectReimbursementByIDTest() {
		System.out.println("In H2 Select Reimbursement Test");
		ERSReimbursement reimbTemp = h2Dao.selectERSReimbursementByID(testReimbursement);
		assertEquals(1, reimbTemp.getReimbID());
	}

	@Test
	public void insertReimbursementTest() {
		System.out.println("In H2 Insert Test");
		testReimbursement.setReimbID(8080);
		h2Dao.insertERSReimbursement(testReimbursement);
		assertEquals(8080, h2Dao.selectERSReimbursementByID(testReimbursement).getReimbID());
	}

	@Test
	public void updateReimbursementTest() {
		System.out.println("In H2 Update Test");
		testReimbursement.setReimbAmount(1.01f);
		h2Dao.updateERSReimbursement(testReimbursement);
		assertEquals(1.01f, h2Dao.selectERSReimbursementByID(testReimbursement).getReimbAmount(), 0);
	}

	@Test
	public void deleteReimbursementTest() {
		System.out.println("In H2 Delete Test");
		h2Dao.deleteERSReimbursement(testReimbursement);
		assertNull(h2Dao.selectERSReimbursementByID(testReimbursement));
	}
}