import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.DocFlavor.READER;

import java.sql.*;

public class match extends App {
    
    public static void matches() {
        String query10 = "select * from ground";
        try {
            Statement st10 = con.createStatement();
            ResultSet rs10 = st10.executeQuery(query10);
            System.out.printf("%-20s%-20s%-20s%-20s\n",  "STADIUM ID","STADIUM NAME", "STADIUM LOCATION",
                    "SEAT ALLOCATION");
            while (rs10.next()) {
                System.out.printf("%-20s", rs10.getInt(1));
                System.out.printf("%-20s", rs10.getString(2));
                System.out.printf("%-20s", rs10.getString(3));
                System.out.printf("%-20d\n", rs10.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        while (true) {
            System.out.println("1.ADD MATCHES\n2.UPDATE MATCHES\n3.CANCEL MATCHES\n4.EXIT");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            System.out.print("ENTER YOUR CHOICE: ");
            int d = s.nextInt();
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------");
            if (d == 1) {
                AddMatch();
            } else if (d == 2) {
                UpdateMatch();
            } else if (d == 3) {
                CancelMatch();
            } else if (d == 4) {
                break;
            } else {
                System.out.println("ENTER CORRECT CHOICE");
                break;
            }
        }
    }

    public static void AddMatch() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                                ADD MATCHES TO THE GROUND                     |");
        System.out.println("|                                *************************                     |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("GROUND ID: ");
        int d = s.nextInt();
        System.out.print("MATCH NAME : ");
        String matchname = s.next();
        System.out.print("MATCH DATE(yyyy-mm-dd) : ");
        String input = s.next();
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");

        String q = "insert into matches(ground_id,match_name,date) values(?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(q);
            p.setInt(1, d);
            p.setString(2, matchname);

            try {

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date pa = simpleDateFormat.parse(input);
                java.sql.Date da = new java.sql.Date(pa.getTime());
                p.setDate(3, da);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }

            int r2 = p.executeUpdate();
            if (r2 == 1) {
                String qq = "select match_id from matches where match_name='" + matchname + "' AND date like '" + input
                        + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(qq);
                int ma = 0;
                if (rs.next()) {
                    ma = rs.getInt(1);
                    System.out.println("SUCCESSFULLY ADDED");
                    ground.Addseatcost(d, ma);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void UpdateMatch() {
        String query = "select * from matches";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.printf("%-20s%-20s%-20s%-20s\n", "MATCH ID", "STADIUM ID", "MATCHES",
                    "DATE OF THE MATCH");
            while (rs.next()) {
                System.out.printf("%-20d", rs.getInt(1));
                System.out.printf("%-20d", rs.getInt(2));
                System.out.printf("%-20s", rs.getString(3));
                String h = "";
                h += rs.getDate(4);
                System.out.printf("%-20s\n", h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("1.CHANGES IN MATCH\n2.CHANGES IN DATE\n3.CHANGE MATCH PLACE \n4.EXIT");
            System.out.print("ENTER YOUR CHOICE : ");
            int a = s.nextInt();
            System.out.println();
            System.out.print("ENTER THE MATCH ID : ");
            int id = s.nextInt();
            if (a == 1) {
                ChangeMatch(id);
            } else if (a == 2) {
                ChangeMatchDate(id);
            } else if (a == 3) {
                ChangeMatchPlace(id);
            } else if (a == 4) {
                matches();
            } else {
                System.out.println("ENTER THE CORRENSPONDING VALUE ");
                break;
            }
        }

    }

    public static void CancelMatch() {
        System.out.println("                             CANCEL MATCH");
        System.out.println("                             ************");
        System.out.println("-------------------------------------------------------------------------------");

        String query = "select * from matches";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.printf("%-20s%-20s%-20s%-20s\n", "MATCH ID", "STADIUM ID", "MATCHES",
                    "DATE OF THE MATCH");
            while (rs.next()) {
                System.out.printf("%-20d", rs.getInt(1));
                System.out.printf("%-20d", rs.getInt(2));
                System.out.printf("%-20s", rs.getString(3));
                String h = "";
                h += rs.getDate(4);
                System.out.printf("%-20s\n", h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.print("ENTER THE MATCH ID ");
        int id = s.nextInt();
        System.out.println();
        System.out.println("1.CONFIRM CANCELLING\n2.EXIT");
        System.out.print("ENTER YOUR CHOICE : ");
        int a = s.nextInt();
        if (a == 1) {
                 String q="delete from mathes where match_id="+id+"";
                 try {
                     Statement st = con.createStatement();
                     ResultSet rs = st.executeQuery(q);
                    if(!rs.next()){
                        System.out.println("MATCH WAS DELETED SUCCESSFULLY");
                        System.out.println("-------------------------------------------------------------------------------");

                    }
                 } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                 }

        } else if (a == 2) {
            return;
        } else {
            System.out.println("ENTER VALID NUMBER");
            return;
        }
    }

    public static void ChangeMatch(int id) {
        System.out.println("                         CHANGES IN THE MATCH");
        System.out.println("                         ********************");
        System.out.println("-------------------------------------------------------------------------------");

        System.out.println("ENTER CHANGED MATCH NAME like(csk-vs-mi)");
        String changedmatch = s.next();
        System.out.println();
        String q = "update matches set match_name ='" + changedmatch + "' where match_id=" + id + "";
        try {
            Statement st1 = con.createStatement();
            int d = st1.executeUpdate(q);
            if (d == 1)
                System.out.println("MATCH WAS CHANGED SUCCESSFULLY");
            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void ChangeMatchDate(int id) {
        System.out.println("                          CHANGE MATCH DATE");
        System.out.println("                          *****************");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("ENTER THE CHANGED DATE (yyyy-mm-dd) : ");
        String date = s.next();
        String q = "update matches set date=? where match_id=" + id + " ";
        try {
            PreparedStatement p = con.prepareStatement(q);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date pa = simpleDateFormat.parse(date);
            java.sql.Date da = new java.sql.Date(pa.getTime());
            p.setDate(1, da);
            int rs = p.executeUpdate();
            if (rs == 1) {
                System.out.println("CHANGES ARE DONE");
                System.out.println("-------------------------------------------------------------------------------");

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void ChangeMatchPlace(int id) {
        System.out.println("                          CHANGE MATCH PLACE");
        System.out.println("                          ******************");
        System.out.println("-------------------------------------------------------------------------------");
        String query10 = "select * from ground";
        try {
            Statement st10 = con.createStatement();
            ResultSet rs10 = st10.executeQuery(query10);
            System.out.printf("%-20s%-20s%-20s%-20s\n", "STADIUM ID", "STADIUM NAME", "STADIUM LOCATION");
            while (rs10.next()) {
                System.out.printf("%-20d", rs10.getInt(1));
                System.out.printf("%-20s", rs10.getString(2));
                System.out.printf("%-20s\n", rs10.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.print("ENTER THE CHANGED STADIUM ID : ");
        int m = s.nextInt();
        String q = "update matches set ground_id =" + m + " where match_id=" + id + "";
        try {
            Statement st1 = con.createStatement();
            int d = st1.executeUpdate(q);
            if (d == 1)
                System.out.println("MATCH STADIUM IS CHANGED SUCCESSFULLY");
            System.out.println("-------------------------------------------------------------------------------");

            System.out.println();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
