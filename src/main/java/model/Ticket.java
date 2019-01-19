package model;

public class Ticket {
    private int user_id;
    private String name;
    private String day;
    private String time;
    private String seat;

    public Ticket() {
    }

    public Ticket(int user_id, String name, String day, String time, String seat) {
        this.user_id = user_id;
        this.name = name;
        this.day = day;
        this.time = time;
        this.seat = seat;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                ", seat='" + seat + '\'' +
                '}';
    }
}
