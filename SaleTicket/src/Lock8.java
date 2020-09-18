import java.util.concurrent.TimeUnit;

/**
 *功能描述
 * @author mdx
 * @date 2020/8/17
 * @param
 * @return
 *
 * 题目：多线程8锁
 * 1    标准访问，请问先打印邮件还是短信？（不一定，如果线程没有睡眠的话，线程调度由cpu决定，需要看线程的优先级）
 * 2    邮件方法暂停4秒钟，请问先打印邮件还是短信？（程序暂停四秒后打印邮件，之后打印sms，sleep方法不会释放锁，资源类被锁住，其他线程无法调用资源类，只能等待sleep的线程唤醒结束后释放资源，其他线程才能操纵资源类。）
 * 3    新增一个普通方法hello()，请问先打印邮件还是hello？（先打印hello再打印邮件，因为邮件方法先暂停四秒钟，时间片由调用hello方法的线程获得，hello方法没加synchronized，没加锁可以直接访问，不需要判断其他线程是否占用资源。）
 * 4    两部手机(两个资源类)，请问先打印邮件还是短信?（先打印短信，再打印邮件，两个线程的资源类不同时，资源上的锁相互不影响，邮件方法睡眠4秒，时间片由B线程获得，所以先执行短信）
 * 5    两个静态同步方法，同一部手机(同一个资源类)，请问先打印邮件还是短信？（先打印邮件，静态方法上的锁相当于类锁，范围比对象锁要大，即使是不同对象，但如果方法是静态同步方法，资源类是同一个类，在线程资源类为同一个类时，线程会进行等待）
 * 6    两个静态同步方法，两部手机(两个资源类)，请问先打印邮件还是短信？（先打印邮件，静态方法上的锁相当于类锁，范围比对象锁要大，即使是不同对象，但如果方法是静态同步方法，资源类是同一个类，在线程资源类为同一个类时，线程会进行等待，只有当该类的锁释放时其他线程才能调用该资源类）
 * 7    1个普通同步方法(短信方法)，1个静态同步方法(邮件方法)，1部手机，请问先打印邮件还是短信？（先短信后邮件，由于两锁的资源类不是同一个，一个为对象锁，一个为类锁，所以两个线程不同步，邮件方法先停止4秒，时间片由短信方法调用线程获得，谁获得时间片谁直接运行，不用关心其他线程，）
 * 7    1个普通同步方法(短信方法)，1个静态同步方法(邮件方法)，2部手机，请问先打印邮件还是短信？（先短信后邮件，由于两锁的资源类不是同一个，一个为对象锁，一个为类锁，所以两个线程不同步，邮件方法先停止4秒，时间片由短信方法调用线程获得，谁获得时间片谁直接运行，不用关心其他线程，）
 *
 */

public class Lock8 {
    public static void main(String[] args) throws Exception{
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
                //phone.hello();
                //phone2.sendSMS();

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

class Phone{
    public static synchronized void sendEmail() throws Exception{
        try{
            //TimeUnit工具类，SECONDS为枚举类型，睡眠单位为秒。
            //TimeUnit.SECONDS.sleep(4);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("------sendEmail");
    }
    public synchronized void sendSMS() throws Exception{
        System.out.println("------sendSMS");
    }
    public void hello(){
        System.out.println("------hello");
    }

}
