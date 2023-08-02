package cleartrip_question;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Main
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String user_name = s.next();
        int no_commands = s.nextInt();
        for(int j=0;j<no_commands;j++)
        {
            String c1 = s.next();
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
               List<Room> r1;
               for(int j=0;j<no_rooms;j++)
               {
                   String room_name = s.next();
                   Room r1 = new Room();
               }
            }
        }
        String[] cmd;

    }
}
