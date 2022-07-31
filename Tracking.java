import java.util.*;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tracking extends replace implements delete{
    Scanner sc = new Scanner(System.in);
    String id1 = "-1";
    File f1;

    public void del(String id) throws IOException {
        String s;
        String totalStr = "";
        try (BufferedReader br = new BufferedReader(new FileReader(id + ".txt"))) {

            while ((s = br.readLine()) != null) {
                totalStr += (s + "\n");
            }
            totalStr = totalStr.replaceAll(id1, "--");
            FileWriter fw = new FileWriter(id + ".txt");
            fw.write(totalStr);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        f1.delete();
    }

    protected void re(String id) throws IOException, InterruptedException {

        f2 = new File(id + id1 + ".txt");
        String str = Files.readAllLines(Paths.get(id + ".txt")).get(9);
        for (int i = 9; str != null; i++) {
            try {
                str = Files.readAllLines(Paths.get(id + ".txt")).get(i);
            } catch (IndexOutOfBoundsException error) {
                System.out.println("Order not found");
                System.out.println("1-To Main Menu\n2-Try Again");
                int x = sc.nextInt();
                if (x == 1) {
                    return;

                } else
                    re(id);

            }

            if (str.equals(id1)) {
                del(id);
                System.out.println("\nOrder Cancelled");
                System.out.println("Enter New Order");
                create c = new create();
                c.view(id);
                break;
            }
        }
    }

    void track(String id) throws IOException, InterruptedException {

        System.out.println("Enter the Tracking ID for the Order to be tracked: ");
        Scanner n = new Scanner(System.in);
        id1 = n.nextLine();

        f1 = new File(id + id1 + ".txt");
        if (f1.exists()) {
            String str[] = new String[7];
            for (int i = 0; i < 7; i++) {

                try {
                    str[i] = Files.readAllLines(Paths.get(id + id1 + ".txt")).get(i);
                } catch (IndexOutOfBoundsException error) {
                    break;
                }
            }
            System.out.println( str[0]);
            System.out.println( str[1]);
            System.out.println( str[2]);
            System.out.println( str[3]);
            System.out.println(str[4] );
            System.out.println(str[5]);
            System.out.println(  str[6]);
            if (str[3].equals("2")) {
                System.out.println("Delivery Charges- " + ((int) ((str[4].charAt(29) - (int) '0') * 30) + 60));
            } else
                System.out.println("Delivery Charges- " + ((int) str[4].charAt(29) - (int) '0') * 30);

           // String c1 = n.nextLine();
           // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            while (true) {
                System.out.println("\n\n1-Replace order\n2-Delete order\n3-Main menu");
                int t = sc.nextInt();
                if (t == 1) {

                    re(id);
                    return;

                } else if (t == 2) {
                    del(id);
                    return;

                } else if (t == 3) {
                    return;
                } else {
                    System.out.println("Enter valid option");
                    continue;
                }
            }

        } else {
            // f1.delete();
            System.out.println("Order not found");
            System.out.println("1-to Main Menu\n2-Try Again");
            int x = sc.nextInt();
            if (x == 1) {

                return;
            } else {

                track(id);

            }
        }
    }

}