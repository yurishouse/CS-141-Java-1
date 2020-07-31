

import java.util.ArrayList;
import java.util.Objects;

public class CustomerData extends PersonData implements Cloneable {
    /**
     * unique int identifier
     */
    private int customerNumber;
    public static final int DEFAULT_CUSTOMER_NUMBER = 0;
    /**
     * true if customer wished to be on mailing list
     */
    private boolean mailingList;
    public static final boolean DEFAULT_MAILING_LIST_CONFIG = false;

    private ArrayList<Long> transactions;

    /**
     * Default Constructor
     * Init customer number to DEFAULT_CUSTOMER_NUMBER, mailingList to DEFAULT_MAILING_LIST_CONFIG
     */
    public CustomerData() {
        super();
        customerNumber = DEFAULT_CUSTOMER_NUMBER;
        mailingList = DEFAULT_MAILING_LIST_CONFIG;
        transactions = new ArrayList<Long>();
    }

    /**
     * Full constructor
     */
    public CustomerData(String lastName, String firstName, String address, String phone, int customerNumber, boolean mailingList, ArrayList<Long> transactions) {
        super(lastName, firstName, address, phone);
        this.customerNumber = customerNumber;
        this.mailingList = mailingList;
        this.transactions = new ArrayList<Long>();
        this.transactions.addAll(transactions);
    }

    /**
     * Getter
     *
     * @return customerNumber
     */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Setter - customerNumber
     *
     * @param customerNumber customerNumber
     */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * Getter
     *
     * @return mailingList
     */
    public boolean getMailingList() {
        return mailingList;
    }

    /**
     * Setter - mailingList
     *
     * @param mailingList mailingList
     */
    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }

    /**
     * Getter
     *
     * @return transactions
     */
    public ArrayList<Long> getTransactions() {
        ArrayList<Long> arrayList = new ArrayList<Long>(this.transactions);
        return arrayList;
    }

    /**
     * Setter - transactions
     *
     * @param transactions transactions cannot bu null
     * @throws IllegalArgumentException when transaction is null
     */
    public void setTransactions(ArrayList<Long> transactions) throws IllegalArgumentException {
        if (transactions == null)
            throw new IllegalArgumentException();
        this.transactions = new ArrayList<Long>();
        this.transactions.addAll(transactions);
    }

    /**
     * add new transaction
     *
     * @param t transaction number
     * @throws IllegalArgumentException if t is more than 15 digit or negative
     */
    public void addTransaction(long t) throws IllegalArgumentException {
        if ((t / 10000000 > 99999999) || t < 0) {
            throw new IllegalArgumentException();
        }
        transactions.add(t);
    }

    @Override
    public String toString() {
        StringBuffer transactionsString = new StringBuffer();
        for (int i = 0; i < transactions.size(); i++) {
            long t = transactions.get(i);
            if (i != 0) transactionsString.append(", ");
            transactionsString.append(t);
        }
        return super.toString() +
                "; Customer number: " + customerNumber +
                "; Mailing list: " + (mailingList ? "true" : "false") +
                "; Transactions: [" + transactionsString.toString() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomerData that = (CustomerData) o;
        return customerNumber == that.customerNumber &&
                mailingList == that.mailingList &&
                Objects.equals(transactions, that.transactions);
    }

    @Override
    public CustomerData clone() {
        CustomerData cd = (CustomerData) super.clone();
        //noinspection unchecked
        cd.transactions = (ArrayList<Long>) this.transactions.clone();
        return cd;
    }
}
