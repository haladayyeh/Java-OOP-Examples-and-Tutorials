package com.mycompany.lab55;

import java.util.Arrays;
import java.util.Scanner;

public class Meal {
     private int code;
    public String name;
    public double price;
    private String description;
    private static int[] usedCodes = new int[0];

    Meal() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter meal name: ");
        name = input.nextLine();
        System.out.print("Enter meal price: ");
        price = input.nextDouble();
        while (price <= 0) {
            System.out.print("Please enter a positive non-zero value for the price: ");
            price = input.nextDouble();
        }
        description = "";
        generateCode();
    }

    Meal(String n, double p, String d) {
        name = n;
        price = p;
        description = d;
        generateCode();
    }

   //لما احط الكود برايفت لازم استخدم هاي الميثود عشان ترجعلي اياه برا الكلاس الي هو فيه
    public int getCode() {
        return code;
    }

    public String getDescription() {
      
        return description;
    }

    public void addToDescription(String newDesc) {
        //بضيف السترينغ الي انا بدي اضيفو للدسكربشن
        if (this.description.isEmpty()) {
            this.description = newDesc;
        } else {
            this.description += ", " + newDesc;
        }
    }

   

    private void generateCode() {
        int code = 1000 + (int) (Math.random() * 9000);
        while (Arrays.binarySearch(usedCodes, code) >= 0)
            code = 1000 + (int) (Math.random() * 9000);
        this.code = code;
        
        int[] temp = new int[usedCodes.length + 1];
        System.arraycopy(usedCodes, 0, temp, 0, usedCodes.length);
        temp[temp.length - 1] = code;
        usedCodes = temp;
        Arrays.sort(usedCodes);
    }

    static void removeCode(int code) {
        if (Arrays.binarySearch(usedCodes, code) < 0)
            return;
        int[] temp = new int[usedCodes.length - 1];
        for (int i = 0, j = 0; i < usedCodes.length; i++)
            if (usedCodes[i] != code)
                temp[j++] = usedCodes[i];
        usedCodes = temp;
    }
}
