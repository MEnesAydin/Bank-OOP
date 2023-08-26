import java.time.LocalDate;

public class LongTerm extends Account{

    public LongTerm(int id, int balance,LocalDate time) {
        super(id, balance,time);
    }

    @Override
    void withdraw(int amount) {
        if(amount <= getBalance() && getBalance()-amount >= 1500){
            setBalance(getBalance()-amount);
            System.out.println(amount + "$ withdrawn. Current balance:: "+getBalance());
        }
        else{
            System.out.println("not enough money");
        }
    }

    public void profit(LocalDate currentDate) {
        profitCalculator(currentDate,24);
    }
}
