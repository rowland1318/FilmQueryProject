package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	private void launch() {

		startUserInterface();

		kb.close();
	}

	private void startUserInterface() {
		boolean keepGoing = true;
		int userChoice;
		while (keepGoing) {
			displayMenu();
			innerLoop: while (true) {
				try {
					userChoice = kb.nextInt();
					kb.nextLine();
					if (userChoice < 1 || userChoice > 3)
						throw new Exception();
					else
						break innerLoop;
				} catch (Exception e) {
					System.out.println("Please Enter a Number(1-3)");
				}
			}
			userChoiceMenu(userChoice);
			if (userChoice == 3)
				keepGoing = false;
		}

	}

	private void userChoiceMenu(int userChoice) {

		switch (userChoice) {

		case 1:
			System.out.print("Please Enter a Film ID: ");
			int id = kb.nextInt();
			Film filmIDChoice = db.findFilmById(id);
			if (filmIDChoice == null) {
				System.out.println("\tFilm ID Not Recognized");
			} else {
				System.out.println(filmIDChoice);
			}
			break;

		case 2:
			System.out.println("\nPlease Enter a Keyword: ");
			String userInput = kb.nextLine();
			List<Film> filmKeyword = db.findFilmByKeyword(userInput);
			if (filmKeyword.size() > 0) {
				for (Film film : filmKeyword) {
					System.out.println(film);
				}
			} else {
				System.out.println("\tNo Matching Films Found");
			}
			break;
		case 3:
			System.out.println("Have a Good Day!");
			break;
		}
	}

	public void displayMenu() {
		System.out.println();
		System.out.println("Welcome to the Film Query Application!");
		System.out.println("Please Select From the Menu (1-3):");
		System.out.println("\t1. Look Up a Film by its ID");
		System.out.println("\t2. Look Up a Film by Keyword");
		System.out.println("\t3. Exit Film Query Application");
	}

}
