package src;
import java.util.*;
import java.sql.*;


 //------------------MAIN_ATM-FILE ---------------//

public class Atm {
    public static void main(String[] args) {

        try {
        Connection con = DBConnection.getConnection();

        System.out.println("Connected to MySql Successfully!");

        con.close();
      }
      catch(SQLException e){
        System.out.println("Connection Failed!");

        e.printStackTrace();
      }


        //-----Scanner methods-----//
        Scanner sc = new Scanner(System.in);
        Account a = new Account();
        System.out.println("\n<==========ATM -- [ALL TIME MONEY - AND BANK SERVICES]==========>");



        //-------------Entering-ID_PASS---------------//
        login:
        while(true){
        System.out.println("1. Login");
        System.out.println("2. Create Account");

        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();


        switch (choice) {
        case 1:
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("\nEnter PASS: ");
        int password = sc.nextInt();
        
        try{
        //------------Checking Id-pass-------------//
        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM accounts WHERE id=? AND password=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setInt(2, password);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

          a.ID = rs.getInt("id");
          a.PASS = rs.getInt("password");
          a.balance = rs.getInt("balance");


            System.out.print("Checking ID-PASS..");
            try{
            for(int i=1; i<=5;i++){
                Thread.sleep(500);
                System.out.print(".");
            }

            } catch(InterruptedException e){
                e.printStackTrace();
        }  
        System.out.println("\n<===========LOGIN SUCCESSFUL============>\n");
        break login;
        }
        
        else{
        System.out.println("~~~~~~~~WRONG LOGIN~~~~~~~~");
        }
        }
        catch(SQLException e){
        e.printStackTrace();
        }
        break;

        case 2:
        a.CreateAcc(sc);
        break;

        case 3:
        System.out.println("<========Thankyou For using Our ATM=======>");
        sc.close();
        return;

        default:
          System.out.println("Invalid Choice! Please enter 1, 2 or 3");
      }
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