package Basic.Task2.Password_Generator;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


//Encripted class
class encriptedPassword{

    //salt generated
    public static String generateSalt(){
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    //Hashed password generated
    public static String generateHashedPassword(String password, String salt){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest((password + salt).getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Fatched error in hashing password.");
        }
    }
}



// main class
public class PasswordGenerator {

    // Method for Generated only password
    public static String generatePassword(){

        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        String spacial = "!@#$%^&*()_+";
        String password = "";
        int length = 8;

        for (int i = 0; i < length; i++) {
            String all = character + number + spacial;
            int index = (int) (Math.random() * all.length());
            password += all.charAt(index);
            }
            System.out.println("\nYour password is : "+ password);
            return password;
    }


    // check password is strong or not
    public static void isStrongPassword(String password){

        int count = 0;

        if(password.length() >= 8) {
            count++;
            }

        if(password.matches(".*[a-z].*")) {
            count++;
            }

        if(password.matches(".*[A-Z].*")) {
            count++;
            }

        if(password.matches(".*[0-9].*")) {
            count++;
            }

        if(password.matches(".*[@,#,$,%].*")) {
            count++;
            }

        if(count == 4) {
            System.out.println("Password is strong");
            // return true;
            }

        else {
            System.out.println("Password is poor");
            // return false;
            }

        }


    //User section in main method
    public static void main(String[] args) {

        //rules
        System.out.println("The rules is :-  ");
        System.out.println("1. Password's length should be 8 ");
        System.out.println("2. Password must be strong [number , char, symbol]");
        System.out.println("3. Password must be unique");
        
        //declear scanner
        Scanner sc = new Scanner(System.in);
        
        // Variable for entered user's choice
        int choice;

        //Menipulated loop for users
        while (true) {

            //Choice section
            System.out.println("\n\nEnter your choice : ");
            System.out.println("1. Generate Password");
            System.out.println("2. Check password is strong or not.");
            System.out.println("3. Encripted password.");
            System.out.println("4. Exit");

            //input for choice
            System.out.print("Select your choice : ");
            choice = sc.nextInt();

            // switch case for calling all methods
            switch (choice) {

                //calling for create password
                case 1:
                generatePassword();
                break;

                // for check password strong or not
                case 2:
                System.out.print("\nEnter the password : ");
                String password = sc.next();
                isStrongPassword(password);
                break;
                
                //for encripted the password
                case 3:
                System.out.print("\nEnter the password : ");
                String passwordToEncripted = sc.next();
                String salt = encriptedPassword.generateSalt();
                String EncriptedPassword = encriptedPassword.generateHashedPassword(passwordToEncripted, salt);
                System.out.println("The encripted password is : "+EncriptedPassword);
                break;

                //for exit from the program
                case 4:
                System.out.println("\nThank you sir/ma'am for your valueable time...:)\nProgramm Ended...!!");
                break;
            }    

        }
    }
}
