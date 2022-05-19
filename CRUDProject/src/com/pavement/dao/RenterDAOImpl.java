package com.pavement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.pavement.model.Renter;

public class RenterDAOImpl implements RenterDAO {

	private JdbcTemplate jdbcTemplate;

	public RenterDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Renter renter) {
		String sql = "INSERT INTO Renter (email, first_name, last_name, contact_number) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, renter.getEmail(), renter.getFirstName(), renter.getLastName(),
				renter.getContactNumber());
	}

	@Override
	public int update(Renter renter) {
		String sql = "UPDATE Renter SET email=?, first_name=?, last_name=?, contact_number=? WHERE id=?";
		return jdbcTemplate.update(sql, renter.getEmail(), renter.getFirstName(), renter.getLastName(),
				renter.getContactNumber(), renter.getId());
	}

	@Override
	public Renter get(Integer id) {
		String sql = "SELECT * FROM Renter WHERE id=" + id;

		ResultSetExtractor<Renter> extractor = new ResultSetExtractor<Renter>() {

			public Renter extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String email = rs.getString("email");
					String first_name = rs.getString("first_name");
					String last_name = rs.getString("last_name");
					String contact_number = rs.getString("contact_number");

					return new Renter(id, email, first_name, last_name, contact_number);
					}

				return null;
			}
		};

		return jdbcTemplate.query(sql, extractor);

	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Renter WHERE id=" + id; 
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Renter> list() {
		String sql = "SELECT * FROM Renter";
		
		RowMapper<Renter> rowMapper = new RowMapper<Renter>() {
			
			@Override
			public Renter mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String email = rs.getString("email");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String contact_number = rs.getString("contact_number");

				return new Renter(id, email, first_name, last_name, contact_number);
			}
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	
	}

}
