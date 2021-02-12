import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class linkedList {


    public class Node {
        int data;
        Node next;
        Node previous;

        public Node(){
            data = 0;
        }
        public Node(int data){
            this.data = data;
        }

    }
    Node head, tail = null;

    public void addNode(int data){
        Node n = new Node(data);
        n.data = data;
        n.next = null;

        Node current = head;
        Node temp;

        if(head == null){
            head = tail = n;
            tail.next = null;
        }
        else if(head != null){
            if (head == tail){
                temp = head;

                 tail= n;
                head.next = tail;
                 tail.previous = head;

            }
            else{
                    temp = tail;
                    tail.next = n;
                    tail = n;
                    tail.previous = temp;

            }
        }
        //System.out.println("Last Data: "+tail.data);
    }
    public void listDisplay(){
        Node current = head;

        if(current == null){
            System.out.println("List is empty");
        }else{
            while(current != null){
                System.out.println(current.data+" ");
                current = current.next;
            }
        }

    }
    public int getList(int index){
        int da = 0;
        Node current = head;
    if(index == 0){
        da = current.data;
    }
        for(int i = 0; i < index; i++){
            current = current.next;
            da = current.data;
        }
        return da;
    }

    public void removeSmallest() {
        Node current = head;
        int min = current.data;
        int index = 0;
        int count = 0;
        if (!nodeisEmpty()) {
            while (current != null) {
                if (current.data < min && current.data != min) {
                    min = current.data;
                    index = count;
                }
                current = current.next;
                count++;
            }
            deleteNode(index);
        }
        else{
            System.out.println("List is empty");
        }
        System.out.println("Smallest value is "+min+" in index "+index);
    } // opgave 2 s.1039
    public void set(int index, int value){
        Node n = new Node(value);

        Node current = head;
        Node temp;

        if(index == 0){
            current = head;
            head = n;
            head.next = current;
        }
        else {
            for(int i = 0; i < index-1; i++){
                current = current.next;
            }
            temp = current.next;
            current.next = n;
            current.next.next = temp;
        }

    } //opgave 1 s.1039
    public void startToLast(){
        Node current = head.next;
        Node temp = null;

        if(current != null && current.next != null){
            temp = current.previous;
            temp.next = null;
            temp.previous = null;

            head = current;
            //head is now head.next, and the old head is in temp
            System.out.println("this is new head data "+head.data);
            current = tail;
            tail = temp;
            tail.previous = current;
            current.next = tail;




            System.out.println("This should be the new tail "+tail.data);

        }else System.out.println("no modifications done!");

    } //opgave 3 s.1039

    public void sortNode(){ //opgave 5s.1039 kunne ikke finde ude af den

    }
    public void switchPairs(){
        Node current = head;
        Node temp;
        int size = listSize();

        if(size % 2 == 0){
            while(current != null){
                temp = current;
                current = temp.next;
                current.next = temp;
                System.out.println(temp.toString());
                current = current.next;
                temp = null;
            }
        }

    }

    public void deleteNode(int index){
        Node current = head;
        Node temp = null;

        if(index == 0){
            temp = head;
            head = temp.next;

        }
        else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            temp = current.next; //current is pre index, and current.next is index
            current.next = temp.next; //on index place, temp,next without the first data
        }
        System.out.println("Data in index: "+index+" was succesfully removed "+temp.data);
    }
    public boolean nodeisEmpty(){
        Node current = head;
        boolean flag = true;
        if(head == null){flag = true;}
        else flag = false;

        return flag;
    }
    public int listSize(){
        Node current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    public boolean containsData(int i){
        Node current = head;

       boolean flag = false;
        while(current != null){
            if(current.data == i){
                flag = true;
            }
            current = current.next;
        }
        return flag;
    }
    public int getData(int index){
        Node current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }
}
