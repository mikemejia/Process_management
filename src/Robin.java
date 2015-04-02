/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_management;

/**
 *
 * @author Mike
 */
public class Robin {
    static int[] arrayWork = new int[90];
    static int[] wait= new int[90];
    static int[] turn= new int[90];
    static int tturn = 0;
     int res = 0;
    Open r = new Open();
    public Robin(){
        int fin = 0;
        int i = 0;
        int w = 0;
       
        for(int q = 0; q < 90;q++){
            arrayWork[q] = r.arrayWor(q);
        }
        while(fin < 90){
            if(arrayWork[w]!=0){
                if(arrayWork[w]<100){
            this.turn[w] = tturn + arrayWork[w];
            this.tturn = tturn + arrayWork[w];
            this.arrayWork[w] = 0;
            fin++;
                                     } 
                     else {
            this.arrayWork[w] = arrayWork[w] - 100;
            this.tturn = tturn + 100;
                        if(arrayWork[w] == 0){
            this.turn[w] = tturn;
            fin++;
                                               }
                             }
            
                                 }
            w++;
            if(w == 90){
            w = 0;
            }
            
          if(i == 0){
            this.wait[i] = 0;
            this.res = 100;}
         if(i > 0 && i < 90){
             this.wait[i] = res;
                if(r.arrayWor(i) < 100){
                this.res = res + r.arrayWor(i);
                                        }
                else
                {
                 this.res = res +100;
                    }
         }
          i++;
         
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
