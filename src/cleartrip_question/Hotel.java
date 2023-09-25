package cleartrip_question;

import java.util.List;
import java.util.Optional;

public class Hotel
{
    private String hotel_name;
    private String city ;
    private Optional<List<Room>> rooms;
    private Optional<Integer> star_rating;

    public Hotel(String hotel_name, String city, Optional<List<Room>> rooms, Optional<Integer> star_rating) {
        this.hotel_name = hotel_name;
        this.city = city;
        this.rooms = rooms;
        this.star_rating = star_rating;
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

    public Optional<List<Room>> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = Optional.ofNullable(rooms);
    }

    public Optional<Integer> getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = Optional.of(star_rating);
    }
}
