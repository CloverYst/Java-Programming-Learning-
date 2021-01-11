package com.clover.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StremasDemo {
    public static void show(){
        List<Movie> movies = List.of(
                new Movie("b",10, Genre.THRILLER),
                new Movie("b",10, Genre.ACTION),
                new Movie("a",30, Genre.COMEDY),
                new Movie("c",20, Genre.COMEDY)
        );

        int count = 0;
        //Imperative Programming: how
        for (var movie:movies)
            if(movie.getLikes()>10)
                count++;


        //Declarative (Functional) Programming: what
        var count2 = movies.stream()
                .filter(movie -> movie.getLikes()>10)
                .count();

        //Creating Streams
        Collection<Integer> x =new ArrayList<>();
        x.stream();

        var list = new ArrayList<>();
        list.stream();

        int[] numbers = {1,2,3};
        Arrays.stream(numbers);

        Stream.of(1,2,3);

        var stream = Stream.generate(()->Math.random());
        stream.limit(3)
                .forEach(n-> System.out.println(n));

        Stream.iterate(1,n->n+1)
                .limit(10)
                .forEach(n-> System.out.println(n));


        //Mapping Elements
        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(name-> System.out.println(name));

        movies.stream()
                .mapToInt(movie->movie.getLikes())
                .forEach(like -> System.out.println(like));

        //flatMap(): Stream<List<X>> -> Stream<X>
        var streamm = Stream.of(List.of(1,2,3),List.of(4,5,6));
        //streamm.forEach(list1-> System.out.println(list1));  //[1,2,3] [4,5,6]
        streamm.flatMap(list1->list1.stream())
                .forEach(n-> System.out.println(n));

        //Filter Elements
        Predicate<Movie> isPopular = movie -> movie.getLikes()>10;

        movies.stream()
                .filter(isPopular)
                .forEach(m-> System.out.println(m.getTitle()));

        //Slicing Streams
        //limit(n) intermedia
        movies.stream()
                .limit(2)
                .forEach(movie -> System.out.println(movie.getTitle()));
        //skip(n)
        movies.stream()
                .skip(2)
                .forEach(movie -> System.out.println(movie.getTitle()));

        //1000movies
        //10 movies per page
        //get 3rd page
        //skip(20) = skip( (page-1) * pageSize)
        //limit(10) = limit(pageSize)

        //takeWhile() : stop when meet the first false
        movies.stream()
                .takeWhile(m->m.getLikes()<30)
                .forEach(movie -> System.out.println(movie.getTitle()));
        //dropWhile()
        movies.stream()
                .dropWhile(movie -> movie.getLikes()<30)
                .forEach(movie -> System.out.println(movie.getTitle()));


        //Sorting Streams
        //if use movies.stream().sorted(argument is comparator, then need to add implements Comparable<Movie> after Movie class
        //more flexible way
        movies.stream()
                .sorted((a,b)->a.getTitle().compareTo(b.getTitle()))
                .forEach(movie -> System.out.println(movie.getTitle()));
        //more simple way
        movies.stream()
                .sorted(Comparator.comparing(m->m.getTitle()))
                .forEach(m-> System.out.println(m.getTitle()));
        //method reference
        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(m-> System.out.println(m.getTitle()));
        //reversed()
        //.sorted(Comparator.comparing(Movie::getTitle).reversed())


        //Getting Unique Elements
        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);

        //Peeking Elements: used to check the operation trouble which get the output of each operation
        movies.stream()
                .filter(m->m.getLikes()>10)
                .peek(m-> System.out.println("filtered:"+m.getTitle()))
                .map(t->t.getTitle())
                .peek(t-> System.out.println("mapped:"+t))
                .forEach(System.out::println);



        //Simple Reduces
        //Terminate Operation: which means cannot add operations after it
        //count()
        var resultCount = movies.stream().count();
        System.out.println(resultCount);
        //match: anyMatch() allMatch() noneMatch()
        var resultAnyMatch = movies.stream().anyMatch(movie -> movie.getLikes()>10);
        System.out.println(resultAnyMatch);
        var resultAllMatch = movies.stream().anyMatch(movie -> movie.getLikes()>10);
        System.out.println(resultAllMatch);
        var resultNoneMatch = movies.stream().anyMatch(movie -> movie.getLikes()>10);
        System.out.println(resultNoneMatch);
        //findFirst() findAny()
        var resultFindFirst = movies.stream().findFirst().get();
        System.out.println(resultFindFirst.getTitle());
        //max(comparator) min(comparator)
        var resultMax= movies.stream().max(Comparator.comparing(Movie::getLikes)).get();
        System.out.println(resultMax.getTitle());

        //reduce() method: we can use general purpose reduction
        Optional<Integer> sum1= movies.stream()
                .map(m->m.getLikes())
                .reduce(Integer::sum);
        System.out.println(sum1.orElse(0));

        Integer sum2 = movies.stream()
                .map(m->m.getLikes())
                .reduce(0,Integer::sum);
        System.out.println(sum2);


        //Collectors: collect data from the stream into a data structure
        //toList()
        var r1= movies.stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.toList());

        //toSet()
        var r2= movies.stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.toSet());

        //toMap()
        var r3= movies.stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.toMap(Movie::getTitle,Movie::getLikes));
        System.out.println(r3);

        //summmingInt
        var r4 = movies.stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.summingInt(Movie::getLikes));
        System.out.println(r4);
        //summarizingInt
        var r5 = movies.stream()
                .filter(m->m.getLikes()>10)
                .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println(r5);
        //joining
        var r6 = movies.stream()
                .filter(m->m.getLikes()>10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(","));
        System.out.println(r6);



        //Grouping Elements
        var resultByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println(resultByGenre);
        var resultByCounting = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,Collectors.counting()));
        System.out.println(resultByCounting);
        var resultByMapping = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(
                                Movie::getTitle,
                                Collectors.joining(","))));
        System.out.println(resultByMapping);


        //Partitioning Elements
        var resultByPartition = movies.stream()
                .collect(Collectors.partitioningBy(m->m.getLikes()>20,
                        Collectors.mapping(Movie::getTitle,
                                Collectors.joining(","))));
        System.out.println(resultByPartition);

        //Primitive Type Streams
        IntStream.generate(()->1);
        //IntStream.iterate()
        IntStream.of(1,2,3);
        IntStream.range(1,5)
                .forEach(System.out::println);
        IntStream.rangeClosed(1,5)
                .forEach(System.out::println);


    }
}
