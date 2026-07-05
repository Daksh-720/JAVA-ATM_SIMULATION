package src;
import java.util.*;
import java.sql.*;


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

    try{
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO accounts(id, password, balance) VALUES (?, ? ,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, Id);
        ps.setInt(2, password);
        ps.setDouble(3, ammount);

        int rows = ps.executeUpdate();

        if(rows > 0){
            System.out.println("<===========ACCOUNT Created Successfully============>");
        }

        ps.close();
        con.close();
    }

    catch(SQLException e) {
        e.printStackTrace();
    }
}




    //<=========Deleting Account=========>//
    void DeleteAcc(Scanner sc) {
        System.out.println("<=========Let's Delete Account :( =========>\n");

        System.out.print("Enter Id: ");
        int id = sc.nextInt();
        System.out.print("Enter Password: ");
        int password = sc.nextInt();
        
        try {
            Connection con = DBConnection.getConnection();

            String sql="DELETE FROM accounts WHERE id=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setInt(2, password);

            int rows=ps.executeUpdate();

            if(rows > 0) {
                System.out.println("\nAccount Deleted Successfully :|");
            }
            else{
                System.out.println("\nIncorrect Id or Password....");
            }

            ps.close();
            con.close();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
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

