package src;
import java.util.*;


//---------------Account Methods for Atm------------------//

public  class Account{
    int ID;
    int PASS;
    double balance;
    

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

