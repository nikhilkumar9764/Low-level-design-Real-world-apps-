package cleartrip_question;

import java.util.Date;
import java.util.Map;

public class Inventory
{
     private Hotel h1;
     private Room r1;
     private double price;
     private int rooms_avail;
     private Map<Date, Integer> book_status;

     public Inventory(Hotel h1, Room r1, double price, int rooms_avail, Map<Date, Integer> book_status)
     {
          this.h1 = h1;
          this.r1 = r1;
          this.price = price;
          this.rooms_avail = rooms_avail;
          this.book_status = book_status;
     }

     public Hotel getH1() {
          return h1;
     }

     public void setH1(Hotel h1) {
          this.h1 = h1;
     }

     public Room getR1() {
          return r1;
     }

     public void setR1(Room r1) {
          this.r1 = r1;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     public int getRooms_avail() {
          return rooms_avail;
     }

     public void setRooms_avail(int rooms_avail) {
          this.rooms_avail = rooms_avail;
     }



     public Map<Date, Integer> getBook_status() {
          return book_status;
     }

     public void setBook_status(Map<Date, Integer> book_status) {
          this.book_status = book_status;
     }
}
