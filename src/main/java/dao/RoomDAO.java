package dao;

import java.sql.Date;
import java.util.List;
import model.Room;

public interface RoomDAO {
	
  List<Room> findAllRooms();
  Room findRoomById(int id);
  List<Room> findAvailableRooms(Date startDate, Date endDate);
  void saveRoom(Room room);
  void updateRoom(Room room);
  void deleteRoom(int id);
}
