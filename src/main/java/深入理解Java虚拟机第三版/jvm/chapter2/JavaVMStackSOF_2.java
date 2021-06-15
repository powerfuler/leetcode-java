package 深入理解Java虚拟机第三版.jvm.chapter2;

/**
 * VM Args：-Xss128k
 *
 * @author zzm
 */
public class JavaVMStackSOF_2 {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF_2 oom = new JavaVMStackSOF_2();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
