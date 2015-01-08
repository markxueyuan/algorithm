/**
 * Created by Xue on 2015/1/7.
 */

import java.util.Iterator;

public class IStack2<Item> implements Iterable<Item>{

    private Node first;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;

        public boolean hasNext(){
            return current != null;
        }
        public void remove(){}

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }


    }

    public static void main(String[] args){
        IStack2<String> s = new IStack2<String>();

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")) s.push(item);
            else if(!s.isEmpty()) StdOut.println(s.pop() + " ");
        }

        StdOut.println("(" +s.size() + " left on stack)");

        for(String a : s){
            StdOut.println(a);
        }
    }
}
