package ModelClasses;

public class Transaction {
    public float amount;
    public int transactionType;
    public String info;
    public String date;
    public Transaction(float amount,int TransactionType,String info,String date){
        this.amount = amount;
        this.transactionType= TransactionType;
        this.info=  info;
        this.date= date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", TransactionType=" + transactionType +
                ", date='" + date + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
