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
public abstract class VacationDecorator implements Vacation{
Vacation vacation;
    public VacationDecorator(Vacation vacation) {
        this.vacation=vacation;
    }
    
    @Override
    public int getCost()
    {
        return vacation.getCost();
    };
    
}
