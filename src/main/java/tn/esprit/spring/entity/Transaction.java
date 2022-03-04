package tn.esprit.spring.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="transactionID")
	private int transactionid;
	
	@Temporal(TemporalType.DATE)
	private Date transactionDate;

	private float transactionAmount;
	
	
    private int nbreC;
    private float amountC;
    
    
	public int getNbreC() {
		return nbreC;
	}

	public void setNbreC(int nbreC) {
		this.nbreC = nbreC;
	}

	public float getAmountC() {
		return amountC;
	}

	public void setAmountC(float amountC) {
		this.amountC = amountC;
	}



	public Transaction(Date transactionDate, float transactionAmount,
			Contract transactionprice) {
		super();
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}

	public Transaction(Date transaction_date, float transaction_amount) {
		super();
		this.transactionDate = transaction_date;
		this.transactionAmount = transaction_amount;
	}
	

	public Transaction() {
		super();
	}

	

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	

	

	




	
}

