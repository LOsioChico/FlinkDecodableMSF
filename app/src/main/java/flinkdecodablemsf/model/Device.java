package flinkdecodablemsf.model;

public class Device {

    private final String id;
    private final String sensorType;
    private final String streamName;

    public Device(String id, String sensorType, String streamName) {
        this.id = id;
        this.sensorType = sensorType;
        this.streamName = streamName;
    }

    public String getId() {
        return id;
    }

    public String getSensorType() {
        return sensorType;
    }

    public String getStreamName() {
        return streamName;
    }

    @Override
    public String toString() {
        return "Device{"
                + "id=" + id
                + ", type='" + sensorType + '\''
                + ", streamName='" + streamName + '\''
                + '}';
    }
}
