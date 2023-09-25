package cleartrip_question;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int no_commands = s.nextInt();
        for(int j=0;j<no_commands;j++)
        {
            String c1 = s.next();
            String user_name = s.next();
            if(Objects.equals(c1, "OnboardProperty"))
            {
               System.out.println("Enter the property details:");
               System.out.println("Hotel title");
               String title = s.next();
               System.out.println("Hotel City");
               String city = s.next();
               System.out.println("Star rating");
               int star_rating = s.nextInt();
               System.out.println("No of rooms in the hotel");
               int no_rooms = s.nextInt();
               List<Room> r1 = new ArrayList<>();
               for(int k=0;k<no_rooms;k++)
               {
                   String room_name = s.next();
                   Room rx = new Room(UUID.randomUUID() , room_name);
                   r1.add(rx);
               }
               Hotel h2 = new Hotel(title,city , Optional.of(r1),Optional.of(star_rating));
               List<Hotel> lhotel= new ArrayList<>();
               lhotel.add(h2);
               User u = new User(user_name , UserType.OWNER  , Optional.of(lhotel), Optional.of(Collections.emptyList()));
                HotelSearchBookingPlatform h1 = new HotelSearchBookingPlatform();
               boolean r = h1.onboard_property(u,h2);
               if(r){
                   System.out.println("Property onboarded successfully!!");
               }
               else{
                   System.out.println("Property not onboarded successfully!!");
               }
            }
            else if(Objects.equals(c1, "AddInventory"))
            {
                System.out.println("Enter the property details:");
                System.out.println("Hotel title");
                String hotel_title = s.next();
                System.out.println("Hotel City");
                String hotel_city = s.next();
                System.out.println("Enter room title");
                String room_title = s.next();
                System.out.println("Hotel price");
                int price = s.nextInt();
                System.out.println("Enter no of rooms available");
                int rooms_avail = s.nextInt();
                Hotel h1 = new Hotel(hotel_title , hotel_city , Optional.empty() , Optional.empty());
                Room r1 = new Room(UUID.randomUUID() , room_title);
                HotelSearchBookingPlatform one = new HotelSearchBookingPlatform();
                one.addinventory(h1,r1,price,rooms_avail);
            }
            else if(Objects.equals(c1, "search"))
            {
                System.out.println("Hotel City");
                String hotel_city = s.next();
                System.out.println("Enter room price range");
                String room_price = s.next();
                List<String> x1 = List.of(room_price.split("-"));
                double st = Double.parseDouble(x1.get(0));
                double en = Double.parseDouble(x1.get(1));
                System.out.println("Enter the rating");
                int rating = s.nextInt();
                System.out.println("Enter the checkin and checkout date");
                String date = s.next();
                String d2 = s.next();
                DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/mm/yyyy");
                LocalDate st_date = LocalDate.parse(date , d1);
                LocalDate en_date = LocalDate.parse(d2,d1);
                HotelSearchBookingPlatform h1 = new HotelSearchBookingPlatform();
                List<Hotel> hlist = h1.search_query(hotel_city , st,en , rating, st_date , en_date );
                for(Hotel h : hlist)
                {
                    System.out.println(h.getHotel_name()+ " " + h.getRooms());
                }
            }
        }
        String[] cmd;

    }
}
