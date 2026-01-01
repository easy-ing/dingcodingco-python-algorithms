# 딩코딩코 Chapter2 - Linked List

# **Linked List(연결 리스트)**

## **1) 연결 리스트란?**

**연결 리스트(Linked List)** 는 데이터를 **노드(Node)** 단위로 저장하고, 

각 노드가 **다음 노드의 주소(참조)** 를 들고 연결되는 자료구조

- 배열(Array): 메모리에 **연속**으로 저장, 인덱스로 접근 빠름
- 연결 리스트: 메모리에 **흩어져** 저장 가능, 대신 **참조로 이어붙임**

---

## **2) 핵심 구성요소**

### **Node(노드)**

노드는 보통 2가지를 가진다.

- data: 실제 값
- next: 다음 노드를 가리키는 참조(없으면 null)

```python
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

### **Head(헤드)**

리스트의 **첫 노드**를 가리키는 포인터(참조).

- 리스트가 비어있으면 head == null

---

## **3) 동작 방식(그림으로 이해)**

예: 10 -> 20 -> 30

- head 는 10 노드를 가리킴
- 10.next 는 20 노드를 가리킴
- 20.next 는 30 노드를 가리킴
- 30.next 는 null

---

## **4) 단일 연결 리스트(Singly Linked List) 구현 예시 (Java)**

> 가장 기본 형태: head 하나만 들고, next로만 연결
> 

```python
public class SinglyLinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // 맨 앞에 삽입: O(1)
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // 맨 뒤에 삽입: O(n)
    public void addLast(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    // 특정 값 검색: O(n)
    public boolean contains(int value) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == value) return true;
            cur = cur.next;
        }
        return false;
    }

    // 특정 값 삭제(첫 번째로 발견된 것): O(n)
    public boolean remove(int value) {
        if (head == null) return false;

        // head가 삭제 대상인 경우
        if (head.data == value) {
            head = head.next;
            return true;
        }

        Node prev = head;
        Node cur = head.next;

        while (cur != null) {
            if (cur.data == value) {
                prev.next = cur.next; // 건너뛰기(연결 재설정)
                return true;
            }
            prev = cur;
            cur = cur.next;
        }

        return false;
    }

    // 출력
    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data);
            if (cur.next != null) System.out.print(" -> ");
            cur = cur.next;
        }
        System.out.println();
    }
}
```

---

## 5) 시간 복잡도 정리

![스크린샷 2026-01-01 오후 8.36.48.png](%EB%94%A9%EC%BD%94%EB%94%A9%EC%BD%94%20Chapter2%20-%20Linked%20List/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2026-01-01_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_8.36.48.png)

- 배열은 동적 배열(ArrayList) 기준으로, 리사이즈가 걸리면 최악 O(n)

---

## **6) 연결 리스트의 장단점**

### **장점**

- **삽입/삭제가 유연**함(특히 맨 앞은 O(1))
- 메모리가 연속일 필요가 없어 **큰 데이터에 유리**한 경우가 있음

### **단점**

- 임의 접근(랜덤 액세스) 불가 → **탐색/접근이 느림(O(n))**
- 노드마다 next를 저장해야 해서 **추가 메모리 사용**
- 캐시 효율이 배열보다 떨어질 수 있음(메모리 여기저기 흩어짐)

---

## **7) Java에서의 LinkedList (표준 라이브러리)**

Java에는 java.util.LinkedList가 있고, **이중 연결 리스트(doubly linked list)** 기반

```python
import java.util.LinkedList;

LinkedList<Integer> list = new LinkedList<>();
list.addFirst(10);
list.addLast(20);
list.removeFirst();
```

다만 실무에서는:

- 조회/인덱스 접근이 많으면 ArrayList
- 앞/뒤 삽입 삭제가 많으면 LinkedList 또는 Deque(ArrayDeque) 고려
    
    (대부분의 큐/덱은 ArrayDeque가 더 빠른 경우도 많음)
    

---

## **8) 한 줄 요약**

- **Linked List는 노드 + 다음 참조(next)로 이어진 구조**
- **맨 앞 삽입/삭제는 빠르지만(O(1))**, **중간 탐색/접근은 느리다(O(n))**