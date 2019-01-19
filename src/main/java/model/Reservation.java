package model;

public class Reservation {
    int movieId;
    int userId;
    int seat;
    String date;
    String time;

    public Reservation() {

    }

    public Reservation(int movieId, int userId, int seat, String date, String time) {
        this.movieId = movieId;
        this.userId = userId;
        this.seat = seat;
        this.date = date;
        this.time = time;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
