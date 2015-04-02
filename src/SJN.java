/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_management;

import java.util.Arrays;

/**
 *
 * @author Mike
 */
public class SJN {
    static int[] arrayWork = new int[90];
    static int[] arrayWorkSort = new int[90];
    static int[] wait= new int[90];
    static int[] turn= new int[90];
    
    static int res = 0;
    Open r = new Open();
    public SJN(){
    for(int i = 0; i < 90; i++){
    arrayWork[i] =r.arrayWor(i); 
    arrayWorkSort[i] =r.arrayWor(i);
    }
        Arrays.sort(arrayWorkSort);
        int p = 0;
        int i = 0;
        
        while( p < 90){
            if(arrayWorkSort[p] == arrayWork[i]){
            if(p == 0){
            this.wait[i] = 0;
            this.turn[i] = r.arrayWor(i);
            this.res = r.arrayWor(i);}
            if(p > 0){
                this.wait[i] = res;
                this.turn[i] = res + r.arrayWor(i);
                this.res = res + r.arrayWor(i);
                        }
            p++;
            
        }
            
                i++;
                if(i == 90){
                    i=0;
                }
            
        }
        
        
    }
    public int returnWait(){
        int AVg = 0;
        for(int i = 0; i < 90; i++){
        AVg = AVg + wait[i];
        }
       AVg = AVg/90;
        
        return AVg;
        }
        public int returnTurn(){
        int AVg = 0;
        for(int i = 0; i < 90; i++){
        AVg = AVg + turn[i];
        }
       AVg = AVg/90;
        
        return AVg;
        }
       
    
}
