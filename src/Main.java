import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {

    private static Database database;
    private static Scanner scanner;
    public static void main(String[] args) {

        database = new Database();
        scanner = new Scanner(System.in);
        System.out.println("1. Sign in");
        System.out.println("2. Sign up");
        int i = scanner.nextInt();
        switch (i){
            case 1:
                signIn();
                break;
            case 2:
                signUp();
                break;
            default:
                System.out.println("Invalid number");
                break;
        }

    }
    private static void signIn(){
        System.out.println("Enter your email or login:");
        String emailOrLogin = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();

        if (UserDatabase.login(emailOrLogin,password,database)){
            User user = UserDatabase.getUser(emailOrLogin, database);
            user.showList();
        } else {
            System.out.println("Incorrect values");
        }




    }

    private static void signUp(){

        System.out.println("Enter your email:");
        String email = scanner.next();

        while (UserDatabase.emailIsUsed(email,database)){
            System.out.println("This email is used");
            System.out.println("Enter your emial:");
            email = scanner.next();
        }

        System.out.println("Enter your login:");
        String login = scanner.next();
        System.out.println("Enter your firstName:");
        String firstName = scanner.next();
        System.out.println("Enter your lastName:");
        String lastName = scanner.next();
        System.out.println("Enter your phoneNumber:");
        String phoneNumber = scanner.next();

        System.out.println("Enter your password:");
        String password = scanner.next();
        System.out.println("Confirm your password:");
        String password2 = scanner.next();

        while (!password.equals(password2)){
            System.out.println("Passwords do not match. Try again");
            System.out.println("Enter your password:");
            password = scanner.next();
            System.out.println("Confirm your password:");
            password2 = scanner.next();
        }

        Visitor visitor = new Visitor();
        visitor.setID(UserDatabase.getNextID(database));
        visitor.setFirstName(firstName);
        visitor.setLastName(lastName);
        visitor.setPhoneNumber(phoneNumber);
        visitor.setEmail(email);
        visitor.setLogin(login);
        visitor.setPassword(password);
        UserDatabase.addVisitor(visitor,database);

        signIn();



    }
/*
    private static boolean checkPasswords(){
        System.out.println("Enter your password:");
        String password = scanner.next();
        System.out.println("Confirm your password:");
        String password2 = scanner.next();

        if (password.equals(password2)){return true;}
        return false;
    }

 */
}