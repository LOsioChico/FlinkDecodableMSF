package flinkdecodablemsf.model;

import java.util.Date;

public class SensorRecord {

    private final String deviceId;
    private final Date timestamp;
    private final String sensorType;
    private final double value;
    private final String unit;

    public SensorRecord(String deviceId, Date timestamp, String sensorType, double value, String unit) {
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.sensorType = sensorType;
        this.value = value;
        this.unit = unit;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getSensorType() {
        return sensorType;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "SensorReading{"
                + "deviceId=" + deviceId
                + ", timestamp=" + timestamp
                + ", sensorType='" + sensorType + '\''
                + ", value=" + value
                + ", unit='" + unit + '\''
                + '}';
    }

}
