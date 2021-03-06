package task;

import java.util.Date;
import java.util.Hashtable;
/**
 * enum state to return a constant to a clear value
 */
enum state{
	NAME_ERROR, SIZE_ERROR, PARENT_ERROR, PROPER, ITEM_ALREADY_IN_HASH, ITEM_NOT_FOUND
}
public class FileSystem {
	private static final int maxLength = 31;
	
	/**
	 the data structure is HashTable because by the definition of HashTable, 
	 he is include only 1 value for 1 key(*Each name, file or directory is unique in the file system ). 
	 */
	private Hashtable<String, Item> itemsHaseTable;
	/**
	 * Constructor
	 */
	public FileSystem(){
		this.itemsHaseTable = new Hashtable<>();
	}
	/**
	 * add new file to the file system
	 * @param String parentDirName, String fileName, Integer fileSize
	 * @return state, PROPER for a successful adding and ITEMALREADYINHASH if the Item is in the HashTable
	 */
	public state addFile(String parentDirName, String fileName, Integer fileSize){
		if(this.checkNewItem(parentDirName, fileName, fileSize)!= state.PROPER)
			return this.checkNewItem(parentDirName, fileName, fileSize);
		try{
			Item i = new File(fileName, parentDirName, null, fileSize);
			itemsHaseTable.put(fileName, i);
		}catch(Exception e){
			return state.ITEM_ALREADY_IN_HASH;
		}
		return state.PROPER;
	}
	/**
	 * add new directory to the file system
	 * @param String parentDirName, String dirName
	 * @return state, PROPER for a successful adding and ITEMALREADYINHASH if the Item is in the HashTable
	 */
	public state addDir(String parentDirName, String dirName){
		if(this.checkNewItem(parentDirName, dirName, null)!= state.PROPER)
			return this.checkNewItem(parentDirName, dirName, null);
		try{
			Item i = new Directory(dirName, parentDirName, null);
			itemsHaseTable.put(dirName, i);
		}catch(Exception e){
			return state.ITEM_ALREADY_IN_HASH;
		}
		return state.PROPER;
	}
	/**
	 * delete an item from the HashTable
	 * @param String name
	 * @return PROPER state when the item deleted and ITEMNOTFOUND state when the item dose not found in the HashTable.
	 */
	public state delete(String name){
		//in java the garbage collector make the job so we don't need a recursive deleting.
		try{
			itemsHaseTable.remove(name);
			return state.PROPER;
		}catch(Exception e){
			//Item not found in HashTable
			return state.ITEM_NOT_FOUND;
		}
	}
	/**
	 * Print the items from the file system and if one of the items it's a directory it print his items.
	 */
	public void showFileSystem(){
		System.out.println("-----FileSystem-----");
		for (String key : itemsHaseTable.keySet()){
			Item i = itemsHaseTable.get(key);
			i.print();
		}
	}
	/**
	 * Set a date to item.
	 * @param String name, Date date
	 * @return PROPER state when this setter successful and ITEMNOTFOUND state when the item dose not found in the HashTable.
	 */
	public state setDate(String name, Date date){
		try{
			Item i = itemsHaseTable.get(name);
			i.setCreateDate(date);
			return state.PROPER;
		}catch(Exception e){
			//Item doesn't exist
			return state.ITEM_NOT_FOUND;
		}
	}
	/**
	 * This method check: 
	 * 1.the length of the name (* up to 32 characters long)
	 * 2.the size is positive / null (* positive long integer )
	 * @param String parentDirName, String itemName, Integer itemSize
	 * @return state, PROPER for a successful state, NAMEERROR if the name is grater then 31 characters, SIZEERROR if the size is negative.
	 */
	private state checkNewItem(String parentDirName, String itemName, Integer itemSize){
		if(itemName.length()>maxLength)
			return state.NAME_ERROR;		
		try{
			Integer.parseUnsignedInt(itemSize.toString());
			return state.PROPER;
		}catch(Exception e){
			if(itemSize == null)
				return state.PROPER;
			else
				return state.SIZE_ERROR; 
		}
	}
}
