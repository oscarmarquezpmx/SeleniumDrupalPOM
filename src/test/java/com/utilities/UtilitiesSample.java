package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import com.fasterxml.jackson.dataformat.yaml.YAMLParser;


import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;
import java.util.List;

public class UtilitiesSample {

        public static void main(String[] args) throws Exception {
            File yamlFile = new File("src/test/resources/vehicle.yml").getAbsoluteFile();

            FleetDeserializer deserializer = new FleetDeserializer();
            Fleet fleet = deserializer.readValue(yamlFile);
            List<Vehicle> vehicles =   fleet.getVehicles();
            Vehicle car = vehicles
                    .stream()
                            .filter((x)-> x.getType() == "car")
                    .reduce((a, b) -> {
                        throw new IllegalStateException("Multiple elements: " + a + ", " + b);
                    })
                    .get();


            System.out.println(car.getType());

        }
    }

    class FleetDeserializer {
        private YAMLFactory factory = new YAMLFactory();
        private ObjectMapper mapper = new ObjectMapper(factory);

        public Fleet readValue(File yamlFile) throws IOException {
            Fleet fleet = new Fleet();
            fleet.setVehicles(new ArrayList<>());

            YAMLParser parser = factory.createParser(yamlFile);
            while (parser.nextToken() != null) {
                if (parser.getCurrentToken() != JsonToken.START_OBJECT) {
                    continue;
                }
                // skip everything until a field name
                while (parser.nextToken() != JsonToken.FIELD_NAME) ;

                Class<? extends Vehicle> type = getType(parser.getCurrentName());
                if (type == null) {
                    continue;
                }

                // skip field name
                parser.nextToken();
                parser.nextToken();

                // read next vehicle
                fleet.getVehicles().add(mapper.readValue(parser, type));
            }

            return fleet;
        }

        private Class<? extends Vehicle> getType(String fieldName) {
            Objects.requireNonNull(fieldName);
            switch (fieldName) {
                case "car":
                    return Car.class;
                case "truck":
                    return Truck.class;
                default:
                    return null;
            }
        }
    }
class Fleet {

    private List<Vehicle> vehicles;

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles= vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}

 abstract class Vehicle {
    private String make;
    private String model;

    @JsonProperty("type")
    abstract public String getType();

    public void setType(String type) {};

    protected Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
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
}
class Car extends Vehicle {

    private int seatingCapacity;
    private double topSpeed;

    @JsonCreator
    public Car(
            @JsonProperty("make") String make,
            @JsonProperty("model") String model,
            @JsonProperty("seating") int seatingCapacity,
            @JsonProperty("topSpeed") double topSpeed) {
        super(make, model);
        this.seatingCapacity = seatingCapacity;
        this.topSpeed = topSpeed;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getType() {
        return "car";
    }

}

class Truck extends Vehicle {

    private double payloadCapacity;

    @JsonCreator
    public Truck(
            @JsonProperty("make") String make,
            @JsonProperty("model") String model,
            @JsonProperty("payload") double payloadCapacity) {
        super(make, model);
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public String getType() {
        return "truck";
    }

}