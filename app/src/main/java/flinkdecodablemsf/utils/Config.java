package flinkdecodablemsf.utils;

import java.util.ArrayList;
import java.util.List;

import flinkdecodablemsf.model.Device;
import software.amazon.awssdk.regions.Region;

public class Config {

    private final List<Device> devices = new ArrayList<>();
    private final long interval = 1000L;
    private final String output = "output_stream";
    private final Region awsRegion = Region.US_EAST_2;

    public Config() {
        devices.add(new Device("temp_sensor_001", "temperature", "temp_stream"));
        devices.add(new Device("humidity_sensor_001", "humidity", "humidity_stream"));
        devices.add(new Device("energy_sensor_001", "energy", "energy_stream"));
    }

    public List<Device> getDevices() {
        return devices;
    }

    public int getDeviceCount() {
        return devices.size();
    }

    public long getInterval() {
        return interval;
    }

    public String getOutput() {
        return output;
    }

    public Region getAwsRegion() {
        return awsRegion;
    }
}
