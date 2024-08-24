package flinkdecodablemsf.sources;

import flinkdecodablemsf.amazon.Kinesis;
import flinkdecodablemsf.model.Device;
import flinkdecodablemsf.model.SensorRecord;

public class DeviceThread implements Runnable {

    private final String streamName;
    private final long interval;
    private final Device device;
    private final Kinesis kinesis;
    private final DeviceDataGenerator dataGenerator;

    public DeviceThread(long interval, String streamName, Device device, Kinesis kinesis) {
        this.interval = interval;
        this.streamName = streamName;
        this.device = device;
        this.kinesis = kinesis;
        this.dataGenerator = new DeviceDataGenerator();
    }

    @Override
    public void run() {
        try {
            SensorRecord sensorRecord = dataGenerator.generateSensorRecord(device);
            kinesis.sendSensorRecord(streamName, sensorRecord);
            System.out.println("Sent record: " + sensorRecord.getJsonString());
            Thread.sleep(interval);
        } catch (InterruptedException e) {
        }
    }
}
