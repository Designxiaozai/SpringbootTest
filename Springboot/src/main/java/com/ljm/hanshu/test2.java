package com.ljm.hanshu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Handler;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test2 {

    public static void main(String[] args) {
        ArrayList<String> list =new ArrayList();
        list.add("222");
        list.add("333");
//      list.stream().filter(Objects::nonNull)
//                .filter(f -> f.equals("222"))
//                .forEach(f->{ System.out.println(f);});

        int [] ar= {1,2,4,5};
        IntStream stream = Arrays.stream(ar);
//        stream.forEach(System.out::println);
//
//        Stream.of(ar).forEach(System.out::println);
        Map<String,Integer> map2 =new HashMap();
        map2.put("2",2);
        map2.entrySet().stream().forEach((k)->{
           System.out.println(k.getKey());
        });
        map2.forEach((k,v)->{
            System.out.println(k
            );
            System.out.println(v);
        });
        list.stream().forEach(System.out::println);
    }
}
