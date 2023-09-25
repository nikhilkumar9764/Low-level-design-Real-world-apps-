package cleartrip_question;

import java.time.LocalDate;
import java.util.*;

public class HotelSearchBookingPlatform
{
     public List<Hotel> hotels;
     public List<Bookings> bookings;

     public HotelSearchBookingPlatform() {
          this.hotels = new ArrayList<>();
          this.bookings = new ArrayList<>();
     }

     public boolean onboard_property(User u1, Hotel h1)
     {
         if(!u1.getHotels_booked().stream().toList().contains(h1))
         {
             u1.onboardProperty(h1);
             hotels.add(h1);
             return true;
         }
         else {
              return false;
         }
     }

     public void addinventory(Hotel h1, Room r1,double price, int room_avail)
     {
          Inventory i1 = new Inventory(h1,r1,price,room_avail);
          r1.getInventory_avail().add(i1);
          List<Room> lroom = h1.getRooms().orElseGet(() -> List.of());
          lroom.add(r1);
          h1.setRooms(lroom);
          System.out.println("Inventory added!!");
     }

     public List<Hotel> search_query(String city , double priceStart , double priceEnd , int star_rating , LocalDate checkin,
                                     LocalDate checkout)
     {
           List<Hotel> res = new ArrayList<>();
           for(Hotel h : hotels)
           {
                Integer srating = h.getStar_rating().orElseGet(()-> -1);
                if(h.getCity().equalsIgnoreCase(city) && srating >=star_rating)
                {
                     List<Room> lr =  h.getRooms().orElseGet(()-> List.of());
                     for(Room r1: lr)
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
              List<Room> lr =  h.getRooms().orElseGet(()-> List.of());
               if(h.getCity().equalsIgnoreCase(city) && lr.contains(r))
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

     public Optional<List<Bookings>> view_bookings(User ux)
     {
          Optional<List<Bookings>> l2 = ux.getbookings_made();
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
         List<Bookings> lres = u1.getbookings_made().orElseGet(()-> List.of());
         boolean res = lres.remove(to_delete);

         u1.setBookings_made(Optional.of(lres));
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
