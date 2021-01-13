package com.clover.project;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightService {
    public CompletableFuture<Quote> getQuote(String site){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Getting a Quote from "+ site);
            var random = new Random();
           LongTask.simulate(1000+random.nextInt(2000));

           var price = 100 + random.nextInt(10);
           return new Quote(site,price);
        });
    }
    public Stream<CompletableFuture<Quote>> getQuotes(){
        var sites = List.of("site1", "site2", "site3");

        return  sites.stream()
                .map(site->getQuote(site));
        //List<CompletableFuture<Quote>>
                //.collect(Collectors.toList());//this is redundant
    }

}
