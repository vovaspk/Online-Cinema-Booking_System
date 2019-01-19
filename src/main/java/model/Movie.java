package model;

import java.util.Date;

public class Movie {
    private int movie_id;
    private String movie_name;
    private String movie_director;
    private String movie_actors;
    private Date movie_releaseDate;
    private int movie_duration_min;
    private String movie_time;

    public Movie(){

    }

    public Movie(int movie_id, String movie_name, String movie_director, String movie_actors, Date movie_releaseDate, int movie_duration_min, String movie_time) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_director = movie_director;
        this.movie_actors = movie_actors;
        this.movie_releaseDate = movie_releaseDate;
        this.movie_duration_min = movie_duration_min;
        this.movie_time = movie_time;
    }

    public Movie(String movie_name, String movie_director, String movie_actors, Date movie_releaseDate, int movie_duration_min, String movie_time) {
        this.movie_name = movie_name;
        this.movie_director = movie_director;
        this.movie_actors = movie_actors;
        this.movie_releaseDate = movie_releaseDate;
        this.movie_duration_min = movie_duration_min;
        this.movie_time = movie_time;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_director() {
        return movie_director;
    }

    public void setMovie_director(String movie_director) {
        this.movie_director = movie_director;
    }

    public String getMovie_actors() {
        return movie_actors;
    }

    public void setMovie_actors(String movie_actors) {
        this.movie_actors = movie_actors;
    }

    public Date getMovie_releaseDate() {
        return movie_releaseDate;
    }

    public void setMovie_releaseDate(Date movie_releaseDate) {
        this.movie_releaseDate = movie_releaseDate;
    }

    public int getMovie_duration_min() {
        return movie_duration_min;
    }

    public void setMovie_duration_min(int movie_duration_min) {
        this.movie_duration_min = movie_duration_min;
    }

    public String getMovie_time() {
        return movie_time;
    }

    public void setMovie_time(String movie_time) {
        this.movie_time = movie_time;
    }
}
