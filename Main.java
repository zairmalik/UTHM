import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    private static PrintStream o = System.out;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        Account uzair = new Account("Uzair bin Nor Jasmin","AA161162","123456","Pagoh",0.00,"Undergraduate");
        String _matricNumber;
        String _password;
        boolean isPasswordCorrect;
        int mainMenuChoice;

        o.println("\nWelcome to UTHM Library System.\n");

        do{
            o.println("Enter your matric card number.");
            o.print(">> ");
            _matricNumber = scan.nextLine();
            o.println("Enter your password.");
            o.print(">> ");
            _password = scan.nextLine();

            if(_matricNumber.matches(uzair.getMatricNumber()) && _password.matches(uzair.getAccountPassword())){
                o.println("Login success!\n");
                isPasswordCorrect = true;
            }
            else{
                o.println("Please try again.\n");
                isPasswordCorrect = false;
            }
        }while(!isPasswordCorrect);

        try{
            File personsFile = new File("C:\\Users\\user\\IdeaProjects\\UTHM\\uzair.txt");
            Scanner scan = new Scanner(personsFile);

            while(scan.hasNextLine()){
                o.println(scan.nextLine());
            }

            scan.close();
        }catch(FileNotFoundException fnfe){
            o.println("File not found!");
        }

        o.println();

        o.println("Main Menu");
        o.println("1 - Search books");
        o.println("2 - Borrow books");
        o.println("3 - Return books");
        o.println("4 - Pay fines");
        o.print(">> ");
        mainMenuChoice = scan.nextInt();

        switch(mainMenuChoice){
            case 1:
                try{
                    File personsFile = new File("C:\\Users\\user\\IdeaProjects\\UTHM\\books.txt");
                    Scanner scan = new Scanner(personsFile);

                    while(scan.hasNextLine()){
                        o.println(scan.nextLine());
                    }

                    scan.close();
                }catch (FileNotFoundException fnfe){
                    fnfe.printStackTrace();
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }
}
