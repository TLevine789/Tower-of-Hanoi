package towerofhanoi;

import stack.StackInterface;
import java.util.EmptyStackException;

//Virginia Tech Honor Code Pledge:
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the 
//actions of those who do.
//-- Tyler Levine (tylerlevine)

/**
 * The LinkedStack class implements StackInterface 
 * and all of its methods.
 * @author Tyler Levine
 * @version 10.19.2021
 *
 * @param <T> The type of object in the stack
 */
public class LinkedStack<T> implements StackInterface<T> 
{
    private Node<T> topNode;
    private int size;
    
    /**
     * Creates a new LinkedStack object
     */
    public LinkedStack()
    {
        topNode = null;
        size = 0;
    }
    
    /**
     * The Node class is used throughout the 
     * LinkedStack class and represents
     * the different objects in the stack.
     * @author Tyler Levine
     *
     * @param <T> The type of object in the Node
     */
    private class Node<T>
    {
        private Node<T> nextNode;
        private T data;
        
        /**
         * Creates a new Node object
         * @param data The data stored in the node
         */
        public Node(T data)
        {
            nextNode = null;
            this.data = data;
        }
        
        /**
         * Creates a new Node object
         * @param entry The data stored in the node
         * @param node The next node
         */
        public Node(T entry, Node<T> node) 
        { 
            this(entry); 
            this.setNextNode(node); 
        }
        
        /**
         * Returns the next Node
         * @return the next Node
         */
        public Node<T> getNextNode()
        {
            return nextNode;
        }
        
        /**
         * Return the data stored in the Node
         * @return The data
         */
        public T getData()
        {
            return data;
        }
        
        /**
         * Sets the Node's next Node
         * @param next The next Node
         */
        public void setNextNode(Node<T> next)
        {
            nextNode = next;
        }
    }
    
    /**
     * Returns the size of the stack
     * @return the size
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Returns true if the stack is empty
     * and false if not
     * 
     * @return True if empty, False if not
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    /**
     * Clears all nodes from the stack
     */
    public void clear()
    {
        Node<T> currentNode = topNode;
        for (int i = 0; i < size; i++)
        {
            currentNode = new Node<T>(null);
            currentNode = currentNode.getNextNode();
        }
        size = 0;
    }
    
    /**
     * Converts the stack into a string
     * 
     * @return The string
     */
    public String toString()
    {
        String output = "";
        if (this.isEmpty())
        {
            return "[]";
        }
        Node<T> currentNode = topNode;
        for (int i = 0; i < size - 1; i++)
        {
            output = output + currentNode.getData() + ", ";
            currentNode = currentNode.getNextNode();
        }
        output = output + currentNode.getData();
        return "[" + output + "]";
    }
    
    /**
     * Adds an object to the front of the stack
     * 
     * @param anEntry The data of the new Node
     */
    public void push(T anEntry)
    {
        Node<T> newNode = new Node<T>(anEntry, topNode);
        topNode = newNode;
        size++;
    }
    
    /**
     * Returns the object at the front of the stack
     * 
     * @return The object
     */
    public T peek()
    {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return topNode.getData();
        }
    }
    
    /**
     * Removes then returns the object
     * at the front of the stack
     * 
     * @return The object
     */
    public T pop()
    {
        if (this.isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            T data = topNode.getData();
            topNode = topNode.getNextNode();
            size--;
            return data;
        }
    }
}
