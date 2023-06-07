package cleartrip_question;

import java.util.List;

public class HotelSearchBookingPlatform
{
     public List<Hotel> hotels;
     public List<Bookings> bookings;

     public void onboard_property(User u1, Hotel h1)
     {
          u1.onboardProperty(h1);

     }
}
