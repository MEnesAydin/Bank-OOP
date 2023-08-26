import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Bank {
    Scanner scanner = new Scanner(System.in);
    private LocalDate localdate = LocalDate.now();
    private int nextid = 1;
    ArrayList<Account> accounts = new ArrayList<Account>();

    public void createAccount(){
        System.out.println("Account type:\n1-Current\n" +
                "2-Special (interest rate: %17)\n" +
                "3-LongTerm: (interest rate: %24)\n" +
                "4-ShortTerm: (interest rate: %17)");
        int choose = scanner.nextInt();
        System.out.println("Oppening balance: ");
        int value = scanner.nextInt();
        if(choose == 1){
            accounts.add(new Current(nextid,value, localdate));
        }
        else if(choose == 2){
            accounts.add(new Special(nextid,value, localdate));
        }
        else if(choose == 3){
            if(value < 1500){
                System.out.println("Opening balance cannot be less than 1500");
                return;
            }
            accounts.add(new LongTerm(nextid,value, localdate));
        }
        else if(choose == 4){
            if(value < 1000){
                System.out.println("Opening balance cannot be less than 1000");
                return;
            }
            accounts.add(new ShortTerm(nextid,value, localdate));
        }
        else{
            System.out.println("wrong choice");
            return;
        }
        System.out.println("account creation successful");
        nextid++;
    }

    public void showAccounts(){
        for(Account account : accounts){
            System.out.println("id: "+ account.getId()
                    + " Balance: " + account.getBalance()
                    + " OpenD: " + account.getOppeningDate());
        }
    }
    private Account findAccount(int id){
        for(Account iter : accounts){
            if(iter.getId() == id){
                return iter;
            }
        }
        System.out.println("Account not found");
        return null;
    }
    public void deposit(int id,int amount){
        findAccount(id).deposit(amount);
    }
    public void withdraw(int id,int amount){
        findAccount(id).withdraw(amount);
    }
    public void profit(int id){
        findAccount(id).profit(localdate);
    }


    public LocalDate getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDate localdate) {
        this.localdate = localdate;
    }
}
