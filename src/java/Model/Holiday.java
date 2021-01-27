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
public class Holiday {

    String title, description, packageType, meal, image;
    int holidayId, pricePerRoom, roomCapacity;

    public Holiday(String title, String description, String packageType, String meal, String image, int holidayId, int pricePerRoom, int roomCapacity) {
        this.title = title;
        this.description = description;
        this.packageType = packageType;
        this.meal = meal;
        this.image = image;
        this.holidayId = holidayId;
        this.pricePerRoom = pricePerRoom;
        this.roomCapacity = roomCapacity;
    }

    public Holiday(String title, String description, int pricePerRoom, String packageType, int roomCapacity, String meal, String image) {
        this.title = title;
        this.description = description;
        this.pricePerRoom = pricePerRoom;
        this.packageType = packageType;
        this.roomCapacity = roomCapacity;
        this.meal = meal;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }

    public int getPricePerRoom() {
        return pricePerRoom;
    }

    public void setPricePerRoom(int pricePerRoom) {
        this.pricePerRoom = pricePerRoom;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

}
