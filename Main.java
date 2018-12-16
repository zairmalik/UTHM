import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
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
        int amountOfBorrowBook1, balanceBook1, amountOfBorrowBook2, balanceBook2;

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
                    File personsFile = new File("C:\\Users\\user\\IdeaProjects\\UTHM\\books..txt");
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
                Books book1 = new Books(100);
                Books book2 = new Books(100);
                int bookChoice;

                o.println("Choose the book that you want.");
                o.println("1. We Were The Lucky Ones, Georgia Hunter");
                o.println("2. Where The Crawdads Sing, Delia Owens");
                o.print(">> ");
                bookChoice = scan.nextInt();

                switch(bookChoice){
                    case 1:
                        o.println("How much do you want to borrow?");
                        o.print(">> ");
                        amountOfBorrowBook1 = scan.nextInt();
                        balanceBook1 = book1.getInStock()-amountOfBorrowBook1;
                        String balanceStringBook1 = Integer.toString(balanceBook1);
                        String inStockStringBook1 = Integer.toString(book1.getInStock());

                        book1.modifyFile("C:\\Users\\user\\IdeaProjects\\UTHM\\Book1.txt",inStockStringBook1, balanceStringBook1);
                        o.printf("Books left: %s ",balanceStringBook1);
                        o.print("borrowed at ");
                        o.print(new Date());
                        uzair.borrowBook("C:\\Users\\user\\IdeaProjects\\UTHM\\uzair.txt","We Were The Lucky Ones",amountOfBorrowBook1);
                        o.println("\nOperation done.");
                        break;
                    case 2:
                        o.println("How much do you want to borrow?");
                        o.print(">> ");
                        amountOfBorrowBook2 = scan.nextInt();
                        balanceBook2 = book1.getInStock()-amountOfBorrowBook2;
                        String balanceStringBook2 = Integer.toString(balanceBook2);
                        String inStockStringBook2 = Integer.toString(book2.getInStock());

                        book2.modifyFile("C:\\Users\\user\\IdeaProjects\\UTHM\\Book2.txt",inStockStringBook2, balanceStringBook2);
                        o.printf("Books left: %s ",balanceStringBook2);
                        o.print("borrowed at ");
                        o.print(new Date());
                        uzair.borrowBook("C:\\Users\\user\\IdeaProjects\\UTHM\\uzair.txt","Where The Crawdads Sing",amountOfBorrowBook2);
                        o.println("Operation done.");
                        break;
                }
                break;
            case 3:
                int bookChoice3;
                o.println("Choose the book that you want to return.");
                o.println("1. We Were The Lucky Ones, Georgia Hunter");
                o.println("2. Where The Crawdads Sing, Delia Owens");
                o.print(">> ");
                bookChoice3 = scan.nextInt();

                switch(bookChoice3){
                    case 1:
                        int amountToReturn;
                        o.println("How much do you want to return?");
                        o.print(">> ");
                        
                        



                }

                break;
            case 4:
                break;
        }
    }
}
