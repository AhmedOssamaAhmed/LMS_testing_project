package engine;

import java.util.ArrayList;

public class Admin extends User {
    String name;
    String Password;
    String number;
    String email;
    //ArrayList<String>currentcourses=new ArrayList<String>();

    public static ArrayList<Admin> admins;
    public static void initAdminArray(){
         if(admins==null) {
             Admin.admins = new ArrayList<Admin>();
             Admin.admins.add(new Admin("Kareem", "010", "0102555525248","kareem@gmail.com"));
         }

        //}

    }
    public Admin(String name,String Password,String number,String email){
        //this.currentcourses=currentcourses;
        this.name=name;
        this.number=number;
        this.Password=Password;
        this.email=email;
    }
}
