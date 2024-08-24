package flinkdecodablemsf.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import flinkdecodablemsf.model.Device;

public class Config {

    private final List<Device> devices = new ArrayList<>();
    private final long interval = 250L;
    private final String output = "output_stream";
    private final Map<String, Object> aws = new HashMap<>();

    public Config() {
        devices.add(new Device("temp_sensor_001", "temperature", "temp_stream"));
        devices.add(new Device("humidity_sensor_001", "humidity", "humidity_stream"));
        devices.add(new Device("energy_sensor_001", "energy", "energy_stream"));
        aws.put("region", "us-east-2");
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

    public Map<String, Object> getAws() {
        return aws;
    }
}
