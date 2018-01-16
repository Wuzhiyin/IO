package fileInfo;

import java.io.File;

/**
 * 文件删除示例
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 12:34
 */
public class File_delete {
    public static void main(String[] args) {
        /**
         * 删除一个文件
         */
        file_delete1();
        /*
		 * 将当前目录中的demo目录删除
		 */
        file_delete2();
    }

    private static void file_delete2() {
        File dir = new File("D:\\a");
        if(dir.exists()){
			/*
			 * 使用delete删除目录时,要求
			 * 该目录必须是一个空目录才可以
			 * 删除.
			 */
            dir.delete();
            System.out.println("目录已删除");
        }else{
            System.out.println("该目录不存在!");
        }
    }

    private static void file_delete1() {
        File file = new File(
                "D:"+ File.separator+"wu.txt"
        );

        if(file.exists()){
            file.delete();
            System.out.println("文件已删除");
        }else{
            System.out.println("该文件不存在!");
        }
    }

}