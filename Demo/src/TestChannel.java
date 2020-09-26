import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/19
 * @param
 * @return
 *
 *  一、通道(Channel):用于源节点与目标节点的连接。在java NIO中负责缓冲区中数据的传输。
 *      Channel本身不存储数据，因此需要配合缓冲区进行传输。
 *  二、通道的主要实现类
 *      java.nio.channels.Channel 接口：
 *          --FileChannel
 *          --SocketChannel
 *          --ServerSocketChannel
 *          --DatagramChannel
 *  三、获取通道
 *  1.Java针对支持通道的类提供了getChannel()方法
 *      本地IO:
 *      FileInputStream/FileOutputStream
 *      RandomAccessFile
 *
 *      网络IO:
 *      Socket
 *      ServerSocket
 *      DatagramSocket
 *  2.在JDK 1.7 中的NIO.2 针对各个通道提供了静态方法open()
 *  3.在JDK 1.7 中的NIO.2 的Files工具类的newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 *  分散读取(Scattering Reads):将通道中的数据分散到多个缓冲区中
 *  聚集写入(Gathering Writes):将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组 -> 字符串
 */

public class TestChannel {

    //获取编码器与解码器
    @Test
    public void test6() throws CharacterCodingException {
        //获取GBK的字符集对象
        Charset gbk = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder charsetEncoder = gbk.newEncoder();
        //获取解码器
        CharsetDecoder charsetDecoder = gbk.newDecoder();

        //创建字符缓冲区
        CharBuffer cb = CharBuffer.allocate(1024);
        cb.put("芜湖起飞");
        //转换为读模式
        cb.flip();
        //注意，其中cb为字符数组，中文字符转换为字节，一个字符占两个字节，cb字符数组长度为4
        //encode字节数组长度为字符数组的两倍
        //对字符缓冲区中字符进行编码（字符->字节）
        ByteBuffer encode = charsetEncoder.encode(cb);
        for (int i = 0; i < encode.limit(); i++) {
            System.out.println(encode.get());
        }
        //解码(字节->字符)
        encode.flip();
        CharBuffer decode = charsetDecoder.decode(encode);
        System.out.println(decode.toString());
    }

    //获取支持的字符集
    @Test
    public void test5(){
        //获取可用字符集，以map方法返回
        Map<String, Charset> cmap = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> cset = cmap.entrySet();
        for(Map.Entry<String,Charset> map :cset){
            System.out.println(map.getKey()+"="+map.getValue());
        }
    }
    //分散和聚集
    @Test
    public void test4() throws IOException {

        RandomAccessFile file1 = new RandomAccessFile("1.txt","rw");

        //1.获取通道
        FileChannel inChannel = file1.getChannel();

        //2.分配指定的缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(5);
        ByteBuffer buffer2 = ByteBuffer.allocate(20);

        //3.分散读取
        ByteBuffer buffer[] = {buffer1,buffer2};
        inChannel.read(buffer);

        //打印缓冲区数组中的值
        for(ByteBuffer b: buffer){
            //将数组中的各个缓冲区，设置为读模式
            b.flip();
        }
        System.out.println(new String(buffer[0].array(),0,buffer[0].limit()));
        System.out.println("-------------------------------");
        System.out.println(new String(buffer[1].array(),0,buffer[1].limit()));

        //4.聚集写入
        RandomAccessFile file2 = new RandomAccessFile("2.txt","rw");
        FileChannel outchannel = file2.getChannel();
        outchannel.write(buffer);



    }

    //通道之间的数据传输
    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("timg.jpg"),StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"),StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        //转换到
        //inChannel.transferTo(0,inChannel.size(),outChannel);
        //转换来自
        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();

    }

    //使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws IOException {
        //记录开始时间
        Long start =  System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("timg.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"),StandardOpenOption.WRITE,StandardOpenOption.READ,StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();

        //记录结束时间
        Long end =  System.currentTimeMillis();
        //输出总耗时
        System.out.println("总共耗时："+(end - start)+"ms");
    }
    //利用通道完成文件的复制(非直接缓存区)
    @Test
    public  void test01(){
        //记录开始时间
        Long start =  System.currentTimeMillis();

        FileInputStream fin = null;
        FileOutputStream fou = null;
        FileChannel inChannel = null;
        FileChannel foChannel = null;
        try {
            //获取IO流
             fin = new FileInputStream("timg.jpg");
             fou = new FileOutputStream("copy.jpg");

             //通过IO流获取通道
            inChannel = fin.getChannel();
            foChannel = fou.getChannel();
              //创建缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //从通道中获取数据，并且存入缓冲区
            while (inChannel.read(buf) != -1){
                //缓冲区已经获取1024字节数据，需要从缓冲区中读取数据，并写到通道中
                buf.flip();//缓冲区转换为写模式，position指针回到0
                //将缓冲区中的数据写入到通道中
                foChannel.write(buf);
                //因为缓冲区中一次只能存放1024字节的数据，在一次写完数据之后需要将缓冲区指针清空，方便下一次存取接下来剩余的数据
                buf.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (foChannel != null) {
                try {
                    foChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fou != null) {
                try {
                    fou.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //记录结束时间
        Long end =  System.currentTimeMillis();
        //输出总耗时
        System.out.println("总共耗时："+(end - start)+"ms");
    }
}
