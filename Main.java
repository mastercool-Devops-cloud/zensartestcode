package Java8Program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	public static void main(String args[]) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		
		//List of employee sorted by id;
		List<Employee> op1 = employeeList.stream().sorted(Comparator.comparing(Employee :: getId)).collect(Collectors.toList());
		//op1.forEach(System.out::println);
		
		//List of employee sorted by age then salary;
		List<Employee> op2 = employeeList.stream().sorted(Comparator.comparing(Employee :: getAge).thenComparing(Employee :: getSalary)).collect(Collectors.toList());
		op2.forEach(System.out::println);
		
		//How many male and female employees are there in the organization?
		Map<String, Long> op3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(op3);
		
		//Print the name of all departments in the organization?
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(x-> System.out.println(x));
		
		//What is the average age of male and female employees?
		Map<String, Double> op4 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
		System.out.println(op4);
		
		//What is the average salary of male and female employees?
		Map<String, Double> op5 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(op5);
		
		//Get the details of highest paid employee in the organization?
		Optional<Employee> op6 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println(op6.get().getName());
		
		//Get the names of all employees who have joined after 2015?
		List<String> op7 = employeeList.stream().filter(x -> x.getYearOfJoining()>2015).map(x-> x.getName()).collect(Collectors.toList());
		System.out.println(op7);
		
		//Count the number of employees in each department?
		Map<String,Long> op8 = employeeList.stream().collect(Collectors.groupingBy(Employee :: getDepartment ,Collectors.counting()));
		System.out.println(op8);
		
		//What is the average salary of each department?
		Map<String, Double> op9 = employeeList.stream().collect(Collectors.groupingBy(Employee :: getDepartment , Collectors.averagingDouble(Employee :: getSalary)));
		System.out.println(op9);
		
		//Get the details of youngest male employee in the each development department?
		Map<String,Optional<Employee>> op10 = employeeList.stream().filter(x -> x.getGender().equalsIgnoreCase("male")).collect(Collectors.groupingBy(Employee :: getDepartment, Collectors.minBy(Comparator.comparing(Employee:: getAge))));
		System.out.println(op10);
		
		//Get the details of youngest male employee in the product development department?
		Optional<Employee> op11 = employeeList.stream().filter(x -> x.getGender().equalsIgnoreCase("male") && x.getDepartment().equalsIgnoreCase("Product Development")).min(Comparator.comparing(Employee::getAge));
		System.out.println(op11);
		
		Set<Entry<Boolean, List<Employee>>> entrySet = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25)).entrySet();
				         
				for (Entry<Boolean, List<Employee>> entry : entrySet) 
				{
				             
				    if (entry.getKey()) 
				    {
				        System.out.println("Employees older than 25 years :");
				    }
				    else
				    {
				        System.out.println("Employees younger than or equal to 25 years :");
				    }
				             
				             
				    List<Employee> list = entry.getValue();
				             
				    for (Employee e : list) 
				    {
				        System.out.println(e.getName());
				    }
				}
		
		
		
		
		
		
		
		
		
		//Write a program to find the no. occurance of charter in a string an pring using map (key keyset and java 8)
				//Write a program to find the no. occurance of word in a sentance print usong map(by entry set and java 8)

		/*
		 * List<Employee> e1 =
		 * empList.stream().sorted(Comparator.comparing(Employee::getEmpid)).collect(
		 * Collectors.toList()); System.out.println(e1);
		 * 
		 * List<Employee> e2 =
		 * empList.stream().sorted(Comparator.comparing(Employee::getEmpid).
		 * thenComparing(Employee::getEmpsalary)).collect(Collectors.toList());
		 * System.out.println(e2);
		 * 
		 * String s1 = "GeeksforGeeksG"; char[] c = s1.toCharArray();
		 * Map<Character,Integer> map = new HashMap<>(); for(Character ch: c) {
		 * if(map.containsKey(ch)) { map.put(ch, map.get(ch)+1); }else { map.put(ch, 1);
		 * } }
		 * 
		 * Iterator<Entry<Character,Integer>> it = map.entrySet().iterator();
		 * while(it.hasNext()) { Entry<Character,Integer> entry = it.next();
		 * System.out.println(entry.getKey()+" : "+entry.getValue()); }
		 * 
		 * String s2 = "Geeks for Geeks to learn Geeks for Geeks to you"; String[] array
		 * = s2.split(" "); Map<String, Integer> maps = new HashMap<>(); for(String ss :
		 * array) { if(maps.containsKey(ss)) { maps.put(ss, maps.get(ss)+1); }else {
		 * maps.put(ss, 1); } }
		 * 
		 * Iterator<Entry<String,Integer>> its = maps.entrySet().iterator();
		 * while(its.hasNext()) { Entry<String,Integer> entry = its.next();
		 * System.out.println(entry.getKey()+" : "+entry.getValue()); }
		 * 
		 * List<String> list = Arrays.asList("abe","","bc","efg","abcd","","jkl"); Long
		 * countEmpty = list.stream().filter(s->s.length()==0).count();
		 * System.out.println(countEmpty); List<String> groupSameLengthStrig =
		 * list.stream().filter(s->s.length()==3).collect(Collectors.toList());
		 */
				
				
		List<Integer> list = Arrays.asList(1,4,5,6,22,3,90,90,89,2,1,3,4,55,6,-234);
		
		//print sum of all numbers
		Optional<Integer> output1 = list.stream().reduce((a,b)->(a+b));
		System.out.println(output1.get());
		//print the average of numbers
		Double output2 = list.stream().mapToInt(e->e).average().getAsDouble();
		System.out.println(output2);
		//squre then >100 then avegare
		Double output3 = list.stream().map(x -> x*x).filter(y -> y>100).mapToInt(z -> z).average().getAsDouble();
		System.out.println(output3);
		//print odd and even
		List<Integer> output4 = list.stream().filter(x->x%2==0).collect(Collectors.toList());
		System.out.println(output4);
		List<Integer> output5 = list.stream().filter(x->x%2!=0).collect(Collectors.toList());
		System.out.println(output5);
		//print number which starts from 2
		List<Integer> output6 = list.stream().map(a-> String.valueOf(a)).filter(b->b.startsWith("2") || b.startsWith("-2")).map(c->Integer.valueOf(c)).collect(Collectors.toList());
		System.out.println(output6);
		//print duplicate numbers
		Set<Integer> output7 = list.stream().filter(x->Collections.frequency(list, x)>1).collect(Collectors.toSet());
		System.out.println(output7);
		
		Set<Integer> set = new HashSet<>();
		List<Integer> output8 = list.stream().filter(x -> !set.add(x)).sorted().collect(Collectors.toList());
		System.out.println("PPP"+output8);
		
		
		//UNIQUE
		Set<Integer> set1 = new HashSet<>();
		List<Integer> output81 = list.stream().filter(x -> set1.add(x)).sorted().collect(Collectors.toList());
		System.out.println("PPP1"+output81);
		
		//Find the max and min number
		int output9 = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
		int output10 = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
		System.out.println(output9);
		System.out.println(output10);
		
		//Sort number asecding and decending order
		List<Integer> output11 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(output11);
		List<Integer> output12 = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(output12);
		
		//get first 5 number
		List<Integer> output13 = list.stream().limit(5).collect(Collectors.toList());
		System.out.println(output13);
		
		//get sum of first 5 number
		Optional<Integer> output14 = list.stream().limit(5).reduce((a,b)->(a+b));
		System.out.println(output14.get());
		
		//skip first 5 number
		List<Integer> output15 = list.stream().skip(5).collect(Collectors.toList());
		System.out.println(output15);
		
		
		//skip first 5 and add rest 
		Optional<Integer> output16 = list.stream().skip(5).reduce((a,b)->(a+b));
		System.out.println(output16.get());
		
		//find 2nd lowest/Highest number
		Optional<Integer> output17 = list.stream().sorted(Collections.reverseOrder()).distinct().limit(2).skip(1).findFirst();
		System.out.println(output17.get());
		
		Optional<Integer> output18 = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst();
		System.out.println(output18.get());
		
		
		Optional<Integer> output20 = list.stream().sorted().distinct().limit(2).skip(1).findFirst();
		System.out.println(output20.get());
		
		Optional<Integer> output21 = list.stream().sorted().distinct().skip(1).findFirst();
		System.out.println(output21.get());
		
		//use of peek() method: used for logging purpose
		System.out.println("-------------");
		List<Integer> output22=list.stream().peek(x->System.out.println(x+"BF")).filter(y->y%2==0).peek(z->System.out.println(z+"AF")).collect(Collectors.toList());
		System.out.println(output22);
		
		
		List<Integer> listNum = Arrays.asList(2,3,4,2,1,2,3,43,2);
		Map<Integer, Long> map1 = listNum.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		map1.forEach((k,v)->System.out.println(k+"  "+v));
		
		
		
		String s1 = "GEEKSFORGEEKS";
		List<Character> list1 = s1.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
		Map<Character,Long> map2 = list1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		map2.forEach((k,v)->System.out.println(k+"  "+v));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
