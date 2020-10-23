package 友富作业;

public class LinkedListTest {


        public static void main(String[] args)
        {
            LinkList theList = new LinkList();
            theList.insertFirst(7);
            theList.insertFirst(6);
            theList.insertFirst(5);
            theList.insertFirst(4);
            theList.insertFirst(3);
            theList.insertFirst(2);
            theList.insertFirst(1);

            theList.displayList();
            System.out.println("delete(4)");
            theList.delete(4);

            System.out.println("delete(16)");
            theList.delete(16);

            theList.displayList();

            System.out.println("insertAfter(2, 12)");
            theList.insertAfter(2, 12);

            System.out.println("insertAfter(4, 14)");
            theList.insertAfter(4, 14);

            System.out.println("insertAfter(7, 17)");
            theList.insertAfter(7, 17);

            theList.displayList();

            System.out.println("insertLast(20)");
            theList.insertLast(20);

            theList.displayList();

        }

}
