package fileInfo;

import java.io.File;
import java.io.FileFilter;

/**
 * 1.获取一个目录中的所有子项
 * 2.重载的listFiles方法:
 * File[] listFiles(FileFilter filter)
 * 该方法要求传入一个文件过滤器,然后返回当前
 * File表示的目录中所有满足过滤器要求的子项.
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-06 10:47
 */
public class File_listFiles {
    public static void main(String[] args) {
        /*
		 * 查看当前目录中的所有子项
		 */
        file_listFile1();
        /*
		 * 获取当前目录中所有文本文件
		 */
        file_listFile2();
    }

    private static void file_listFile2() {
        File dir = new File(".");
        /**
         * JAVA8 特性lambda表达式替代匿名内部类更加简洁
         * Java中内部类以及Lambda表达式中不允许修改外部类中的变量(fileFilter)，这是为了避免多线程情况下的race condition
         */
        //FileFilter fileFilter = (File pathname)->{System.out.println("过滤:"+pathname.getName()); return pathname.getName().endsWith(".txt");};
        FileFilter filter = new FileFilter(){
            public boolean accept(File file){
                String name = file.getName();
                System.out.println("正在过滤:"+name);
                return name.endsWith(".txt");
            }
        };
        File[] subs = dir.listFiles(filter);
        for(File sub : subs){
            System.out.println(sub.getName());
        }
    }

    private static void file_listFile1() {
        File dir = new File(".");
        /*
		 * dir.isFile()
		 * 判断当前File表示的是否为一个文件
		 *
		 * dir.isDirectory()
		 * 判断当前File表示的是否为一个目录
		 */
        if(dir.isDirectory()){
            //获取一个目录中的所有子项
            File[] subs = dir.listFiles();
            for(File sub : subs){
                if(sub.isFile()){
                    System.out.print("文件:");
                }
                if(sub.isDirectory()){
                    System.out.print("目录:");
                }
                System.out.println(sub.getName());
            }
        }
    }
}