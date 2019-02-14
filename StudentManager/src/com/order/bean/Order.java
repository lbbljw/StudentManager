package com.order.bean;

public class Order {
	String name;
	String date;
	int amount;
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
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (amount != other.amount)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [name=" + name + ", date=" + date + ", amount=" + amount + "]";
	}
	/**
	 * @param name
	 * @param date
	 * @param amount
	 */
	public Order(String name, String date, int amount) {
		super();
		this.name = name;
		this.date = date;
		this.amount = amount;
	}
	/**
	 *
	 */
	public Order() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}


}
