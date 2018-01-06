package fileInfo;

import java.io.File;

/**
 * 1.使用File创建目录
 * 2.创建一个多级目录
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-06 11:55
 */
public class File_mkDir {
    public static void main(String[] args) {
        /*
		 * 在当前目录中创建一个目录"demo"
		 * "./"可以不写,默认就是当前目录
		 */
        File_mkDir();
        /*
		 * 在当前目录中
		 * 创建目录:a/b/c/d/e/f
		 */
        File_mkDirs();
    }

    private static void File_mkDirs() {
        File dirs = new File("."+File.separator
                            +"a"+File.separator
                            +"b"+File.separator
                            +"c"+File.separator
                            +"d");
        if (!dirs.exists()) {
            /*
			 * mkdir与mkdirs的主要区别是
			 * mkdir在创建目录时要求父目录必须
			 * 存在,而mkdirs则会将不存在的父目
			 * 录自动创建出来
			 */
            dirs.mkdirs();
            System.out.println("创建完毕!");
        }else{
            System.out.println("该目录已存在!");
        }
    }

    private static void File_mkDir() {
        File dir = new File("demo");
        if (!dir.exists()){
            dir.mkdir();
            System.out.println("创建完毕!");
        }else {
            System.out.println("该目录已存在!");
        }

    }
}