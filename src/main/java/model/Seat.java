package model;

public class Seat {
    private int seatNumber;
    private boolean isReserved;

    public Seat() {

    }

    public Seat(int seatNumber, boolean isReserved) {
        this.seatNumber = seatNumber;
        this.isReserved = isReserved;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean getIsReserved() {
        return isReserved;
    }

    public boolean getReservationStatus()
    {
        return isReserved;
    }

    public void reserve()
    {
        isReserved = true;
    }

    public void unreserve()
    {
        isReserved = false;
    }
}
