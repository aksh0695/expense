package com.backend.expense.entity;

import java.math.BigInteger;
import java.util.Date;

public class TransactionObjects {
    private BigInteger transactionId;

    private Date transactionDate;

    private TransactionType transactionType;

    private String transactionDetail;

    private String transactionCategory;

    private double trasactionCost;
    
    private String transactionSource;

    public BigInteger getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigInteger transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public double getTrasactionCost() {
        return trasactionCost;
    }

    public void setTrasactionCost(double trasactionCost) {
        this.trasactionCost = trasactionCost;
    }

    public String getTransactionSource() {
		return transactionSource;
	}

	public void setTransactionSource(String transactionSource) {
		this.transactionSource = transactionSource;
	}

	@Override
	public String toString() {
		return "TransactionObjects [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", transactionType=" + transactionType + ", transactionDetail=" + transactionDetail
				+ ", transactionCategory=" + transactionCategory + ", trasactionCost=" + trasactionCost
				+ ", transactionSource=" + transactionSource + "]";
	}

}
