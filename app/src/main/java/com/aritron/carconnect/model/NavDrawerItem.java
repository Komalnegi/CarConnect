/**
 * 
 */
package com.aritron.carconnect.model;

/**
 * @author Renovate
 *
 */
public class NavDrawerItem {

	private int iconId;
	private String navItem;
	/**
	 * @param iconId
	 * @param navItem
	 */
	public NavDrawerItem(int iconId, String navItem) {
		super();
		this.iconId = iconId;
		this.navItem = navItem;
	}
	/**
	 * 
	 */
	public NavDrawerItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the iconId
	 */
	public int getIconId() {
		return iconId;
	}
	/**
	 * @param iconId the iconId to set
	 */
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
	/**
	 * @return the navItem
	 */
	public String getNavItem() {
		return navItem;
	}
	/**
	 * @param navItem the navItem to set
	 */
	public void setNavItem(String navItem) {
		this.navItem = navItem;
	}
	
	
}
