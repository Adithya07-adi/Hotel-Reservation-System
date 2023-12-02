import java.util.ArrayList;
import java.util.List;

class Room {
    int roomNumber;
    boolean isOccupied;
    String guestName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.guestName = "";
    }

    public void occupyRoom(String guestName) {
        this.isOccupied = true;
        this.guestName = guestName;
    }

    public void vacateRoom() {
        this.isOccupied = false;
        this.guestName = "";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getGuestName() {
        return guestName;
    }
}

class Hotel {
    List<Room> rooms;

    public Hotel(int numRooms) {
        rooms = new ArrayList<>();
        for (int i = 1; i <= numRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public void showRoomStatus() {
        System.out.println("Room Status:");
        for (Room room : rooms) {
            String status = room.isOccupied() ? "Occupied by " + room.getGuestName() : "Available";
            System.out.println("Room #" + room.getRoomNumber() + ": " + status);
        }
    }

    public boolean reserveRoom(int roomNumber, String guestName) {
        Room room = findRoom(roomNumber);
        if (room != null && !room.isOccupied()) {
            room.occupyRoom(guestName);
            System.out.println("Room #" + roomNumber + " reserved for " + guestName);
            return true;
        } else {
            System.out.println("Room #" + roomNumber + " is not available for reservation.");
            return false;
        }
    }

    public void checkOut(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null && room.isOccupied()) {
            room.vacateRoom();
            System.out.println("Guest checked out from Room #" + roomNumber);
        } else {
            System.out.println("Room #" + roomNumber + " is not occupied or does not exist.");
        }
    }

    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(5);

        hotel.showRoomStatus();

        hotel.reserveRoom(2, "Adithya v");
        hotel.reserveRoom(4, "Prajwal");

        hotel.showRoomStatus();

        hotel.checkOut(2);

        hotel.showRoomStatus();
    }
}
