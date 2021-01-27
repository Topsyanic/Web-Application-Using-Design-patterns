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
public class VacationFactory {

    Vacation vacationObj;

    public Vacation selectPackage(String type,int pricePerRoom, int noOfRooms) {
        if (type.equalsIgnoreCase("Basic")) {
            vacationObj = new BasicPackage(pricePerRoom,noOfRooms);
        } else if (type.equalsIgnoreCase("Standard")) {
            vacationObj= new StandardPackage(pricePerRoom,noOfRooms);
        }
        else if(type.equalsIgnoreCase("Luxury"))
        {
            vacationObj = new LuxuryPackage(pricePerRoom,noOfRooms);
        }

        return vacationObj;
    }
}
