package 深入理解Java虚拟机第三版.jvm.chapter7;

/**
 * 非主动使用类字段演示
 **/
public class NotInitialization_1 {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }

}
