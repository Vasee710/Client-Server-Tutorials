/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestfour;

import com.sun.istack.internal.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author MAC 04
 */
public class DummyServer {
    
    ArrayList <TemperatureSample> samples = new ArrayList<TemperatureSample>();
    String fileName = "Sample.ser";
    
    public DummyServer(){
        try{
            loadFromFile();
        }catch (IOException ex){
            //Logger.getLogger(DummyServer.class.getName()).log(Level.SEVERE, null,ex );
        }catch (ClassNotFoundException ex){
            //Logger.getLogger(DummyServer.class.getName()).log(Level.SEVERE, null,ex );

        }
    }
    
    private void saveToFile() throws FileNotFoundException, IOException{
        System.out.println("[SERVER] - Saving " + samples + " to file " + fileName);
        
        //saving objects in a file
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        
        //method for serialization of object
        out.writeObject(samples);
        
        out.close();
        file.close();
        
        System.out.println("[SERVER] - Object has been serialized");
    }
    
    
    
    public boolean isConnected(){
        System.out.println("[SERVER] - Testingif the server is connected...");
        return true;
    }
    
    public void addSample(TemperatureSample s) throws IOException{
        System.out.println("[SERVER] - Adding " + s + " to " + samples);
        samples.add(s);
        System.out.println("[SERVER] - Samples are " + samples);
        saveToFile();
    }

    private void loadFromFile()throws FileNotFoundException, IOException, ClassNotFoundException{
        System.out.println("[SERVER] - Loading sample from file " + fileName);
        //reading object from a file
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);
        
        //method for deserialization of object
        samples = (ArrayList<TemperatureSample>)in.readObject();
        in.close();
        file.close();
    }
    
    //TASK 20
    public double getColdestTemperatureIn(String city){
        System.out.println("[SERVER] - is finding the coldest temperature in the specified city");
        //String coldestCity = samples.get(0).location;
        ArrayList<Double> cityTemps = new ArrayList<>();
        
        for(int i = 0; i < samples.size(); i++ ){
            if (samples.get(i).location.equals(city)){
                cityTemps.add(samples.get(i).value);
            }
        }
       
        double coldestTemp = cityTemps.get(0);
        for(int i = 0; i < cityTemps.size(); i++){
            if(cityTemps.get(i) < coldestTemp){
                coldestTemp = cityTemps.get(i);
            }
        }
        return coldestTemp;
    }
    
    public double getHottestTemperatureIn(String city){
        System.out.println("[SERVER] - is finding the hottest temperature in the specified city");
        //String coldestCity = samples.get(0).location;
        ArrayList<Double> cityTemps = new ArrayList<>();
        
        for(int i = 0; i < samples.size(); i++ ){
            if (samples.get(i).location.equals(city)){
                cityTemps.add(samples.get(i).value);
            }
        }
       
        double hottestTemp = cityTemps.get(0);
        for(int i = 0; i < cityTemps.size(); i++){
            if(cityTemps.get(i) > hottestTemp){
                hottestTemp = cityTemps.get(i);
            }
        }
        return hottestTemp;
    }
    
    public double getAverageTemperatureIn(String city){
        System.out.println("[SERVER] - is finding the average temperature in the specified city");
        //String coldestCity = samples.get(0).location;
        ArrayList<Double> cityTemps = new ArrayList<>();
        
        for(int i = 0; i < samples.size(); i++ ){
            if (samples.get(i).location.equals(city)){
                cityTemps.add(samples.get(i).value);
            }
        }
        
        double total = 0;
        double average = 0;
        
        for(int i = 0; i < cityTemps.size(); i++){
            total = total + cityTemps.get(i);
        }
        average = total / cityTemps.size();
        return average;
    }
    
    public int getNumberOfSamplesIn (String city){
         System.out.println("[SERVER] - is finding the average temperature in the specified city");
        //String coldestCity = samples.get(0).location;
        ArrayList<Double> cityTemps = new ArrayList<>();
        
        for(int i = 0; i < samples.size(); i++ ){
            if (samples.get(i).location.equals(city)){
                cityTemps.add(samples.get(i).value);
            }
        }
        
        return cityTemps.size();
    }
    
    
}
