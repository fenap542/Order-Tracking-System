import java.util.*;
import java.io.*;


public class Main{
        public static void main(String []args)throws IOException, InterruptedException
        {
            Scanner sc=new Scanner(System.in);
           
            String c=sc.nextLine();
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            information x=new information();
            x.login();
            
            String c1=sc.nextLine();
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            System.out.println("Thanks For Ordering through LightSpeed Tracking Company !!");
    
    
        }
}
