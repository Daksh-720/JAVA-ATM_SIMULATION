package src;
import java.util.*;


 //------------------MAIN_ATM-FILE ---------------//

public class Atm {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Account a = new Account();


        System.out.println("\n<==========ATM -- [ALL TIME MONEY - AND BANK SERVICE]==========>");



        //-------------CHECKING-ID_PASS---------------//

        while(true){
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("\nEnter PASS: ");
        int password = sc.nextInt();

        if(a.ID == id && a.PASS == password){
            System.out.print("Checking ID-PASS..");

            try{
            for(int i=1; i<=5;i++){
                Thread.sleep(500);
                System.out.print(".");
            }

            System.out.println("\n<===========LOGIN SUCCESSFUL============>\n");
            } catch(InterruptedException e){
                e.printStackTrace();


        }  break;


        }
        System.out.println("~~~~~~~~WRONG LOGIN~~~~~~~~");
        }


    
       
        //-------------ATM-CLASS-CALL--------------//

        while(true){
        //menu
        System.out.println("1.) View Account Balance");
        System.out.println("2.) Deposit Money");
        System.out.println("3.) Withdraw Money");
        System.out.println("4.) Create Account");
        System.out.println("5.) Exit ATM");   
        
        //choose nums        
        System.out.print("Enter respective Number: ");
        int n = sc.nextInt();

        switch(n){
            case 1: a.Balance();
                    a.LOADING();
                    break;

            case 2: a.Deposit(sc);
                    a.LOADING();
                    break;

            case 3: a.Withdraw(sc);
                    a.LOADING();
                    break;
             
            case 4: a.CreateAcc(sc);
                    a.LOADING();
                    break;

             case 5:
                    System.out.println();
                    a.LOADING();
                    System.out.println("<==========Thank You For Using Our ATM!==========>");
                    sc.close();
                    return;

            default: System.out.println("INVALID OPTION");
        }

        
      }
        
    }
}