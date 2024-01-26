import java.sql.ResultSet;

import java.sql.Statement;

public class admin extends App{
    public static void works(){
     System.out.println();
     System.out.println("ADMIN ACCESS");
     System.out.println();
     System.out.println("1.PRINT ENTIRE USER\n2.PRINT THE DETAIS BASED ON ID\n3.REMOVE THE USER BY ID\n4.EXIT");
     System.out.println();
     System.out.print("ENTER YOUR CHOICE : ");
     int a=s.nextInt();
     System.out.println();
    if(a==1){
        String query = "select * from user where whom ='user'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.printf("%-20s%-20s%-20s%-20s\n", "USER ID", "USER EMAIL", "USER NAME",
                    "PHONE NUMBER");
            while (rs.next()) {
                System.out.printf("%-20d", rs.getInt(1));
                System.out.printf("%-20s", rs.getString(2));
                System.out.printf("%-20s", rs.getString(3));
                System.out.printf("%-20S\n", rs.getString(4));
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    else if(a==2) {
        System.out.print("ENTER YOUR ID : ");
        int b=s.nextInt();
        String query = "select * from user where user_id="+b+"";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.printf("%-20s%-20s%-20s\n",  "USER EMAIL", "USER NAME",
                    "PHONE NUMBER");
            while (rs.next()) {
                System.out.printf("%-20s", rs.getString(1));
                System.out.printf("%-20s", rs.getString(2));
                System.out.printf("%-20S\n", rs.getString(3));
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }    
    else if(a==3){
        System.out.print("ENTER YOUR ID : ");
        int b=s.nextInt();
        String query = "delete from user where whom ="+b+"";
        try {
            Statement st = con.createStatement();
            int  rs = st.executeUpdate(query);
            if(rs!=0){
                System.out.println("USER WAS DELETED");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    else if(a==4){
        ground.welcomeadmin();
    }

    }
}
