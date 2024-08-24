package flinkdecodablemsf.sources;

import flinkdecodablemsf.model.Device;
import flinkdecodablemsf.model.SensorRecord;

public class DeviceThread implements Runnable {

    private final DeviceDataGenerator dataGenerator;
    private final Device device;
    private final long interval;

    public DeviceThread(Device device, long interval) {
        this.dataGenerator = new DeviceDataGenerator();
        this.device = device;
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            SensorRecord sensorRecord = dataGenerator.generateSensorRecord(device);
            System.out.println(sensorRecord);
            Thread.sleep(interval);
        } catch (InterruptedException e) {
        }
    }
}
