/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package win7calcclone;

/**
 *
 * @author ReaLgressA
 */
public class Calc {
    private NumberStorage numStorage;
    
    public Calc() {
        numStorage = new NumberStorage();
        MainWindow w = new MainWindow(numStorage);
        w.setVisible(true); 
    }
    
    public static void main(String[] args) {
        Calc calc = new Calc();
    }
    
}
