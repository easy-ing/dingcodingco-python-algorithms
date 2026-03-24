class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# 한 곳에서만 자료를 넣고 뺄 수 있다
# LIFO => Last in First Out = 가장 마지막에 넣은게 제일 빨리 나온다
# 가장 마지막에 들어온 값을 head로 넣어서 관리하자

class Stack:

    def __init__(self):
        self.head = None
    
    def push(self,value):
        new_head = Node(value) # 새로 노드 생성
        new_head.next = self.head # 새 노드의 다음 헤드를 현재의 해드로 바꿈
        self.head = new_head # 최상위 헤드를 새 노드로 바꿈
    
    def pop(self):
        if self.is_empty():
            return "Stack is empty!"
        deleted_head = self.head # 지우게 될 값을 리턴해야함 -> deleted에 잠깐 저장시킴
        self.head = self.head.next # 단순히 값을 없애는게 아니라
        return deleted_head
    
    def peek(self):
        if self.is_empty():
            return "Stack is empty!"
        return self.head.data
    
    def is_empty(self): # 현재 스택이 비어있는지 아닌지 확인해줌
        return self.head is None

stack = Stack()
stack.push(4)
print(stack.head.data)

stack.push(3)
print(stack.head.data)

stack.push(5)
print(stack.peek())

stack.pop()
print(stack.peek())