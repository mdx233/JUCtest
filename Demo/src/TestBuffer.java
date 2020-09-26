import org.junit.Test;

import java.nio.ByteBuffer;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/19
 * @param
 * @return
 *
 * 一、缓冲区(Buffer) :在java nio 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 *
 * 根据数据类型不同(boolean 除外)，提供了相应的缓冲区:
 * ByterBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 二、缓冲区存取数据的两个核心方法：
 * put():存取数据到缓冲区
 * get():获取缓冲区中的数据
 *
 * 四、缓冲区中的四个核心属性
 * capacity :容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit :界限，表示缓冲区中可以操作数据的大小。(超过limit限制大小后的数据不能进行读写)
 * position :位置，表示缓冲区中正在操作数的位置
 * mark :用于标记当前position的位置。可以通过reset() 将position恢复到mark的位置。
 *  注意：
 *  以上四个个属性要遵从一下规律
 *  0 <= mark <= position <= limit <= capacity
 *
 *  五、直接缓冲区与非直接缓冲区:
 *    非直接缓冲区:通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中
 *    直接缓冲区:通过allocateDirect()方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 */
public class TestBuffer {
    @Test
    public void test03(){
        //分配直接缓冲区
        ByteBuffer bufdir = ByteBuffer.allocateDirect(1024);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //isDirect方法，判断是否是直接缓冲,如果是直接缓冲区则返回true，如果不是则返回false
        System.out.println(bufdir.isDirect());
        System.out.println(buffer.isDirect());
    }
    @Test
    public void test02(){
        String str ="abcde";
       ByteBuffer buf = ByteBuffer.allocate(1024);
       //往缓冲区中存放数据
       buf.put(str.getBytes());
       //切换为读模式
       buf.flip();

       byte[] dst = new byte[buf.limit()];
       buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));

        System.out.println("position:"+buf.position());//position为2

        //mark() :标记
        buf.mark();//记录现在position位置：2

        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println("position:"+buf.position());//position为4

        //使用rest将position的位置重置为mark标记的位置
        buf.reset();
        System.out.println("position:"+buf.position());//position为2

        //判断缓冲区中是否还有剩余数据
        if (buf.hasRemaining()){
            //获取缓冲区可以操作的数量
            System.out.println(buf.remaining());//缓冲区中共5个数据，position为2，则还剩余3个
        }
    }

    @Test
    public void test1(){
        String str = "abcde";

        //1.分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);


        System.out.println("-----allocate分配内存(现在为写模式)-----");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //2.利用put()存入数据到缓冲区
        buf.put(str.getBytes());

        System.out.println("-----put()之后-----");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //3.切换读取数据模式
        buf.flip();

        System.out.println("-----flip()切换读取数据模式之后-----");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //4.利用get()读取缓冲区的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        String s = new String(dst,0,dst.length);
        System.out.println("读取缓冲区中的数据："+s);

        System.out.println("-----get()之后-----");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //5.rewind 可以将position重置为初始值，可以重新读出缓冲区数据
        buf.rewind();

        System.out.println("-----rewind()之后-----");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());

        //6.clear() 清空缓冲区。缓冲区重的数组依然存在，但是出于”被遗忘“状态，等于将三个指针置为初始值，并不清空数据
        buf.clear();

        System.out.println("-----clear()之后-----");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
    }


}
