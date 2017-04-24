package Leetcode_AddTwoNumber;

/**
 * Created by hasee on 2017/4/10.
 */

/*
You are given two linked lists representing two non-negative numbers.
The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */

public class Solution {

    public static void printList(ListNode N){
        while(N != null){
            System.out.print(N.val+" ");
            N = N.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode Head = new ListNode(0);
        ListNode Current = Head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1!=null || p2!=null){
            int a = (p1==null)?0:p1.val;
            int b = (p2==null)?0:p2.val;
            int result = a + b + carry;
            if(result>=10){
                result -= 10;
                carry = 1;
            }else {
                carry = 0;
            }
            Current.next = new ListNode(result);
            Current = Current.next;
            if(p1 != null){
                p1 = p1.next;
            }
            if(p2 != null) {
                p2 = p2.next;
            }
        }
        if(carry == 1){
            Current.next = new ListNode(1);
        }
        return Head.next;
    }

    public static void main(String [] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        printList(l1);
        ListNode l2 = new ListNode(5);
        printList(l2);
        ListNode result = addTwoNumbers(l1,l2);
        printList(result);
    }
}
