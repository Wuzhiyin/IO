package fileInfo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/12/25.
 * java.io.File
 * File的每一个实例可以表示文件系统中的
 * 一个文件或目录.
 * 使用File可以:
 * 1:访问文件或目录的属性信息(名称,大小等)
 * 2:操作文件或目录(创建,删除)
 * 3:访问一个目录的子项
 * 但是不能访问文件数据.
 */
public class FileExample {
    public static void main(String[] args) {
        createFile();
        fileInfo();

    }

    /**
     * 访问文件或目录的属性信息
     */
    private static void fileInfo() {
        File file = new File("demo.txt");
        //获取文件名
        String name = file.getName();
        System.out.println("-----------YouMeek.com-----------name值=" + name);
        //文件大小,单位是字节
        long length = file.length();
        System.out.println("-----------YouMeek.com-----------length值=" + length);
        //查看是否可读可写是否隐藏
        boolean canRead = file.canRead();
        System.out.println("是否可读:"+canRead);
        boolean canWrite = file.canWrite();
        System.out.println("是否可写:"+canWrite);
        boolean isHidden = file.isHidden();
        System.out.println("是否隐藏:"+isHidden);
        //查看最后修改时间
        long time = file.lastModified();
        System.out.println("最后修改时间(毫秒):"+time);
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "yyyy年M月d日,H:m:s"
        );
//		Date date = new Date(time);
//		System.out.println("最后修改时间:"+sdf.format(date));
        System.out.println(
                "最后修改时间:"+sdf.format(time)
        );

    }

    /**
     * 文件创建示例
     */
    public static void createFile() {
        /*
		 * 通常表示路径应当习惯的使用
		 * 相对路径.
		 * "."表示当前目录,在eclipse/IDEA中运行时
		 * 当前目录为当前类所处项目的根目录
		 */
        File f = new File("."+File.separator+"demo.txt");
        System.out.println("-----------YouMeek.com-----------File.separator值=" + File.separator);
        System.out.println("-----------YouMeek.com-----------File.separatorChar值=" + File.separatorChar);
        System.out.println("-----------YouMeek.com-----------File.pathSeparator值=" + File.pathSeparator);
        System.out.println("-----------YouMeek.com-----------File.pathSeparatorChar值=" + File.pathSeparatorChar);
        try {
            boolean ex = f.createNewFile();//当且仅当不存在具有此抽象路径名指定名称的文件时,不可分地创建一个新的空文件.

            if(ex){//或者使用!f.exists()替换使用.函数本意:判断当前File表示的文件或目录是否真实存在.
                System.out.println("文件创建成功");
            }else{
                System.out.println("文件已存在");
            }
            System.out.println("-----------YouMeek.com-----------ex值=" + ex);
            System.out.println("该分区大小"+f.getTotalSpace()/(1024*1024*1024)+"G");//返回由此分区的大小。
            f.mkdirs();// 删除此抽象路径名表示的文件或目录
            //f.delete();// 删除此抽象路径名表示的文件或目录
            System.out.println("文件名  "+f.getName());  //  返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("文件父目录字符串 "+f.getParent());// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
