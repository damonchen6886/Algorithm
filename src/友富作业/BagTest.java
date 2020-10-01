package 友富作业;

/**
 * @author psychocoder
 */
public class BagTest {

    public static void main(String[] args) {

        int initSize = 15;

        /**
         * Create an instance of a class Bag and initialize the constructor with
         * an initial value.
         */
        ArrayBag bag = new ArrayBag(initSize);

        /**
         * Get the capacity of the Bag
         */
        System.out.println("Capacity (No. of items the bag can hold) :"
                + initSize);
        /**
         * Insert some values.
         */
        System.out.println("\nAdding 4 elements");
        bag.add(12);
        bag.add(212);
        bag.add(1);
        bag.add(123);
        printBag(bag);

        /**
         * Insert some more values.
         */
        System.out.println("\nAdding1 4 elements");
        bag.add(142);
        bag.add(12);
        bag.add(19);
        bag.add(131);
        printBag(bag);
       
        // Remove element
        int key=17;
        System.out.println("\nRemoving "+key);
        bag.remove(key);

        key=12;
        System.out.println("\nRemoving "+key);
        bag.remove(key);
            
        printBag(bag);

        System.out.println("\nNew bag");
        ArrayBag newBag = new ArrayBag(initSize);
        newBag.add(1);
        newBag.add(19);
        newBag.add(12);        
        printBag(newBag);
        
        if (bag.containsAll(newBag))
            System.out.println("Bag contains all elements of newBag");
        else
            System.out.println("Bag does not contain all elements of newBag");
        System.out.println("\nAdding an element to newBag");
        newBag.add(24);
        printBag(newBag);
        if (bag.containsAll(newBag))
            System.out.println("Bag contains all elements of newBag");
        else
            System.out.println("Bag does not contain all elements of newBag");   
    }
    
    public static void printBag(ArrayBag bag)
    {
        System.out.println("Number of elements in the bag : "
                + bag.numItems());
        Object[] elements = bag.toArray();
        for(int i=0; i<bag.numItems(); i++)
            System.out.print(elements[i]+" ");
        System.out.println();
    }
}
