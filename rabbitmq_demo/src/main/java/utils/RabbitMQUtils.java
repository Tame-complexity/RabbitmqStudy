package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

/**
 * @Author linshengqian
 * @Date 2022/8/28 14:12
 * @description:
 */
public class RabbitMQUtils {
    private static ConnectionFactory connectionFactory;
    private static Properties properties;

    static {
        //重量级资源  类加载执行之执行一次
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.1.160");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/admin");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

    }

    //定义提供连接对象的方法
    public static Connection getConnection()  {
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭通道和关闭连接工具方法
    public static void closeConnectionAndChanel(Channel channel, Connection conn) {
        try {
            if (channel != null) {
                channel.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}


