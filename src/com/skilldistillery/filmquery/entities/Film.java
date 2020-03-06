package com.skilldistillery.filmquery.entities;

public class Film {
	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageID;
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}
	public int getLanguageID() {
		return languageID;
	}
	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
}
