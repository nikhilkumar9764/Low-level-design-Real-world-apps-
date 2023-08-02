package cleartrip_question;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Bookings
{
    private UUID book_id;
    private String guest_name;
    Hotel h1;
    Room r1;
    private LocalDate checkindate;
    private LocalDate checkoutdate;

    public Bookings(UUID book_id, String guest_name, Hotel h1, Room r1, LocalDate checkindate, LocalDate checkoutdate)
    {
        this.book_id = book_id;
        this.guest_name = guest_name;
        this.h1 = h1;
        this.r1 = r1;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
    }

    public UUID getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = UUID.fromString(book_id);
    }

    public String getGuest_name() {
        return guest_name;
    }

    public void setGuest_name(String guest_name) {
        this.guest_name = guest_name;
    }

    public Hotel getH1() {
        return h1;
    }

    public void setH1(Hotel h1) {
        this.h1 = h1;
    }

    public Room getr1() {
        return r1;
    }

    public void setr1(Room r1) {
        this.r1 = r1;
    }

    public LocalDate getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(LocalDate checkindate) {
        this.checkindate = checkindate;
    }

    public LocalDate getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(LocalDate checkoutdate) {
        this.checkoutdate = checkoutdate;
    }
}
