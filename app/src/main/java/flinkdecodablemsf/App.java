package flinkdecodablemsf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import flinkdecodablemsf.amazon.Kinesis;
import flinkdecodablemsf.model.Device;
import flinkdecodablemsf.sources.DeviceThread;
import flinkdecodablemsf.utils.Config;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        AwsCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create("flink");
        Kinesis kinesis = new Kinesis(credentialsProvider, config.getAwsRegion());

        ExecutorService threadPoolService = Executors.newFixedThreadPool(config.getDeviceCount() * 2);
        while (true) {
            int randomIndex = (int) (Math.random() * config.getDeviceCount());
            Device device = config.getDevices().get(randomIndex);
            threadPoolService.execute(new DeviceThread(config.getInterval(), device.getStreamName(), device, kinesis));
        }
    }
}
