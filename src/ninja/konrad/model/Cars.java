/*
 * This class represents the cars owned by an individual
 * the car informaiton is:
 *    year, make, model, color, current value
 */
package ninja.konrad.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Cars {
    // The Inventory of Cars is maintained in a hasmap with the key being the
    // owner ID of the car.
    private static final HashMap<Integer, Car[]> INVENTORY = new HashMap<Integer, Car[]>();
    
    
    static {
       Car[] bobsCars= {new Car("1966", "Ford", "Mustang", "Blue", BigDecimal.valueOf(18500.00)), 
                             new Car("1959", "Cadillac", "Eldorado", "Red", BigDecimal.valueOf(28500.00)),
                             new Car("2015", "Audi", "A8", "Black", BigDecimal.valueOf(102524.00)),
                             new Car("1959", "Jaguar", "XJS", "Grey", BigDecimal.valueOf(95400.00)),
                             new Car("1969 Alpha Romeo", "Spider", "A8", "Black", BigDecimal.valueOf(62480.00)),
                             new Car("1975", "Pontiac", "Trans Am", "Black", BigDecimal.valueOf(45600.00))};
            INVENTORY.put(1, bobsCars);
            
            Car[] johnsCars= {new Car("1969", "Volkswagen", "Beetle", "Orange", BigDecimal.valueOf(3525.00)), 
                             new Car("1972", "AMC", "Gremlin", "Red", BigDecimal.valueOf(1400.00)),
                             new Car("1961", "Chevrolet", "Corvair", "Red", BigDecimal.valueOf(1500.00)),
                             new Car("1976", "Chevrolet", "Chevette", "White", BigDecimal.valueOf(300.00)),
                             new Car("1996", "Ford", "Explorer", "Blue", BigDecimal.valueOf(3250.00)),
                             new Car("19", "Chevrolet", "Chevette", "White", BigDecimal.valueOf(300.00)),
                             new Car("1985", "Yugo", "GV", "Silver", BigDecimal.valueOf(250.00))};
            INVENTORY.put(2, johnsCars);
            
            Car[] lionelCars= {new Car("1988", "Porsche", "959", "Silver", BigDecimal.valueOf(33525.00)), 
                               new Car("2008", "Ferrari", "F430", "Red", BigDecimal.valueOf(228500.00)),
                               new Car("1950", "Mercury", "Coupe", "Black", BigDecimal.valueOf(328500.00)),
                               new Car("1973", "Porsche", "Carrera", "White", BigDecimal.valueOf(102524.00)),
                               new Car("1959", "Cadillac", "Eldorado", "Red", BigDecimal.valueOf(28500.00)),
                               new Car("1960", "Maserati", "3500 GT", "Red", BigDecimal.valueOf(402524.00)),
                               new Car("2007", "Alpha Romero", "8C", "Red", BigDecimal.valueOf(95524.00))};
            INVENTORY.put(3, lionelCars);
            
             Car[] sarahsCars= {new Car("2015", "BMW", "X5", "Black", BigDecimal.valueOf(85250.00)), 
                             new Car("2007", "Nissan", "Pathfinder", "Black", BigDecimal.valueOf(16600.00)),
                             new Car("2012", "Jeep", "Grand Cherokee", "Blue", BigDecimal.valueOf(25600.00))};
            INVENTORY.put(4, sarahsCars);
            
             Car[] trumpsCars= {new Car("2010", "Bugatti", "Veyron", "Orange", BigDecimal.valueOf(1250000.00)), 
                             new Car("1962", "Ferrari", "250 GTO Berlinetta", "Red", BigDecimal.valueOf(38100000.00)),
                             new Car("1970", "Plymouth", "Hemi Cuda", "Black", BigDecimal.valueOf(2475000.00)),
                             new Car("1934", "Packard", "1108 Dietrich", "Black", BigDecimal.valueOf(3630000.00)),
                             new Car("1953", "Jaguar", "C-Type", "Black", BigDecimal.valueOf(13200000.00)),
                             new Car("1998", "McLauren", "F-1", "Red", BigDecimal.valueOf(17350000.00)),
                             new Car("2007", "Audi", "RS4", "Grey", BigDecimal.valueOf(110524.00)),
                             new Car("1965", "Ford", "Shelby GT500", "Red", BigDecimal.valueOf(228500.00)),
                             new Car("1968", "Chevrolet", "Corvette L88", "Black", BigDecimal.valueOf(275800.00)),
                             new Car("1997", "Dodge", "Viper GTS", "Blue", BigDecimal.valueOf(352500.00))};
            INVENTORY.put(5, trumpsCars); 
    }
    
    // The CAR inventory is a singleton, so make constructor private
    private Cars(){
        ;
       }
    
    public static Car[] getInventory(Integer ownerID){
        System.out.println("Inventory for id: " + ownerID);
        return INVENTORY.get(ownerID);
    }
    
    public static void main(String[] args){
        Cars app = new Cars();

        System.out.println("Bobs Cars: ");
        Car[] cars = Cars.getInventory(1);
        app.listInventory(cars);
        System.out.println("Johns Cars: ");        
        app.listInventory(app.getInventory(2));
        
        System.out.println("Lionels Cars: ");        
        app.listInventory(app.getInventory(3));
        
        System.out.println("Sarahs Cars: ");       
        app.listInventory(app.getInventory(4));    
        
        System.out.println("Trumps Cars: ");       
        app.listInventory(app.getInventory(5));        
    }
    
    private void listInventory(Car[] cars){
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i].toString());
        }
    }
}
