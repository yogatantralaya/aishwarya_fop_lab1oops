//Program to generate new user credentials
import java.util.Scanner;
public class Employee {

    public String firstName="";
    public String lastName="";
    //parameterized Constructor to set the firstName and lastName of the user
    public Employee(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    //Main method
    public static void main(String[] args) {

        Employee emp = new Employee("Novak","Djokovic");
        int count=0;
        String dept;
        do {
            //to display the options and get the department of the user
            dept = emp.displayOptions();
            count++;
            System.out.println("Retry --->" +count);
        }while((dept.equalsIgnoreCase("Invalid")) && (count < 3));
        if(count >= 3){
            System.out.println("Ran out of retry(s)!!!!");
        }
        else {
            //to generate email id for the user
            String email = CredentialService.generateEmailAddress(emp.firstName, emp.lastName, dept);
            //to generate password for the user
            String pwd = CredentialService.generatePassword();
            //to display the generated credentials
            CredentialService.showCredentials(emp.firstName, email, pwd);
        }

    }
    public String displayOptions() {
        Scanner sc = new Scanner(System.in);
        String department;
        System.out.println("Please enter the department from the following\n1. Technical\n2. Admin\n3. Human Resource\n4. Legal");
        department = sc.next();
        switch (department) {
            case "1":
                return "tech";
            case "2":
                return "admin";
            case "3":
                return "hr";
            case "4":
                return "legal";
            default: {
                System.out.println("Please enter a valid department!");
                return "Invalid";
            }
        }
    }

}

class CredentialService{
    public static String generateEmailAddress(String firstName, String lastName, String dept){
        String company = "abc";
        String email = firstName + lastName + "@" + dept + "." + company + "." + "com";
        return email.toLowerCase();
    }

    public static String generatePassword(){
        String alphabetsUpper = "abcdefghijklmnopqrstuvwxyz";
        String alphabetsLower = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String number = "0123456789";
        String specialCharacters = "!@#$%^&*";
        int max = 25;
        int min = 0;
        int ranOne = (int) (Math.random()*(max-min+1)+min);
        int ranTwo = (int) (Math.random()*(max-min+1)+min);
        int ranThree = (int) (Math.random()*(max-min+1)+min);
        int ranFour = (int) (Math.random()*(max-min+1)+min);
        max = 9;
        int ranFive = (int) (Math.random()*(max-min+1)+min);
        max = 7;
        int ranSix = (int) (Math.random()*(max-min+1)+min);
        return "" + alphabetsUpper.charAt(ranOne) + alphabetsLower.charAt(ranTwo) + alphabetsUpper.charAt(ranThree) + alphabetsLower.charAt(ranFour) + number.charAt(ranFive) + specialCharacters.charAt(ranSix);
    }
    public static void showCredentials(String firstName, String email, String pwd){
        System.out.println("Dear " + firstName + " your generated credentials are as follows\n" +
                "Email ---> " + email + "\nPassword ---> " + pwd);
    }
}