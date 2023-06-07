package cleartrip_question;

import java.util.Date;
import java.util.List;

public class Room
{
    private String room_id;
    private String roomtype;
    private List<Inventory> inventory_avail;

    public String getRoom_id() {
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

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }
}
