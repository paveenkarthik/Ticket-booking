
import java.sql.*;
public class userimp implements userinterface{
  Connection con;
    @Override
    public boolean Login(String phone_number, String email) {
        // TODO Auto-generated method stub
       con=DB.database();
       String whom="";
       String query="select * from user where (user_email=? or phone_number=?) and Password=? ";
       try {
           PreparedStatement pre=con.prepareStatement(query);
           pre.setString(1, phone_number);
           pre.setString(2, phone_number);
           pre.setString(3, email);
           ResultSet rs=pre.executeQuery();
           if(rs.next())
           {
               System.out.println("welcome to the ticket booking\n YOU WAS LOGINED IN");
               String query1="select whom from user where user_email=? ";
               PreparedStatement pre1=con.prepareStatement(query1);
               pre1.setString(1, phone_number);
               ResultSet rs2=pre1.executeQuery();
               if(rs2.next()){
                   whom=rs2.getString(1);
                   System.out.println(whom);
                }
                if(!whom.equals("user")){
                    ground.welcomeadmin();
                }
                else
                ticket.book();
            }
            else
            {
                System.out.println("SOMETHING WRONG ON YOUR LOGIN");
                System.out.println("REENTER THE INPUT CORRECTLY");
                return false;
            }
          
       } catch (Exception e) {
           // TODO: handle exception
        e.printStackTrace();
       }
       return true;
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean Signup(user use) {
        // TODO Auto-generated method stub
        con=DB.database();
        String query="insert into user(user_name,user_email,phone_number,whom,Password) values(?,?,?,?,?); ";
        try {
            PreparedStatement pre=con.prepareStatement(query);
            pre.setString(1, use.getUser_name());
            pre.setString(2, use.getUser_email());
            pre.setString(3, use.getPhone_number());
            pre.setString(4, "user");
            pre.setString(5, use.getPassword());
            int c=pre.executeUpdate();
           if(c!=0){
               System.out.println("welcome to the ticket booking");
               return false;
           }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
       return true;
    }
    
}
