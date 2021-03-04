package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	
	public static void main (String args[]) throws ParseException {			
							
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
						
			System.out.println("Enter cliente data: ");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Birth date(DD/MM/YYYY): ");
			Date birthDate = sdf.parse(sc.next());
			
			Client client = new Client(name,email,birthDate);
			
			System.out.println();
			System.out.println("Enter order data: ");
			System.out.print("Status: ");
			OrderStatus status = OrderStatus.valueOf(sc.next());
			
			Order order = new Order();
			
			order.setMoment(new Date());
			order.setStatus(status);
			order.setClient(client);
			
			System.out.print("How many items to this order? ");
			int aux = sc.nextInt();
						
			
			for(int i = 0 ;i< aux;i++) {
				
				System.out.println("Enter #" + (i+1) + " item data:");
				System.out.print("Product name: ");
				sc.nextLine();
				String productName = sc.nextLine();
				System.out.print("Product Price: ");
				double productPrice = sc.nextDouble();
				System.out.print("Quantity: ");
				int quantity = sc.nextInt();
				
				Product p = new Product(productName,productPrice);
				
				OrderItem it = new OrderItem(quantity,productPrice,p);
				
				order.addItem(it);
				
			}
			
			System.out.println();
			System.out.println(order);
			
			sc.close();					
			
	}
}
