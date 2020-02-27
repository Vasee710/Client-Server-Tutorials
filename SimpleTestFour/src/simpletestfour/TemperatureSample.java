/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestfour;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author MAC 04
 */
public class TemperatureSample implements Serializable{
    public double value;
    public String location;
    public Date time;
    
    public TemperatureSample(double value, String location, Date time){
        this.value = value;
        this.location = location;
        this.time = time;
    }

    @Override
    public String toString() {
        return "TemperatureSample{" + "value=" + value + ", location=" + location + ", time=" + time + '}';
    }
}
