package task;

import java.util.Date;

public class File extends Item{
	private int size;
	/**
	 * Constructor
	 *@param String name, String parentDirName, Date createDate, int size
	 */
	public File(String name, String parentDirName, Date createDate, int size) {
		super(name, parentDirName, createDate);
		this.size = size;
	}
	@Override
	public String getType(){
		return "File";
	}
	/**
	 *This method print the class
	 */
	@Override
	public void print() {
		System.out.println("---------------------");
		System.out.println("Name: "+this.getName());
		System.out.println("CreateDate: "+this.getCreateDate());
		System.out.println("ParentDirName: "+this.getParentDirName());
		System.out.println("Size: "+this.size);
		System.out.println("---------------------");
	}
	
}
