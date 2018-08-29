package najmul.bitm.sqlitedatabaseexample;

import java.util.ArrayList;

/**
 * Created by Trainer on 3/29/2017.
 */

public class Movie {
    private String movieName;
    private String movieYear;
    private int movieId;

    public Movie(String movieName, String phoneNumber) {
        this.movieName = movieName;
        this.movieYear = phoneNumber;
    }

    public Movie(String movieName, String movieYear, int movieId) {
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieId = movieId;
    }



    public Movie() {
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public ArrayList<Movie> getAllPersons(){
        ArrayList<Movie>persons = new ArrayList<>();
        persons.add(new Movie("Tanvir Ahmad","01555555555"));
        persons.add(new Movie("Shabbir Ahmad","01555555555"));
        persons.add(new Movie("abcd Ahmad","01555555555"));
        persons.add(new Movie("efgh Ahmad","01555555555"));
        persons.add(new Movie("ijkl Ahmad","01555555555"));
        persons.add(new Movie("mnop Ahmad","01555555555"));
        persons.add(new Movie("qrst Ahmad","01555555555"));
        persons.add(new Movie("uvwx Ahmad","01555555555"));
        persons.add(new Movie("yzab Ahmad","01555555555"));
        persons.add(new Movie("Messi Ahmad","01555555555"));
        persons.add(new Movie("Ronaldo Ahmad","01555555555"));
        persons.add(new Movie("Sakib Ahmad","01555555555"));
        return persons;

    }
}
