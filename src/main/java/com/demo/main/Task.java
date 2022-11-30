package com.demo.main;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.demo.model.Customer;
import com.demo.model.Item;
import com.demo.model.Order;

public class Task {

	
	public static void main(String args[]) {

		Item i1=new Item(134, "Moto24", 15000, "Mobiles");
		Item i2=new Item(157, "Spiderman", 50, "Books");
		Item i3=new Item(204, "Acer", 70000, "Laptops");
		Item i4=new Item(210, "iPhone", 45000, "Mobiles");
		Item i5=new Item(215, "Shirt", 1500, "Shirts");
		List<Item> itemList=List.of(i1,i2,i3,i4,i5);

		List<Customer> custList=List.of(new Customer(1, "Tom", "male", "Bangalore"),
				new Customer(2,"Mike", "male", "Delhi"),
				new Customer(3, "Miley", "female", "Pune"),
				new Customer(4, "Kunal", "male", "Delhi"),
				new Customer(5, "Sakshi", "female", "Delhi"));

		List<Item> o1_itemlist=List.of(itemList.get(0),itemList.get(2));
		List<Item> o2_itemlist=List.of(itemList.get(2));
		List<Item> o3_itemlist=List.of(itemList.get(3),itemList.get(4));
		List<Item> o4_itemlist=List.of(itemList.get(0),itemList.get(1),itemList.get(2),itemList.get(4));
		List<Item> o5_itemlist=List.of(itemList.get(0));

		Order o1=new Order(1, "delivered", LocalDate.of(2021, Month.NOVEMBER, 12),  LocalDate.of(2021, Month.NOVEMBER, 14),o1_itemlist,custList.get(0));
		Order o2=new Order(2, "delivered", LocalDate.of(2022, Month.MAY, 19),  LocalDate.of(2022, Month.MAY, 24),o2_itemlist,custList.get(3));
		Order o3=new Order(3, "delivered", LocalDate.of(2021, Month.JULY, 31),  LocalDate.of(2021, Month.AUGUST, 4),o3_itemlist,custList.get(1));
		Order o4=new Order(4, "pending", LocalDate.of(2022, Month.OCTOBER, 29),null,o4_itemlist,custList.get(2));
		Order o5=new Order(5, "pending", LocalDate.of(2021, Month.OCTOBER, 30),null,o5_itemlist,custList.get(4));
		List<Order> orderList=List.of(o1,o2,o3,o4,o5);

		List<Item> mobileList=new ArrayList<Item>();
		mobileList=itemList.stream().filter(i->i.getCategory().equalsIgnoreCase("Mobiles")).collect(Collectors.toList());
		System.out.println("1)Task : \n"+mobileList);

		mobileList=mobileList.stream().filter(i->i.getPrice()>20000).collect(Collectors.toList());
		System.out.println("2)Task : \n"+mobileList);

		List<Order> olistnew=new ArrayList<Order>(orderList);
		orderList.forEach((o)->{o.getItems().forEach(i->{
			if(i.getCategory().equalsIgnoreCase("mobiles"))
				olistnew.remove(o);
		});
		});
		System.out.println("3)Task : \n"+olistnew);	
		
		List<Item> laptopList=new ArrayList<Item>();
		Consumer<List<Item>> consumer = (llist)-> {
			llist.forEach((n)->{
				if(n.getCategory().equalsIgnoreCase("laptops"))
				{
					int dis=100-5;
					int disprice=(int) (dis*n.getPrice()/100);
					n.setPrice(disprice);
					laptopList.add(n);
					System.out.println("4)Task : \n"+laptopList);	
				}

			});
		};
		doTask(consumer, itemList);

		List<Order> olistFemale=orderList.stream().filter(o->o.getCus().getGender().equals("female")).toList();
		List<Item> itemOlistFemale=new ArrayList<Item>();
		olistFemale.forEach(o->{
			itemOlistFemale.addAll(o.getItems());
		});
		System.out.println("5)Task : \n"+olistFemale+"\n"+itemOlistFemale);
	
		List<Item> olistnew22=new ArrayList<Item>();
		LocalDate frstDate = LocalDate.parse("2022-01-01");
		LocalDate scndDate = LocalDate.parse("2022-10-31");
		
		  orderList.forEach((o)->{ 
			  if(o.getOrderDate().isAfter(frstDate) && o.getOrderDate().isBefore(scndDate)) {
				  
				  olistnew22.addAll(o.getItems());
				  olistnew22.stream().distinct();
			} });
		  System.out.println("6)Task : \n"+olistnew22);
	}


	private static void doTask(Consumer<List<Item>> c, List<Item> list) {
		c.accept(list);
	} 
}
