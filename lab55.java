package com.mycompany.lab55;

import java.util.Scanner;

public class Lab55 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        Restaurant myRestaurant = new Restaurant();

        operateRestaurant(myRestaurant);
        
    }
    public static void printMenu(Menu menu){
        Meal[] meals = menu.getMeals();
        
        System.out.printf("%-15s %-15s %-10s %-30s\n", "Meal-Code", "Name", "Price", "Description");
        System.out.println("-----------------------------------------------------------------------");
        
        if(meals != null){
            for(int i = 0; i < meals.length; i++){
                System.out.printf("%-15d %-15s %-10.2f %-30s\n", 
                        meals[i].getCode(), 
                        meals[i].name, 
                        meals[i].price, 
                        meals[i].getDescription());
             
            }
        
        }
    
    }
    public static void operateRestaurant(Restaurant r){
        
        boolean exit = false;
        
        while(!exit){
            System.out.println("\nWhat to do:"); 
            System.out.println("1. Print menu"); 
            System.out.println("2. Add meal"); 
            System.out.println("3. Remove meal");
            System.out.println("4. Modify meal"); 
            System.out.println("5. Print the most expensive meal"); 
            System.out.println("6. Print random meal"); 
            System.out.println("7. Exit"); 
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            
            switch(choice){
                case 1:
                    printMenu(r.menu);
                    break;
                    
                case 2:
                    r.menu.addMealToTop();
                    break;
                    
                case 3:
                    boolean REM = r.menu.removeMeal();
                    if(REM){
                        System.out.println("Meal removed succescfully");
                
                    }
                    else{
                        System.out.println("couldnt find code");
                        
                    }
                    break;
                   
                case 4:
                    modifyMeal(r);
                    break;
                    
               case 5:
                    Meal EXP = r.getMostExpensiveMeal();
                    if(EXP != null)System.out.println("Meal name:"+EXP.name+"\n Meal price"+EXP.price);
                    break;
                    
               case 6:
                   r.printRandomMeal();
                    break;
                    
               case 7:
                   exit = true;
                   System.out.println("EXIT");
                   break;
                   
                default:
                   System.out.println("INVALIED , TRY AGAIN");
                   
                
            }
            
          
        }
       
   
    }
    public static void modifyMeal(Restaurant r){
        System.out.println("enter meal to modify");
        int CODEMODE = input.nextInt();
        
        Meal[] CUR = r.menu.getMeals();
        
        Meal mod = null;
        
        if(CUR != null){
            for(int i=0; i<CUR.length;i++){
                if(CUR[i].getCode() == CODEMODE){
                    mod = CUR[i];
                    break;
                    
                }
               
            }
            
        }
        if(mod == null){
            System.out.println("couildnt fine");
            
        }
        else{
            System.out.println("1.Modify price"); 
            System.out.println("2.ADD descreption");
            int CHOICE = input.nextInt();
            if(CHOICE==1){
                System.out.println("enter price");
                mod.price = input.nextDouble();
                System.out.println("price updated");
                
            }
            else if(CHOICE ==2){
                input.nextLine();
                System.out.println("enter desc");
                String newDesc = input.nextLine();
                mod.addToDescription(newDesc);
                System.out.println("DONE");
              
            }
            else{
                System.out.println("INVALIED CHOICE");
                
            }
        }
        
        
    }

}

