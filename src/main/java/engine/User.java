package engine;

import java.util.ArrayList;
import java.util.regex.*;
public class User {
    public static int ID = 0;

    public static User Login(String name, String Password) {
        Student.initStudentArray();
        Admin.initAdminArray();
        Doctor.initDoctorArray();
        TA.initDoctorArray();

        for (int i = 0; i < Student.students.size(); i++) {
            if (Student.students.get(i).name.equals(name) && Student.students.get(i).Password.equals(Password)) {
                String user = "Student";
                return Student.students.get(i);
            }
        }
        for (int i = 0; i < Admin.admins.size(); i++) {
            if (Admin.admins.get(i).name.equals(name) && Admin.admins.get(i).Password.equals(Password)) {
                String user = "Admin";
                return Admin.admins.get(i);
            }
        }
        for (int i = 0; i < Doctor.Doctors.size(); i++) {
            if (Doctor.Doctors.get(i).Name.equals(name) && Doctor.Doctors.get(i).Password.equals(Password)) {
                String user = "Doctor";
                return Doctor.Doctors.get(i);
            }
        }
        for (int i = 0; i < TA.TAS.size(); i++) {
            if (TA.TAS.get(i).Name.equals(name)&&TA.TAS.get(i).Password.equals(Password)) {
                String user = "TA";
                return TA.TAS.get(i);
            }
        }
        return null;
    }


    public static String Registerstudent(String name,String Password,String Phonenumber, String email){
        ArrayList<String> course=new ArrayList<String>();
        //NewName
        char[] chars = name.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return "Invalid Name";
            }
        }
        //NewName

        //NewEmail
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==false){
            return "Invalid Email";
        }
        //NewEmail

        //New PhoneNumber
        char[] charss = Phonenumber.toCharArray();
        for(char k : charss){
            if(Character.isLetter(k)){
                return "Invalid Phone Number";
            }
        }
        //New PhoneNumber
        Student.students.add(new Student(name, Password, "0", String.valueOf(ID),email, Phonenumber, true,course));
        ID ++;
        return "Student Added Successfully";
    }

    //Different Returns for better testing
    public static String Register(String type,String name,String Password,String email,String Phonenumber){
        ArrayList<String> course=new ArrayList<String>();
        //NewName
        char[] chars = name.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return "Invalid Name";
            }
        }
        //NewName

        //NewEmail
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()==false){
            return "Invalid Email";
        }
        //NewEmail

        //New PhoneNumber
        char[] charss = Phonenumber.toCharArray();
        for(char k : charss){
            if(Character.isLetter(k)){
                return "Invalid Phone Number";
            }
        }
        if(type.equals("Doctor")){
            Doctor.Doctors.add(new Doctor(name,Password,email,Phonenumber,course));
            return "Doctor Added Successfully";
        } else if (type.equals("TA")) {
            TA.TAS.add(new TA(name,Password,email,Phonenumber,course));
            return "TA Added Successfully";
        }
        return "Invalid Type";
    }

    public boolean isAdmin(){
        return this instanceof Admin;
    }

    public boolean isStudent(){
        return this instanceof Student;
    }

    public boolean isDoctor(){
        return this instanceof Doctor;
    }

    public boolean isTA(){
        return this instanceof TA;
    }
}
