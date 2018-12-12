import java.util.Formatter;

public class Account {

    private String personsName, matricNumber, accountPassword, homeAddress, type;
    private double creditBalance;

    Account(String name, String idNumber, String password, String homeAddress, double creditBalance, String type){
        personsName = name;
        matricNumber = idNumber;
        accountPassword = password;
        this.homeAddress = homeAddress;
        this.creditBalance = creditBalance;
        this.type = type;
    }

    /*
    Haven't tested yet this (firstTimeCreateAccount) method, try this if you want the system to write their details in the file.
    */
    public void firstTimeCreateAccount(){
        try{
            Formatter f = new Formatter("C:\\Users\\user\\IdeaProjects\\UTHM\\%s",personsName + ".txt");
            f.format("Name: %s\r\n",personsName);
            f.format("Matric Number: %s\r\n",matricNumber);
            f.format("Address: %s\r\n",homeAddress);
            f.format("Type: %s\r\n",type);
            f.format("Credit: %f\r\n",creditBalance);
            f.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getPersonsName() {
        return personsName;
    }

    public String getMatricNumber() {
        return matricNumber;
    }

    public String getAccountPassword() {
        return accountPassword;
    }
}
