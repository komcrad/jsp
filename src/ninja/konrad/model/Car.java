/*
 * This class is the Car class
 */
package ninja.konrad.model;

import java.math.BigDecimal;

/**
 *
 * @author david
 */
public class Car {
    private String year;    // year car was manufactored
    private String make;    // make or manufacturer of car
    private String model;   // model of car
    private String color;   // color of car
    private BigDecimal currentValue; // current value of car

    public Car(){
        ;
    }
    
    public Car(String year, String make, String model, String color, BigDecimal value){
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.currentValue = value;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(BigDecimal currentValue) {
        this.currentValue = currentValue;
    }
    
    @Override
    public String toString(){
        return this.getYear() + ", " +
               this.getMake() + ", " +
               this.getModel() + ", " +
               this.getColor() + ", " + 
               this.getCurrentValue();
    }
}
