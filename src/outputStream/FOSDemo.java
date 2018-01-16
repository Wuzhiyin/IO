package outputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *流,标准的IO操作.
 * 流根据方向分为:
 * 输入流:用来读取数据的流(从数据源将数据
 *        读取到程序中)
 * 输出流:用来写出数据的流
 *
 * 流分为两类:
 * 节点流与处理流
 * 节点流(又叫低级流):数据源明确,真实负责读写
 * 数据的流,读写一定是建立在低级流的基础上进行
 * 的.
 * 处理流(高级流):不能独立存在,要建立在其他流
 *               的基础上.使用高级流的目的在于
 *               简化读写操作.
 *
 * 文件流:用于读写文件数据的流
 * 文件流是一对低级流.
 *
 * java.io.FileOutputStream
 * 文件输出流.用于向文件中写数据的流
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 14:11
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        /*
		 * FileOutputStream的构造方法:
		 * FileOutputStream(File file)
		 * FileOutputStream(String path)
		 * 以上两种创建方式创建出来的文件流是覆盖写操
		 * 作,即:若该文件存在,会先将该文件中所有数据
		 * 删除,然后将该流写出的数据作为文件数据.
		 *
		 *
		 * FileOutputStream(File file,boolean append)
		 * FileOutputStream(String path,boolean append)
		 * 以上两种构造方法要求传入第二个参数,若该参数
		 * 为true,则是追加写操作,即:通过当前流写出的内容
		 * 会被追加到该文件末尾.
		 */
        FileOutputStream fos
                = new FileOutputStream("fos.txt",true);

        String str = "扛过枪,吃过鸡,我们就是好兄弟了!!!";
        byte[] data = str.getBytes("GBK");
        fos.write(data);

        System.out.println("写出完毕!");
        fos.close();


    }
}