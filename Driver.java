import java.util.NoSuchElementException;

public class Driver{

    public static void main(String[] args){
        LinkedList<String> list1 = new LinkedList<String>(new String[]{"1","2","3","4","5","6"});
        System.out.println(list1);
        list1.add(0,"5");
        list1.add(0,"25");
        System.out.println(list1);
        list1.remove("25");
        System.out.println(list1);
        list1.remove("6");
        list1.remove();
        list1.remove(3);
        list1.remove(2);
        list1.remove(1);
        System.out.println(list1);
        list1.add(1,"6");
        System.out.println(list1);
        System.out.println(list1.getHead().getData());
        try{
            list1.remove("1000");
        }
        catch(NoSuchElementException e){
            System.out.println("Could not remove!");
        }
        System.out.println(list1);
        for(String s : list1){
            System.out.println(s);
        }
        try{
            System.out.println(list1.contains(null));
        } catch (IllegalArgumentException e){
            System.out.println("Input to contains was null!!");
        }
        System.out.println("---");
        System.out.println(list1.contains("25"));
        System.out.println(list1.contains("1000"));
        list1.clear();
        System.out.println(list1.isEmpty());
        System.out.println(list1.contains("1"));
        for(String s : list1){
            System.out.println(s);
        }
        try{
            list1.set(0,"182");
        } catch(IndexOutOfBoundsException e){
            System.out.println("Cannot call set when list is empty");
        }
        list1.add(0,"12");
        System.out.println(list1.size());
        System.out.println(list1.get(0));
        System.out.println(list1);
        list1.set(0,"25");
        System.out.println(list1);
        System.out.println(list1.isEmpty());
        try{
            System.out.println(list1.get(5));
        } catch(IndexOutOfBoundsException e){
            System.out.println("Can't get an out of index element");
        }
        System.out.println(list1.get(0));
        try{
            System.out.println(list1.set(2,"12"));
        } catch(IndexOutOfBoundsException e){
            System.out.println("Can't call set on indices that don't exist");
        }
    }
}