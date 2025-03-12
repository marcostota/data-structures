package stack;

public class StackLinkList {

    private static Node first = null;
    static StackLinkList list = new StackLinkList();

    public static void push(int data){
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
    }

    public static void pop(){
        Node temp = first;
        first = first.next;
        System.out.println("Removed element from the stack" + temp.data);
    }

    public static void printList(StackLinkList list){
        Node currentNode = list.first;
        System.out.println("Linked List");
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void main (String[] args) {
        list.push(4);
        list.push(6);
        list.push(1);
        printList(list);
        list.pop();
        printList(list);
    }
}
