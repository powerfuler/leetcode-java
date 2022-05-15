package others.q03_100盏灯问题;

/**
 * 问题描述：
 * 有100盏灯,编号依次为1,2,3.100,电灯全部关着。现在来了100个人,第一个人把所有的灯开关按下；第二个人隔一个灯按下（2,4,6…）；
 * 第三个人每隔两个灯按下（3,6,9…）.第100个人隔99个灯按下（100）,最后还有几盏灯，那几盏灯亮着？
 *
 * 问题分析：由于所有灯都全部关着，我们可以知道当灯被按下次数为奇数时灯亮，偶数时灯灭。
 * 每盏灯的开关被按下次数与其编号的正约数个数有关系。
 * 例如：
 * 第一个被拉1下；
 * 第二个被拉2下；
 * 第三个被拉2下；
 * 第四个被拉3下；
 * ……
 * 上述可知，非方数一定有偶个公约数，平方数一定有奇个公约数，而灯开关被按下的数为奇数时灯才亮，
 * 所有编号1~100中平方数有1（1^2），4(2^2)，9(3^2)，16(4^2)，25（5^2），36（6^2），49（7^2），64（8^2），81（9^2），100（10^2）共10个数。所以亮着的灯有10个。
 * 灯亮的编号为1~10的平方。（即求1~100的完全平方数）
 */
public class Solution {
    public static void main(String[] args) {
        count2();
    }

    public static void count2() {
        for (int n = 1; n <= 100; n++) {
            int m = (int) Math.sqrt(n);
            if (m * m == n) {
                System.out.println("第" + n + "盏灯亮着");
            }
        }
    }

    private static void count1() {
        //false：表示灯是关着的，true：表示灯是开着的
        boolean[] arr = new boolean[101];
        for (int i = 1; i < 101; i++) {
            System.out.print("第" + i + "个学生按了灯的编号为：");
            for (int j = i; j < 101; j = j + i) {
                //打印每一个学生按的灯的编号
                System.out.print(j + " ");
                //如果之前灯的状态为false,被按了一次之后，状态值变为true。反之亦然。
                arr[j] = !arr[j];
            }
            System.out.print("\n\n");
        }
        int count = 0;
        System.out.print("开灯的编号：");
        for (int i = 1; i < 101; i++) {
            if (arr[i]) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.print("\n");
        System.out.print("开灯的总数量：" + count);
    }
}