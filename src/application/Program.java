package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Product product = new Product();
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.print("Product #"+i + "data: \n");
            System.out.print("Common, used or imported (c/u/i)?");
            char o = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name:");
            String name = sc.nextLine();
            System.out.print("Price:");
            Double price = sc.nextDouble();
            if(o == 'i'){
                System.out.print("Customs fee:");
                Double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name,price,customsFee));
            }else if(o == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY)");
                Date manufDate = sdf.parse(sc.next());
                products.add(new UsedProduct(name, price, manufDate));
            }else{
                products.add(new Product(name, price));
            }
        }

        System.out.print("PRICE TAGS: \n");

        for(Product prod : products){
            System.out.println(prod.priceTag());

        }






        sc.close();
    }
}
