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
public class LuxuryPackage implements Vacation {

    int pricePerRoom, noOfRooms;

    public LuxuryPackage(int pricePerRoom, int noOfRooms) {
        this.noOfRooms = noOfRooms;
        this.pricePerRoom = pricePerRoom;
    }

    @Override
    public int getCost() {
        int total = (pricePerRoom * noOfRooms) * 115 / 100;
        return total;
    }

}
