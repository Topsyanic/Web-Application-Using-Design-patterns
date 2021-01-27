/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Raaid
 */
public class HolidayAdapter implements HolidayPost {
Holiday holiday;
    @Override
    public Holiday addHoliday(String title, String description, int pricePerRoom, String packageType, int roomCapacity, String meal, String image) {
        description = "Description is unavailable";
        holiday = new Holiday(title,description,pricePerRoom,packageType,roomCapacity,meal,image);
        return holiday;
    }
    
}
