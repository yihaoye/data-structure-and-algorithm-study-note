https://leetcode.com/discuss/interview-question/system-design/622704/Design-a-system-to-store-and-retrieve-logs-for-all-of-eBay
  
Q: Design a system to store and retrieve logs for all of eBay.  
  
A: https://dzone.com/articles/distributed-logging-architecture-for-microservices  
In this article, we will examine some best practices to follow while logging microservices and the architecture to handle distributed logging in the microservices world. As we all, know microservices run on multiple hosts. To fulfill a single business requirement, we might need to talk to multiple services running on different machines. So, the log messages generated by microservices are distributed across multiple hosts.

As a developer or administrator, if you want to troubleshoot any issue, that leaves you clueless. You don’t know which microservice running on which host served your request. Even if you know which host(s) served your request, going to different hosts and grepping the logs and correlating them across all the microservices requests is a cumbersome process. If your environment is auto-scaled, then troubleshooting an issue is unimaginable. Here are some practices that will make life easier when troubleshooting issues in the microservices world.

## Centralize and Externalize Log Storage
As microservices are running on multiple hosts, you should send all the generated logs across the hosts to an external, centralized place. From there, you can easily get the log information from one place. It might be another physical system that is highly available or an S3 bucket or any other storage option. If you are hosting your environment on AWS, you can leverage CloudWatch, and other cloud providers generally offer similarly appropriate services.

## Log Structured Data
Generally, we put log messages with raw text output in log files. There are different log encoders available that will produce JSON log messages. That way, we will have the right data available in the logs to troubleshoot any issues. Below are some useful links to configure JSON appenders.

https://logging.apache.org/log4j/2.x/manual/layouts.html

https://github.com/qos-ch/logback-contrib/wiki/JSON

If you are using Logstash as your log aggregation tool, then there are encoders you can configure to output JSON log messages.

https://github.com/logstash/logstash-logback-encoder

https://github.com/logstash/log4j-jsonevent-layout

## Correlation IDs
Generate a correlation ID when you are making the first microservice call and pass that same ID to downstream services. Log the correlation ID across all microservice calls. That way, we can use the correlation ID coming from the response to trace out the logs. 

If you are using Spring Cloud to develop microservices, you can use the Spring Sleuth module along with Zipkin.

## Dynamic Logging Levels and Async Logging
We should be using different log levels in our code — and have enough logging statements in the code as well. We should have the liberty to change the log level dynamically. That is very helpful for enabling the appropriate log level. We don't need to enable the least logging level to print all the logs during server startup. We also avoid the overhead of excessive logging that way. Add asynchronous log appenders so that the logger thread will not be blocked by the request thread. If you are using Spring Cloud, then use Spring Boot admin to achieve dynamic log level changes.

## Make Logs Searchable
Make sure all the fields available in the logs are searchable. For example, If you get ahold of the correlation ID, you can search all the logs based on that t to find out the request flow.

Now, let's examine the architecture of log management in the microservices world. This solution uses the ELK stack. Generally, we will have different log configurations for different environments. For a development environment, we will go with console appenders or file appenders, which will output the logs in the local host. This is easy and convenient during development. For other environments, we will send the logs to a centralized place. The architecture we are going to discuss is for QA and higher environments.

![](https://smarttechies.files.wordpress.com/2017/07/distributed_logging_architecture.png?w=1210)  

In the above architecture, we configured the Kafka log appender to output the log messages to a Kafka cluster. From the Kafka cluster, the message will be ingested by Logstash. While ingesting the log messages into Logstash, we can transform the information as required. The output of Logstash will be stashed to Elasticsearch. Using the Kibana visualization tool, we can search the indexed logs with the parameters we logged. Remember, we can use Rabbit MQ/Active MQ (or other) message brokers instead of Kafka. Below are some of useful links on appenders.

https://github.com/danielwegener/logback-kafka-appender

http://docs.spring.io/spring-amqp/api/org/springframework/amqp/rabbit/logback/AmqpAppender.html

https://logging.apache.org/log4j/2.0/manual/appenders.html#KafkaAppender

https://logging.apache.org/log4j/2.0/manual/appenders.html#JMSAppender

In the second option given below, we will write the log messages using a Logstash appender to the file on the host machines. The Filebeat agent will watch the log files and ingest the log information to the Logstash cluster.

![](https://smarttechies.files.wordpress.com/2017/07/distributed_logging_architecture_2.png?w=1210)  

Among the first and second options, my choice is the first one. That's because:

* If the system is highly scalable, with an autoscaling feature, the instances will be created and destroyed based on need. In that case, if you go with the second option, there might be a loss of log files if the host is destroyed. But with the first option, when we log, the message will come to our middleware. It is the perfect suite for autoscaling environments.
* With the second option, we are installing Filebeat or similar file watchers on the host machine. For some reason, if those agents stop working, we may not get the logs from that host. Again, we are losing the log information.