import java.sql.*;
import java.util.*;

public class ticket extends App {
    public static void book() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("1.BOOKING\n2.CANCELLATION\n3.EXIT");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("ENTER YOUR CHOICE : ");
        int choice = s.nextInt();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        if (choice == 1) {
            ticketbooking();
        } else if (choice == 2) {
            cancel();
        } else if(choice==3) {
            System.out.println("THANK YOU  (:)..!!");
          exit();
        }
        else
        {
            System.out.println("ENTER THE CORRESPONDING DETAILS");
            System.out.println("-------------------------------------------------------------------------------");
          book();
        }
       
    }

    public static void ticketbooking() {

        Connection con = DB.database();
        while (true) {
            System.out.println("                        TICKET BOOKING");
            System.out.println("                        **************");
            System.out.println("-------------------------------------------------------------------------------");                              
            System.out.println();
            System.out.println("                            MATCHES");
            System.out.println("                            *******");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            String query = "select * from matches";
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                System.out.printf("%-20s%-20s%-20s%-20s\n", "STADIUM ID", "STADIUM NAME", "MATCHES",
                "DATE OF THE MATCH");
                while (rs.next()) {
                    System.out.printf("%-20d", rs.getInt(2));
                    int ground=rs.getInt(2);
                    String down="";
                    String q="select ground_name from ground where ground_id="+ground+"";
                    try {
                        
                        Statement st2 = con.createStatement();
                        ResultSet rs2= st2.executeQuery(q);
                        if(rs2.next())
                        down+=rs2.getString(1);
                        
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    System.out.printf("%-20s", down);
                    System.out.printf("%-20s", rs.getString(3));
                    String h="";
                    h+=rs.getDate(4);
                    System.out.printf("%-20s\n", h);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("                            STADIUM");
            System.out.println("                            *******");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            String query10 = "select * from ground";
            try {
                Statement st10 = con.createStatement();
                ResultSet rs10 = st10.executeQuery(query10);
                System.out.printf("%-20s%-20s%-20s\n",  "STADIUM NAME", "STADIUM LOCATION",
                        "SEAT ALLOCATION");
                while (rs10.next()) {
                    System.out.printf("%-20s", rs10.getString(2));
                    System.out.printf("%-20s", rs10.getString(3));
                    System.out.printf("%-20d\n", rs10.getInt(4));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
                System.out.println("-------------------------------------------------------------------------------");
                System.out.print("ENTER STATIUM ID: ");
                int i = s.nextInt();
                System.out.println();
                System.out.println("-------------------------------------------------------------------------------");
                int k = 0;
                System.out.println();
                String query1 = "select * from matches where ground_id=" + i + "";
                // 1System.out.println("--------------------------------------------------------------------------------------------------------------------");
                try {
                    Statement st1 = con.createStatement();
                    ResultSet rs1 = st1.executeQuery(query1);
                    System.out.printf("%-20s%-20s%-20s%-20s\n", "MATCH ID", "STADIUM ID", "MATCHES", "DATE");
                        while (rs1.next()) {
                            System.out.printf("%-20d", rs1.getInt(1));
                            System.out.printf("%-20d", rs1.getInt(2));
                            System.out.printf("%-20s", rs1.getString(3));
                            System.out.printf("%-20s\n", rs1.getDate(4));
                            k=2;
                        }
                        System.out.println("-------------------------------------------------------------------------------");
                     if (k!=2) {

                        System.out.println("                        NO MATCHES AT THIS GROUND ");
                        ticketbooking();
                        k = 2;
                    }
                    booking();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // if (k == 2) {
                // } else {
                // System.out.println(" NO MATCHES FOUND");
                // ticketbooking();
                // }
        }
    }

    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void booking() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("1.CONFIRM BOOKING\n2.EXIT");
            int book = s.nextInt();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            if (book == 1) {
                bookticket();
                break;
            } else if (book == 2) {
                System.out.println("THANK YOU (:)..!");
                System.out.println("-------------------------------------------------------------------------------");
                break;
            } else {
                System.out.println("UNABLE TO FETCH YOUR INPUT ENTER '1'");
                System.out.println("-------------------------------------------------------------------------------");
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------------------------------------------
    public static void bookticket() {
        Scanner s = new Scanner(System.in);
        System.out.println();
        // System.out.println("BOOK TICKETS");
        // System.out.println("***********");
        // System.out.println();
        System.out.print("ENTER YOUR EMAIL ID OR PHONE NUMBER : ");
        String ep = s.next().toLowerCase();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        int id1 = 0;
        String query = "select user_id from user where user_email='" + ep + "' or phone_number='" + ep + "'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next())
                id1 = rs.getInt(1);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("ENTER THE STADIUM ID : ");
        int gi = s.nextInt();
        System.out.println();
        System.out.print("ENTER THE MATCH ID : ");
        int mi = s.nextInt();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("                            SEAT'S AVAILABLE ");
        System.out.println("                           ******************");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        String query1 = "select * from seat where ground_id=" + gi + " AND match_id=" + mi + "";
        String q = "select * from ticketcost where ground_id=" + gi + " AND match_id=" + mi + "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "GROUND ID", "VIP SEAT", "FIRST CLASS SEAT",
                    "SECOND CLASS SEAT", "STANDARD SEAT");
            while (rs.next()) {
                System.out.printf("%-20d", rs.getInt(1));
                System.out.printf("%-20d", rs.getInt(2));
                System.out.printf("%-20d", rs.getInt(3));
                System.out.printf("%-20d", rs.getInt(4));
                System.out.printf("%-20d\n", rs.getInt(5));
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("                           COST OF THE SEATS");
            System.out.println("                           *****************");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println();
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(q);
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "GROUND ID", "VIP SEAT", "FIRST CLASS SEAT",
            "SECOND CLASS SEAT", "STANDARD SEAT");
            while (rs1.next()) {
                System.out.printf("%-20d", rs1.getInt(1));
                System.out.printf("%-20d", rs1.getInt(2));
                System.out.printf("%-20d", rs1.getInt(3));
                System.out.printf("%-20d", rs1.getInt(4));
                System.out.printf("%-20d\n", rs1.getInt(5));
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            // System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("1.VIP SEAT\n2.FIRST CLASS SEAT\n3.SECOND CLASS SEAT\n4.STANDARD SEAT\n5.EXIT");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.print("ENTER YOUR CHOICE : ");
            int choice = s.nextInt();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            
            System.out.println();
            if (choice == 1) {
                SEAT.vip(id1, gi, mi);
            } else if (choice == 2) {
                SEAT.fcseat(id1, gi, mi);
            } else if (choice == 3) {
                SEAT.scseat(id1, gi, mi);
            } else if (choice == 4) {
                SEAT.stseat(id1, gi, mi);
            } else if (choice == 5) {
                booking();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cancel() {
        
        
        System.out.println("TICKET CANCELLING");
        System.out.println("*****************");
        System.out.print("ENTER YOUR EMAIL ID : ");
        String email = s.next();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
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
            System.out.println("-------------------------------------------------------------------------------");
            System.out.printf("%-20s%-20s%-20s%-20s\n", "GROUND ID", "NO OF TICKETS", "TYPE OF SEAT", "TICKET_ID");
            while (rs1.next()) {
                System.out.printf("%-20d", rs1.getInt(1));
                System.out.printf("%-20d", rs1.getInt(2));
                System.out.printf("%-20s", rs1.getString(3));
                System.out.printf("%-20d\n", rs1.getInt(4));
            }
        if(!rs.next())
        {
            System.out.println("THERE IS NO BOOKING");
            return;
        }
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.print("ENTER THE TICKET ID : ");
            int k = s.nextInt();
            cancel.retrude(k);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void exit()
    {
        System.out.print("THANK YOU..(:)...!!");
    }
}
