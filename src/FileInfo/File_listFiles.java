package FileInfo;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取一个目录中的所有子项
 * 重载的listFiles方法:
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
        File_listFile1();
        /*
		 * 获取当前目录中所有文本文件
		 */
        File_listFile2();
    }

    private static void File_listFile2() {
        File dir = new File(".");

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

    private static void File_listFile1() {
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