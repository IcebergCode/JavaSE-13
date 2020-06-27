package cn.itcast.day13.demo01;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
* throws关键字：异常处理的第一种方式，交给别人处理
* 作用：
*       当方法内部抛出异常对象的时候，那么我们就必须处理这个异常对象
*       可以使用throws关键字处理异常对象，会把异常对象声明抛出给方法的调用者处理（自己不处理，别人处理），最终交给JVM处理-->中断处理
* 使用格式：
*       修饰符 返回值类型 方法名(参数列表) throws AAAException, BBBException...{
*           throw new AAAException("产生原因");
*           throw new BBBException("产生原因");
*           ...
*       }
* 注意事项：
*       1、throws关键字必须写在方法声明处
*       2、throws关键字后面声明的异常必须是Exception或者是Exception的子类
*       3、方法内部如果抛出了多个异常对象，那么throws后面必须也声明多个异常
*           如果抛出的多个异常对象有子父类关系，那么直接声明父类异常即可
*       4、调用了一个声明抛出异常的方法，我们就必须处理声明的异常
*           要么继续使用throws声明抛出，交给方法的调用者处理，最终交给JVM
*           要么try...catch自己处理异常
* */
public class Demo05Throws {
    /*
    * FileNotFoundException 继承了(extends) IOException
    * 此时，如果抛出的多个异常对象有子父类关系，那么直接声明父类异常即可
    * */

    //public static void main(String[] args) throws FileNotFoundException, IOException {
    //public static void main(String[] args) throws IOException {
    public static void main(String[] args) throws Exception {
//        readFile("f:\\h123.java");
//        readFile("d:\\h123.java");  //此时抛出异常
        readFile("f:\\h123.exe");

        System.out.println("后续代码"); //使用throws后，程序出现异常后后续代码就不会执行了
    }

    /*
    * 定义一个方法，对传递的文件路径进行合法性判断
    * 如果路径不是"f:\\h123.java"，那么就抛出文件找不到的异常，告知方法的调用者
    * 注意：
    *       FileNotFoundException：是编译异常，抛出了编译异常，就必须处理这个异常
    *       可以使用throws继续声明抛出FileNotFoundException这个异常对象，让方法的调用者处理
    * */
    public static void readFile(String fileName) throws FileNotFoundException, IOException {
        if(!fileName.equals("f:\\h123.java")){
            throw new FileNotFoundException("传递的文件路径不是：f:\\h123.java");
        }

        /*
        * 如果传递的路径，不是.txt结尾
        * 那么就抛出IO异常对象，告知方法的调用者，文件的后缀名不对
        * */
        if(!fileName.endsWith(".java")){
            throw new IOException("文件的后缀名不对");
        }

        System.out.println("路径没有问题，读取文件");
    }
}
