/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestfour;

import com.sun.istack.internal.logging.Logger;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author MAC 04
 */
public class DummyClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DummyClient client = new DummyClient();
        client.execute();
        
    }

    private void execute() {
        DummyServer server = new DummyServer();
        if(server.isConnected()){
            System.out.println("[CLIENT] - The server is connected, the test can proceed");
            
            TemperatureSample s1 = new TemperatureSample(10.3, "London", new Date());
            System.out.println("[CLIENT] - The sample is : " +s1);
            try{
                server.addSample(s1);
            }catch(IOException ex){
                //Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            TemperatureSample s2 = new TemperatureSample(9.1, "London", new Date());
            System.out.println("[CLIENT] - The sample is : " +s2);
            try{
                server.addSample(s2);
            }catch(IOException ex){
                //Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            TemperatureSample s3 = new TemperatureSample(5.1, "London", new Date());
            System.out.println("[CLIENT] - The sample is : " +s3);
            try{
                server.addSample(s3);
            }catch(IOException ex){
                //Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("[CLIENT] - wants to find the coldest temperature in London");
            String city = "London";
            double coldestTemp = server.getColdestTemperatureIn(city);
            System.out.println("[CLIENT] - is displaying the lowest temperature in " + city);
            System.out.println("[CLIENT] - the coldest temperature is " + coldestTemp);
            
            System.out.println("[CLIENT] - wants to find the coldest temperature in London");
            double hottestTemp = server.getHottestTemperatureIn(city);
            System.out.println("[CLIENT] - is displaying the hottest temperature in " + city);
            System.out.println("[CLIENT] - the hottest temperature is " + hottestTemp);
            
            System.out.println("[CLIENT] - wants to find the average temperatures in a city");
            double averageTemp = server.getAverageTemperatureIn(city);
            System.out.println("[CLIENT] is displaying the average temperature in " + city + " is " + averageTemp);
            
            System.out.println("[CLIENT] - wants to find the recorded temperatures in a city");
            int noOfRecordings = server.getNumberOfSamplesIn(city);
            System.out.println("[CLIENT] is displaying the recorded temperature in " + city + " is " + noOfRecordings);

            
            System.out.println("[CLIENT] - The process has finished.");
        }else{
            System.out.println("[CLIENT] - The server is connected, the test has failed");
        }
    }
    
}
