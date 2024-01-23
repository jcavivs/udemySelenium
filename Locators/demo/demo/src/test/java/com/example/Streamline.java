package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;
import org.testng.Assert;


public class Streamline {
    
 
        @Test // ChromeDriver driver = new ChromeDriver();
        public void streamFilter(){
        ArrayList<String> names = new ArrayList<String>();
        names.add("Albert");
        names.add("Angelica");
        names.add("Anthony");
        names.add("Angela");
        names.add("Balmond");
        names.add("Bae");
        names.add("Baa");
        names.add("Bakekang");
        names.add("Bert");
        names.add("Berting");
        names.add("Enteng");  
        // Long x = names.stream().filter(s-> s.startsWith("B")).count();
        // System.out.println(x);

        Long j = Stream.of("Albert","Angela","Balmond","Bakekang","Bert","Berting")
                    .filter(s->{
                            s.startsWith("B");
                            return true;
                            }).count();

        System.out.println(j);

        names.stream().filter(s->s.startsWith("E")).forEach(s->System.out.println(s));
    }
    
    @Test
    public void mapFilter(){

        // Stream.of("Albert","Angela","Balmond","Bakekang","Bert","Berting")
        //             .filter(s->s.endsWith("t")).map(s->s.toUpperCase())
        //             .forEach(s->System.out.println(s));

        List<String> names = Arrays.asList("Albert","Angela","Bae","Baa","Balmond","Bakekang","Bert","Berting");
        names.stream().filter(s->s.startsWith("B")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    
    }

    @Test
    public void mergingList(){
        ArrayList<String> name1 = new ArrayList<String>();
        name1.add("John");
        name1.add("Clarence");
        name1.add("Vivo");

        ArrayList<String> name2 = new ArrayList<String>();
        name2.add("Deanne");
        name2.add("Aubrey");
        name2.add("San-Antonio");

        Stream<String> newStream = Stream.concat(name1.stream(), name2.stream());
        // newStream.filter(s->s.equalsIgnoreCase("aubrey")).forEach(s->System.out.println(s));
        
        boolean flag= newStream.anyMatch(s->s.equalsIgnoreCase("clarence"));
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect(){
        List<String> collectList = Stream.of("John","Clarence","Vivo","Deanne","Aubrey")
        .filter(s->s.endsWith("e")).map(s->s.toUpperCase()).collect(Collectors.toList());

        System.out.println(collectList.getLast());
    }

    @Test
    public void assignment(){
        List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
        // values.stream().distinct().forEach(s->System.out.println(s));

        //specific index
        // values.stream().distinct().sorted().forEach(s->System.out.println(s));
        
        
        List<Integer> newList = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(newList.get(3));
    }
}
