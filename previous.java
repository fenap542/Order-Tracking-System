import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
class previous extends Tracking 
    {
    Scanner sc= new Scanner(System.in);
    int count =0;
    void pre(String id)throws IOException, InterruptedException{
        File f2 = new File( id+".txt");

        if(f2.exists())
        {
            System.out.println("Tracking ids: ");
            for(int i=9;;i++)
            {
                String st;
                try
                {
                    st = Files.readAllLines(Paths.get(id+".txt")).get(i);
                }
                catch(IndexOutOfBoundsException error)
                {
                    break;
                }
                if(!st.equals("--"))
                {
                   count++;
                    System.out.println(st);
                }
            }

        }
       
        
          if(count>0)
          {
            System.out.println("1-Track previous order \n2-Delete previous order\n3-Exit");
        
        
        
            while(true)
            {
               System.out.print("Enter option");
            int op=sc.nextInt();
                if(op==1)
                {
                   track(id);
                   return;
                }
                else if(op==3)
                {
                  return;
                }
                else if(op==2)
                {
                    del(id);
                    return;
                }
                else{
                    System.out.println("Invalid option\n");
                    continue ;
                }
    
                }
          }
          else 
          {
              System.out.println("\nNo previous order ");
          }

    }

     

    public void del(String id) throws IOException 
    {
        sc = new Scanner(System.in);
        System.out.println("Enter the Tracking ID for the Order to be Cancelled: "); 
        String id1 = sc.nextLine();
        File f2 = new File(id + id1 + ".txt");
        String str = Files.readAllLines(Paths.get( id + ".txt")).get(9);
        for (int i = 9; str != null; i++) 
        {
            try 
            {
                str = Files.readAllLines(Paths.get(id + ".txt")).get(i);
            } 
            catch (IndexOutOfBoundsException error) 
            {
                System.out.println("Order not found");
                System.out.println("1-to Main Menu\n2-Try Again");
                int x = sc.nextInt();
                if (x == 1) 
                {
                    return;
                } else
                    del(id);
            }

            if (str.equals(id1)) 
            {
                String s;
                String totalStr = "";
                try (BufferedReader br = new BufferedReader(new FileReader(id + ".txt"))) 
                {

                    while ((s = br.readLine()) != null) 
                    {
                        totalStr += (s+"\n");
                    }
                    totalStr = totalStr.replaceAll(id1, "--");
                    FileWriter fw = new FileWriter(id+".txt");
                    fw.write(totalStr);
                    fw.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                
                f2.delete();

                System.out.println("Order Cancelled !");
                String c = sc.nextLine();
                break;
            }
        }

    }
   
}
