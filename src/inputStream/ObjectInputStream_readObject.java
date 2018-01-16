package inputStream;

import test.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 读取一个对象
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 14:48
 */
public class ObjectInputStream_readObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person wang = (Person)ois.readObject();
        System.out.println(wang.toString());
    }
}