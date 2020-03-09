package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		if (filmId <= 0) {
			return null;
		}
		Film film = null;
		String user = "student";
		String password = "student";
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			String sqltxt;
			sqltxt = "SELECT * FROM film WHERE id = ?;";
			stmt = conn.prepareStatement(sqltxt);
			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageID(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));
				film.setLanguage(getLanguage(filmId));

			}
			rs.close();
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		if (actorId <= 0) {
			return null;
		}
		Actor actor = null;
		String user = "student";
		String password = "student";
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			String sqltxt;
			sqltxt = "SELECT * FROM actor WHERE actor.id = ?;";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));

			}
			rs.close();
			conn.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		if (filmId <= 0) {
			return null;
		}
		ArrayList<Actor> actors = null;
		String user = "student";
		String password = "student";
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			String sqltxt;
			sqltxt = "SELECT actor.id, actor.first_name, actor.last_name, film.title FROM actor JOIN film_actor on actor.id = film_actor.actor_id JOIN film ON film.id = film_actor.film_id WHERE film.id=?;";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			actors = new ArrayList<Actor>();
			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actors.add(actor);
			}
			rs.close();
			conn.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		ArrayList<Film> films = null;
		String user = "student";
		String password = "student";
		PreparedStatement stmt = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			String sqltxt;
			sqltxt = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			films = new ArrayList<Film>();
			while (rs.next()) {
				Film film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageID(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActors(findActorsByFilmId(film.getId()));
				film.setLanguage(getLanguage(film.getId()));
				films.add(film);
			}
			conn.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	@Override
	public String getLanguage(int filmId) {
		String user = "student";
		String password = "student";
		PreparedStatement stmt = null;
		Connection conn = null;
		String returnedLang = "";
		try {
			conn = DriverManager.getConnection(URL, user, password);
			String sqltxt;
			sqltxt = "SELECT language.name FROM film JOIN language on film.language_id = language.id WHERE film.id = ?";

			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				returnedLang = rs.getString(1);
			}
			rs.close();
			conn.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return returnedLang;


	}
}
