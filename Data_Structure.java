package Storage_System;

import java.util.Scanner;

class Stack {
    private int maxSize = 5;
    private int top = -1;
    private int[] stack = new int[maxSize];

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full!");
        } else {
            stack[++top] = value;
            System.out.println("Pushed " + value + " into stack.");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.println("Popped: " + stack[top--]);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
        } else {
            System.out.print("Stack contents: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

class Queue {
    private int maxSize = 5;
    private int front = 0;
    private int rear = -1;
    private int[] queue = new int[maxSize];

    public void enqueue(int value) {
        if (rear == maxSize - 1) {
            System.out.println("Queue is full!");
        } else {
            queue[++rear] = value;
            System.out.println("Enqueued " + value + " into queue.");
        }
    }

    public void dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Dequeued: " + queue[front++]);
        }
    }

    public void display() {
        if (front > rear) {
            System.out.println("Queue is empty!");
        } else {
            System.out.print("Queue contents: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

class LinkedList {
    private Node head;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted " + value + " at the end.");
    }

    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            System.out.println("Deleted " + head.data + " from the beginning.");
            head = head.next;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            Node temp = head;
            System.out.print("Linked List contents: ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}

class CircularLinkedList {
    private Node head;
    private Node tail;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        System.out.println("Inserted " + value + " into circular linked list.");
    }

    public void delete() {
        if (head == null) {
            System.out.println("List is empty!");
        } else if (head == tail) {
            System.out.println("Deleted " + head.data + " from the list.");
            head = tail = null;
        } else {
            System.out.println("Deleted " + head.data + " from the list.");
            head = head.next;
            tail.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            Node temp = head;
            System.out.print("Circular Linked List contents: ");
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println();
        }
    }
}

public class DataStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, operation, value;

        do {
            System.out.println("\nChoose Data Structure:");
            System.out.println("1. Stack");
            System.out.println("2. Queue");
            System.out.println("3. Linked List");
            System.out.println("4. Circular Linked List");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Stack stack = new Stack();
                    do {
                        System.out.println("\n--- Stack Operations ---");
                        System.out.println("1. Push");
                        System.out.println("2. Pop");
                        System.out.println("3. Display");
                        System.out.println("4. Exit");
                        System.out.print("Enter choice: ");
                        operation = scanner.nextInt();

                        switch (operation) {
                            case 1:
                                System.out.print("Enter value to push: ");
                                value = scanner.nextInt();
                                stack.push(value);
                                break;
                            case 2:
                                stack.pop();
                                break;
                            case 3:
                                stack.display();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (operation != 4);
                    break;

                case 2:
                    Queue queue = new Queue();
                    do {
                        System.out.println("\n--- Queue Operations ---");
                        System.out.println("1. Enqueue");
                        System.out.println("2. Dequeue");
                        System.out.println("3. Display");
                        System.out.println("4. Exit");
                        System.out.print("Enter choice: ");
                        operation = scanner.nextInt();

                        switch (operation) {
                            case 1:
                                System.out.print("Enter value to enqueue: ");
                                value = scanner.nextInt();
                                queue.enqueue(value);
                                break;
                            case 2:
                                queue.dequeue();
                                break;
                            case 3:
                                queue.display();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (operation != 4);
                    break;

                case 3:
                    LinkedList linkedList = new LinkedList();
                    do {
                        System.out.println("\n--- Linked List Operations ---");
                        System.out.println("1. Insert at end");
                        System.out.println("2. Delete at beginning");
                        System.out.println("3. Display");
                        System.out.println("4. Exit");
                        System.out.print("Enter choice: ");
                        operation = scanner.nextInt();

                        switch (operation) {
                            case 1:
                                System.out.print("Enter value to insert at end: ");
                                value = scanner.nextInt();
                                linkedList.insertAtEnd(value);
                                break;
                            case 2:
                                linkedList.deleteAtBeginning();
                                break;
                            case 3:
                                linkedList.display();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (operation != 4);
                    break;

                case 4:
                    CircularLinkedList circularList = new CircularLinkedList();
                    do {
                        System.out.println("\n--- Circular Linked List Operations ---");
                        System.out.println("1. Insert");
                        System.out.println("2. Delete");
                        System.out.println("3. Display");
                        System.out.println("4. Exit");
                        System.out.print("Enter choice: ");
                        operation = scanner.nextInt();

                        switch (operation) {
                            case 1:
                                System.out.print("Enter value to insert: ");
                                value = scanner.nextInt();
                                circularList.insert(value);
                                break;
                            case 2:
                                circularList.delete();
                                break;
                            case 3:
                                circularList.display();
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    } while (operation != 4);
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}