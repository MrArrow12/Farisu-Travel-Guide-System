/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Customer extends Bill {
       private String Accomodation;
       private String Flight;
       private String Adult_Or_Child;
       private String Name , getLocation,getDeparture,getHotel;
       private int Age;
       Customer()
       {    super();
           System.out.println("Object created");
          
       }
       
       public void setName(String Name)
       {
           this.Name = Name;
       }
       
        public void setAge(int Age)
       {
           this.Age = Age;
       }
        
        public void setInformation(String getLocation, String getAccomodation, String getFlight, String getAdultChild, String getDeparture, String getHotel)
        {
            this.getLocation = getLocation;
            this.Accomodation = getAccomodation;
            this.Flight = getFlight;
            this.getDeparture = getDeparture;
            this.Adult_Or_Child = getAdultChild;
            this.getHotel = getHotel;
            
            System.out.println("Location: "+this.getLocation);
             System.out.println("Accomodation: "+this.Accomodation);
              System.out.println("Flight: "+this.Flight);
               System.out.println("Departure: "+this.getDeparture);
                System.out.println("Adult/Child : "+this.Adult_Or_Child);
                 System.out.println("Hotel: "+this.getHotel);
        }
        
        public String Location()
        {
            return this.getLocation;
        }
        
        public String Accomodation()
        {
            return this.Accomodation;
        }
        
        public String getFlight()
        {
            return this.Flight;
        }
        
        public String Departure()
        {
            return this.getDeparture;
        }
        
        public String AdultChild()
        {
            return this.Adult_Or_Child;
        }
        
        public String Hotel()
        {
            return this.getHotel;
        }
        
        public String getName()
        {
            return this.Name;
        }
        
        public int getAge()
        {
            return this.Age;
        }
       
       
       
       public void FillCalculation(double Hotelprices, String getLocation, String getAccomodation, String getFlight, String getAdultChild, String getDeparture, String getHotel )
       {  
           System.out.println("Hotel Prices: "+Hotelprices);
           super.Calculate(Hotelprices, getLocation, getAccomodation, getFlight, getAdultChild, getDeparture, getHotel);
       }
       
       public double getTotal()
       {
           return super.getCalculationWithTaxes();
       }
       
       public double getSubtotal()
       {
           return super.getCalculationWithoutTaxes();
       }
       
        public String toString()
    {     
           double subtotal = getSubtotal();
           subtotal = Math.round(subtotal * 100);
           subtotal = subtotal/100;
           
           double total = getTotal();
           total = Math.round(total * 100);
           total = total/100;
        return "\nName : "+this.Name+"\nAge :"+this.Age+
                "\nTrip Location: "+this.getLocation+"\nAccomodation: "+this.Accomodation+
                "\nFlight: "+this.Flight+"\nDeparture: "+this.getDeparture+"\nAdult/Child: "+
                this.Adult_Or_Child+"\nHotel : "+this.getHotel+"\nSubtoal: RM"+subtotal+"\nTotal : RM"+total;
    }
       
       
       
       
    
}
