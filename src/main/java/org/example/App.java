package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        TruckServices truckServices =  new TruckServices();

        Truck tata = new Truck("TATA","2019",1000,"rajesh");
        Truck volvo = new Truck("VOLVO","2020",2000,"Raju vai");
        Truck tesla = new Truck("TESLA","2024",3000,"Elon vai");

        // adding data into database  ...
        System.out.println("Adding data ...");
        truckServices.addtruck(tata);
        truckServices.addtruck(volvo);
        truckServices.addtruck(tesla);

        // fetching..
        System.out.println("fectching data ...");
        Truck truck = truckServices.getTruckById(2);
        System.out.println(truck);

        // update ..
        System.out.println("updating data ...");
        tata.setId(1);
        System.out.println(tata);
        tata.setDriverName("rajesh vai");
        tata.setCapacity(1500);
        truckServices.updateTruck(tata);
        System.out.println("udated successfully : "+truckServices.getTruckById(1));

        // display all the trucks ...
        System.out.println("display all the data ...");
        List<Truck> TrucksData = truckServices.getAllTrucks();

        System.out.println(TrucksData);

        // delete ...
        System.out.println("deleting data ...");
        truckServices.deleteTruck(2);
        System.out.println("delete successfully");

        TrucksData = truckServices.getAllTrucks();
        System.out.println(TrucksData);

    }
}
