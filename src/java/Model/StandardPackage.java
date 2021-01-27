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
public class StandardPackage implements Vacation {
  int pricePerRoom, noOfRooms;

    public StandardPackage(int pricePerRoom, int noOfRooms) {
        this.noOfRooms = noOfRooms;
        this.pricePerRoom = pricePerRoom;
    }
    

    @Override
    public int getCost() {
        int total = (pricePerRoom * noOfRooms)*110/100;
        return total;
    }
    
}
