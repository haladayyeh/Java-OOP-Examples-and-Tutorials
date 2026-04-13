package com.mycompany.lab55;

import java.util.Scanner;


public class Menu { 
    private Meal[] meals;

    public Menu() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of meals to start with: ");
        int num = input.nextInt();
        meals = new Meal[num];
        for (int i = 0; i < num; i++) {
            meals[i] = new Meal();
        }
    }

    public Menu(Meal[] meals) {
        if (meals == null) {
            this.meals = new Meal[0];
            return;
        }
        this.meals = new Meal[meals.length];
        for (int i = 0; i < meals.length; i++) {
            String tName = meals[i].name;
            double tPrice = meals[i].price;
            String tDes = meals[i].getDescription();
            this.meals[i] = new Meal(tName, tPrice, tDes);
        }
    }

    public Meal[] getMeals() {
        return this.meals;
    }

    public void addMealToTop() {
        Meal newMeal = new Meal();
        Meal[] arr = new Meal[this.meals.length + 1];
        arr[0] = newMeal;
        for (int i = 0; i < this.meals.length; i++) {
            arr[i + 1] = this.meals[i];
        }
        this.meals = arr;
    }

    public boolean removeMeal() {
        if (this.meals.length == 0) return false;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter meal code to remove: ");
        int CODE = input.nextInt();
        int INDX = -1;

        for (int i = 0; i < this.meals.length; i++) {
            if (this.meals[i].getCode() == CODE) {
                INDX = i;
                break;
            }
        }

        if (INDX == -1) return false;
        Meal.removeCode(CODE);
        Meal[] arr = new Meal[this.meals.length - 1];
        int j = 0;
        for (int i = 0; i < this.meals.length; i++) {
            if (i == INDX) continue;
            arr[j++] = this.meals[i];
        }

        this.meals = arr;
        return true;
    }
}
