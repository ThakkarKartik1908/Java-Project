import java.io.*;
import java.util.*;

class LoginCLI {
    public static String currentUser;

    boolean login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String u = sc.nextLine().trim();

        System.out.print("Password: ");
        String p = sc.nextLine().trim();

        try {
            BufferedReader br = new BufferedReader(new FileReader("data/users.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[0].equalsIgnoreCase(u) && d[1].equals(p)) {
                    currentUser = u;
                    System.out.println("Login Successful!");
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading users file!");
        }

        System.out.println("Invalid Login!");
        return false;
    }
}