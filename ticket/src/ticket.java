import java.sql.*;
import java.util.*;

public class ticket extends App {
    public static void book() {
        System.out.println("1.BOOKING\n2.CANCELLATION\n3.EXIT");
        System.out.println();
        System.out.print("ENTER YOUR CHOICE : ");
        int choice = s.nextInt();
        if (choice == 1) {
            ticketbooking();
        } else if (choice == 2) {
            cancel();
        } else {
            System.out.println("THANK YOU  (:)..!!");
            return;
        }

    }

    public static void ticketbooking() {

        Connection con = DB.database();
        System.out.println("TICKET BOOKING");
        System.out.println("**************");
        System.out.println();
        System.out.println("STADIUMS");
        String query = "select * from ground";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.printf("%-20s%-20s%-20s%-20s\n", "STADIUM ID", "STADIUM NAME", "STADIUM LOCATION",
                    "AVAILABLE SEAT ALLOCATIO ");
            while (rs.next()) {
                System.out.printf("%-20d", rs.getInt(1));
                System.out.printf("%-20s", rs.getString(2));
                System.out.printf("%-20s", rs.getString(3));
                System.out.printf("%-20d\n", rs.getInt(4));
            }
            System.out.println();
            booking();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void booking() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1.BOOKING\n2.EXIT");
            int book = s.nextInt();
            if (book == 1) {
                bookticket();
                break;
            } else if (book == 2) {
                System.out.println("THANK YOU (:)..!");
                break;
            } else {
                System.out.println("UNABLE TO FETCH YOUR INPUT ENTER '1'");
            }
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------
    public static void bookticket() {
        Scanner s = new Scanner(System.in);
        System.out.println();
        System.out.println("BOOK TICKETS");
        System.out.println("***********");
        System.out.println();
        System.out.print("ENTER YOUR EMAIL ID OR PHONE NUMBER : ");
        String ep = s.next();
        int id1 = 0;
        String query = "select user_id from user where user_email=? or phone_number=?";
        try {
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, ep);
            pre.setString(2, ep);
            ResultSet rs = pre.executeQuery();
            if (rs.next())
                id1 = rs.getInt(1);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println();
        System.out.print("ENTER THE GROUND ID : ");
        int gi = s.nextInt();
        System.out.println();
        System.out.println("WHICH TYPE OF SEAT YOU WANT ");
        System.out.println("***************************");
        System.out.println();
        String query1 = "select * from seat where ground_id='" + gi + "'";
        String q = "select * from ticketcost1 where ground_id='" + gi + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "ground id", "VIP SEAT", "FIRST CLASS SEAT",
                    "SECOND CLASS SEAT", "STANDARD SEAT");
            while (rs.next()) {
                System.out.printf("%-20d", rs.getInt(1));
                System.out.printf("%-20d", rs.getInt(2));
                System.out.printf("%-20d", rs.getInt(3));
                System.out.printf("%-20d", rs.getInt(4));
                System.out.printf("%-20d\n", rs.getInt(5));
            }
            System.out.println();
            System.out.println("COST OF THE SEATS");
            System.out.println("*****************");
            System.out.println();
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(q);
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "ground id", "VIP SEAT", "FIRST CLASS SEAT",
                    "SECOND CLASS SEAT", "STANDARD SEAT");
            while (rs1.next()) {
                System.out.printf("%-20d", rs1.getInt(1));
                System.out.printf("%-20d", rs1.getInt(2));
                System.out.printf("%-20d", rs1.getInt(3));
                System.out.printf("%-20d", rs1.getInt(4));
                System.out.printf("%-20d\n", rs1.getInt(5));
            }
            System.out.println();
            System.out.println("1.VIP SEAT\n2.FIRST CLASS SEAT\n3.SECOND CLASS SEAT\n4.STANDARD SEAT\n5.EXIT");
            System.out.println();
            System.out.println("ENTER YOUR CHOICE : ");
            int choice = s.nextInt();

            System.out.println();
            if (choice == 1) {
                SEAT.vip(id1, gi);
            } else if (choice == 2) {
                SEAT.fcseat(id1, gi);
            } else if (choice == 3) {
                SEAT.scseat(id1, gi);
            } else if (choice == 4) {
                SEAT.stseat(id1, gi);
            } else if (choice == 5) {
                bookticket();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cancel() {
        System.out.println("CONFIRM YOUR CANCELLATION");
        System.out.println("1.YES\n2.NO");
        System.out.print("ENTER YOUR CHOICE : ");
        int a = s.nextInt();
        System.out.println();
        if (a == 2) {
            book();
        }
        System.out.println();
        System.out.print("ENTER YOUR EMAIL ID : ");
        String email = s.next();
        int eid = 0;
        String q = "select user_id from user where user_email='" + email + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);
            if (rs.next()) {
                eid = rs.getInt(1);
            }
            String q1 = "select ground_id,no_of_ticket,seat,ticket_id from ticket where user_id=" + eid + "";
            Statement stq = con.createStatement();
            ResultSet rs1 = stq.executeQuery(q1);
            System.out.printf("%-20s%-20s%-20s%-20s\n", "GROUND ID", "NO OF TICKETS", "TYPE OF SEAT","TICKET_ID");
            while (rs1.next()) {
                System.out.printf("%-20d", rs1.getInt(1));
                System.out.printf("%-20d", rs1.getInt(2));
                System.out.printf("%-20s", rs1.getString(3));
                System.out.printf("%-20d\n", rs1.getInt(4));
            }
            System.out.println();
            System.out.print("ENTER THE TICKET ID : ");
            int k=s.nextInt();
            cancel.retrude(k);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
