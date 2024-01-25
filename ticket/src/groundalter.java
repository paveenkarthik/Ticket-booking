import java.util.*;
import java.sql.*;

public class groundalter extends App {
    public static void groundname(int id) {
        System.out.println();
        System.out.print("ENTER THE CHANGED NAME");
        String change = s.next();
        String query = "update ground set ground_name ='"+ change +"' where ground_id=" + id + "";
        try {
            Statement st = con.createStatement();
            int d = st.executeUpdate(query);
            if (d != 0)
                System.out.println("CHANGES DONE");
            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void groundplace(int id) {
        System.out.println();
        System.out.print("ENTER THE CHANGED PLACE : ");
        String change = s.next();
        String query = "update ground set ground_place ='"+ change +"' where ground_id=" + id + "";
        try {
            Statement st = con.createStatement();
            int d = st.executeUpdate(query);
            if (d != 0)
                System.out.println("CHANGES DONE");
            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void groundseat(int id) {
        System.out.println();
        System.out.println("ENTER THE CHANGED CAPASITY : ");
        int change = s.nextInt();
        System.out.print("ENTER THE CHANGED VIP SEAT : ");
        int vi=s.nextInt();
        System.out.println();
        System.out.print("ENTER THE CHANGED FIRST CLASS SEAT : ");
        int fc=s.nextInt();
        System.out.println();
        System.out.print("ENTER THE CHANGED SECOND CLASS SEAT : ");
        int sc=s.nextInt();
        System.out.println();
        System.out.print("ENTER THE CHANGED STANDARD SEAT : ");
        int sta=s.nextInt();
        System.out.println();
        String query = "update ground set total_seat_cap =" + change + " where ground_id=" + id + "";
        String query1 = "update seatpanel set vip= " + vi + ",firstclass="+fc+",seconclass="+sc+",standard="+sta+" where ground_id=" + id + "";
        String query2 = "update seat set vip= " + vi + ",firstclass="+fc+",seconclass="+sc+",standard="+sta+" where ground_id=" + id + "";
        try {
            Statement st = con.createStatement();
            int d = st.executeUpdate(query);

            Statement st1 = con.createStatement();
            int d1 = st1.executeUpdate(query1);

            Statement st2 = con.createStatement();
            int d2 = st2.executeUpdate(query2);


            if (d != 0 && d1!=0 && d2!=0)
                System.out.println("CHANGES DONE");
            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
