package inputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流
 * InputStreamReader
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 16:12
 */
public class InputStreamReader_read {
    public static void main(String[] args) throws IOException {
        FileInputStream fis
                = new FileInputStream("osw.txt");

        InputStreamReader isr
                = new InputStreamReader(fis,"UTF-8");

        int d = -1;
        while((d = isr.read())!=-1){
            System.out.print((char)d);
        }

        isr.close();
    }
}