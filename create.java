import java.util.*;
import java.util.Date;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class create
{
    Scanner n = new Scanner(System.in);
    private int days;

     void view(String id) throws IOException, InterruptedException 
    {
        Map<Integer, String> mop = new HashMap<Integer, String>();
        Map<Integer, String> delivery = new HashMap<Integer, String>();
        Map<Integer, String> type = new HashMap<Integer, String>();

        mop.put(1, "Cash on Delivery");
        mop.put(2, "UPI");
        mop.put(3, "Credit/Debit card");
        delivery.put(1, "Normal Delivery");
        delivery.put(2, "Fast Track");
        type.put(1, "Electronics");
        type.put(2, "Clothing");
        type.put(3, "Books");
        int x;
        a:
        while (true) 
        {
            System.out.println("Order type \n1-Electronics\n2-Clothing \n3-Books");
            x = n.nextInt();
            if (x > 3 || x < 0) 
            {
                System.out.println("Please select a valid option");
                continue a;
            } else 
            {
                break;
            }
        }

        try 
        {

         days = state(x, Files.readAllLines(Paths.get(id + ".txt")).get(6));
        } catch (IOException e) 
        {
            System.out.println(e);
        }
        String trackId = Integer.toString((int) (Math.random() * 10000000));

        int mop1,del;
        b:
        while (true) 
        {
            System.out.println("Mode Of payment\n1-Cash on Delivery \n2-UPI\n3-Credit/Debit card");
             mop1 = n.nextInt();
            if (mop1 > 3 || mop1 <= 0) 
            {
                System.out.println("Please select a valid option");
                continue b;
            } else 
            {
                break;
            }

        }

       c:
        while (true) 
        {
            System.out.println("Delivery options\n1-Normal Delivery \n2-Fast Track");
            del = n.nextInt();
            if (del > 2 || del <= 0) 
            {
                System.out.println("Please select a valid option");
                continue c;
            } else 
            {
                break;
            }

        }

        Date date = java.util.Calendar.getInstance().getTime();
        BufferedWriter bf = new BufferedWriter(new FileWriter(id + ".txt", true));
        bf.write(trackId + "\n");
        bf.close();
        bf = new BufferedWriter(new FileWriter(id + trackId + ".txt", true));
        bf.write("Tracking id - "+trackId + "\n");
        bf.write("Order type - "+type.get(x) + "\n");
        bf.write("Mode of Payment - "+mop.get(mop1) + "\n");
        bf.write("Type of Delivery - "+delivery.get(del) + "\n");
        if(del==2)
        {
            bf.write("Order to be delivered within "+(days - 1) + " days\n");
        }
        else
            bf.write("Order to be delivered within "+(days) + " days\n");
        bf.write( "Delivery Address- " + Files.readAllLines(Paths.get(id + ".txt")).get(8) + "\n");
        bf.write("Date of Order Placement- "+date + "\n");
        bf.close();
        System.out.print("Order created sucessfully\nTracking id-"+ trackId);

        String c1=n.nextLine();
        c1=n.nextLine();
       new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }

    private int state(int x, String state) 
    {
        if (x == 1) 
        {
            if (state.equalsIgnoreCase("gujarat")) 
            {
                return 2;
            } else if (state.equalsIgnoreCase("maharashtra") || state.equalsIgnoreCase("madhya pradesh")
                    || state.equalsIgnoreCase("rajasthan")) 
            {
                return 3;
            }
            else 
            {
                return 5;
            }
        } 
        else if (x == 2) 
        {
            if (state.equalsIgnoreCase("maharashtra")) 
            {
                return 2;
            } 
            else if (state.equalsIgnoreCase("gujarat") || state.equalsIgnoreCase("madhya pradesh")
                    || state.equalsIgnoreCase("karnataka") || state.equalsIgnoreCase("goa")) 
            {
                return 3;
            }
            else 
            {
                return 5;
            }
        } 
        else if (x == 3) 
        {
            if (state.equalsIgnoreCase("goa"))
            {
                return 2;
            } 
            else if (state.equalsIgnoreCase("maharashtra") || state.equalsIgnoreCase("kerela")
                    || state.equalsIgnoreCase("karnataka")) 
            {
                return 3;
            }
            else
            {
                return 5;
            }
        }
        return 0;
    }
}
