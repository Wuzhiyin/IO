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
         * 读写一个字节
         */
        radomAccessFile_Read();
        randomAccessFile_write();
        /**
         * 读取字符串
         */
        randomAccessFile_readStr();
        /**
         * 写出字符串
         */
        randomAccessFile_writeStr();
        /**
         * 读写基本类型数据以及RAF基于指针的读写操作
         */
        RandomAccessFileDemo();
    }

    private static void RandomAccessFileDemo() throws IOException {
        RandomAccessFile raf
                = new RandomAccessFile("raf.dat","rw");
		/*
		 * 获取指针位置的方法:
		 * long getFilePointer()
		 */
        long pos = raf.getFilePointer();
        System.out.println("pos:"+pos);

        int imax = Integer.MAX_VALUE;
		/*
		 *                            vvvvvvvv
		 * 01111111 11111111 11111111 11111111
		 */
        raf.write(imax>>>24);
        System.out.println("pos:"+raf.getFilePointer());

        raf.write(imax>>>16);
        raf.write(imax>>>8);
        raf.write(imax);
        System.out.println(imax);
        System.out.println("pos:"+raf.getFilePointer());

		/*
		 * void writeInt(int d)
		 * 将int值写出
		 */
        raf.writeInt(imax);
        System.out.println("pos:"+raf.getFilePointer());
        raf.writeLong(123L);
        System.out.println("pos:"+raf.getFilePointer());
        raf.writeDouble(123.123);
        System.out.println("pos:"+raf.getFilePointer());

        System.out.println("写出完毕!");
        //移动指针到文件最开始
        raf.seek(0);
        System.out.println("pos:"+raf.getFilePointer());
		/*
		 * readInt可以一次性读取4字节,转换为int值
		 * 若读取到文件末尾则抛出EOFException
		 * EOF  end of file
		 */
        int d = raf.readInt();
        System.out.println(d);//?
        System.out.println("pos:"+raf.getFilePointer());

        raf.seek(8);
        long l = raf.readLong();
        System.out.println(l);
        System.out.println("pos:"+raf.getFilePointer());

        double dou = raf.readDouble();
        System.out.println(dou);
        System.out.println("pos:"+raf.getFilePointer());
        raf.close();
    }

    private static void randomAccessFile_writeStr() throws IOException {
        RandomAccessFile raf
                = new RandomAccessFile("raf.txt","rw");

        String str = "夜空中最亮的星是否听清那仰望的人心底的孤独和叹息";
        System.out.println(str.length());
		/*
		 * 将字符串转换为一组字节:
		 * String提供了相关方法
		 * byte[] getBytes()
		 * 将当前字符串按照系统默认字符集转换为
		 *
		 * byte[] getBytes(String csn)
		 * 按照指定字符集转换为一组字节(推荐)
		 */
        byte[] data = str.getBytes("GBK");

        raf.write(data);
        System.out.println("写出完毕!");
        raf.close();
    }

    private static void randomAccessFile_readStr() throws IOException {
        RandomAccessFile raf
                =  new RandomAccessFile("raf.txt","r");

        byte[] data = new byte[100];

        int len = raf.read(data);
        System.out.println("len:"+len);
		/*
		 * 字符串提供了构造方法可以将给定的字节数组
		 * 转换为字符串.
		 * String(byte[] d,int offset,int len,String csn)
		 * 将给定字节数组从下标offset处开始连续len个
		 * 字节按照csn指定的字符集转换为字符串
		 *
		 */
        String str = new String(data,0,len,"gbk");
        System.out.println(str);

        raf.close();
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