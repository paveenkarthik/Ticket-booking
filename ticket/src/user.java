
public class user {
    private int user_id;
    private String user_name;
    private String user_email;
    private String phone_number;
    private String password;
 public user(){
    
 }
    public user(int user_id, String user_name, String user_email, String phone_number, String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.phone_number = phone_number;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    @Override
    public String toString() {
        return "user [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
                + ", phone_number=" + phone_number + "]";
    }

    
}
