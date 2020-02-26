/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletesttwo;

import java.util.Arrays;

/**
 *
 * @author Vaseekaran
 */
public class SimpleCalculatorServer {
    public boolean isServerConnected(){
        System.out.println("[SERVER] - Connection is being tested...");
        return true;
    }
    
    public int addIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - Adding " + a + " and " + b);
        return a+b;
    }
    
     public double divideIntegerNumbers(int a, int b) throws Exception{
         if(b == 0){
             throw new SimpleCalculatorServerException("Cannot divide a number by zero");
         }
         
         if(a == 0 && b == 0){
             throw new SimpleCalculatorServerException("Zero cannot be divided by zero");
         }
         
         System.out.println("[SERVER] - Dividing " + a + " and " + b);
         return (double)a/b;
     }
         

    public int substractIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - Substracting " + a + " and " + b);
        return a - b;
    }
    
    public int multiplyingIntegerNumbers(int a, int b){
        System.out.println("[SERVER] - Server is multiplying " + a + " and " + b);
        return a*b;
    }
    
    public int[] addArrayElements(int[] a, int [] b) throws Exception{
        System.out.println("[SERVER} - Server is adding the arrays " + Arrays.toString(a) + " and " + Arrays.toString(b));
        if(a.length != b.length){
            System.out.println("[SERVER] - The array lengths are not equal");
            throw new Exception();
        }
        int lenOfArray = a.length;
        
        int[] c = new int [lenOfArray];
        for(int i = 0; i < a.length; i++){
            c[i] = a[i] + b[i];
        }
        return c;
    }
    
    public int [] divideTwoArrayElements(int[] a, int [] b) throws Exception{
        System.out.println("[SERVER] - the server is dividing each element of the 2 arrays " + Arrays.toString(a) + " and " + Arrays.toString(b));
        if(a.length != b.length){
            System.out.println("The lengths of both arrays are not equal");
            throw new Exception();
        }else{
            int lenOfArray = a.length;
            int [] c = new int[lenOfArray];
            
            for(int i = 0; i < lenOfArray ; i++){
                if(b[i] == 0){
                    throw new SimpleCalculatorServerException("Number canot be divided by zero");
                }else if(a[i] == 0 && b[i] == 0){
                    throw new SimpleCalculatorServerException("Both numerator and denominator are zero");
                }else{
                    c[i] = a[i] + b[i];
                }
            
            }
            return c;
        }
        
        
    }
}
         
     
     
