package company.bytedance.q101_q200.q0165_1.code;

import java.util.ArrayList;

/**
 *
 *
 */
public class Solution3 {
    public int compareVersion(String version1, String version2) {
        String[] a1 = spilt1(version1);
        String[] a2 = spilt1(version2);

        for (int n = 0; n < Math.max(a1.length, a2.length); n++) {
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
            if (i < j) {
                return -1;
            } else if (i > j) {
                return 1;
            }
        }
        return 0;
    }

    public String[] spilt1(String version1) {
        ArrayList<String> testList = new ArrayList<String>();
        StringBuffer s = new StringBuffer();
        for (int j = 0; j < version1.length(); j++) {
            if (version1.charAt(j) != '.') {
                s.append(version1.charAt(j));
            } else {
                testList.add(s.toString());
                s = new StringBuffer();
            }
        }
        testList.add(s.toString());
        //初始化需要得到的数组
        String[] array = new String[testList.size()];
        //使用for循环得到数组
        for (int i = 0; i < testList.size(); i++) {
            array[i] = testList.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int i = new Solution3().compareVersion("7.5.2.4", "7.5.3");
        System.out.println(i);
    }
}