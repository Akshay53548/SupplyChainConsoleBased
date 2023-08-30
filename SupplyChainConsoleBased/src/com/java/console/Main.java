package com.java.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("WELCOME TO SUPPLY CHAIN APP");
        Scanner scanner = new Scanner(System.in);

        Supplier supplier = new Supplier("Supplier A");
        Distributor distributor = new Distributor("Distributer X");
        Retailer retailer = new Retailer("Retailer R");


        Product product1 = new Product("Product1", 10.99);
        Product product2 = new Product("Product2", 24.99);

        distributor.sourceProduct(supplier, product1);
        distributor.sourceProduct(supplier,product2);


        System.out.println("please select how can i help you");

        while(true){
            System.out.println("Options:");
            System.out.println("1. Order products");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();

            if(choice==1){
                System.out.println("Available products: ");
                System.out.println("1." +product1.name +" $" +product1.price);
                System.out.println("2." +product2.name +" $" +product2.price);
                System.out.println("Select a product");

                int productChoice = scanner.nextInt();

                if(productChoice==1){
                    retailer.orderProducts(distributor, product1);
                }else if(productChoice==2){
                    retailer.orderProducts(distributor, product2);
                }else{
                    System.out.println("Invalid product selection");
                }
            }else if(choice==2){
                System.out.println("thank you for using supply chain app");
                break;
            }else{
                System.out.println("Invalid choice");
            }
        }
    }
}

class Product{
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}


class Supplier{
    String name;

    public Supplier(String name) {
        this.name = name;
    }
}

class Distributor{
    String name;
    List<Product> productsFromSupplier = new ArrayList<>();

    public Distributor(String name) {
        this.name = name;
    }

    public void sourceProduct(Supplier supplier, Product product){
        productsFromSupplier.add(product);
        System.out.println("Product "+ product.name +" sourced from " +supplier.name);
    }
}

class Retailer{
    String name;
    List<Product> productsToSell = new ArrayList<>();

    public Retailer(String name) {
        this.name = name;
    }

    public void orderProducts(Distributor distributor, Product product){
        productsToSell.add(product);
        System.out.println("Ordered product "+ product.name+ " from" +distributor.name);
    }
}