public class MainBank {
    public static void main(String[] args) {
        long acc1 = Long.parseLong(args[0]);
        long acc2 = Long.parseLong(args[1]);
        double amt = Double.parseDouble(args[2]);
        //PART I
       /*Account accountNO  = getAccount(acc);
       if(accountNO == null)
       {
        System.out.println("Sorry no account on this");
       }
       else{
           accountNO.accountInformation();
           accountNO.deposit(amt);
           accountNO.accountInformation(); 
       }*/
        
       //PART II
       Account account1 = getAccount(acc1);
       Account account2  = getAccount(acc2);
       if(account1 == null || account2 == null)
       {
           System.out.println("Sorry you have entered wrong information");
       }
       else
        {
            System.out.println("Depositor account information ");
            account1.accountInformation();
            System.out.println("To whom account information ");
            account2.accountInformation();
            System.out.println("----------------------");
            account1.withdraw(amt);
            account2.deposit(amt);
            System.out.println("Depositor account information after Tx ");
            account1.accountInformation();
            System.out.println("To whom account information after Tx");
            account2.accountInformation();

        }

    }

    // pass the accountNO and get the Account from Accounts[] 
    public static Account getAccount(long accountNo) {
        Account[] accounts = AccountsDB.getAccounts();
       
            for(Account acc : accounts)
            {
                if(acc.getAccountNumber() == accountNo)
                    return acc;
                
            }
            return null;


            
        
       
        // get the account from accounts using the accountNo
        
       
    }
}