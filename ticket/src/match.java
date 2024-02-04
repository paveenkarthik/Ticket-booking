import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.sql.*;


public class match extends App {
    public static void matches() {
        while (true) {
            System.out.println("1.ADD MATCHES\n2.UPDATE MATCHES\n3.CANCEL MATCHES\n4.EXIT");
            System.out.println();
            System.out.print("ENTER YOUR CHOICE: ");
            int d = s.nextInt();
            if (d == 1) {
                AddMatch();
            } else if (d == 2) {
                UpdateMatch();
            } else if (d == 3) {
                CancelMatch();
            } else if (d == 4) {
                break;
            } else {
                System.out.println("ENTER CORRENT CHOICE");
                break;
            }
        }
    }

    public static void AddMatch() {
        System.out.println("ADD MATCHES TO THE GROUND");
        System.out.println();
        System.out.print("GROUND ID: ");
        int d = s.nextInt();
        System.out.print("MATCH NAME : ");
        String matchname = s.next();
        System.out.print("MATCH DATE(yyyy-mm-dd) : ");
        String input =s.next();
        System.out.println();
    
        String q="insert into matches(ground_id,match_name,date) values(?,?,?)";
        try {
            PreparedStatement p=con.prepareStatement(q);
            p.setInt(1,d );
            p.setString(2, matchname);
            
            try {
                
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                 Date pa=simpleDateFormat.parse(input);
                 java.sql.Date da=new java.sql.Date(pa.getTime());
                 p.setDate(3,da);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            
         int r2 = p.executeUpdate(); 
        if(r2==1)
        {
            String qq="select match_id from matches where match_name='"+matchname+"' AND date like '"+input+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(qq);
            int ma=0;
            while(rs.next())
            {
               ma=rs.getInt(1);
            }
            System.out.println("SUCCESSFULLY ADDED");
            ground.Addseatcost(d, ma);
        }
     } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
     }

    }

    public static void UpdateMatch() {

    }

    public static void CancelMatch() {

    }
}
