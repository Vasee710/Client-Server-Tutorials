/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletest;

/**
 *
 * @author Vaseekaran
 */
public class SimpleTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SimpleTest test = new SimpleTest();
        DummyServer ds = new DummyServer();
        ds.testConnection();
        test.execute();
    }
    
    private static void execute(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
