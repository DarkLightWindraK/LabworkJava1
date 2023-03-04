public class Main {
    public static void main(String[] args) {
       var mylist = new CustomLinkedList<String>();
       mylist.add("Throw");
       mylist.add("me");
       mylist.add("some");
       mylist.add("numbers");

       System.out.println(mylist.get(0));
    }
}