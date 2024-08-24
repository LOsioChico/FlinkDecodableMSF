package flinkdecodablemsf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import flinkdecodablemsf.model.Device;
import flinkdecodablemsf.sources.DeviceThread;
import flinkdecodablemsf.utils.Config;

public class App {

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        ExecutorService threadPoolService = Executors.newFixedThreadPool(10);

        while (true) {
            int randomIndex = (int) (Math.random() * config.getDeviceCount());
            Device device = config.getDevices().get(randomIndex);
            threadPoolService.execute(new DeviceThread(device, config.getInterval()));
        }
    }
}
