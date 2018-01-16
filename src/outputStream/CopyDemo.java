package outputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用文件流复制文件
 * 学习心得：
 *
 * @Author Warriorwu
 * @Create 2018-01-16 13:56
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 使用文件流复制文件
         */
        copyDemo1();
        /**
         * 缓冲流 缓冲流是一对高级流,作用是提高读写效率. java.io.BufferedInputStream
         * java.io.BufferedOutputStream
         */
        copyDemo2();
    }

    private static void copyDemo2() throws IOException {
        FileInputStream fis
                = new FileInputStream("music.mp3");
        BufferedInputStream bis
                = new BufferedInputStream(fis);


        FileOutputStream fos
                = new FileOutputStream("music_cp3.mp3");
        BufferedOutputStream bos
                = new BufferedOutputStream(fos);

        int d = -1;

        long start = System.currentTimeMillis();
        while ((d = bis.read()) != -1) {
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,耗时:"+(end-start)+"ms");
        bis.close();
        bos.close();
    }

    private static void copyDemo1()throws IOException {
        FileInputStream fis
                = new FileInputStream("music.mp3");

        FileOutputStream fos
                = new FileOutputStream("music_cp2.mp3");

        byte[] data = new byte[1024*10];
        int len = -1;

        while((len = fis.read(data))!=-1){
            fos.write(data,0,len);
        }
        System.out.println("复制完毕");
        fis.close();
        fos.close();
    }
}