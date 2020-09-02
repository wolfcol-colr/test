import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

//  public static void main(String[] args) throws InterruptedException, TimeoutException, IOException {
//    new Producer().testBasicPublish();
//  }
//
//  public void testBasicPublish() throws IOException, TimeoutException, InterruptedException {
//    ConnectionFactory factory = new ConnectionFactory();
//    // 指定虚拟主机的名称，默认是"/"
////    factory.setVirtualHost("/");
//    factory.setHost("127.0.0.1");
//    factory.setPort(AMQP.PROTOCOL.PORT);
//
//    Connection connection = factory.newConnection();
//    Channel channel = connection.createChannel();
//
//    String EXCHANGE_NAME = "exchange.direct";
//    String QUEUE_NAME = "queue_name";
//    String ROUTING_KEY = "key";
//    channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
//    channel.queueDeclare(QUEUE_NAME, true, false, false, null);
//    channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
//
//    String message = "Hello RabbitMQ:";
//    try {
//      channel.txSelect();
//      for (int i = 0; i < 5; i++) {
//        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, (message + i).getBytes("UTF-8"));
//      }
//      channel.txCommit();
//    } catch (Exception e) {
//      channel.txRollback();
//    }
//
//    channel.close();
//    connection.close();
//  }
}
