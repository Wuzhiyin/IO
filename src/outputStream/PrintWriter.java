package outputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 缓冲字符输入输出流
 * 缓冲字符流的特点:可以按行读写字符串
 * BufferedWriter,BufferedReader
 *
 * PrintWriter内部集成了BufferedWriter作为
 * 缓冲作用,它自身有提供了自动行刷新功能.
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 16:54
 */
public class Printwriter {
    public static void main(String[] args) throws IOException {
        printWriterDemo1();
        /**
         *  PrintWriter在流连接中的用法
         */
        printWriterDemo2();
    }

    private static void printWriterDemo2()throws IOException {
        FileOutputStream fos
                = new FileOutputStream("pw1.txt");
		/*
		 * 如果在流连接中希望使用PW按照指定字符集
		 * 写出字符串时,需要自行添加转换流.并在
		 * 转换流中指定字符集
		 */
        OutputStreamWriter osw
                = new OutputStreamWriter(fos,"UTF-8");

        PrintWriter pw
                = new PrintWriter(osw);

        pw.println("丑八怪啊啊啊啊啊啊啊啊啊");
        pw.println("在这暧昧的时代");

        System.out.println("写出完毕!");

        pw.close();
    }

    private static void printWriterDemo1()throws IOException {
        /*
		 * PW提供了直接针对文件写操作的构造方法
		 * PrintWriter(String path)
		 * PrintWriter(File file)
		 *
		 * 按照指定字符集对文件写操作
		 * PrintWriter(String path,String csn)
		 * PrintWriter(File file,String csn)
		 */
        PrintWriter pw = new PrintWriter("pw.txt","UTF-8");

        pw.println("你还要我怎样,");
        pw.println("要怎样,");
        pw.println("你突然来的短信就够我悲伤.");

        System.out.println("写出完毕!");

        pw.close();
    }
}