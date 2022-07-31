import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

class num extends Exception
{
   
    num()
   {
       System.out.println("Invalid Input\n");
   }
}
class StringValidation
{
    public boolean validtaeString(String str)
     {
       str = str.toLowerCase();
       char[] charArray = str.toCharArray();
       for (int i = 0; i < charArray.length; i++) 
       {
          char ch = charArray[i];
          if (!(ch >= 'a' && ch <= 'z'))
           {
             return false;
           }
       }
       return true;
    }
}
class information 
{
    String id,password,fname,lname,mobile,mailid,address,state,city;
    
    Scanner sc = new Scanner(System.in);

    private int option()
    {
        System.out.println("Welcome To LightSpeed Tracking Company!! \n\n");
        System.out.println("\t 1-Login \n\t2-Sign in");
        int x=sc.nextInt();
        String c=sc.nextLine();
        System.out.print("\033[H\033[2J");
       System.out.flush(); 
        return x;
    }

    public void login() throws IOException, InterruptedException 
    {
       
        // sign in

        if (option() == 2) 
        {
            System.out.println("Enter ID");
            id = sc.nextLine();
            File f1 = new File(id + ".txt");
            // if file already exists
            if (f1.exists()) 
            {
                System.out.println("Id already exist");
                String c=sc.nextLine();
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                login();
            }
            System.out.println("Enter Password");
            password = sc.nextLine();
            while(true)
            {
                try
                {
                    System.out.println("Enter Your First Name");
                    fname = sc.nextLine();     
                    StringValidation obj = new StringValidation();
                    boolean bool = obj.validtaeString(fname);
                    if(!bool) 
                    {
                        throw new num();
                    }
                    else
                    {
                        break;
                    }
                }
                catch (num e)
                {
                    continue;
                }
            }
                
            while(true)
            {
                try
                {
                    System.out.println("Enter Your Last Name");
                    lname = sc.nextLine();     
                    StringValidation obj = new StringValidation();
                    boolean bool = obj.validtaeString(lname);
                    if(!bool) 
                    {
                        throw new num();
                    }
                    else
                    {
                        break;
                    }
                }
                catch (num e)
                {
                    continue;
                }
            }
            while(true)
            {
                try{
              System.out.println("Enter Your Mobile Number");
                mobile = sc.nextLine();
                int x = mobile.indexOf('0');
                    if (mobile.length() == 10 && x!=0) 
                    {
                        break;
                    } else 
                    {
                        throw new num();
                    }
                }
                catch(num e)
                {
                   continue ;
                }
                
                 
            }
            while(true)
            {
                System.out.println("Enter Your Mail Id");
                mailid = sc.nextLine();
                if(!mailid.contains("@gmail.com"))
                {
                    System.out.println("Invalid Mail Id");
                }
                else
                {
                    break;
                }
            }
            while(true)
            {
                try
                {
                    System.out.println("Enter Your State");
                    state = sc.nextLine();   
                    StringValidation obj = new StringValidation();
                    boolean bool = obj.validtaeString(state);
                    if(!bool) 
                    {
                        throw new num();
                    }
                    else
                    {
                        break;
                    }
                }
                catch (num e)
                {
                    continue;
                }
            }
            while(true)
            {
                try
                {
                    System.out.println("Enter Your City");
                    city = sc.nextLine();  
                    StringValidation obj = new StringValidation();
                    boolean bool = obj.validtaeString(city);
                    if(!bool) 
                    {
                        throw new num();
                    }
                    else
                    {
                        break;
                    }
                }
                catch (num e)
                {
                    continue;
                }
            }
           
            System.out.println("Enter Your Address (In single line only)");
            address = sc.nextLine();

            // else writing input into file

            BufferedWriter bf = new BufferedWriter(new FileWriter(id + ".txt", true));
            bf.write(password + "\n");
            bf.write(fname + "\n");
            bf.write(lname + "\n");
            bf.write(mobile + "\n");
            bf.write(id + "\n");
            bf.write(mailid + "\n");
            bf.write(state + "\n");
            bf.write(city + "\n");
            bf.write(address + "\n");
            bf.close();
            String c=sc.nextLine();
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            menu();
            return;
        }

        // login

        else
        {
            System.out.println("Enter ID");
            id = sc.nextLine();
            System.out.println("Enter Password");
            String str1 = sc.nextLine();
            File f1 = new File(id + ".txt");
            if (f1.exists()) 
            {
                String str;
                BufferedReader br = new BufferedReader(new FileReader(id + ".txt"));
                str = br.readLine();

                if (str.equals(str1) == true) 
                {
                    System.out.println("Login Successful!!!");
                    String c=sc.nextLine();
                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                    br.close();
                    menu();
                    return;
                } 
                else 
                {
                    System.out.println("Incorrect password");
                    String c=sc.nextLine();
                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                    br.close();
                    login();
                }

            } 
            else
            {
                System.out.println("Incorrect ID");
                String c=sc.nextLine();
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                login();
            }

        }
        String c=sc.nextLine();
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    }

    void menu() throws IOException, InterruptedException
    {
        System.out.println("1-Create an Order");

        System.out.println("2-Track your Order");

        System.out.println("3-Previous Order");

        System.out.println("4-Order Replacement");

        System.out.println("5-Order Cancellation");

        System.out.println("6-Exit");
        int x = sc.nextInt();
        switch (x) 
        {
            case 1: 
            {
                create order = new create();
                order.view(id);
                break;
            }
            case 2: 
            {
                Tracking trace=new Tracking();
                trace.track(id);
                break;
            }
            case 3: 
            {
                previous pre=new previous();
                pre.pre(id);
                break;
            }
            case 4: 
            {
                replace re = new replace();
                re.re(id);
                break;
            }
            case 5: 
            {
               del(id);
                break;
            }
            case 6:
            {
                return;
            }
            default: 
            {
                System.out.println("Enter valid option");
            }
        }
        String c=sc.nextLine();
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        menu();
    }
    
    public void del(String id) throws IOException 
    {
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
                System.out.println("1-To Main Menu\n2-Try Again");
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
                break;
            }
        }

    }

}