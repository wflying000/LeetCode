import java.util.HashMap;
import java.util.Map;

// 运用所掌握的数据结构，设计和实现一个  LRU (Least Recently Used，最近最少使用) 缓存机制 。

// 实现 LRUCache 类：

// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，
// 则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public Node() {

    }
}

// 利用双向链表与map实现LRUCache
// 链表节点存储key与value, 链表存在开始和结尾分别存在一个功能节点head与tail
// 保证最近访问的节点是head后一节点即head.next, 最久未使用的节点是tail前一节点即tail.prev
// map存储(key, node)

// 插入值时, 如果key已存在, 则通过key取出对应node, 将key对应的值更新为value,即node.val = value
// 再将node放到head之后 
// 如果key不存在, 先判断当前是否达到最大容量, 如果达到最大容量则删除tail前一节点即tail.prev并删除
// map中的key, 然后再创建节点Node(key, value)并放入map, 并将节点置于head之后

// 访问值时，如果key不存在则返回-1, 如果存在则通过map获得对应node, 并将node置于head后一节点

public class LC146 {
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> key2node;

    public LC146(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        key2node = new HashMap<>();
    }
    
    public int get(int key) {
        if (!key2node.containsKey(key)) {
            return -1;
        }
        Node node = key2node.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        Node first = head.next;
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;

        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = null;
        Node first = null;
        if (key2node.containsKey(key)) {
            node = key2node.get(key);
            node.val = value;
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;         
        } else {
            if (key2node.size() == capacity) {
                Node tmp = tail.prev;
                tmp.prev.next = tail;
                tail.prev = tmp.prev;
                key2node.remove(tmp.key);
            }
            node = new Node(key, value);
            key2node.put(key, node);
        }
        first = head.next;
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
    }
}
