import java.io.File;
import java.util.Scanner;

/**
 * This challenge is inspired from LeetCode Problem 193.
 *
 * Given an input file called "inut.txt" that contains a list of potential
 * phone numbers on each line, determine if each line is a valid phone number.
 *
 * A valid phone number is defined as any sequence of digits that has the
 * following characteristics:
 * 1. It may contain a '+' at the start of the string, for the international
 *   dialing code. The '+' is optional.
 *
 * 2. It may contain a '-' in the string, to separate the country code, area
 *   code, and local number. The '-' is optional.
 *
 * 3. It may contain a '(' and ')' in the string, to enclose the area code.
 */
public class ParsePhone {
    private static boolean isValidNumber(String number) {
        char[] chars = number.toCharArray();

        Queue q = new Queue();
        for(int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])) 
                q.enqueue(Integer.parseInt(chars[i] + ""));
        }

        if(q.getSize() != 10) return false;
        else return true;
    }

    private static class Queue {
        private Node head;
        private Node tail;
        private int size;

        public Queue() {
            head = null;
            tail = head;
            size = 0;
        }

        public void enqueue(int value) {
            Node newNode = new Node(value);
            if(head == null) {
                head = newNode;
                tail = head;
                size++;
                return;
            }

            tail.setNext(newNode);
            tail = newNode;
            size++;
        }

        public Node dequeue() {
            if(head == null) return null;

            Node tmp = head;
            head = head.next;

            size--;
            return tmp;
        }

        public int getSize() {
            return size;
        }

        private class Node {
            private Node next;
            private int value;

            public Node(int value) {
                this.value = value;
            }

            public boolean hasNext() {
                return next != null;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }

    public static void main(String[] args) {
        File input = new File("input.txt");

        if(input.exists() == false) {
            System.out.println("File not found");
            return;
        }

        try {
            Scanner sc = new Scanner(input);

            while(sc.hasNextLine()) {
                String number = sc.nextLine();
                System.out.println(isValidNumber(number) ? number : "Invalid");
            }

            sc.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
