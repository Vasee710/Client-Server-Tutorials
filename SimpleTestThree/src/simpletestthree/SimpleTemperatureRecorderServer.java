/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestthree;

import java.util.ArrayList;

/**
 *
 * @author Vaseekaran
 */
public class SimpleTemperatureRecorderServer {
    
    ArrayList <Double> celsiusTemperatures = new ArrayList<>();
    ArrayList <Double> kelvinTemperatures = new ArrayList<>();
    ArrayList <Double> fahrenheitTemperatures = new ArrayList<>();
    //instead of primitive, equivalent type is used
    public Boolean isServerConnected(){
        System.out.println("[SERVER] - testing if the server is connected...");
        return true;
    }
    
    public void addTemperature(Double sample) throws lessThanMinimumTemperature{
        if(sample < -273.15){
            throw new lessThanMinimumTemperature("The temperature is incorrect as it is lower than -273.15 degree celsius");
        }
        System.out.println("[SERVER] - Adding sample " + sample);
        celsiusTemperatures.add(sample);
        System.out.println("[SERVER] - All samples now are: " + celsiusTemperatures);
    }
    
    public Double getColdestTemperature() throws ArrayIsEmpty{
        //if Array is empty
        if(celsiusTemperatures.isEmpty()){
            throw new ArrayIsEmpty("There are no elements in the temperature array");
        }
        
        System.out.println("[SERVER] - is finding the minimum temperature among the set");
        //double min = 0.0; (if temps are lower than zero only, this will work)
        double min = celsiusTemperatures.get(0);
        
        for(int i = 0; i < celsiusTemperatures.size(); i++){
            if(min > celsiusTemperatures.get(i)){
                min = celsiusTemperatures.get(i);
            }
        }
        
        return min;
    }
    
    public Double getHottestTemperature() throws ArrayIsEmpty{
        //if Array is empty
        if(celsiusTemperatures.isEmpty()){
            throw new ArrayIsEmpty("There are no elements in the temperature array");
        }
        System.out.println("[SERVER] - is finding the maximum temperature among the set");
        
        double max = celsiusTemperatures.get(0);
        
        for(int i = 0; i < celsiusTemperatures.size(); i ++){
            if(max < celsiusTemperatures.get(i)){
                max = celsiusTemperatures.get(i);
            }
        }
        
        return max;
    }
    
    public Double getAverageTemperature() throws ArrayIsEmpty{
        //if Array is empty
        if(celsiusTemperatures.isEmpty()){
            throw new ArrayIsEmpty("There are no elements in the temperature array");
        }
        System.out.println("[SERVER] - is finding the average temperature among the dataset");
        double total = 0;
        
        for(int i = 0; i < celsiusTemperatures.size(); i++){
            total += celsiusTemperatures.get(i);
        }
        
        double average = total / celsiusTemperatures.size();
        return average;
    }
    
    public void addKelvin(double sample) throws lessThanMinimumTemperature{
        if(sample < 0){
            throw new lessThanMinimumTemperature("The kelvin temperature is lower than zero, therefore it is incorrect.");
        }
        System.out.println("[SERVER] - is adding " + sample + " kelvin temperature to the system");
        kelvinTemperatures.add(sample);
        kelvinToCelsius();
        
    }
    
    public void kelvinToCelsius(){
        System.out.println("[SERVER] - is attempting to convert the kelvin to celsius");
        double convertedCelsius = kelvinTemperatures.get(0) - 273.15;
        System.out.println("[SERVER] - The converted celsius value of " + kelvinTemperatures.get(0) + " is " + convertedCelsius);
        celsiusTemperatures.add(convertedCelsius);
        System.out.println("[SERVER] - has successfully converted the " + kelvinTemperatures.get(0) + " kelvin to " + convertedCelsius + " celsius");
        kelvinTemperatures.remove(0);
        System.out.println("[SERVER] - All samples now are: " + celsiusTemperatures);
                
    }
    
    public void addFahrenheit(double sample) throws lessThanMinimumTemperature{
        if (sample < -459.67){
            throw new lessThanMinimumTemperature("The fahrenheit temperature is lower than -459.67 fahrenheit, therefore it is incorrect.");
        }
        System.out.println("[SERVER] - is adding the fahrenheit temperature to the system");
        fahrenheitTemperatures.add(sample);
        fahrenheitToCelsius();
    }

    private void fahrenheitToCelsius() {
        System.out.println("[SERVER] - is attempting to convert the " + fahrenheitTemperatures.get(0) + " fahrenheit value to celsius.");
        double phase1 = fahrenheitTemperatures.get(0) - 32;
        double phase2 = phase1 * 5;
        double convertedCelsius = phase2 / 9;
        celsiusTemperatures.add(convertedCelsius);
        System.out.println("[SERVER] - has successfully converted the " + fahrenheitTemperatures.get(0) + " fahrenheit to " + convertedCelsius + " celsius");
        fahrenheitTemperatures.remove(0);
        System.out.println("[SERVER] - All samples now are: " + celsiusTemperatures);
    }
    
}
