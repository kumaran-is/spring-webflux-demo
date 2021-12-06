package com.demo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {


    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("springwebfux")
        	//	.then(Mono.error(new RuntimeException("Some Exception")))
                .log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }

   @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("Angular", "Spring Boot", "Spring Web Flux", "blockchain")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
                .concatWithValues("reactjs")
                .log();

        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    } 
}
