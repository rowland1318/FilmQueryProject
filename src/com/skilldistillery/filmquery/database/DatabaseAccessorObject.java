package com.skilldistillery.filmquery.database;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
  @Override
  public Film findFilmById(int filmId) {
    return null;
  }
@Override
public Actor findActorById(int actorId) {
	// TODO Auto-generated method stub
	return null;
}
  
}


