import java.sql.*;

public class cancel extends App {
    public static void retrude(int id) {
        String seat = "";
        int gid = 0;
        int tick = 0;
        int amount = 0;
        String query = "select seat,ground_id,no_of_ticket,amount from ticket where ticket_id =" + id + "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                seat = rs.getString(1);
                gid = rs.getInt(2);
                tick = rs.getInt(3);
                amount = rs.getInt(4);
            }
            String q2=""; 
            if(seat.equals("vip"))
             q2 = "update seat set vip=vip+"+tick+" where ground_id="+gid+";";
             else if(seat.equals("firstclass"))
             q2 = "update seat set firstclass=firstclass"+tick+" where ground_id="+gid+";";
             else if(seat.equals("secondclass"))
             q2 = "update seat set secondclass=secondclass"+tick+" where ground_id="+gid+";";
             else if(seat.equals("standard"))
             q2 = "update seat set standard=standard"+tick+" where ground_id="+gid+";";
             
             String q3="update ground set total_seat_cap=total_seat_cap+"+tick+" where ground_id="+gid+";";
            Statement st1 = con.createStatement();
            int d = st1.executeUpdate(q2);
            
            System.out.println();
            System.out.println("YOUR AMOUNT ("+amount+") WILL BE CREDITED IN 10 MINITES");
            System.out.println();
            System.out.println("IF YOU RECEIVED THE AMOUNT ENTER .1");
            int a=s.nextInt();
            if(a==1)
            {
                String q="delete from ticket where ticket_id="+id+"";
                Statement stq = con.createStatement();
                int d1 = stq.executeUpdate(q);
                if(d1!=0)
                {
                    System.out.println("YOUR TICKETS ARE CANCELLED");
                    ticket.book();
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}