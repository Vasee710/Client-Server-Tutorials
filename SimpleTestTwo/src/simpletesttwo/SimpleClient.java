/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletesttwo;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vaseekaran
 */
public class SimpleClient {
    
    SimpleCalculatorServer server = new SimpleCalculatorServer();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SimpleClient simpleClient = new SimpleClient();
        simpleClient.executeTest();
    }

    private void executeTest() {
        System.out.println("[CLIENT] - Testing if the server is connected...");
        
        if(server.isServerConnected()){
            System.out.println("[CLIENT] - the client is connected, test can proceed...");
            
            int x = 2;
            int y = 3;
            
            System.out.println("[CLIENT] - Asking the server what is the sum of " + x + " and " + y);
            double z = server.addIntegerNumbers(x, y);
            System.out.println("[CLIENT] - THe server has replied that the sum of " + x + " and " + y + " is " + z);
            
            if(z == x + y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the incorrect answer");
            }
            
            x = 4;
            y = 2;
            
            System.out.println("[CLIENT] - asking the server what is the division of " + x + " and " + y);
            try {
                z = server.divideIntegerNumbers(x, y);
                System.out.println("[CLIENT] - the server has replied that the division of " + x + " and " + y + " is " + z);
                if(z == (double)x/y){
                    System.out.println("[CLIENT] - The server has returned the correct answer");
                }else{
                    System.out.println("[CLIENT] - The server has returned the incorrect answer");
                }
            } catch (Exception ex) {
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("[CLIENT] - asking server what is the substraction of " + x + " and " + y );
            z = server.substractIntegerNumbers(x, y);
            System.out.println("[CLIENT] - server has replied that the substraction of " + x + " and " + y + " is " + z);
            
            if (z == x - y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the incorrect answer");
            }
            
            System.out.println("[CLIENT] - asking server what is the multiplication of " + x + " and " + y );
            z = server.multiplyingIntegerNumbers(x, y);
            System.out.println("[CLIENT] - server has replied that the multiplication of " + x + " and " + y + " is " + z);
            
            if (z == x * y){
                System.out.println("[CLIENT] - The server has returned the correct answer");
            }else{
                System.out.println("[CLIENT] - The server has returned the incorrect answer");
            }
            
            //Array adding
            
            int [] a = {1,2,3};
            int [] b = {3,4,5};
           
            System.out.println("[CLIENT] - is asking to add 2 arrays " + Arrays.toString(a) + " and " + Arrays.toString(b));
            try {
                int [] c = server.addArrayElements(a, b);
                System.out.println("[CLIENT] - server has returned the asnwer as " + Arrays.toString(c));
            } catch (Exception ex) {
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //Array dividing
            
            int [] d = {6,8,10};
            int [] e = {3,4,5};
           
            System.out.println("[CLIENT] - is asking to add 2 arrays " + Arrays.toString(d) + " and " + Arrays.toString(e));
            try {
                int [] f = server.divideTwoArrayElements(d, e);
                System.out.println("[CLIENT] - server has returned the asnwer as " + Arrays.toString(f));
            } catch (Exception ex) {
                Logger.getLogger(SimpleClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }else{
            System.out.println("[CLIENT] - The client is NOT connected, the test has failed...");
        }
        
 
    }
    
}
