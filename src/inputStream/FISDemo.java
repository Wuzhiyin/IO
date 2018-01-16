package inputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件输入流
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 14:06
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis
                = new FileInputStream("fos.txt");

        byte[] data = new byte[100];
        int len = fis.read(data);
        String str = new String(data,0,len,"GBK");
        System.out.println(str);

        fis.close();
    }
}