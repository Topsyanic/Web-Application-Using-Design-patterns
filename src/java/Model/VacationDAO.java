/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raaid
 */
public class VacationDAO {

    Connection connection;
    Database database = Database.getInstance();

    public VacationDAO() throws SQLException {
        connection = database.getConnection();
    }

    public boolean addVacation(Holiday holiday) {

        try {
            PreparedStatement ps = connection.prepareStatement("insert into holidays(title,description,price_per_room,package_type,max_room_capacity,meal,image)" + "values(?,?,?,?,?,?,?)");
            ps.setString(1, holiday.getTitle());
            ps.setString(2, holiday.getDescription());
            ps.setInt(3,holiday.getPricePerRoom());
            ps.setString(4, holiday.getPackageType());
            ps.setInt(5, holiday.getRoomCapacity());
            ps.setString(6, holiday.getMeal());
            ps.setString(7, holiday.getImage());

            ps.executeUpdate();

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(VacationDAO.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    public List<Holiday> viewHolidays() throws SQLException {
        List<Holiday> holidayList = new ArrayList<Holiday>();
        PreparedStatement ps = connection.prepareStatement("select * from holidays");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int holidayId = rs.getInt("holiday_id");
            String description = rs.getString("description");
            String title = rs.getString("title");
            String packageType = rs.getString("package_type");
            String meal = rs.getString("meal");
            String image = rs.getString("image");
            int pricePerRoom = rs.getInt("price_per_room");
            int roomCapacity = rs.getInt("max_room_capacity");
            Holiday myHoliday = new Holiday(title, description, packageType, meal, image, holidayId, pricePerRoom, roomCapacity);
            holidayList.add(myHoliday);
        }
        return holidayList;
    }

    public void editPost(String holidayId, String description, String title, String packageType, String roomCapacity, String meal, String pricePerRoom) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("update holidays set title = ?,description = ?,package_type = ?,max_room_capacity = ?,meal = ?,price_per_room = ? where holiday_id = ?");
        ps.setString(1, title);
        ps.setString(2, description);
        ps.setString(3, packageType);
        ps.setString(4, roomCapacity);
        ps.setString(5, meal);
        ps.setString(6, pricePerRoom);
        ps.setString(7, holidayId);
        ps.executeUpdate();
        ps.close();
    }

    public List<Holiday> searchVacationAscending(String keyword) throws SQLException {
        List<Holiday> holidayList = new ArrayList<Holiday>();
        PreparedStatement ps = connection.prepareStatement("select * from holidays where title like ? or description like ? order by price_per_room asc");
        ps.setString(1, keyword);
        ps.setString(2, keyword);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int holidayId = rs.getInt("holiday_id");
            String description = rs.getString("description");
            String title = rs.getString("title");
            String packageType = rs.getString("package_type");
            String meal = rs.getString("meal");
            String image = rs.getString("image");
            int pricePerRoom = rs.getInt("price_per_room");
            int roomCapacity = rs.getInt("max_room_capacity");
            Holiday myHoliday = new Holiday(title, description, packageType, meal, image, holidayId, pricePerRoom, roomCapacity);
            holidayList.add(myHoliday);
        }
        return holidayList;

    }
    
    public List<Holiday> searchVacationDescending(String keyword) throws SQLException {
        List<Holiday> holidayList = new ArrayList<Holiday>();
        PreparedStatement ps = connection.prepareStatement("select * from holidays where title like ? or description like ? order by price_per_room desc");
        ps.setString(1, keyword);
        ps.setString(2, keyword);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int holidayId = rs.getInt("holiday_id");
            String description = rs.getString("description");
            String title = rs.getString("title");
            String packageType = rs.getString("package_type");
            String meal = rs.getString("meal");
            String image = rs.getString("image");
            int pricePerRoom = rs.getInt("price_per_room");
            int roomCapacity = rs.getInt("max_room_capacity");
            Holiday myHoliday = new Holiday(title, description, packageType, meal, image, holidayId, pricePerRoom, roomCapacity);
            holidayList.add(myHoliday);
        }
        return holidayList;

    }

    public void deleteVacation(String holidayId) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("delete from holidays where holiday_id = ?");
        ps.setString(1, holidayId);
        ps.executeUpdate();
    }
}
