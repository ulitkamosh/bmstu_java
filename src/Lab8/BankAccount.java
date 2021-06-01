package Lab8;

public class BankAccount {

    private long value;

    public long getValue() {
        return value;
    }

    public BankAccount(long value) {
        this.value = value;
    }

    public void Withdraw(long withdrawValue) {
        if (this.value >= withdrawValue) {
            this.value = this.value - withdrawValue;
            System.out.println("Счет - " + this.value + " Аккаунта - " + this);
        } else {
            System.out.println("Недостаточно денежных средств");
        }
    }

    public void Add(long addValue) {
        if (addValue >= 0) {
            this.value = this.value + addValue;
            System.out.println("Счет - " + this.value + " Аккаунта - " + this);
        } else {
            System.out.println("Невозможно выполнить операцию");
        }
    }
}

class Transaction extends Thread {
    private final Object key = new Object();
    private final BankAccount account;
    private final long value;
    private final boolean toWithdraw;

    public Transaction (BankAccount account, long value, boolean toWithdraw) {
        this.account = account;
        this.value = value;
        this.toWithdraw = toWithdraw;
    }

    @Override
    public void run() {
        synchronized (key) {
            if (toWithdraw){
                account.Withdraw(value);
            } else{
                account.Add(value);
            }
        }
    }

}
