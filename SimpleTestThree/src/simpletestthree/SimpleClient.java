/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestthree;

/**
 *
 * @author Vaseekaran
 */
public class SimpleClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArrayIsEmpty, lessThanMinimumTemperature {
        // TODO code application logic here
        SimpleClient simpleClient = new SimpleClient();
        simpleClient.executeTest();
    }

    private void executeTest() throws ArrayIsEmpty, lessThanMinimumTemperature {
        SimpleTemperatureRecorderServer server = new SimpleTemperatureRecorderServer();
        if(server.isServerConnected()){
            System.out.println("[CLIENT] - The server is connected. The test can proceed.");
            
            server.addTemperature(new Double(10));
            //server.addTemperature(10.0);
            server.addTemperature(12.0);
            server.addTemperature(1.0);
            server.addTemperature(212.0);
            server.addTemperature(11.0);
            server.addTemperature(0.032);
            server.addKelvin(1);
            server.addFahrenheit(41);
            
            
            //to find the minimum temperature
            System.out.println("[CLIENT] - wants the server to find the lowest temperature");
            double lowTemp = server.getColdestTemperature();
            System.out.println("[CLIENT] - The client is displaying the lowest temperature");
            System.out.println("[CLIENT] - The minimum temperature in the dataset is " + lowTemp);
            
            //find the maximum temperature
            System.out.println("[CLIENT] - wants the server to find the highest temperature");
            double maxTemp = server.getHottestTemperature();
            System.out.println("[CLIENT] - The client is displaying the highest temperature");
            System.out.println("[CLIENT] - The maximum temperature in the dataset is " + maxTemp);
            
            //find the average temperature
            System.out.println("[CLIENT] - wants the server to display the average temperature");
            double average = server.getAverageTemperature();
            System.out.println("[CLIENT] - displays that the average of the dataset is " + average);
 
        }
 
        else{
            System.out.println("[CLIENT] - The server is not connected, terminating test.");
        }
    }
    
}
