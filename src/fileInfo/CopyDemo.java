package fileInfo;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 文件复制
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 12:55
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 文件复制
         */
        randomAccessFile1();
        /**
         * 若想提高读写效率,可以通过提高每次读写的
         * 数据量减少读写次数来达到.
         */
        randomAccessFile2();
    }

    private static void randomAccessFile2() throws IOException {
        RandomAccessFile src
                = new RandomAccessFile(
                "soft.zip","r"
        );

        RandomAccessFile desc
                = new RandomAccessFile(
                "soft_cp1.zip","rw"
        );
		/*
		 * RandomAccessFile提供了一次性读取
		 * 一组字节的方法:
		 * int read(byte[] data)
		 * 一次性尝试读取给定字节数组总长度的
		 * 字节量并存入到该数组中,返回值为实际
		 * 读取到的字节量.
		 * 若返回值为-1,则表示当前没有读取到任何
		 * 字节(文件末尾).
		 */
        //10k
        byte[] data = new byte[1024*10];
        int len = -1;//记录每次实际读取到的字节量

        long start = System.currentTimeMillis();
        while((len = src.read(data))!=-1){
			/*
			 * 将给定字节数组中从offset处开始连续
			 * 的len个字节一次性写出
			 */
            desc.write(data,0,len);
        }

        long end = System.currentTimeMillis();

        System.out.println("复制完毕!耗时:"+(end-start)+"ms");
        src.close();
        desc.close();
    }


    private static void randomAccessFile1()throws IOException {
        RandomAccessFile src
                = new RandomAccessFile(
                "D:\\soft.zip","r"
        );

        RandomAccessFile desc
                = new RandomAccessFile(
                "D:\\soft_cp.zip","rw"
        );
        //保存每次读取到的字节
        int d = -1;

        long start = System.currentTimeMillis();
        while( (d = src.read())!=-1){
            desc.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕!耗时:"+(end-start)+"ms");
        src.close();
        desc.close();
    }
}