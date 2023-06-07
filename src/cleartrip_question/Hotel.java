package cleartrip_question;

import java.util.List;

public class Hotel
{
    private String hotel_id;
    private String hotel_name;
    private String city ;
    private List<Room> rooms;
    private int star_rating;

    public Hotel(String hotel_id, String hotel_name, String city, List<Room> rooms, int star_rating) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.city = city;
        this.rooms = rooms;
        this.star_rating = star_rating;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }
}
