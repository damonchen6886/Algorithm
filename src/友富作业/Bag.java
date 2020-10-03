package 友富作业;

public interface Bag
{
    boolean add(Object item);
    boolean remove(Object item);
    boolean contains(Object item);
    boolean containsAll(Bag other);
    int numItems();
    Object grab();
    Object[] toArray();
}


