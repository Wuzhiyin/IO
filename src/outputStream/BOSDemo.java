package outputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流写出数据的缓冲区问题
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 13:51
 */
public class BOSDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos
                = new FileOutputStream("bos.txt");
        BufferedOutputStream bos
                = new BufferedOutputStream(fos);
        String str = "和我在成都的街头走一走,哦哦哦哦.";
        byte[] data = str.getBytes("GBK");
        bos.write(data);
		/*
		 * void flush()
		 * 强制将缓冲区已缓存数据一次性写出
		 */
        bos.flush();
        System.out.println("写出完毕!");
        //缓冲流关闭时会自动flush一次
        bos.close();
    }
}