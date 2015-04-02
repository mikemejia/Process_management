/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_management;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author Mike
 */
public final class Open extends JFrame{
    static int[] arrayPos = new int[90];
    static int[] arrayWork = new int[90];
    static int[] arrayArrival = new int[90];
    
    public void rpen() throws FileNotFoundException {
     Scanner TT;
    JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(Open.this);
        
        
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        TT = new Scanner(file);
        arrayset(TT);
    }
  }
    public void arrayset(Scanner a){
        int num = 0;
    while(a.hasNext()){
        this.arrayPos[num] = a.nextInt();
        this.arrayWork[num] = a.nextInt();
        this.arrayArrival[num] = a.nextInt();
        
        num++;
    }
    }
    public int arrayWor(int q){
    
    
    return arrayWork[q];}
}