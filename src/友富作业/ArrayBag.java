package 友富作业;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayBag implements Bag {

    int capacity;
    List<Object> bag;
    public ArrayBag(int size){
        this.bag = new ArrayList<>();
        capacity =  size;

    };

    @Override
    public boolean add(Object item) {
        if(this.bag.size() < capacity){
            return this.bag.add(item);
        }
        // capacity is full;
        return false;

    }

    @Override
    public boolean remove(Object item) {
        if(!this.bag.remove(item)){
            System.out.println(item + " not found!");
            return false;
        }
        return true;


    }

    @Override
    public boolean contains(Object item) {
        for(int i = 0 ; i < bag.size();i++){
            if(this.bag.get(i).equals(item)){
                return true;
            }
        }
        return false;
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
        for(int i = 0; i < size;i++){
            arr[i]  = this.bag.get(i);
        }
        return arr;
    }


    public boolean containsAll(ArrayBag b){
        HashMap<Integer, Object> bagMap = new HashMap<>();
        for(int i = 0; i< this.bag.size();i++){
            bagMap.put(i,this.bag.get(i));
        }
        for(int i= 0; i < b.bag.size();i++){
            if(!bagMap.containsValue(b.bag.get(i))){
                return false;
            }
        }
        return true;
    }

}
