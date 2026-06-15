import java.util.*;


class Account{
    int ID = 12345;
    int PASS = 12345;
    double balance = 5000;
    

    //--------DEFAULT_BALANCE------//
    void Balance(){
    System.out.println("Account Balance is " + balance);
}

    

    //--------DEPOSITING_MONEY----------//
    void Deposit(Scanner sc){
    while(true){
    System.out.print("Enter Amount TO Deposit: ");
    double ammount = sc.nextDouble();

    if(ammount < 0){
        System.out.println("~~~~~~INVALID AMMOUNT~~~~~~");
        continue;
    }
    balance += ammount;
    System.out.println("₹" + ammount + " Deposited Successfully!");
    System.out.println("Current Balance: ₹" + balance);
    break;
 }
}



    //--------WITHDRAWING_MONEY---------//
    void Withdraw(Scanner sc){
    while(true){
    System.out.print("Enter Amount TO WITHDRAW: ");
    int ammount = sc.nextInt();

    if(ammount < 0 || ammount > balance){
        System.out.println("~~~~~~~INVALID AMOUNT~~~~~~~~");
        continue;
    }
    balance -= ammount;
    System.out.println("₹" + ammount + " WITHDRAWN-SUCCESSFULLY");
    System.out.println("CURRENT BALANCE: ₹" + balance);
    break;
  }
}


  
    //---------CREATING_ACCOUNT----------//
    void CreateAcc(Scanner sc){
    System.out.println("<========LETS-CREATE-YOUR-ACCOUNT========>\n");

    System.out.print("Enter Account_Id: ");
    int Id = sc.nextInt();
    System.out.println();
    System.out.print("Enter Account_Password: ");
    int password = sc.nextInt();
    System.out.println();

    System.out.print("<========YOUR ACCOUNT IS READY========>\n");
    System.out.print("ID: "+ Id + "\n" + "PASSWORD: "+ password + "\n");
    System.out.println();

    System.out.print("Enter Ammount to START your Account: ");
    double ammount = sc.nextDouble();

    System.out.println("CURRENT ACCOUNT BALANCE: ₹"+ ammount);
    System.out.println("\n");
}


   //<=========LOADING - UI==========>//
    void LOADING(){
    try{
        System.out.print("Saving your Work..");
        for(int i=1; i<=5; i++){
            Thread.sleep(500);
            System.out.print(".");
        }
        System.out.println("\n");
    }

    catch(InterruptedException e){
        System.out.println("~~~~~~~~Interrupted the worker!!!!~~~~~~~~~");
    }
   }


}




 //------------------MAIN_ATM-FILE ---------------//

public class atm {
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

            default: ;
        }

        
      }
        
    }
}