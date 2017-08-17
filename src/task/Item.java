package task;

import java.util.Date;

public abstract class Item {
	
	private String name;
	private Date createDate;
	private String parentDirName;
	
	/**
	 * Constructor
	 *@param String name,String parentDirName, Date createDate
	 */
	public Item(String name,String parentDirName, Date createDate) {
		super();
		this.name = name;
		this.createDate = createDate;
		this.parentDirName = parentDirName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getParentDirName() {
		return parentDirName;
	}
	public void setParentDirName(String parentDirName) {
		this.parentDirName = parentDirName;
	}
	public abstract String getType();
	public abstract void print();
}
