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
    
    //in order to get decimal numbers: change the attribute of function from int to float
    public double divideIntegerNumbers(int a, int b) throws Exception{
        //Exceptions to decide if b = 0 (which causes infinity
        //or if both a and b are zero, which causes the answer to become indeterminant
        if(b == 0){
            throw new Exception();
        }
        
        if (b == 0 && a == 0){
            throw new Exception();
        }
        
        System.out.println("[SERVER} - Dividing " + a + " and " + b);
        return (double)a/b; //have cast it to double in order to obtain the real value
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
                    System.out.println("The denominator is zero");
                    throw new Exception();
                }else if(a[i] == 0 && b[i] == 0){
                    System.out.println("Both numerator and denominator are zero");
                    throw new Exception();
                }else{
                    c[i] = a[i] + b[i];
                }
            
            }
            return c;
        }
        
        
    }
}
