/*]
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process_management;

/**
 *
 * @author Mike
 */
public class FCFS {
   static int[] wait = new int[90];
   static int[] turn = new int[90];
   static int time = 0;
   int res = 0;
    Open t = new Open();
    
        public FCFS (){
        for(int i = 0; i < 90;i++){
            if(i == 0){
            wait[i] = 0;
            turn[i] = t.arrayWor(i);
            this.res = t.arrayWor(i);}
            if(i > 0){
                wait[i] = res;
                turn[i] = res + t.arrayWor(i);
                this.res = res + t.arrayWor(i);
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
        
        public int time(){
        this.time = wait[89];
        return time;}
        
        }
    

