package cleartrip_question;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User
{
    private String username;

    UserType u;
    private List<Bookings> bookings_made;
    private List<Hotel> hotels_booked;

    public User(String username,UserType u1, List<Bookings> bookings_made, List<Hotel> hotels_booked)
    {
        this.username = username;
        this.u = u1;
        this.bookings_made = bookings_made;
        this.hotels_booked = hotels_booked;
    }

    public String getUsername() {
        return username;
    }

    public UserType getU() {
        return u;
    }

    public List<Hotel> getHotels_booked()
    {
        return hotels_booked;
    }

    public List<Bookings> getbookings_made()
    {
        return bookings_made;
    }

    public void onboardProperty(Hotel h1)
    {
        hotels_booked.add(h1);
    }

    public void addBooking(Bookings b1)
    {
        bookings_made.add(b1);
    }

    public void removeBooking(Bookings b1)
    {
        bookings_made.remove(b1);
    }

    public List<Inventory> view_inventory(Date search)
    {
        List<Inventory> lres=new ArrayList<>();
        for(Hotel h1 : hotels_booked)
        {
            for(Room r : h1.getRooms())
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
