
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
               System.out.println("                   YOU ACCOUNT WAS LOGINED IN ");
               System.out.println("                 ******************************");
               System.out.println("-------------------------------------------------------------------------------");
               String query1="select whom from user where user_email='"+phone_number+"' OR phone_number='"+phone_number+"' ";
               Statement st = con.createStatement();
               ResultSet rs2 = st.executeQuery(query1);
               if(rs2.next()){
                   whom=rs2.getString(1);
                }
                if(!whom.equals("user")){
                    System.out.println("WELCOME ADMIN");
                    ground.welcomeadmin();
                }
                else if(whom.equals("user")){
                System.out.println("WELCOME USER");
                ticket.book();}
                else
                {
                    System.out.print("SOMETHING WRONG WITH YOUR LOGIN");
                }
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
               System.out.println("CONTINUE YOUR LOGIN");
               System.out.println("-------------------------------------------------------------------------------");


               return false;
           }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
       return true;
    }
    
}
