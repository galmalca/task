package boot;

import java.util.Date;

import task.Directory;
import task.FileSystem;

public class Main {
	
	public static void main(String[] args) {
		FileSystem fs = new FileSystem();
		fs.addDir("/", "opt");
		fs.addDir("/", "dev");
		fs.addDir("/", "home");
		fs.addFile(null, "chardev.ko", -1);
		fs.addDir("/", "dev");
		fs.addDir("/", "home");
		fs.addFile(null, "chardev.ko", 17);
		Date date = new Date(1220227200L * 1000);
		Directory d1 = new Directory("gal","home", null);
		fs.addDir(d1.getParentDirName(),d1.getName());
		fs.setDate("gal", date);
		fs.showFileSystem();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		fs.delete("dev");
		fs.delete("opt");
		fs.showFileSystem();
	}

}
