package DataStructures;

import DataStructures.*;
import ADTs.*;
import Exceptions.*;

/**
 *
 * @author ITCS2214
 * @version 1.0
 * @param <T> 
 */
public class LinkedQueue<T> implements QueueADT<T> {

    /**
     * 
     */
    private SinglyLinkedNode<T> front;
    private SinglyLinkedNode<T> rear;
    private int count;

    /**
     *
     */
    public LinkedQueue() {
        // Initialize data member variables front, rear and count
        front = rear; 
        rear = null;
        count = 0;
    }

    @Override
    public void enqueue(T element) {
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>();
        temp.setElement(element);
        //if queue is empty, set front and rear to temp node. Or else
        if (isEmpty()) {
            front =  temp;
            rear = temp;
        }
        else {
    //-set the next reference of the rear node to the new node
            rear.setNext(temp);
    //-set rear to point to the new node
            rear = temp;
        }
    //Increment count
        count++;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Queue [first()]");
        }
        return front.getElement();
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
    //If queue is empty, throw an EmptyCollectionException exception.
        if (isEmpty())
            throw new EmptyCollectionException("queue");
        //Declare a temporary node, temp and set it to be the same as front
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>();
        temp = front;
        //Set front to the node next to the front
        front = front.getNext();
        //if queue is empty, set rear to null.
        if (isEmpty())
            rear = null;
            //Decrease count
        count--;
            //Return the data element of them temporary node
        return temp.getElement();
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0 ? true : false;
    }

    @Override
    public int size() {
        return this.count;
    }
}
