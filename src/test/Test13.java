package test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;

/**
 * 将emp.dat文件中所有员工解析出来，并创建为若干Emp实例存入一个
 * 集合，然后输出该集合中每个员工信息。
 * 该文件800字节，每80个字节为一个员工的信息。
 * 其中:
 * 	 name为字符串，长度为32个字节，编码为:UTF-8
 *   age为int,长度为4个字节
 * 	 gender为字符串，长度为10个字节，编码为:UTF-8
 * 	 salary为int,长度为4个字节
 * 	 hiredate为字符串，格式"yyyy-MM-dd"，长度为30个字节，编码为:UTF-8
 * 格式可参考当前包中emp.jpg图
 * 提示:
 * 使用RandomAccessFile读取字符串时，例如name,可以先读取32个字节，再按照UTF-8
 * 转换为字符串，读取age时可以直接使用readInt方法。依次类推。
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 17:10
 */
public class Test13 {
    public static void main(String[] args) throws IOException, URISyntaxException {
        //使用类加载器加载当前包中的emp.dat文件
        File file = new File(Test13.class.getClassLoader().getResource("test/emp.dat").toURI());

        RandomAccessFile raf
                = new RandomAccessFile(file,"r");

        for(int i=0;i<10;i++){
            //读取name
            String name = readString(32,raf);
            //读取年龄
            int age = raf.readInt();
            //读取性别
            String gender = readString(10,raf);
            int salary = raf.readInt();
            String hiredate = readString(30,raf);
            System.out.println(name+","+age+","+gender+","+salary+","+hiredate);

        }
    }

    public static String readString(int len,RandomAccessFile raf) throws IOException {
        byte[] data = new byte[len];
        raf.read(data);
        String str = new String(data,"UTF-8").trim();
        return str;
    }
}