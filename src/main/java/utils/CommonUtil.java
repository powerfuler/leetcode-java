package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q001_010.q002_两数相加.code.ListNode;

public class CommonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    // 打印输出方法
    public static void print(ListNode listNode) {
        // 创建链表节点
        while (listNode != null) {
            System.out.println("节点:" + listNode.val);
            listNode = listNode.next;
        }
        System.out.println();
    }
}
