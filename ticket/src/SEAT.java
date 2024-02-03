import java.sql.*;
import java.util.*;

public class SEAT extends App {
    public static void vip(int ui, int gi) {
        while (true) {
            System.out.println("NUMBER OF SEATS YOU NEEDED");
            int seat = s.nextInt();
            String query = "update seat set vip=vip-" + seat + " where ground_id=" + gi + "";
            String query1 = "update ground set total_seat_cap=total_seat_cap-" + seat + " where ground_id=" + gi + "";
            String q = "insert into ticket(user_id,ground_id,no_of_ticket,seat,amount) values(?,?,?,?,?)";
            String q1 = "select c_vip from ticketcost where  ground_id=" + gi + "";
            String q2 = "select vip from seatpanel where  ground_id=" + gi + "";
            String q3 = "select vip from seat where  ground_id=" + gi + "";
            int cost = 0;
            int ps = 0;
            int ts = 0;
            int total = 0;
            int tic=0;
            try {
                Statement st = con.createStatement();
                int d = st.executeUpdate(query);

                Statement s1 = con.createStatement();
                int d1 = s1.executeUpdate(query1);

                Statement s2 = con.createStatement();
                ResultSet dc = s2.executeQuery(q1);
                if (dc.next())
                    cost = dc.getInt(1);

                Statement s3 = con.createStatement();
                ResultSet dps = s3.executeQuery(q2);
                if (dps.next())
                    ps = dps.getInt(1);

                Statement s4 = con.createStatement();
                ResultSet dts = s4.executeQuery(q3);
                if (dts.next())
                    ts = dts.getInt(1);

                PreparedStatement pr = con.prepareStatement(q);
                pr.setInt(1, ui);
                pr.setInt(2, gi);
                pr.setInt(3, seat);
                pr.setString(4, "vip");
                pr.setInt(5, cost);
                int d2 = pr.executeUpdate();

                String ticket1 = "select ticket_id from ticket where user_id=" + ui + " and ground_id=" + gi + "";
                Statement t = con.createStatement();
                ResultSet dc1 = t.executeQuery(ticket1);
                if (dc1.next())
                    tic= dc1.getInt(1);


                if ((ps / 1.3) > ts) {
                    cost *= 1.5;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();

                } else if ((ps / 2) > ts) {
                    cost *= 2;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else if ((ps / 4) > ts) {
                    cost *= 2.5;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else if ((ps / 8) > ts) {
                    cost *= 3;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else {
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                }

                String qu = "update ticket set amount=" + cost + " where ticket_id=" + tic + "";
                Statement sty = con.createStatement();
                int d7 = sty.executeUpdate(qu);

                System.out.println("1.PAY\n2.EXIT");
                int what = s.nextInt();
                if (what == 1 && d != 0 && d1 != 0 && d7 != 0 && d2 != 0) {
                    System.out.println("YOUR TICKET BOOKED SUCCESSFULLY.....!!");
                    ticket.book();
                    break;
                } else if (what == 2)
                    break;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------
    public static void fcseat(int ui, int gi) {
        while (true) {
            System.out.println("NUMBER OF SEATS YOU NEEDED");
            int seat = s.nextInt();
            int cost = 0;
            int ps = 0;
            int ts = 0;
            int tic=0;
            String query = "update seat set firstclass=firstclass-" + seat + " where ground_id=" + gi + "";
            String query1 = "update ground set total_seat_cap=total_seat_cap-" + seat + " where ground_id=" + gi + "";
            String q1 = "select c_fc from ticketcost where  ground_id=" + gi + "";
            String q2 = "select firstclass from seatpanel where  ground_id=" + gi + "";
            String q3 = "select firstclass from seat where  ground_id=" + gi + "";
            String q = "insert into ticket(user_id,ground_id,no_of_ticket,seat,amount) values(?,?,?,?,?)";
            int total = 0;
            try {
                Statement st = con.createStatement();
                int d = st.executeUpdate(query);

                Statement s1 = con.createStatement();
                int d1 = s1.executeUpdate(query1);

                Statement s2 = con.createStatement();
                ResultSet dc = s2.executeQuery(q1);
                if (dc.next())
                    cost = dc.getInt(1);

                Statement s3 = con.createStatement();
                ResultSet dps = s3.executeQuery(q2);
                if (dps.next())
                    ps = dps.getInt(1);

                Statement s4 = con.createStatement();
                ResultSet dts = s4.executeQuery(q3);
                if (dts.next())
                    ts = dts.getInt(1);

                PreparedStatement pr = con.prepareStatement(q);
                pr.setInt(1, ui);
                pr.setInt(2, gi);
                pr.setInt(3, seat);
                pr.setString(4, "firstclass");
                pr.setInt(5, cost);
                int d2 = pr.executeUpdate();

                String ticket1 = "select ticket_id from ticket where user_id=" + ui + " and ground_id=" + gi + "";
                Statement t = con.createStatement();
                ResultSet dc1 = t.executeQuery(ticket1);
                if (dc1.next())
                    tic = dc1.getInt(1);

                if ((ps / 1.3) > ts) {
                    cost *= 1.5;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();

                } else if ((ps / 2) > ts) {
                    cost *= 2;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else if ((ps / 4) > ts) {
                    cost *= 2.5;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else if ((ps / 8) > ts) {
                    cost *= 3;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else {
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                }

                String qu = "update ticket set amount=" + cost + " where ticket_id=" + tic + "";
                Statement sty = con.createStatement();
                int d7 = sty.executeUpdate(qu);

                System.out.println("1.PAY\n2.EXIT");
                int what = s.nextInt();
                if (what == 1 && d != 0 && d1 != 0 && d2 != 0) {
                    System.out.println("YOUR TICKET BOOKED SUCCESSFULLY.....!!");
                    ticket.book();
                    break;
                } else if (what == 2)
                    break;

                String que = "update ticketcost1 set c_vip=" + cost + " where ground_id=" + gi + "";
                Statement stch = con.createStatement();
                stch.executeUpdate(que);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void scseat(int ui, int gi) {
        while (true) {
            System.out.println("NUMBER OF SEATS YOU NEEDED");
            int seat = s.nextInt();
            String query = "update seat set secondclass=secondclass-" + seat + " where ground_id=" + gi + "";
            String query1 = "update ground set total_seat_cap=total_seat_cap-" + seat + " where ground_id=" + gi + "";
            String q = "insert into ticket(user_id,ground_id,no_of_ticket,seat,amount) values(?,?,?,?,?)";
            String q1 = "select c_sc from ticketcost where  ground_id=" + gi + "";
            String q2 = "select secondclass from seatpanel where  ground_id=" + gi + "";
            String q3 = "select secondclass from seat where  ground_id=" + gi + "";
            int cost = 0;
            int ps = 0;
            int ts = 0;
            int total = 0;
            int tic=0;
            try {
                Statement st = con.createStatement();
                int d = st.executeUpdate(query);

                Statement s1 = con.createStatement();
                int d1 = s1.executeUpdate(query1);

                Statement s2 = con.createStatement();
                ResultSet dc = s2.executeQuery(q1);
                if (dc.next())
                    cost = dc.getInt(1);

                Statement s3 = con.createStatement();
                ResultSet dps = s3.executeQuery(q2);
                if (dps.next())
                    ps = dps.getInt(1);

                Statement s4 = con.createStatement();
                ResultSet dts = s4.executeQuery(q3);
                if (dts.next())
                    ts = dts.getInt(1);

                PreparedStatement pr = con.prepareStatement(q);
                pr.setInt(1, ui);
                pr.setInt(2, gi);
                pr.setInt(3, seat);
                pr.setString(4, "secondclass");
                pr.setInt(5, cost);
                int d2 = pr.executeUpdate();

                String ticket1 = "select ticket_id from ticket where user_id=" + ui + " and ground_id=" + gi + "";
                Statement t = con.createStatement();
                ResultSet dc1 = t.executeQuery(ticket1);
                if (dc1.next())
                    tic = dc1.getInt(1);

                if ((ps / 1.3) > ts) {
                    cost *= 1.5;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();

                } else if ((ps / 2) > ts) {
                    cost *= 2;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else if ((ps / 4) > ts) {
                    cost *= 2.5;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else if ((ps / 8) > ts) {
                    cost *= 3;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else {
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                }
                System.out.println("1.PAY\n2.EXIT");
                int what = s.nextInt();

                String qu = "update ticket set amount=" + cost + " where ticket_id=" + tic + "";
                Statement sty = con.createStatement();
                int d7 = sty.executeUpdate(qu);

                if (what == 1 && d != 0 && d1 != 0 && d2 != 0) {
                    System.out.println("YOUR TICKET BOOKED SUCCESSFULLY.....!!");
                    ticket.book();
                    break;
                } else if (what == 2)
                    break;

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void stseat(int ui, int gi) {
        while (true) {
            System.out.println("NUMBER OF SEATS YOU NEEDED");
            int seat = s.nextInt();
            String query = "update seat set standard=standard-" + seat + " where ground_id=" + gi + "";
            String query1 = "update ground set total_seat_cap=total_seat_cap-" + seat + " where ground_id=" + gi + "";
            String q = "insert into ticket(user_id,ground_id,no_of_ticket,seat,amount) values(?,?,?,?,?)";
            String q1 = "select c_st from ticketcost where  ground_id=" + gi + "";
            String q2 = "select standard from seatpanel where  ground_id=" + gi + "";
            String q3 = "select standard from seat where  ground_id=" + gi + "";
            int cost = 0;
            int ps = 0;
            int ts = 0;
            int total = 0;
            int tic=0;
            try {
                Statement st = con.createStatement();
                int d = st.executeUpdate(query);

                Statement s1 = con.createStatement();
                int d1 = s1.executeUpdate(query1);

                Statement s2 = con.createStatement();
                ResultSet dc = s2.executeQuery(q1);
                if (dc.next())
                    cost = dc.getInt(1);

                Statement s3 = con.createStatement();
                ResultSet dps = s3.executeQuery(q2);
                if (dps.next())
                    ps = dps.getInt(1);

                Statement s4 = con.createStatement();
                ResultSet dts = s4.executeQuery(q3);
                if (dts.next())
                    ts = dts.getInt(1);

                PreparedStatement pr = con.prepareStatement(q);
                pr.setInt(1, ui);
                pr.setInt(2, gi);
                pr.setInt(3, seat);
                pr.setString(4, "standard");
                pr.setInt(5, cost);
                int d2 = pr.executeUpdate();

                String ticket1 = "select ticket_id from ticket where user_id=" + ui + " and ground_id=" + gi + "";
                Statement t = con.createStatement();
                ResultSet dc1 = t.executeQuery(ticket1);
                if (dc1.next())
                    tic = dc1.getInt(1);

                if ((ps / 1.3) > ts) {
                    cost *= 1.5;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();

                } else if ((ps / 2) > ts) {
                    cost *= 2;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else if ((ps / 4) > ts) {
                    cost *= 2.5;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else if ((ps / 8) > ts) {
                    cost *= 3;
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                } else {
                    total = cost * seat;
                    System.out.println("COST: " + total);
                    System.out.println();
                }
                String qu = "update ticket set amount=" + cost + " where ticket_id=" + tic + "";
                Statement sty = con.createStatement();
                int d7 = sty.executeUpdate(qu);

                System.out.println("1.PAY\n2.EXIT");
                int what = s.nextInt();
                if (what == 1 && d != 0 && d1 != 0 && d2 != 0) {
                    System.out.println("YOUR TICKET BOOKED SUCCESSFULLY.....!!");
                    ticket.book();
                    break;
                } else if (what == 2)
                    break;
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}
