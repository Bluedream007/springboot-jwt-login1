package bluedream.example.security.domain;

import javax.persistence.*;

@Entity
@Table(name = "account_record")
public class AccountRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_Id")
    private Long accountId;
    @Column(name = "user_Id")
    private Long userId;
    @Column(name = "account_balance")
    private double accountBalance;
    @Column(name = "withdrawals_amount")
    private int withdrawalsAmount;
    @Column(name = "deposit_Amount")
    private int depositAmount;
    @Column(name = "note")
    private String note;


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getWithdrawalsAmount() {
        return withdrawalsAmount;
    }

    public void setWithdrawalsAmount(int withdrawalsAmount) {
        this.withdrawalsAmount = withdrawalsAmount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(int depositAmount) {
        this.depositAmount = depositAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
