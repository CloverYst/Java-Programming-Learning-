package com.clover.lambdas;

import java.util.List;
import java.util.function.*;

public class LambdaDemo {
    /*public static void show(){
        greet(new ConsolePrinter());
    }*/

    //
    public LambdaDemo(String message){

    }

    //Lambda Expression Variable Capture
    public static String prefix = "-";

    //Method Reference
    public static void print(String message){
        System.out.println(message);
    }


    //Anonymous Inner Class: this Class dont have name
    public static void show(){
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        String prefixx = "-";
        //Lambda Expression
        greet((String message)->{
            System.out.println(prefix+message);
        });
        //actually some are not necessary
        greet(message -> System.out.println(prefixx+message));

        //convert Lambda Expression to Method Reference
        //Class/Object::Method
        greet(System.out::println);
        greet(LambdaDemo::print);
        //if the print method is not static need to create a new instance like var demo =new LambdaDemo();
        //greet(demo::print);
        //if u wanna use a constructor to pass a value
        greet(LambdaDemo::new);

        //Consumer Interface: just has one method accept(T t) so it's a functional interface can convert to Lambda Expression
        List<Integer> list = List.of(1,2,3);
        //for iterate the list there are two ways
        //Imperative programming
        for (var item: list)
            System.out.println(item);
        //Declarative programming
        list.forEach(item -> System.out.println(item));

        //Chaining Consumer: run many operations in sequence
        List<String> list1 = List.of("a","b","c");
        Consumer<String> print = item-> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());
        list1.forEach(print.andThen(printUpperCase).andThen(print));

        //The Supplier Interface: has one get() method is functional interface no input but return value
        //Supplier<Double> getRandom = ()->{return Math.random();};
        Supplier<Double> getRandom = Math::random;
        var random = getRandom.get();
        System.out.println(random);

        //The Function Interface
        Function<String, Integer> map = str -> str.length();
        var length = map.apply("sky");
        System.out.println(length);

        //Composing Functions
        //"key:value" -> "key=value" -> "{key=value}"
        Function<String, String> replaceColon = str -> str.replace(",",":");
        Function<String, String> addBraces = str -> "{" + str + "}";
        var result = replaceColon.
                andThen(addBraces).
                apply("key,value");
        System.out.println(result);
        //another way
        var result1 = addBraces.compose(replaceColon).apply("key,value");
        System.out.println(result1);

        //The Predicate Interface : method test(T t)
        Predicate<String> isLongerThan5 = str ->str.length() > 5;
        var theResult = isLongerThan5.test("sky");
        System.out.println(theResult);
        //Combining Predicates
        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");
        Predicate<String> hasLeftAndRight = hasLeftBrace.and(hasRightBrace);
        //hasLeftBrace.or(hasRightBrace)   hasLeftBrace.negate()
        var r= hasLeftAndRight.test(result1);
        System.out.println(r);

        //The BinaryOperator Interface
        BinaryOperator<Integer> add = (a,b) -> a+b;
        //var ab= add.apply(1,2);
        Function<Integer,Integer> square = a -> a*a;
        var result3= add.andThen(square).apply(1,2);
        System.out.println(result3);

        //The UnaryOperator Interface
        UnaryOperator<Integer> sq = n ->n*n;
        UnaryOperator<Integer> increment = n->n+1;
        var result4= increment.andThen(sq).apply(2);
        System.out.println(result4);


    }

    public static void greet(Printer printer){
        printer.print("Hello world");
    }
}
