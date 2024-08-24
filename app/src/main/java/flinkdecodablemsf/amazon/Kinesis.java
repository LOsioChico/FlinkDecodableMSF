package flinkdecodablemsf.amazon;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.kinesis.KinesisAsyncClient;

public class Kinesis {

    private final AwsCredentialsProvider credentialsProvider;
    private final Region region;

    public Kinesis(AwsCredentialsProvider credentialsProvider, Region region) {
        this.credentialsProvider = credentialsProvider;
        this.region = region;
    }

    public KinesisAsyncClient getKinesisAsyncClient() {
        return KinesisAsyncClient.builder()
                .region(region)
                .credentialsProvider(credentialsProvider)
                .build();
    }
}
