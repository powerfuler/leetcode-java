package company.bytedance.q101_q200.q0146_1;

import company.bytedance.q101_q200.q0146_1.code.LRUCache1;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test0() {
        long t4 = System.currentTimeMillis();
        LRUCache1 lruCache1 = new LRUCache1(2);
        lruCache1.put(1, 1);
        lruCache1.put(2, 2);
        lruCache1.get(1);
        lruCache1.put(3, 3);
        lruCache1.get(2);
        lruCache1.put(4, 4);
        lruCache1.get(1);
        lruCache1.get(3);
        lruCache1.get(4);
        lruCache1.put(1, 1);

//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出:
//[null, null, null, 1, null, -1, null, -1, 3, 4]
    }
}
