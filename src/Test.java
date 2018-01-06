import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 仅仅作为练习
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-06 14:40
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 1.创建一个文件夹名为"Test"保存在D盘
         */
        File dir = new File("D:"+File.separator+"Test");
        if (!dir.exists()){
            dir.mkdir();
            System.out.println("创建完毕!");
        }else{
            System.out.println("该目录已存在!");
        }
        /**
         * 2.在Test文件夹中创建一个多级目录分别为"a/b/c/d"
         */
        File dirs = new File("D:"+File.separator
                            +"Test"+File.separator
                            +"a"+File.separator
                            +"b"+File.separator
                            +"c"+File.separator
                            +"d");
        if (!dirs.exists()){
            dirs.mkdirs();
            System.out.println("多级目录创建完毕");
        }else{
            System.out.println("多级目录已存在");
        }
        /**
         * 3.创建一个文件名为"wu.txt"的文本文件保存在Test文件夹下
         */
        File file = new File("D:"+File.separator
                            +"Test"+File.separator
                            +"wu.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
                System.out.println("创建成功");
            }else {
                System.out.println("文件已存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * 4.打印"wu.txt"的名字/文件大小/可读写性/是否隐藏/最后修改日器
         */
        String name = file.getName();
        System.out.println("-----------YouMeek.com-----------name值=" + name);
        long length = file.length();
        System.out.println("-----------YouMeek.com-----------length值=" + length);
        boolean canRead = file.canRead();
        System.out.println("-----------YouMeek.com-----------canRead值=" + canRead);
        boolean canWrite = file.canWrite();
        System.out.println("-----------YouMeek.com-----------canWrite值=" + canWrite);
        boolean isHidden = file.isHidden();
        System.out.println("-----------YouMeek.com-----------isHidden值=" + isHidden);
        long time = file.lastModified();
        System.out.println("-----------YouMeek.com-----------time值=" + time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String timeStr = sdf.format(time);
        System.out.println("-----------YouMeek.com-----------timeStr值=" + timeStr);
        /**
         * 5.获取Test目录中的所有子项
         */

        File[] subs = dir.listFiles();
        for (File sub : subs) {
            if (sub.isDirectory()){
                System.out.print("目录:");
            }
            if (sub.isFile()){
                System.out.print("文件:");
            }
            System.out.println(sub.getName());
        }
        /**
         * 6.获取Test目录下的包含.txt的文件
         * JAVA8 特性lambda表达式替代匿名内部类更加简洁
         * Java中内部类以及Lambda表达式中不允许修改外部类中的变量(fileFilter)，这是为了避免多线程情况下的race condition
         */
        //FileFilter fileFilter = (File pathname)->{System.out.println("过滤:"+pathname.getName()); return pathname.getName().endsWith(".txt");};
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                System.out.println("过滤:"+pathname.getName());
                return pathname.getName().endsWith(".txt");
            }
        };
        subs = dir.listFiles(fileFilter);
        for (File sub: subs) {
            System.out.println(sub.getName());
        }
    }

}