import java.util.*;
import java.io.*;
import java.nio.file.Files;

import java.nio.file.Paths;

public class replace extends create implements delete  
{

    Scanner sc = new Scanner(System.in); 
    String id1;
    File f2;
   protected void re(String id) throws IOException,InterruptedException
    {
        System.out.println("Enter the Tracking ID for the Order to be Replaced: ");
        id1 = sc.nextLine();
         f2 = new File(id + id1 + ".txt");
        String str = Files.readAllLines(Paths.get(id + ".txt")).get(9);
        for (int i = 9; str != null; i++) 
        {
            try
            {
                str = Files.readAllLines(Paths.get(id + ".txt")).get(i);
            } catch (IndexOutOfBoundsException error) 
            {
                System.out.println("Order not found");
                System.out.println("1-To Main Menu\n2-Try Again");
                int x = sc.nextInt();
                if (x == 1) 
                {
                    return;

                } else
                    re(id);
            }

            if (str.equals(id1)) 
            {
                del(id);
                System.out.println("Previous order Cancelled");
                System.out.println("Enter New Order");
                view(id);
                break;
            }
        }
    }

    public void del(String id) throws IOException 
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
    }

}