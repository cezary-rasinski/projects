import java.util.*;
import java.util.stream.Stream;

public class CustomList<T> extends AbstractList<T> {
    class Node{
        T value;
        Node next;
    }
    Node start;
    Node end;

    public CustomList()
    {
        start = end = null;
    }

    public boolean add(T t){
        addLast(t);
        return true;
    }

    @Override
    public T get(int i) {
        if(start == null)
            throw new NoSuchElementException();

        if(size() <= i)
            throw new NoSuchElementException();

        Node temp = start;
        for (int j = 0; j < i; j++){
            temp = temp.next;
        }
        return temp.value;
    }

    @Override
    public int size() {
        if (start == null)
            return 0;
        else {
            int i = 0;
            Node temp = start;
            while(temp != end) {
                temp = temp.next;
                i++;
            }
            return i;
        }
    }

    public void addLast(T value){
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
    }

    public T getLast() {
        if (end == null) {
            throw new NoSuchElementException();
        }
        return end.value;
    }

    public void addFirst(T value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = start;

        if (start == null){
            start = newNode;
            end = newNode;
        } else {
            start = newNode;
        }
    }

    public T getFirst(){
        if (start == null) {
            throw new NoSuchElementException();
        }
        return start.value;
    }

    public T removeFirst() {
        if (start == null) {
            throw new NoSuchElementException();
        }
        T startValue = start.value;
        if(start == end) {
            start = null;
            end = null;
            return startValue;
        } else {
            start = start.next;
            return startValue;
        }
    }

    public T removeLast() {
        if (start == null) {
            throw new NoSuchElementException();
        }
        T endValue = end.value;
        if (start == end) {
            start = null;
            end = null;
            return endValue;
        } else {
            Node temp = start;
            while (temp.next != end) {
                temp = temp.next;
            }
            temp.next = null;
            end = temp;
        }
        return endValue;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = start;

            @Override
            public boolean hasNext(){
                return temp != null;
            }

            @Override
            public T next() {
                T value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }

    public Stream<T> stream() {
        Stream.Builder<T> streamBuilder = Stream.builder();

        for(T item : this) {
            streamBuilder.accept(item);
        }

        return streamBuilder.build();
    }

    public static <T> List<T> filterByClass(List<?> list, Class<T> clas) {
        List<T> result = new ArrayList<>();
        for (Object obj : list) {
            if (clas.isInstance(obj)) {
                result.add(clas.cast(obj));
            }
        }
        return result;
    }
}
