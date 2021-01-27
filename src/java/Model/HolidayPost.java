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
public interface HolidayPost {
    public abstract Holiday addHoliday(String title, String description, int pricePerRoom, String packageType, int roomCapacity, String meal, String image);
}
