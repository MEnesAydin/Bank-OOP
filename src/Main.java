import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Current date: " + bank.getLocaldate() + "\n" +
                    "Select process:\n" +
                    "1- Show accounts\n" +
                    "2- Create account\n" +
                    "3- Deposit\n" +
                    "4- Withdraw\n" +
                    "5- Calculate profit\n" +
                    "6- move time forward\n"+
                    "q - Quit");
            String choose = scanner.nextLine();
            if (choose.equals("1")) {
                bank.showAccounts();
            }
            else if (choose.equals("2")) {
                bank.createAccount();
            }
            else if (choose.equals("3")) {
                System.out.print("id: ");
                int id = scanner.nextInt();
                System.out.print("Amount: ");
                int amount = scanner.nextInt();
                bank.deposit(id, amount);
                scanner.nextLine();
            }
            else if (choose.equals("4")) {
                System.out.print("id: ");
                int id = scanner.nextInt();
                System.out.println("Amount: ");
                int amount = scanner.nextInt();
                bank.withdraw(id,amount);
                scanner.nextLine();
            }
            else if(choose.equals("5")){
                System.out.print("id: ");
                int id = scanner.nextInt();
                bank.profit(id);
                scanner.nextLine();
            }
            else if(choose.equals("6")){
                System.out.println("Day: ");
                int day = scanner.nextInt();
                bank.setLocaldate(bank.getLocaldate().plusDays(day));
                scanner.nextLine();
            }
            else if(choose.equals("q")){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("System error");
            }


        }
    }
}