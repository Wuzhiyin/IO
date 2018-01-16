package test;

import java.io.*;
import java.util.Scanner;

/**
 * 简易记事本软件
 *
 * 程序启动后要求用户输入文件名.
 * 然后针对该文件写入数据.
 *
 * 用户在控制台每输入一行字符串,就按行将该
 * 字符串写入到该文件中.
 *
 * 当用户输入"exit"时,程序结束.
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 16:19
 */
public class Note {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件名:");
        String name = scanner.nextLine();
		/*
		 * 在使用流连接形式创建PrintWriter时,构造
		 * 方法除了第一个参数传入一个流之外,还支持
		 * 第二个参数,该参数是一个boolean值,若该值
		 * 为true,则当前PrintWriter具有了自动行刷新
		 * 功能.即:每当使用PrintWriter的println方法
		 * 写出一行字符串后,会自动flush
		 */
        PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(
                        new FileOutputStream(name)
                ),true
        );
        System.out.println("请输入内容:");
        String line = null;
        while(true){
            line = scanner.nextLine();
            if("exit".equals(line)){
                break;
            }
            pw.println(line);
        }

        System.out.println("再见!");
        pw.close();
    }
}