class DoublyLinkedList<T extends Comparable> {

    private DoublyLinkedNode<T> first;
    private DoublyLinkedNode<T> last;
    private int numNodes;

    public DoublyLinkedList() {
        first = null;
        last = null;
        numNodes = 0;
    }

    public void addLast(T element) {
        //TODO1 create a DoublyLinkedNode<T> node
        
 
        if (numNodes == 0) {
            //TODO2 doubly linked list is empty
            
        }
        else {//TODO3 doubly linked list is not empty



        }

        numNodes++;
    }

    public boolean isEmpty() {
        return (numNodes == 0);
    }

    public int size() {
        return numNodes;
    }
    
    public String toString(){
        DoublyLinkedNode<T> temp = first;
        
        String result = "";
        while (temp != null) {
            result += temp.getElement()  + " -> ";
            temp = temp.getNext();
        }
        return result;
    }

    public boolean isPalindrome(){
        DoublyLinkedNode<T> p = first;
        DoublyLinkedNode<T> q = last;
        
        while ((p != null) && (q != null) && ((p != q) && p.getPrev() != q) ){
            // TODO4 if the data contained in nodes referred by p and q is not equal, return false
            
            
            //move p to its right of the list and move q to its left of the list
            p = p.getNext();
            q = q.getPrev();
        }
        return true;
    }
}
public class Main{
    public static void main(String [] argv){
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("B");
        list.addLast("A");
        System.out.println(list.toString());
        System.out.println(list.isPalindrome());
    }
}

class DoublyLinkedNode<T> {
    private DoublyLinkedNode<T> next;
    private DoublyLinkedNode<T> prev;
    private T element;

    /**
     * Default constructor creates an empty node
     */
    public DoublyLinkedNode() {
        next = null;
        prev = null;
        element = null;
    }

    /** 
     * Creates a node containing element
     * @param elem element to be stored
     */
    public DoublyLinkedNode(T elem) {
        next = null;
        prev = null;
        element = elem;
    }
    
    /**
     * Gets the node that follows this one 
     * @return next linear node
     */
    public DoublyLinkedNode<T> getNext()
    {
        return next;
    }
    
    /**
     * Sets the node that follows this one
     * @param n LinearNode to follow this one
     */
    public void setNext(DoublyLinkedNode<T> n) 
    {
        next = n;
    }

    /** 
     * Gets the node that is before this one
     * @return prev LinearNode<T>
     */
    public DoublyLinkedNode<T> getPrev() 
    {
        return prev;
    }

    /**
     * Sets the node that is before this one
     * @param p LinearNode to put before this one
     */
    public void setPrev(DoublyLinkedNode<T> p) 
    {
        prev = p;
    }

    /**
     * Returns the element stored in this node
     * @return element stored in the node
     */
    public T getElement() {
        return element;
    }
    
    public void setElement(T elem) {
        element = elem;
    }

    @Override
    public String toString() {
        return "{el=" + element + ", next=" + next + ", prev=" + prev +  "}";
    }
}
