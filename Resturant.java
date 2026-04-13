package com.mycompany.lab55;


public class Restaurant { 
    public Menu menu;

    public Restaurant() {
        this.menu = new Menu();
    }

    public Restaurant(Menu menu) {
        this.menu = new Menu(menu.getMeals());
    }

    public void printRandomMeal() {
        Meal[]CURRENT =this.menu.getMeals();
        
        if (CURRENT != null && CURRENT.length > 0) {
            int RANDINDX = (int) (Math.random() * CURRENT.length);//بيعطيني حسب طول المصفوفة بين 0-arr.len
            Meal RANDMEAL = CURRENT[RANDINDX];
            
            System.out.println("\n--- Random Meal Selected ---");
            System.out.println("Code: " + RANDMEAL.getCode());
            System.out.println("Name: " + RANDMEAL.name);
            System.out.println("Price: " + RANDMEAL.price);
            System.out.println("Description: " + RANDMEAL.getDescription());
            System.out.println("----------------------------");
        } else {
            System.out.println("The menu is empty!");
        }
    }

    public Meal getMostExpensiveMeal() {
        Meal[] CUR = this.menu.getMeals();
        
        if (CUR == null || CUR.length == 0) return null;
        
        Meal EXP = CUR[0];
        for (int i = 1; i < CUR.length; i++) {
            if (CUR[i].price > EXP.price) {
                EXP = CUR[i];
            }
        }
        return EXP;
        
    }
}
