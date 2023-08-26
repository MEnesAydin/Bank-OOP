import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Account {
    private int id;
    private int balance;
    private LocalDate oppeningDate;

    public Account(int id, int balance,LocalDate oppeningDate) {
        this.id = id;
        this.balance = balance;
        this.oppeningDate = oppeningDate;
    }

    void showBallance(){
        System.out.println("Current balance: "+balance);
    }
    void showId(){
        System.out.println("Account id: "+id);
    }
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Money deposit succesfull\nCurrent balance: "+getBalance());
    }

    abstract void withdraw(int amount);

    public abstract void profit(LocalDate currentDate);
    public void profitCalculator(LocalDate currentDate,int interest){
        int daysBetween = (int) ChronoUnit.DAYS.between(getOppeningDate(), currentDate);
        float interestRate = (float) interest / 100;
        int benefit = (int) ((getBalance() * interestRate / 365) * daysBetween);
        System.out.println("Profit: " + benefit + "$");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getOppeningDate() {
        return oppeningDate;
    }

    public void setOppeningDate(LocalDate oppeningDate) {
        this.oppeningDate = oppeningDate;
    }


}




