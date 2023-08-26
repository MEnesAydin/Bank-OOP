import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Special extends Account{
    private int oppeningBallance;
    public Special(int id, int balance,LocalDate time) {
        super(id, balance,time);
        oppeningBallance = balance;
    }

    @Override
    void withdraw(int amount) {
        if(amount <= getBalance() && amount < oppeningBallance){
            setBalance(getBalance()-amount);
            System.out.println(amount + "$ withdrawn. Current balance:: "+getBalance());
        }
        else{
            System.out.println("not enough money");
        }
    }


    @Override
    public void profit(LocalDate currentDate) {
        profitCalculator(currentDate,12);
    }
}
