package 友富作业;

class Link
{
    public int iData;              // data item
    public Link next;              // next link in list
    // -------------------------------------------------------------
    public Link(int id)             // constructor
    {
        iData = id;                 // initialize data
        next = null;
    }                           
    // -------------------------------------------------------------
    public void displayLink()      // display ourself
    {
        System.out.print(iData +" ");
    }
}  // end class Link
public class LinkList
{
    private Link first;            // ref to first item on list
    // -------------------------------------------------------------
    public LinkList()              // constructor
    { 
        first = null; 
    }           // no items on list yet
    // -------------------------------------------------------------
    public boolean isEmpty()       // true if list is empty
    { 
        return (first==null); 
    }
    // -------------------------------------------------------------
    public void insertFirst(int dd) // insert at start of list
    {                           // make new link
        Link newLink = new Link(dd);
        newLink.next = first;       // newLink --> old first
        first = newLink;            // first --> newLink
    }
    // -------------------------------------------------------------
    public Link deleteFirst()      // delete first item
    {                           // (assumes list not empty)
        Link temp = first;          // save reference to link
        first = first.next;         // delete it: first-->old next
        return temp;          // return deleted link
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
    // -------------------------------------------------------------
    public Link find(int key){
        Link temp = first;

        while(temp!= null){
            if(temp.iData == key){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void insertAfter(int afterKey, int newKey){
        Link newLink = new Link(newKey);
        Link cur = find(afterKey);
        if(cur == null){
            return;
        }
        Link next = cur.next;
        cur.next = newLink;
        newLink.next =next;
        return;
    }

    public Link delete(int key){
        Link cur = find(key);
        if(cur == null){
            return null;
        }
        Link prev = first;
        while(prev.next != cur){
            prev = prev.next;
        }
        prev.next = cur.next;
        return cur;

    }
    public Link getLast(){
        Link temp = first;
        while(temp.next != null){
            temp = temp.next;
        }
        return temp;

    }

    public void insertLast(int key){
        Link last = getLast();
        Link add = new Link(key);
        last.next = add;
        add.next = null;
        return;

    }
}  // end class LinkList

