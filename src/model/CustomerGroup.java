package model;

import java.time.LocalDateTime;

/**
 * The <code>CustomerGroup<code> creates a customer group 
 * and manages its maximum discount.
 *
 * @author Jonas
 * @version 15/12/2023
 * @since 07/12/2023
 */
public class CustomerGroup {
	private String name;
	private String type;
	private TemporalPriceList maxDiscount;
	private static CustomerGroup defaultCustomerGroup;
	
	/**
	 * Constructs a <code>CustomerGroup</code>.
	 * 
	 * @param name			The name associated with the group.
	 * @param type			The type associated with the group.
	 * @param maxDiscount	The maximum amount of discount associated with the group.
	 */
	public CustomerGroup(String name, String type, double maxDiscount, LocalDateTime date) {
		this.name = name;
		this.type = type;
		this.maxDiscount = new TemporalPriceList();
		this.maxDiscount.addPrice(maxDiscount, date);
	}
	
	/**
	 * This method gets <code>maxDiscount</code>.
	 * @return a <code>double</code> representing the maximum discount a costumer group can get
	 * 0.2 = 20%
	 */
	public double getMaxDiscount(LocalDateTime date) {
		return maxDiscount.getPrice(date);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TemporalPriceList getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(TemporalPriceList maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	/**
	 * This method gets <code>defaultCustomerGroup</code>.
	 * @return a <code>defaultCustomerGroup<code> representing <code>CustomerGroup</code>. 
	 */
	public static CustomerGroup getDefaultCustomerGroup() {
		if(defaultCustomerGroup == null) {
			defaultCustomerGroup = new CustomerGroup("Default Group", "Default", 0.0d, LocalDateTime.of(2020, 1,1,1,1));
		}
		return defaultCustomerGroup;	
	}
	
}
