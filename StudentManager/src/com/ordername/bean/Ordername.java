package com.ordername.bean;

public class Ordername {
	int id;
	String name;
	String date;
	int amount;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date セットする date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount セットする amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ordername [id=" + id + ", name=" + name + ", date=" + date + ", amount=" + amount + "]";
	}
	/**
	 * @param id
	 * @param name
	 * @param date
	 * @param amount
	 */
	public Ordername(int id, String name, String date, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.amount = amount;
	}
	/**
	 *
	 */
	public Ordername() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}


}
