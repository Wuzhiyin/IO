package outputStream;

import test.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象流是一组高级流,作用是方便读写java中
 * 任何对象.
 *
 * java.io.ObjectOutputStream()
 * 对象输出流,可以写出java对象
 * 工作原理:将给定java对象按照其结构转化为
 * 一组字节然后写出.
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 14:22
 */
public class ObjectOutputStream_writeObject {
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.setName("苍老师");
        p.setAge(18);
        p.setGender("女");
        List<String> otherInfo = new ArrayList<String>();
        otherInfo.add("是一名演员");
        otherInfo.add("爱好的写毛笔字");
        otherInfo.add("促进中日文化交流");
        otherInfo.add("广大男性同胞的启蒙老师");
        p.setOtherInfo(otherInfo);

        FileOutputStream fos
                = new FileOutputStream("person.obj");
        ObjectOutputStream oos
                = new ObjectOutputStream(fos);
		/*
		 * 当调用oos.writeObject时,实际做了两件事
		 * 首先p对象经过writeObject方法时,OOS将
		 * 该对象按照结果转换为了一组字节.
		 *
		 * 将一个对象转换为一组字节的过程称为:
		 * 对象序列化
		 *
		 * 然后再将这组字节通过FOS写入到了文件中.
		 * 将数据写入硬盘的过程称为:持久化
		 */
        oos.writeObject(p);
        System.out.println("写出完毕!");

        oos.close();
    }
}