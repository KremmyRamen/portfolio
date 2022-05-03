/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import ADTs.StackADT;
import Exceptions.EmptyCollectionException;

/**
 *
 * @author Qiong
 * @param <T>
 * @version 1
 */
public class LinkedStack<T> implements StackADT<T> {

    private int count;
    private SinglyLinkedNode<T> top;
    
    /**
     *
     */
    public LinkedStack()
    {
        top = null;
        count = 0;
    }
    
    /**
     *
     * @param data This is a variable
     */
    public LinkedStack(T data)
    {
        top = new SinglyLinkedNode(data);
        count = 1;
    }
    
    @Override
    public void push(T element) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        SinglyLinkedNode<T> temp = new 
            SinglyLinkedNode<T>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
        if (this.isEmpty()) 
            throw new EmptyCollectionException();
        
        SinglyLinkedNode<T> node = top;
        top = top.getNext();
        count--;
        node.setNext(null);
        return node.getElement();
    }

    @Override
    public T peek() throws EmptyCollectionException {
        //TODO: Implement this method
        //throw new UnsupportedOperationException("Not SupportedYet");
        
        if (this.top == null || this.size() == 0) {
            throw new EmptyCollectionException("peek()");
        }
        return this.top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        if (top != null) {
            return "LinkedListStack{" + "count=" + count + ", top=" + 
                    top.getElement() + '}';
        } 
        else {
            return "LinkedListStack{" + "count=" + count + '}';
        }
    }
    
    /**
     *
     * @param argv This is a variable 
     */
    public static void main(String[] argv)
    {
        StackADT<String> cities = new LinkedStack<String>();
        try {
            cities.push("Tokyo");
            cities.push("Atlanta");
            cities.pop();
            cities.pop();
            cities.push("Miami");
            cities.pop();
            cities.push("Charlotte");
            System.out.println("Charlotte".equalsIgnoreCase(cities.peek()));
            System.out.println(1 == cities.size());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
