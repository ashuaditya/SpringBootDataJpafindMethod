package com.app.runner;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repo.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	public void run(String... args) throws Exception {
		repo.findByProdCode("A").forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCodeIs("A").forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCodeEquals("A").forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCostLessThan(3.2).forEach(System.out::println);
		repo.findByProdCostLessThanEqual(5.2).forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCodeOrProdCostLessThan("E", 5.2).forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCodeIsNotNull().forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCodeLike("A").forEach(System.out::println);
		repo.findByProdCodeContaining("B").forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCostBetween(4.5, 7.5).forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCodeIn(Arrays.asList("A", "B")).forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdCostOrderByProdCost(5.2).forEach(System.out::println);
		System.out.println("===============================");
		repo.findByProdIdOrProdCodeIsNotNullOrProdCostLessThanOrderByProdCodeDesc(15, 5.6).forEach(System.out::println);
		System.out.println("===============================");
		
		
	}

}
