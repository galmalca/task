package task;

import java.sql.Date;
import java.util.Hashtable;

import task.FileSystem.state;

public class Directory extends Item{
	/**
	 the data structure is HashTable because by the definition of HashTable, 
	 he is include only 1 value for 1 key(*Each name, file or directory is unique in the file system ). 
	 */
	private Hashtable<String, Item> haseTable = new Hashtable<>();
	/**
	 * Constructor
	 *@param String name,String parentDirName, Date createDate
	 */
	public Directory(String name, String parentDirName, Date createDate){
		super(name,parentDirName,createDate);		
	}
	/**
	 *This method add a new item to the HashTable
	 *@param Item item
	 *@return PROPER state when the item successfully added and ITEMALREADYINHASH state when the item already in the hash.
	 */
	public state addItem(Item item){
		if(item!=null)
			try{
				item.setParentDirName(getName());
				this.haseTable.put(item.getName(), item);
			}catch (Exception e) {
				return state.ITEMALREADYINHASH;
			}
		return state.PROPER;
	}
	/**
	 *This method add a new item to the HashTable
	 *@return String value (the type of the item)
	 */
	@Override
	public String getType(){
		return "Dir";
	}
	/**
	 *This method print the class
	 */
	@Override
	public void print() {
		System.out.println("---------------------");
		System.out.println("Name: "+this.getName());
		if(this.getCreateDate()!= null)
			System.out.println("CreateDate: "+this.getCreateDate().toString());
		else
			System.out.println("CreateDate: "+this.getCreateDate());
		System.out.println("ParentDirName: "+this.getParentDirName());
		for (String key : haseTable.keySet()) {
			Item item = this.haseTable.get(key);
			item.print();
		}
		System.out.println("---------------------");
	}
}
