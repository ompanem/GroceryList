import java.util.Scanner;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class Main 
{
  private static HashMap<String, Integer> groceries = new HashMap<String, Integer>();

  public static void main(String[] args) 
  {
    Scanner input = new Scanner(System.in);
    while(true)
    {
      System.out.println("Hello! Welcome to groceries app.  Would you like to add an item, Delete an item? quit(q) or display?");
      String choice = input.nextLine();
      if(choice.equalsIgnoreCase("q"))
      {
        break;
      }
      else if(choice.equalsIgnoreCase("add"))
          {
            addItem(groceries);
            

          }
      else if(choice.equalsIgnoreCase("display"))
      {
         if(groceries.size()==0){
           System.out.println("Nothing is in the list" + "\n");
           delaySecond();
         }

          for(String i:groceries.keySet()){
            Integer amount = groceries.get(i);
            System.out.println( "\n" + "Item: " + i + " Amount: " + amount + "\n");
            delaySecond();
          }
        }
       if(choice.equalsIgnoreCase("delete"))
        {
         deleteItem(groceries);
        }
      }
    }
    public static void delaySecond(){
      try{
        TimeUnit.SECONDS.sleep(1);
      }
      catch(InterruptedException e){
        e.printStackTrace();
      }
    }


  
    public static void addItem(HashMap <String, Integer> groceries)
    {
      Scanner input = new Scanner(System.in);
       System.out.println();
       System.out.println("What item would you like to add?");
       String addItem = input.nextLine();
        System.out.println("How much of " + addItem + " would you like to add? ");
             int numAdd = input.nextInt();


             if(numAdd<1)
               {
                 System.out.println("not possible");
               }
            else if(groceries.containsKey(addItem)){
              groceries.put(addItem, groceries.get(addItem)+numAdd);
            }
             else
               {
                 groceries.put(addItem, numAdd);
                 input.nextLine();
               }
    }

    public static void deleteItem(HashMap <String, Integer> groceries)
    {
      Scanner input = new Scanner(System.in);
       if(groceries.size() ==0)
         {
           System.out.println("There is nothing in your list to delete");
         }
          else
          {
            System.out.println("What item would you like to delete?");
            String deleteItem = input.nextLine();

            if(groceries.containsKey(deleteItem))
            {

              System.out.println("How much of " + deleteItem + " would you like to delete");

              int deleteAmount = input.nextInt();
              int currentAmount = groceries.get(deleteItem);

              if(deleteAmount<currentAmount)
              {
                 int deleteItem2 = currentAmount-deleteAmount;
                 if(deleteItem2<0)
                 {
                   System.out.println("You cannot remove more than what you have!");
                 }
                else if(deleteItem2==0)
                {
                  groceries.remove(deleteItem);
                }
                else
                {
                  groceries.put(deleteItem, deleteItem2);
                  System.out.println(deleteItem + "has been deleted.");
                  delaySecond();
                }
              }
            }
            else
            {
              System.out.println("Item isn't in your list");
            }
          }
    }
  }
