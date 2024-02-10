package dto;

public class Movie_DTO 
{
	private int movieId;
	private String movieName;
	private double movieCost;
	private double movieRating;
	private String movieGeneral;
	private String movieLanguage;

	private byte[] movieImage;
	

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getMovieCost() {
		return movieCost;
	}

	public void setMovieCost(double movieCost) {
		this.movieCost = movieCost;
	}

	public double getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}

	public String getMovieGeneral() {
		return movieGeneral;
	}

	public void setMovieGeneral(String movieGeneral) {
		this.movieGeneral = movieGeneral;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public byte[] getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(byte[] movieImage) {
		this.movieImage = movieImage;
	}
}
