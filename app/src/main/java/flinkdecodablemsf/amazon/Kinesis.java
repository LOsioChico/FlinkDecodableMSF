package flinkdecodablemsf.amazon;

import flinkdecodablemsf.model.SensorRecord;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;
import software.amazon.awssdk.services.kinesis.model.PutRecordRequest;
import software.amazon.awssdk.services.kinesis.model.PutRecordResponse;

public class Kinesis {

    private final KinesisAsyncClient kinesisAsyncClient;

    public Kinesis(AwsCredentialsProvider credentialsProvider, Region region) {
        this.kinesisAsyncClient = KinesisAsyncClient.builder()
                .region(region)
                .credentialsProvider(credentialsProvider)
                .build();
    }

    public KinesisAsyncClient getKinesisAsyncClient() {
        return kinesisAsyncClient;
    }

    public PutRecordResponse sendSensorRecord(String streamName, SensorRecord sensorRecord) {
        PutRecordRequest request = PutRecordRequest.builder()
                .streamName(streamName)
                .partitionKey(sensorRecord.getDeviceId())
                .data(SdkBytes.fromUtf8String(sensorRecord.getJsonString()))
                .build();
        return kinesisAsyncClient.putRecord(request).join();
    }
}
