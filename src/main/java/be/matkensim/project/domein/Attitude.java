/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.matkensim.project.domein;

/**
 *
 * @author Kenzo
 */
public class Attitude 
{
    private String attitude;

    public Attitude(String attitude) {
        this.attitude = attitude;
    }

    public String getAttitude() {
        return attitude;
    }

    public void setAttitude(String attitude) {
        this.attitude = attitude;
    }

    @Override
    public String toString() {
        return attitude;
    }
    
    
}
