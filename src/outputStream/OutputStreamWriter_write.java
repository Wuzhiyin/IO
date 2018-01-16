package outputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java根据流读写数据的单位划分为:
 * 字节流与字符流
 * 字符流:以字符为最小单位书写数据.
 * 字符流底层本质还是读写字节,只是字节与字符
 * 的转换工作交给字符流来处理.
 *
 *
 * 转换流
 * InputStreamReader
 * OutputStreamWriter
 * 由于常用的字符流都只能连接到其他的字符流
 * 但是通常低级流都是字节流,那么就导致了这些
 * 字符流是无法直接处理字节流这样的情况.
 * 而转换流本身是字符流,它有能处理字节流,所以
 * 经常在流连接中起到"转换器"的作用.故名转换流
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 16:41
 */
public class OutputStreamWriter_write {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos
                = new FileOutputStream("osw.txt");

        OutputStreamWriter osw
                = new OutputStreamWriter(fos,"UTF-8");

        osw.write("我在这里!");
        osw.write("赶紧来找我!");
        System.out.println("写出完毕!");
        osw.close();
    }
}