import java.util.*;


public class App extends DB {
    static Scanner s;
    public static void main(String[] args)  {
        s=new Scanner(System.in);
        while(true){
            userinterface hey=new userimp();

        
        System.out.println("WELCOME TO CRICKET TICKET BOOKING");
        System.out.println("*********************************");
        System.out.print("1.Login\n2.Signup\n3.Exit\n");
        int does=s.nextInt();
        if(does==1){
                System.out.println("LOGIN");
                System.out.println("*****");
                System.out.println("ENTER YOUR EMAIL ID OR MOBILE NUMBER");
                String num=s.next();
                System.out.println("ENTER YOUR PASSWORD");
                String pass=s.next();
              if( hey.Login(num, pass))
              break;
        }
        else if(does==2){
            System.out.println("SIGNUP");
            System.out.println("******");
              user use =new user();
                  System.out.println("ENTER YOUR NAME");
                  String name=s.next();
                  System.out.println("ENTER YOUR PHONE NUMBER");
                  String num=s.next();
                  if(num.length()!=10){
                    System.out.println("CONTACT NUMBER CONTAIN 10 NUMBERS");
                      System.out.println();
                      continue;
                  }
                  System.out.println("ENTER YOUR EMAIL ID");
                  String email=s.next();
                  System.out.println("ENTER YOUR PASSWORD");
                  String pass=s.next();
                  if(pass.length()!=8)
                  {
                      System.out.println("PASSWORD MIGHT CONTAIN 8 CHARACTER");
                      System.out.println();
                      continue;
                  }
                  use.setUser_name(name);
                  use.setPhone_number(num);
                  use.setUser_email(email);
                  use.setPassword(pass);
                  if(hey.Signup(use)){
                    break;
                  }
          }
            else if(does==3){
             System.out.println("THANK YOU (:)..!!");
                break;
            }
        }
    }
    }
