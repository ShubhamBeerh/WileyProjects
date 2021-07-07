package com.Test.testques;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.*;
public class Streams {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//1) IntStream
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();
		System.out.println();
		
		//2) Skip Function
		IntStream.range(1, 10).skip(5).forEach(x -> System.out.print(x+ " "));
		System.out.println();
		System.out.println();
		
		//3)Sum Function inside sysout
		System.out.println(IntStream.range(1,10).sum());
		System.out.println();
		System.out.println();
			
		//4)Stream of Sorted and findFirst
		Stream.of("Ava","Aneri","Alberto").sorted().findFirst().ifPresent(System.out::println);
		System.out.println();
		System.out.println();
		
		//5)Stream from Array,sort,filter and then print
		String[] names = {"Shubham","Ishika","Arjun","Arpit","Priyansha","Kajal"};
		Arrays.stream(names).filter(x->x.contains("s")).sorted().forEach(System.out::println);
		System.out.println();
		System.out.println();
		
		//6)Average of squares
		int[] nums = {4,6,5,7,8,6,3};
		Arrays.stream(nums).map(x->x*x).average().ifPresent(System.out::print);
		System.out.println();
		System.out.println();
		
		//7)Stream from List,filter and print
		List<String> list = Arrays.asList(names);
		list.stream().map(String::toLowerCase).filter(s->s.startsWith("a")).forEach(System.out::println);
		//Second Method
		System.out.println("Second Method");
		list.stream().map(s->s.toLowerCase()).filter(s->s.startsWith("a")).forEach(System.out::println);
		System.out.println();
		System.out.println();
		
		//8)Stream rows from textfile, sort, filter and print
		Stream<String> bands = Files.lines(Paths.get("/Users/shubhambeerh/Desktop/Bands.txt"));
		bands.sorted().filter(s-> s.length()>6).forEach(System.out::println);
		bands.close();
		System.out.println();
		System.out.println();
		
		//9)Stream rows from a text file and save them into a list
		List<String> bandList = Files.lines(Paths.get("/Users/shubhambeerh/Desktop/Bands.txt"))
				.filter(s->s.contains("Day"))
				.sorted(Comparator.reverseOrder()) //Sorts in reverse order, it is an inbuilt method
				.collect(Collectors.toList());
		bandList.stream().forEach(System.out::println);
		System.out.println();
		System.out.println();
		
		//10)Stream rows from CSV File and count
		Stream<String> rows = Files.lines(Paths.get("/Users/shubhambeerh/Desktop/Table.txt"));
		int count = (int)rows.map(x->x.split(",")).filter(x->x.length==3).count();
		System.out.println(count);
		rows.close();
		System.out.println();
		System.out.println();
		
		//11)Stream rows from CSV file and extract data
		Stream<String> rowsExtract = Files.lines(Paths.get("/Users/shubhambeerh/Desktop/Table.txt"));
		rowsExtract.map(x->x.split(","))
			.filter(x->x.length==3)
			.filter(x->Integer.parseInt(x[1])>15)
			.forEach(x->System.out.println(x[0]+"::"+x[1]+"::"+x[2]));
		System.out.println();
		System.out.println();
		
		
		//12)Stream rows from CSV and store data in HashMap
		Stream<String> rowsToMap = Files.lines(Paths.get("/Users/shubhambeerh/Desktop/Table.txt"));
		Map<String,Integer> map = new HashMap<String,Integer>();
		map=rowsToMap.map(x->x.split(","))
			.filter(x->x.length==3)
			.filter(x->Integer.parseInt(x[1])>=15)
			.collect(Collectors.toMap(
					x->x[0],
					x->Integer.parseInt(x[1])
					));
				
		for(Map.Entry<String,Integer> hash: map.entrySet()) {
			System.out.println(hash.getKey()+"----"+hash.getValue());
		}
		System.out.println();
		System.out.println();
		
		//Random Lambda Function Try
		Covid covid = () -> System.out.println("I am here");
		covid.here();
		System.out.println();
		System.out.println();
		
		//13) Reduction - sum
		double total = Stream.of(6.6,7.0,5.2,2.8).reduce(0.0,(Double a,Double b)->a+b);
		System.out.println("Normal Stream : "+total);
		System.out.println("------");
		double total2 = Stream.of(6.6,7.0,5.2,2.8).reduce(0.0,Double::sum);
		System.out.println("Stream with Operator : "+total2);
		System.out.println("------");
		System.out.println();
		System.out.println();
		
		//14) Summary Statistics
		IntSummaryStatistics statistics = IntStream.of(7,6,5,3,4,2,1,8).summaryStatistics();
		System.out.println(statistics);
	}

}
