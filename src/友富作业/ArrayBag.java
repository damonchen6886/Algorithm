package 友富作业;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayBag implements Bag {

    int capacity;
    int index;
    HashMap<Object,Integer> bag;
//    ArrayList<Object> m
    public ArrayBag(int size){
        this.bag = new HashMap<>();
        capacity =  size;

    };

    @Override
    public boolean add(Object item) {
        if(this.bag.size() < capacity){
            this.bag.put(item,index++);
            return true;
        }
        // capacity is full;
        return false;

    }

    @Override
    public boolean remove(Object item) {
        if(this.bag.remove(item) == null){
            System.out.println(item + " not found!");
            return false;
        }
        return true;


    }

    @Override
    public boolean contains(Object item) {
        return this.bag.containsKey(item);
    }

    @Override
    public boolean containsAll(Bag other) {
        for(Object key : ((ArrayBag) other).bag.keySet()){
            if(!this.bag.containsKey(key)){
                return false;
            }
        }
        return true;

    }


    @Override
    public int numItems() {
        return this.bag.size();
    }

    @Override
    public Object grab() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int size = this.bag.size();
        Object[] arr = new Object[this.bag.size()];
        for(Object key: this.bag.keySet()){
            arr[--size]  = key;
        }
        return arr;
    }

}
