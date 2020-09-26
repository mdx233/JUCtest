package 非阻塞式;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/21
 * @param
 * @return
 * 一、使用NIO完成网络通信的三个核心：
 * 1.通道(Channel)：负责连接
 *      java.nio.channels.Channel 接口：
 *          SelectableChannel
 *              SocketChannel
 *              ServerSocketChannel
 *              DatagramChannel
 *
 *              Pipe.SinkChannel
 *              Pipe.SourceChannel
 *
 *  2.缓冲区(Buffer)：负责数据的存取
 *
 *  3.选择器(Selector)：是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 *
 */
public class TestNoBlockingNIO {
    //客户端
    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));

        //2.分配指定大小的缓冲区
        CharBuffer buf = CharBuffer.allocate(1024);
        //3.将数据存入缓冲区
        //获取utf-8字符集对象
        Charset charset = Charset.forName("UTF-8");
        buf.put("芜湖起飞");
        buf.flip();
        //获取编码器
        CharsetEncoder charsetEncoder = charset.newEncoder();
        //进行编码，将字符转换为字节
        ByteBuffer encode = charsetEncoder.encode(buf);

        //4.将数据发送到服务端。
        sChannel.write(encode);
        //5.关闭通道
        sChannel.close();
    }
    //服务端
    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        //2.绑定连接
        ssChannel.bind(new InetSocketAddress(9999));

        //3.获取客户端通道
        SocketChannel sChannel = ssChannel.accept();

        //4.分配缓冲区用于接收数据
        ByteBuffer  buf = ByteBuffer.allocate(1024);

        //5.接收客户端发送的数据
        sChannel.read(buf);
        buf.flip();
        System.out.println(buf.limit());
        //对获取的字节进行解码
        //获取utf-8字符集对象
        Charset charset = Charset.forName("UTF-8");
        //获取解码器
        CharsetDecoder charsetDecoder = charset.newDecoder();
        CharBuffer decode = charsetDecoder.decode(buf);

        System.out.println(decode.toString());


    }
}
