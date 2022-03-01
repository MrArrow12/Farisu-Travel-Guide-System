/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
interface Tax
{
    public void Calculate(double Hotelprices, String getLocation, String getAccomodation, String getFlight, String getAdultChild, String getDeparture, String getHotel);
    public double getCalculationWithoutTaxes();
    public double getCalculationWithTaxes();
         
}

public class Bill implements Tax {
    private double  prices;
    private final double SST = (1+ 0.06);
    private final double Adult = 120;
    private final double Child = 70;
    private final double KLIA = 5000;
    private final double ShahAirport = 3000;
    private final double Melaka = 1500;
    private final double Penang = 1800;
    private final double Kuching = 2000;
    private double Standard , FirstClass , Economy;
    public void Calculate(double Hotelprices, String getLocation, String getAccomodation, String getFlight, String getAdultChild, String getDeparture, String getHotel)
    {      prices = 0;
        System.out.println("getDeparture = "+getDeparture);
              if(getAdultChild.equals("Adult"))
               {   
                   this.prices += Adult;
                   System.out.println("Calling class: Adult: "+prices);
               }
               
               if(getAdultChild.equals("Child"))
               {
                   this.prices += Child;
               }
               
                 // KLIA ,Melaka International,Airport , Sultan Abdul Aziz Shah Airport, Penang International Airport ,Kuching International Airport  
               if(getDeparture.trim().equals("KLIA"))
               {   
                   
                   this.prices += KLIA;
                   System.out.println("Calling class: KLIA: "+prices);
               }
               
               if(getDeparture.trim().equals("Melaka International Airport"))
               {
                   this.prices += Melaka;
                   System.out.println("Calling class: Melaka: "+prices);
               }
               
                if(getDeparture.trim().equals("Sultan Abdul Aziz Shah Airport"))
               {
                   this.prices += ShahAirport;
                   System.out.println("Calling class: Sultan: "+prices);
               }
                
                if(getDeparture.trim().equals("Penang International Airport"))
               {
                   this.prices += Penang;
                   System.out.println("Calling class: Penang "+prices);
               }
                
                  if(getDeparture.trim().equals("Kuching International Airport"))
               {
                   this.prices += Kuching;
                   System.out.println("Calling class: Kuching: "+prices);
               }
      
        if(getLocation.equals("Germany") )
        {    
             
             this.Standard = 10000;
             this.FirstClass = 14000;
             this.Economy = 8000;
             
             
             
            if(getAccomodation.equals("Single"))
            {
              this.prices = prices * (1+ 0.20) + 5;
              System.out.println("Calling class Single Class: "+prices);
            }
            
             if(getAccomodation.equals("Double"))
            {
              this.prices = prices * (1+ 0.20) + 10;
              System.out.println("Calling class Double Class: "+prices);
            }
             
             
              if(getAccomodation.equals("Triple"))
            {
              this.prices = prices * (1+ 0.20) + 15;
              System.out.println("Calling class Extra Triple: "+prices);
            }
              
              
              if(getFlight.trim().equals("Standard"))
              {
                  this.prices += this.Standard;
                  System.out.println("Calling class Standard Class: "+prices);
              }
              
               if(getFlight.trim().equals("First class"))
              {
                  this.prices += this.FirstClass;
                   System.out.println("Calling class First Class: "+prices);
                  
              }
               
               if(getFlight.trim().equals("Economy"))
              {
                  this.prices += this.Economy;
                  System.out.println("Calling class Economy Class: "+prices);
              }
               
               
             
                
                
                 
              this.prices += Hotelprices;
            
        }
        
        if(getLocation.equals("Japan"))
        {   
            this.FirstClass = 15200;
            this.Economy = 9000;
            this.Standard = 11000;
            
            
              if(getAccomodation.equals("Single"))
            {
              this.prices = prices * (1+ 0.40) + 5;
              
            }
            
             if(getAccomodation.equals("Double"))
            {
              this.prices = prices * (1+ 0.40) + 10;
              
            }
             
             
              if(getAccomodation.equals("Triple"))
            {
              this.prices = prices * (1+ 0.40) + 15;
              
            }
              
              
               if(getFlight.trim().equals("Standard"))
              {
                  this.prices += this.Standard;
                   System.out.println("Calling class Standard Class: "+prices);
              }
              
               if(getFlight.trim().equals("First class"))
              {
                  this.prices += this.FirstClass;
                   System.out.println("Calling class First Class: "+prices);
              }
               
               if(getFlight.trim().equals("Economy"))
              {
                  this.prices += this.Economy;
                  System.out.println("Calling class Economy Class: "+prices);
              }
               
                this.prices += Hotelprices;
        }
        
        if(getLocation.equals("Thailand"))
        {   this.FirstClass = 10000;
            this.Economy = 5000;
            this.Standard = 7000;
              if(getAccomodation.equals("Single"))
            {
              this.prices = prices * (1+ 0.10) + 5;
              
            }
            
             if(getAccomodation.equals("Double"))
            {
              this.prices = prices * (1+ 0.10) + 10;
              
            }
             
             
              if(getAccomodation.equals("Triple"))
            {
              this.prices = prices * (1+ 0.10) + 15;
              
            }
              
              
              if(getFlight.trim().equals("Standard"))
              {
                  this.prices += this.Standard;
                  System.out.println("Calling class Standard Class: "+prices);
              }
              
               if(getFlight.trim().equals("First class"))
              {
                  this.prices += this.FirstClass;
                  System.out.println("Calling class First Class: "+prices);
              }
               
                if(getFlight.trim().equals("Economy"))
              {
                  this.prices += this.Economy;
                  System.out.println("Calling class Economy Class: "+prices);
              }
                
                 this.prices += Hotelprices;
        }
        
        
        if(getLocation.equals("Australia"))
        {   
            this.FirstClass = 23000;
            this.Economy = 15000;
            this.Standard = 17000;
            
               if(getAccomodation.equals("Single"))
            { System.out.println("Calling class Single: "+prices);
              this.prices = prices * (1+ 0.30) + 5;
              
            }
            
             if(getAccomodation.equals("Double"))
            {
              this.prices = prices * (1+ 0.30) + 10;
              
            }
             
             
              if(getAccomodation.equals("Triple"))
            {
              this.prices = prices * (1+ 0.30) + 15;
              
            }
              
              
              if(getFlight.trim().equals("Standard"))
              {   
                  this.prices += this.Standard;
                   System.out.println("Calling class Standard Class: "+prices);
              }
              
              if(getFlight.trim().equals("First class"))
              {   
                  this.prices += this.FirstClass;
                  System.out.println("Calling class First Class: "+prices);
              }
               
               if(getFlight.trim().equals("Economy"))
              {   
                  this.prices += this.Economy;
                  System.out.println("Calling class Economy Class: "+prices);
              }
               
                this.prices += Hotelprices;
               System.out.println(" BIll objects calling prices : "+this.prices);
        }
        
        
        if(getLocation.equals("Singapore"))
        {   this.FirstClass = 15000;
            this.Economy = 9700;
            this.Standard = 12000;
              if(getAccomodation.equals("Single"))
            {
              this.prices = prices * (1+ 0.50) + 5;
              
            }
            
             if(getAccomodation.trim().equals("Double"))
            {
              this.prices = prices * (1+ 0.50) + 10;
              
            }
             
             
              if(getAccomodation.trim().equals("Triple"))
            {
              this.prices = prices * (1+ 0.50) + 15;
              
            }
              
              
               if(getFlight.trim().equals("Standard"))
              {
                  this.prices += this.Standard;
                  System.out.println("Calling class Standard Class: "+prices);
              }
              
              if(getFlight.trim().equals("First class"))
              {
                  this.prices += this.FirstClass;
                  System.out.println("Calling class First Class: "+prices);
              }
               
               if(getFlight.trim().equals("Economy"))
              {
                  this.prices += this.Economy;
                  System.out.println("Calling class Economy Class: "+prices);
              }
               
                this.prices += Hotelprices;
        }
        
        
    }
    
    
    public double getCalculationWithoutTaxes()
    {
        prices = Math.round(prices * 100);
        prices = prices/100;
        return prices;
    }
    
     public double getCalculationWithTaxes()
     {   
          prices = Math.round(prices * 100);
          prices = prices/100;
          return prices * SST;
     }
    
    
    
}
