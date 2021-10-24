package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Programa {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 3, 6, 7, 8, 9);

        Stream<Integer> stream1 = lista.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(stream1.toArray()));

        Stream<String> stream2 = Stream.of("Maria", "João", "Carlos");
        System.out.println(Arrays.toString(stream2.toArray()));

        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(stream3.limit(10).toArray()));

        // Fibonacci 1
        Stream.iterate(new Integer[]{0, 1}, t -> new Integer[]{t[1], t[0] + t[1]}).limit(10).forEach(x -> System.out.println("{" + x[0] + "," + x[1] + "}"));

        // Fibonacci 2
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(x -> System.out.println(x));

        // Fibonacci 3
        String collect = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .map(String::valueOf) // convert to string
                .collect(Collectors.joining(", "));

        System.out.println("collect: " + collect);
    }
}
