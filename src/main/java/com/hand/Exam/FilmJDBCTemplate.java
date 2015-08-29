package com.hand.Exam;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class FilmJDBCTemplate {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String title, String description, Integer language_id) {
		String SQL = "insert into Film (title, description, language_id) values (?, ?,?)";
		jdbcTemplateObject.update(SQL, title, description, language_id);
		// System.out.println("Created Record Name = " + name + " Age = " +
		// age);
		return;
	}

	public Film getFilm(String title,String description,Integer language_id) {
		String SQL = "select * from Film where title = ? and description=? and language_id=?";
		Film film = jdbcTemplateObject.queryForObject(SQL, new Object[] { title,description,language_id }, new FilmMapper());
		return film;
	}

	public List<Film> listFilms() {
		String SQL = "select * from Film";
		List<Film> film = jdbcTemplateObject.query(SQL, new FilmMapper());
		return film;
	}

}
