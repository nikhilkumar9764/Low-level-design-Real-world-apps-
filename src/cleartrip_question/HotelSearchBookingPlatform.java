package cleartrip_question;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HotelSearchBookingPlatform
{
     public List<Hotel> hotels;
     public List<Bookings> bookings;

     public HotelSearchBookingPlatform() {
          this.hotels = new ArrayList<>();
          this.bookings = new ArrayList<>();
     }

     public void onboard_property(User u1, Hotel h1)
     {
          u1.onboardProperty(h1);
          hotels.add(h1);
          System.out.println("Property onboarded successfully!!");
     }

     public void addinventory(User u1, Hotel h1, Room r1,double price, int room_avail)
     {
          Inventory i1 = new Inventory(h1,r1,price,room_avail);
          r1.getInventory_avail().add(i1);
          h1.getRooms().add(r1);
          System.out.println("Inventory added!!");
     }

     public List<Hotel> search_query(String city , double priceStart , double priceEnd , int star_rating , Date checkin,
                                     Date checkout)
     {
           List<Hotel> res = new ArrayList<>();
           for(Hotel h : hotels)
           {
                if(h.getCity().equalsIgnoreCase(city) && h.getStar_rating()>=star_rating)
                {
                     for(Room r1: h.getRooms())
                     {
                         for(Inventory iv : r1.getInventory_avail())
                         {
                              if(iv.getPrice()>=priceStart && iv.getPrice()<=priceEnd && iv.getBook_status().get(checkin)>0
                               && iv.getBook_status().get(checkout)>0 )
                              {
                                   res.add(h);
                                   break;
                              }
                         }
                     }
                }
           }
           return res;
     }

     public void make_booking(User u1,String city,Room r,LocalDate checkin,LocalDate checkout)
     {
          for(Hotel h: hotels)
          {
               if(h.getCity().equalsIgnoreCase(city) && h.getRooms().contains(r))
               {
                    for(Inventory i : r.getInventory_avail())
                    {
                         if(i.getBook_status().get(checkin)>0 && i.getBook_status().get(checkout)>0 )
                         {
                              Bookings b = new Bookings(UUID.randomUUID() , u1.getUsername() , h , r , checkin , checkout);
                              this.bookings.add(b);
                              u1.addBooking(b);
                              for(LocalDate l1 = checkin; l1.isBefore(checkout);l1 = l1.plusDays(1))
                              {
                                   i.setBook_status(l1);
                              }
                         }
                    }
               }
          }
     }

     public List<Bookings> view_bookings(User ux)
     {
          List<Bookings> l2 = ux.getbookings_made();
          return l2;
     }

     public boolean remove_booking(User u1, UUID s1)
     {
         Bookings to_delete = null;
         int sz = this.bookings.size();
         for(int j=0;j<sz;j++)
         {
              if(bookings.get(j).getBook_id() == s1)
              {
                  to_delete = bookings.get(j);
              }
         }
         boolean res = u1.getbookings_made().remove(to_delete);
         if(res == true)
         {
              System.out.println("Booking was deleted!!");
              return true;
         }
         else{
              System.out.println("Booking was not found , couldn't delete!!");
              return false;
         }
     }

}
