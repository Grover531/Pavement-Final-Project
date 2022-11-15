package com.pavement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.pavement.model.Renter;

class RenterDAOTest {
	private DriverManagerDataSource dataSource;
	private RenterDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pvmt?useSSL=true&amp");
		dataSource.setUsername("webstudent");
		dataSource.setPassword("webstudent");

		dao = new RenterDAOImpl(dataSource);
	}

	@Test
	void testSave() {

		Renter renter = new Renter("g@email", "G", "Miranda", "646-123-4567");
		int result = dao.save(renter);

		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		
		Renter renter = new Renter(2, "alex@gmail.com", "Alexis", "Miranda", "201-123-4567");
		int result = dao.update(renter);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Renter renter = dao.get(id);
		if (renter != null) {
			System.out.println(renter);
		}
		
		assertNotNull(renter);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Renter> listRenters = dao.list();
		
		for (Renter aRenter : listRenters) {
			System.out.println(aRenter);
		}
		
		assertTrue(!listRenters.isEmpty());
	}

}
