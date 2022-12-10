import java.util.Scanner;
public class PreWork {


    Scanner sc = new Scanner(System.in);

    //function to checkPalindrome
    public void checkPalindrome() {
        System.out.println("Enter a Number:");
        int input = sc.nextInt();
        int num = input;
        int rem = 0;
        while(num!=0) {
            rem = rem * 10 + (num % 10);
            num = num / 10;
        }
        if(rem==input) {
            System.out.println("The given input " + input + " is a palindrome");
        }
        else {
            System.out.println("The given input " + input + " is not a palindrome");
        }
    }

    //function to printPattern
    public void printPattern() {
        System.out.println("Enter a Number:");
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            for (int j = i; j < input; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //function to check no is prime or not
    public void checkPrimeNumber() {
        System.out.println("Enter a Number:");
        int input = sc.nextInt();
        boolean isNotPrime=false;
        for(int i=2; i<=Math.sqrt(input); i++){
            if(input%i==0){
                isNotPrime = true;
                break;
            }
        }
        if(isNotPrime){
            System.out.println("The given number "  + input + " is not a Prime Number");
        }
        else{
            System.out.println("The given number "  + input + " is a Prime Number");
        }
    }

    // function to print Fibonacci Series
    public void printFibonacciSeries() {

        //initialize the first and second value as 0,1 respectively.

        int first = 0, second = 1;
        System.out.println("Enter the limit");
        int limit = sc.nextInt();
        int num=0;
        System.out.print("The Fibonacci series is: ");
        for(int i=0; i<limit; i++){
            if(i==0){
                System.out.print(first);
                continue;
            }
            else if(i==1){

                System.out.print(", " +second);
                continue;
            }
            num = first + second;
            first=second;
            second=num;
            System.out.print(", ");
            System.out.print(num);
        }
        System.out.println("");
    }


//main method which contains switch and do while loop

    public static void main(String[] args) {

        PreWork obj = new PreWork();

        int choice;

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("Enter your choice from below list.\n" + "1. Find palindrome of number.\n"

                    + "2. Print Pattern for a given no.\n" + "3. Check whether the no is a  prime number.\n"

                    + "4. Print Fibonacci series.\n" + "--> Enter 0 to Exit.\n");

            System.out.println();


            choice = sc.nextInt();

            switch (choice) {


                case 0:

                    choice = 0;

                    break;


                case 1: {

                    obj.checkPalindrome();

                }

                break;


                case 2: {


                    obj.printPattern();

                }

                break;


                case 3: {

                    obj.checkPrimeNumber();

                }

                break;


                case 4: {


                    obj.printFibonacciSeries();

                }

                break;


                default:

                    System.out.println("Invalid choice. Enter a valid no.\n");

            }


        } while (choice != 0);

        System.out.println("Exited Successfully!!!");

        sc.close();

    }


}
