/**
 * Created by Xue on 2015/1/7.
 */

import java.util.Iterator;

public class IBag<Item> implements Iterable<Item> {

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

    public void add(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
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
        IBag<Integer> b = new IBag<Integer>();
        int a = 3;
        b.add(a);
        b.add(a);
        b.add(a);
        b.add(2);
        for(int s : b){
            StdOut.println(s);
        }

    }
}
