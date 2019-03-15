package sample;

public class AccountInfo{


    private QueueHistory history;
    private int balance;

    public int getBalance() {
        return balance;
    }
    //private int userPin;

    AccountInfo(QueueHistory queueHistory){

        this.history = queueHistory;
        this.balance = 0;
        //this.userPin = 1234;

    }

    int count=1;



    /*public int getUserPin() {
        return userPin;
    }*/


    int deposit (int amount) {

        balance = balance + amount;
        history.pop(amount,count);
        count++;
        return balance;
    }

    int withdraw (int amount) {

            balance = balance - amount;
            int trans = -1*amount;
            history.pop(trans,count);
            count++;

        return balance;
    }

    boolean withdrawCheck(int amount) {

        boolean tf = true;
        if (amount > balance) {
            tf = false;
        }
        return tf;
    }


}