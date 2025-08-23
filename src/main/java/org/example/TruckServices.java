package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TruckServices {

    public void addtruck(Truck truck)
    {
        String sql = "insert into Truck(name,model,capacity,driver_name) values(?,?,?,?)";

       try{
           Connection connection = ConnectionDetails.getconnection();
           PreparedStatement prepareStatement = connection.prepareStatement(sql);

           prepareStatement.setString(1,truck.getName());
           prepareStatement.setString(2,truck.getModel());
           prepareStatement.setInt(3,truck.getCapacity());
           prepareStatement.setString(4,truck.getDriverName());

           int update = prepareStatement.executeUpdate();
           System.out.println("row inserted = "+update);

       } catch (SQLException e) {
           throw new RuntimeException(e);
       }

    }

    // for read
    public Truck getTruckById(int id)
    {
        Truck truck = new Truck();
        String sql = "select * from truck where id = ?";

        try
        {
            Connection connection = ConnectionDetails.getconnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,id);

            ResultSet resultSet = prepareStatement.executeQuery();

            if(resultSet.next())
            {
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return truck;
    }

    // udating purpose

    public void updateTruck(Truck truck)
    {
        String sql = "update truck set name = ?, model = ?, capacity = ?, driver_name = ? where id = ?";
        try {
            Connection connection = ConnectionDetails.getconnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setString(1,truck.getName());
            prepareStatement.setString(2,truck.getModel());
            prepareStatement.setInt(3,truck.getCapacity());
            prepareStatement.setString(4,truck.getDriverName());
            prepareStatement.setInt(5,truck.getId());

            int update = prepareStatement.executeUpdate();

            System.out.println("row updated : "+ update);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // get all truck method ...

    public List<Truck> getAllTrucks()
    {
        String sql = "select * from truck";
        List<Truck>truckList =  new ArrayList<>();

        try {
            Connection connection = ConnectionDetails.getconnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next())
            {
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));

                truckList.add(truck);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return truckList;
    }

    // delete method ,,,,

    public void deleteTruck(int id)
    {

        String sql = "delete from truck where id = ?";
        try {
            Connection connection = ConnectionDetails.getconnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1,id);

            int deleteRow = prepareStatement.executeUpdate();
            System.out.println("delete row = "+deleteRow);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
