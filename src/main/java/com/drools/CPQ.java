package com.drools;

import java.util.Date;

public class CPQ {

	private String ClientID;
	private String BranchID;
	private String CustomerID; //TR+Acct Number
	private String ItemID;
	private String ItemType; // product, enhancement, shipping , tax

	private double cap;  // cap
	private Date   HoldingPeriod;
	private double cost;
	private double CostMarkup;  // list Price
	private double ClientContractDiscount; // Negotiated Price
	private double ClientRetailMarkup; // Retail Price
	
	private double ListPrice;
	private double NegotiatedPrice;
	private double RetailPrice;	
	private double ClientSplit;
 
	
	public String getItemID() {
		return ItemID;
	}
	public String getClientID() {
		return ClientID;
	}
	public void setClientID(String clientID) {
		ClientID = clientID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
	public String getItemType() {
		return ItemType;
	}
	public void setItemType(String itemType) {
		ItemType = itemType;
	}
	public double getCap() {
		return cap;
	}
	public void setCap(double cap) {
		this.cap = cap;
	}
	public Date getHoldingPeriod() {
		return HoldingPeriod;
	}
	public void setHoldingPeriod(Date holdingPeriod) {
		HoldingPeriod = holdingPeriod;
	}
	public String getBranchID() {
		return BranchID;
	}
	public void setBranchID(String branchID) {
		BranchID = branchID;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getCostMarkup() {
		return CostMarkup;
	}
	public void setCostMarkup(double costMarkup) {
		CostMarkup = costMarkup;
	}
	public double getClientContractDiscount() {
		return ClientContractDiscount;
	}
	public void setClientContractDiscount(double clientContractDiscount) {
		ClientContractDiscount = clientContractDiscount;
	}
	public double getClientRetailMarkup() {
		return ClientRetailMarkup;
	}
	public void setClientRetailMarkup(double clientRetailMarkup) {
		ClientRetailMarkup = clientRetailMarkup;
	}
	public double getListPrice() {
		return ListPrice;
	}
	public void setListPrice(double listPrice) {
		ListPrice = listPrice;
	}
	public double getNegotiatedPrice() {
		return NegotiatedPrice;
	}
	public void setNegotiatedPrice(double negotiatedPrice) {
		NegotiatedPrice = negotiatedPrice;
	}
	public double getRetailPrice() {
		return RetailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		RetailPrice = retailPrice;
	}
	public double getClientSplit() {
		return ClientSplit;
	}
	public void setClientSplit(double clientSplit) {
		ClientSplit = clientSplit;
	}


}