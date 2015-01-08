/**
 * Created by Xue on 2015/1/7.
 */

import java.util.Iterator;

public class IQueue<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size() {return N;}

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
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
        IQueue<String> q = new IQueue<String>();

        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.println(q.dequeue() + " ");
        }

        StdOut.println("(" + q.size() + " left on queue)");

        for(String s :q){
            StdOut.println(s);
        }
    }
}
