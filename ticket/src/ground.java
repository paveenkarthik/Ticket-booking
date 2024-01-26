
import java.sql.*;
public class ground extends App {
    public static void welcomeadmin() {
        while (true) {
            System.out.println("WELCOMMING YOU TO THE CRICKET TICKET BOOKING");
            System.out.println("********************************************");
            System.out.println();
            System.out.println("1.TICKET BOOKING\n2.ADDING GROUND\n3.UPDATES ON GROUND\n4.CANCELLING TICKETS\n5.ADMIN WORKS\n6.EXIT");
            System.out.println();
            System.out.print("WHAT YOU WANT TO DO? ENTER YOUR CHOICE:= ");
            int choice = s.nextInt();
            if (choice == 2) {
                groundupdate();

            }else if(choice ==1){
                ticket.ticketbooking();
            } 
            else if (choice == 3) {
                groundaccess();
            } else if (choice == 4) {
                ticket.cancel();
            }
            else if(choice==5){
                admin.works();
            }
            else if(choice==6)
            break;
        }

    }

    public static void groundupdate() {
        System.out.println("ADDING A NEW GROUND DETAILS");
        System.out.println("***************************");
        System.out.println();
        System.out.print("GROUND NAME  : ");
        String g_name = s.next();
        System.out.println();
        System.out.print("GROUND PLACE : ");
        String g_place = s.next();
        System.out.println();
        System.out.print("GROUND TOTAL SEATING CAPACITY : ");
        int cap = s.nextInt();
        System.out.println();
        int id1=0;
         System.out.println("SPECIAL SEATS CAPACITES");
         System.out.println("***********************");
         System.out.println();
         System.out.print("NO OF VIP SEATS : ");
         int vip=s.nextInt();
         System.out.println();
         System.out.print("NO OF FIRST CLASS SEATS : ");
         int fc=s.nextInt();
         System.out.println();
         System.out.print("NO OF SECONG CLASS SEATS : ");
         int sc=s.nextInt();
         System.out.println();
         System.out.print("NO OF STANDARED SEATS : ");
         int st=s.nextInt();
         System.out.println("COST OF THE TICKET");
         System.out.println("******************");
         System.out.println();
         System.out.print("COST OF THE VIP SEAT : ");
         int cv=s.nextInt();
         System.out.println();
         System.out.print("COST OF THE FIRST CLASS SEAT : ");
         int cf=s.nextInt();
         System.out.println();
         System.out.print("COST OF THE SECOND CLASS SEAT : ");
         int cs=s.nextInt();
         System.out.println();
         System.out.print("COST OF THE STANDARD SEAT : ");
         int cst=s.nextInt();
         System.out.println();
        String query = "insert into ground(ground_name,ground_place,total_seat_cap) values(?,?,?)";
        String query2 = "insert into seat values(?,?,?,?,?)";
        String query4 = "insert into seatpanel values(?,?,?,?,?)";
        String query3="insert into ticketcost values(?,?,?,?,?)";
        String query5="insert into ticketcost1 values(?,?,?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(query);
            pre.setString(1, g_name);
            pre.setString(2, g_place);
            pre.setInt(3, cap);
            int r = pre.executeUpdate();
            if (r != 0) {
                String q = "select ground_id from ground where ground_name=?";
                    PreparedStatement pr = con.prepareStatement(q);
                    pr.setString(1, g_name);
                    ResultSet rs = pr.executeQuery();
                    if(rs.next()){
                        id1=rs.getInt(1);     
                    }
            }
            PreparedStatement pre2 = con.prepareStatement(query2);
            pre2.setInt(1,id1 );
            pre2.setInt(2, vip);
            pre2.setInt(3, fc);
            pre2.setInt(4, sc);
            pre2.setInt(5, st);
            int r2 = pre2.executeUpdate(); 
            PreparedStatement pre4 = con.prepareStatement(query4);
            pre4.setInt(1,id1 );
            pre4.setInt(2, vip);
            pre4.setInt(3, fc);
            pre4.setInt(4, sc);
            pre4.setInt(5, st);
            int r4 = pre4.executeUpdate(); 
            PreparedStatement pre1 = con.prepareStatement(query3);
            pre1.setInt(1,id1 );
            pre1.setInt(2,cv);
            pre1.setInt(3,cf);
            pre1.setInt(4,cs);
            pre1.setInt(5,cst);
            int r1 = pre1.executeUpdate(); 
            PreparedStatement pre5 = con.prepareStatement(query5);
            pre5.setInt(1,id1 );
            pre5.setInt(2,cv);
            pre5.setInt(3,cf);
            pre5.setInt(4,cs);
            pre5.setInt(5,cst);
            int r5 = pre5.executeUpdate(); 
            if(r!=0  && r2!=0 && r1!=0 && r4!=0 && r5!=0)
            {
                System.out.println("YOUR INFORMATION IS ADDED SUCCESSFULLY");
            }
          } 
            catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void groundaccess() {
      System.out.println("UPDATING THE GROUND");
      System.out.println("*******************");
      System.out.println();
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
      } catch (Exception e) {
          e.printStackTrace();
      }
      System.out.print("ENTER GROUND ID : ");
      int id=s.nextInt();
      System.out.println();
      System.out.println("1.ALTER GROUND NAME\n2.ALTER GROUND PLACE\n3.ALTER SEAT CAPACITY");
      System.out.println();
      System.out.print("ENTER THE CHOICE : ");
      int what=s.nextInt();
      if(what==1){
         groundalter.groundname(id);
      }
      else if(what==2)
      {
        groundalter.groundplace(id);
      }
      else if(what==3)
      {
        
      }

    }
}
