package leetCode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode listNode8 = new ListNode(1, null);
		ListNode listNode7 = new ListNode(2, listNode8);
		ListNode listNode6 = new ListNode(3, listNode7);
		ListNode listNode5 = new ListNode(4, listNode6);
		ListNode listNode4 = new ListNode(4, listNode5);
		ListNode listNode3 = new ListNode(3, listNode4);
		ListNode listNode2 = new ListNode(2, listNode3);
		ListNode listNode1 = new ListNode(1, listNode2);
		
	    System.out.println(sol.isPalindrome(listNode1));
	}
}

class ListNode{
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
	boolean isPalindrome = true;
	ListNode headNode;
	
    public boolean isPalindrome(ListNode head) {
    	headNode = head;
        ListNode currentNode = getNext(head.next);        
        return isPalindrome;
    }
    
    private ListNode getNext(ListNode head){
       if (head == null) return null;
       if (!isPalindrome) return null;

       ListNode currentNode = getNext(head.next);
       
       if (currentNode == null) {
    	   if (headNode.val != head.val) {
    		   isPalindrome = false; 
    		   return null;
    	   }
    	   else {
    		    headNode = headNode.next;
    		    return currentNode;
    	   }
       }      
       return null;
    }
    
    public boolean isPalindromeBest(ListNode head) {
        if (head == null) return true;
        else if(head.next == null) return true;
        int size = 1;
        ListNode slowerP = head;
        ListNode fasterP = head.next;
        
        ListNode tempNode = slowerP.next;
        slowerP.next = null;
       
        while(fasterP != null) {
            for(int i = 0; i < 2; i++) {
                if(fasterP != null) 
                    fasterP = fasterP.next;
                else 
                    break;
                size++;
            }
            ListNode temp = slowerP;
            slowerP = tempNode;
            tempNode = slowerP.next;
            slowerP.next = temp;
        }
        
       fasterP = slowerP.next;
       if(size % 2 != 0) {
           slowerP = tempNode;
           tempNode = tempNode.next;
       }
       
       while(slowerP != null) {
            if(slowerP.val != fasterP.val)
                return false;
           fasterP = fasterP.next;
           slowerP = tempNode;
           tempNode = (tempNode == null ) ? null : tempNode.next ;
       }
        return true;
    }
    
    public boolean isPalindromeSecond(ListNode head) {
        if (head == null) return true;
        else if(head.next == null) return true;
        int size = 1;
        ListNode slowerP = head;
        ListNode fasterP = head.next;
        
        ListNode tempNode = slowerP.next;
        slowerP.next = null;
       
        while(fasterP != null) {
            for(int i = 0; i < 2; i++) {
                if(fasterP != null) 
                    fasterP = fasterP.next;
                else 
                    break;
                size++;
            }
            ListNode temp = slowerP;
            slowerP = tempNode;
            tempNode = slowerP.next;
            slowerP.next = temp;
        }
        
       fasterP = slowerP.next;
       if(size % 2 != 0) {
           slowerP = tempNode;
           tempNode = tempNode.next;
       }
       
       while(slowerP != null) {
            if(slowerP.val != fasterP.val)
                return false;
           fasterP = fasterP.next;
           slowerP = tempNode;
           tempNode = (tempNode == null ) ? null : tempNode.next ;
       }
        return true;
    }
}


