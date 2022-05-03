
package DataStructures;

/**
 * A simple Linear Node for use in linked structures such as lists
 * @author clatulip
 * @param <T> 
 * @version 1
 */
public class SinglyLinkedNode<T> {
    private SinglyLinkedNode<T> next;
    private T element;

    /**
     * Default constructor creates an empty node
     */
    public SinglyLinkedNode() {
        super();
    }

    /** 
     * Creates a node containing element
     * @param elem element to be stored
     */
    public SinglyLinkedNode(T elem) {
        next = null;
        element = elem;
    }
    
    /**
     * Gets the node that follows this one 
     * @return next linear node
     */
    public SinglyLinkedNode<T> getNext()
    {
        return next;
    }
    
    /**
     * Sets the node that follows this one
     * @param n LinearNode to follow this one
     */
    public void setNext(SinglyLinkedNode<T> n) 
    {
        next = n;
    }

    /**
     * Returns the element stored in this node
     * @return element stored in the node
     */
    public T getElement() {
        return element;
    }
    
    /**
     * Sets element to parameter.
     * @param elem Is a variable used in this method.
     */
    public void setElement(T elem) {
        element = elem;
    }

    /**
     *
     * @return Returns a string.
     */
    @Override
    public String toString() {
        return "{el=" + element + ", next=" + next +  "}";
    }
}
