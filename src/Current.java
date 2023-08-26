import java.time.LocalDate;

public class Current extends Account{
    public Current(int id, int balance,LocalDate time) {
        super(id, balance,time);
    }

    @Override
    void withdraw(int amount) {
        if(amount <= getBalance()){
            setBalance(getBalance()-amount);
            System.out.println(amount + "$ withdrawn. Current balance:: "+getBalance());
        }
        else{
            System.out.println("not enough funds");
        }
    }

    public void profit(LocalDate currentDate) {
        System.out.println("account is not suitable for making a profit");
    }
}
