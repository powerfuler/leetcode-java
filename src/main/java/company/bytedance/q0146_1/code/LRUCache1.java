package company.bytedance.q0146_1.code;

import java.util.HashMap;
import java.util.Map;

/**
 * ### 双向链表
 *
 * 具体的，我们使用哈希表来存储「键值对」，键值对的键作为哈希表的 Key，而哈希表的 Value 则使用我们自己封装的 `Node` 类，`Node` 同时作为双向链表的节点。
 *
 * * 插入：检查当前键值对是否已经存在于哈希表：
 *   * 如果存在，则更新键值对，并将当前键值对所对应的 `Node` 节点调整到链表头部（`refresh` 操作）
 *   * 如果不存在，则检查哈希表容量是否已经达到容量：
 *     * 没达到容量：插入哈希表，并将当前键值对所对应的 `Node` 节点调整到链表头部（`refresh` 操作）
 *     * 已达到容量：先从链表尾部找到待删除元素进行删除（`delete` 操作），然后再插入哈希表，并将当前键值对所对应的 `Node` 节点调整到链表头部（`refresh` 操作）
 * * 查询：如果没在哈希表中找到该 Key，直接返回 $-1$；如果存在该 Key，则将对应的值返回，并将当前键值对所对应的 `Node` 节点调整到链表头部（`refresh` 操作）
 *
 * 一些细节：
 *
 *  为了减少双向链表左右节点的「判空」操作，我们预先建立两个「哨兵」节点 `head` 和 `tail`。
 *
 */
public class LRUCache1 {
    class Node {
        int k, v;
        Node pre;//前驱
        Node next;//后继指针域

        Node(int _k, int _v) {
            k = _k;
            v = _v;
        }
    }

    int capacity;
    Node head, tail;
    Map<Integer, Node> map;

    // 初始化链表
    public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            refresh(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.v = value;
        } else {
            if (map.size() == capacity) {
                Node del = tail.pre;
                // 移除尾部数据
                map.remove(del.k);
                delete(del);
            }
            node = new Node(key, value);
            map.put(key, node);
        }
        refresh(node);
    }

    /**
     * 头插法
     * refresh 操作分两步：
     *  1. 先将当前节点从双向链表中删除（如果该节点本身存在于双向链表中的话）
     *  2. 将当前节点添加到双向链表头部，头插法
     * @param node
     */
    void refresh(Node node) {
        delete(node);
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    /**
     * 将当前节点从双向链表中移除，由于我们预先建立 head 和 tail 两位哨兵，因此如果 node.pre 不为空，则代表了 node 本身存在于双向链表（不是新节点）
     * @param node
     */
    void delete(Node node) {
        if (node.pre != null) {
            Node currPre = node.pre;
            currPre.next = node.next;
            node.next.pre = currPre;
        }
    }
}