package fileInfo;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * randomAccessFile示例
 * java.io.RandomAccessFile
 * 基于指针读写文件数据.
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 13:14
 */
public class RandomAccessFile_io {
    public static void main(String[] args)throws IOException {
        /**
         * 读取一个字节
         */
        radomAccessFile_Read();
        randomAccessFile_write();
    }

    private static void randomAccessFile_write() throws IOException {
        /*
		 * 对当前目录中的raf.dat文件进行写操作
		 * 常用构造方法:
		 * RandomAccessFile(String path,String mode)
		 * RandomAccessFile(File file,String mode)
		 *
		 * 其中第二个参数为模式:
		 * "r":只读模式
		 * "rw":读写模式
		 */
        RandomAccessFile raf
                = new RandomAccessFile(
                "D:\\raf.dat","rw"
        );
		/*
		 * void write(int d)
		 * 写出一个字节,写出的是给定int
		 * 值对应2进制的"低八位"
		 *                            vvvvvvvv
		 * 00000000 00000000 00000000 00000001
		 * 00000000 00000000 00000001 00000001
		 * 数字1 -- 49
		 */
        raf.write(257);

        System.out.println("over!");

        raf.close();
    }

    private static void radomAccessFile_Read()throws IOException {
        RandomAccessFile raf
                = new RandomAccessFile(
                "D:\\raf.dat","r"
        );
		/*
		 * int read()
		 * 读取一个字节,并以10进制的int值
		 * 形式返回.如果返回值为-1,则表示
		 * 读取到文件末尾.
		 *
		 * 00000000 00000000 00000000 00000001
		 *
		 */
        int d = raf.read();
        System.out.println(d);

        raf.close();
    }
}