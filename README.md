# FlinkDecodableMSF

FlinkDecodableMSF is a Java application that interacts with Amazon Kinesis to list streams and manage device threads.

## Prerequisites

- Java 21 or higher (Recommended)
- AWS CLI

## Setup

1. Configure an AWS profile named `flink` with the following command:

```bash
$ aws configure --profile flink
```

Be sure to set the region to `us-east-2` and add the required policy of `AmazonKinesisFullAccess` to the profile.

2. Add the following stream to the AWS account:

```bash
$ aws kinesis create-stream --stream-name temp_stream --shard-count 1 --profile flink

$ aws kinesis create-stream --stream-name energy_stream --shard-count 1 --profile flink

$ aws kinesis create-stream --stream-name humidity_stream --shard-count 1 --profile flink
```

The streams are used to simulate the data that the application will process and you will find the data in the [Config](/app/src/main/java/flinkdecodablemsf/utils/Config.java) file.