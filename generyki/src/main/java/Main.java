import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new CustomList<>();
        list1.add(3);
        list1.add(9);
        list1.add(6);

        List<Integer> list2 = list1.stream()
                .filter((item) -> item > 5)
                .collect(Collectors.toList());

        for(Integer i : list2) {
            System.out.println(i);
        }

        List<Object> list3 = new CustomList<>();
        list3.add(1);
        list3.add(14);
        list3.add("gdfsaefw");
        list3.add("HI");
        list3.add(6.12);

        List<Integer> integers = CustomList.filterByClass(list3, Integer.class);
        System.out.println(integers);

        List<String> strings = CustomList.filterByClass(list3, String.class);
        System.out.println(strings);

    }
}