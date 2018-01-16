package test;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.List;

/**
 * 使用该类测试对象流的读写对象操作
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 14:26
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 605564126214418139L;
    private transient String name;
    private int age;
    private String gender;
    private List<String> otherInfo;

    public Person(){

    }

    public Person(String name, int age, String gender, List<String> otherInfo) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(List<String> otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + otherInfo;
    }
}