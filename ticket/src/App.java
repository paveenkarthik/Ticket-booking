import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class App extends DB {
    static Scanner s;
    public static void main(String[] args) throws IOException  {
        s=new Scanner(System.in);
        while(true){
            userinterface hey=new userimp();
            System.out.println("WELCOME TO CRICKET TICKET BOOKING");
            System.out.println("*********************************");
            System.out.print("1.Login\n2.Signup\n3.Exit\n");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.print("ENTER YOUR CHOICE: ");
          //   int does=0;
          // try {
              int does=s.nextInt();
            //  int  does=s.hasNextInt() ? s.nextInt() : -1;
            // } catch (Exception e) {
            //   // TODO: handle exception
            //   System.out.println("YOUR INPUT WAS MISMATCH");
            //   System.out.println("RERUN UR PROCESS");
            //   break;
            // }
            System.out.println("-------------------------------------------------------------------------------");
            
            if(does==1){
              System.out.println("                                 LOGIN");
              System.out.println("                                 *****");
              System.out.print("ENTER YOUR EMAIL ID OR MOBILE NUMBER: ");
              String num=s.next().toLowerCase();
              System.out.println();
              System.out.print("ENTER YOUR PASSWORD: ");
              String pass=s.next();
              System.out.println("-------------------------------------------------------------------------------");
              if( hey.Login(num, pass))
              break;
            }
            else if(does==2){
              System.out.println("                              SIGNUP");
              System.out.println("                              ******");
              System.out.println("-------------------------------------------------------------------------------");
                  user use =new user();
                  System.out.println();
                      System.out.print("ENTER YOUR NAME =>");
                      String name=s.next().toLowerCase();
                      System.out.println();
                      System.out.print("ENTER YOUR PHONE NUMBER =>");
                      String num=s.next();
                      System.out.println();
                      while(num.length()!=10){
                        System.out.println("CONTACT NUMBER CONTAIN 10 NUMBERS");
                        System.out.println();
                        System.out.print("ENTER YOUR PHONE NUMBER =>");
                        num=s.next();
                          System.out.println();
                      }
                      System.out.print("ENTER YOUR EMAIL ID =>");
                      String email=s.next().toLowerCase();
                      boolean f= email.contains("gmail.com");
                      while(!f)
                      {
                        System.out.print("ENTER VALID EMAIL ID : ");
                        email=s.next().toLowerCase();
                        System.out.println();
                      }
                      System.out.println();
                      System.out.print("ENTER YOUR PASSWORD =>");
                      String pass=s.next();
                      System.out.println();
                      while(pass.length()<8)
                      {
                        System.out.println("PASSWORD MIGHT CONTAIN 8 CHARACTER");
                        System.out.println();
                        System.out.print("REENTER YOUR PASSWORD =>");
                        pass=s.next();
                        
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
                 System.out.println("-------------------------------------------------------------------------------");
                 System.out.println("-------------------------------------------------------------------------------");
                    break; 
                }
                else{
                  System.out.println("ENTER CORRESPONDING VALUE");
                  break;
                }
        }
    }
    }
