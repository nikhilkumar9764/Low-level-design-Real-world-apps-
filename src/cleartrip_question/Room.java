package cleartrip_question;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Room
{
    private UUID room_id;
    private String roomtype;
    private List<Inventory> inventory_avail;

    public Room(UUID  rid , String room_name) {
        this.room_id = rid;
        this.roomtype = room_name;
    }

    public UUID getRoom_id() {
        return room_id;
    }

    public List<Inventory> getInventory_avail()
    {
        return inventory_avail;
    }

    public void setInventory_avail(List<Inventory> i1)
    {
        this.inventory_avail =  i1;
    }

    public void setRoom_id(UUID room_id) {
        this.room_id = room_id;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }
}
