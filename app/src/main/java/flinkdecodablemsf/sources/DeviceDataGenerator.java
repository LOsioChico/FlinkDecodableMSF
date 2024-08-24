package flinkdecodablemsf.sources;

import java.util.Date;

import flinkdecodablemsf.model.Device;
import flinkdecodablemsf.model.SensorRecord;

public class DeviceDataGenerator {

    public SensorRecord generateSensorRecord(Device device) {
        switch (device.getSensorType()) {
            case "temperature" -> {
                return generateTemperatureData(device);
            }
            case "humidity" -> {
                return generateHumidityData(device);
            }
            case "energy" -> {
                return generateEnergyData(device);
            }
            default ->
                throw new IllegalArgumentException("Unknown sensor type: " + device.getSensorType());
        }
    }

    private SensorRecord generateTemperatureData(Device device) {
        double temperature = generateRandomValue(18, 25);
        return createSensorRecord(device, temperature, "Celsius");
    }

    private SensorRecord generateHumidityData(Device device) {
        double humidity = generateRandomValue(30.0, 70.0);
        return createSensorRecord(device, humidity, "Percent");
    }

    private SensorRecord generateEnergyData(Device device) {
        double energy = generateRandomValue(0.5, 5.0);
        return createSensorRecord(device, energy, "kWh");
    }

    private double generateRandomValue(double min, double max) {
        return Math.round((min + Math.random() * (max - min)) * 100.0) / 100.0;
    }

    private SensorRecord createSensorRecord(Device device, double value, String unit) {
        return new SensorRecord(
                device.getId(),
                new Date(),
                device.getSensorType(),
                value,
                unit
        );
    }
}
