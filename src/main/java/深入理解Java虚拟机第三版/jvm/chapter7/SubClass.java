package 深入理解Java虚拟机第三版.jvm.chapter7;

/**
 * @author zzm
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}
