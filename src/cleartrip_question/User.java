package cleartrip_question;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;

public class User
{
    private String username;
    UserType u;
    private Optional<List<Bookings>> bookings_made;
    private Optional<List<Hotel>> hotels_booked;

    public User(String username, UserType u1, Optional<List<Hotel>> hotels_booked, Optional<List<Bookings>> bookings_made)
    {
        this.username = username;
        this.u = u1;
        this.bookings_made = bookings_made;
        this.hotels_booked = hotels_booked;
    }

    public String getUsername() {
        return username;
    }

    public void setBookings_made(Optional<List<Bookings>> bookings_made) {
        this.bookings_made = bookings_made;
    }

    public void setHotels_booked(Optional<List<Hotel>> hotels_booked) {
        this.hotels_booked = hotels_booked;
    }

    public UserType getU() {
        return u;
    }

    public Optional<List<Hotel>> getHotels_booked()
    {
        return hotels_booked;
    }

    public Optional<List<Bookings>> getbookings_made()
    {
        return bookings_made;
    }

    public void onboardProperty(Hotel h1)
    {
        List<Hotel> l1 = getHotels_booked().orElseGet(() -> List.of());
        l1.add(h1);
        hotels_booked = Optional.of(l1);
    }

    public void addBooking(Bookings b1)
    {
        List<Bookings> l2 = getbookings_made().orElseGet(() -> List.of());
        l2.add(b1);
        bookings_made = Optional.of(l2);
    }

    public List<Inventory> view_inventory(LocalDate search)
    {
        List<Inventory> lres=new ArrayList<>();
        List<Hotel> l3 = getHotels_booked().orElseGet(() -> List.of());
        for(Hotel h1 : l3)
        {
            List<Room> lr =  h1.getRooms().orElseGet(()-> List.of());
            for(Room r : lr)
            {
                 for(Inventory i : r.getInventory_avail())
                 {
                     if(i.getR1()==r && i.getBook_status().get(search)>0)
                     {
                         lres.add(i);
                     }
                 }
            }
        }
        return lres;
    }




}
