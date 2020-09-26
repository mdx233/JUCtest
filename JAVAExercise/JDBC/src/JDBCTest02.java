import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCTest02 {
/*
* 注册驱动的第二种方式 *常用 （使用com.mysql.jdbc.Driver类中的静态代码块）
* 由于静态代码块中的代码是在类加载的时候执行的
* 利用反射机制Class.forName（）方法
* Class.forName（）方法会导致类加载
*
*
* */
    public static void main(String[] args) {
        //1.注册驱动
        ResourceBundle bundle = ResourceBundle.getBundle("JDBC");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection conn = null;

        Statement state = null;
        try {

            Class.forName(driver);
            //2.获取链接
            conn = DriverManager.getConnection(url,user,password);
            System.out.println(conn);

            //3.过去数据库操作对象
            state = conn.createStatement();
            //4.执行Sql语句
            int count =  state.executeUpdate("update dept set DEPTNO = 4399,DNAME = '做饭位' where DEPTNO = 50");
            System.out.println(count == 1 ? "修改成功！":"修改失败！");
            //5.对结果数据集进行整理

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            //(先关闭数据库操作对象，再关闭数据库链接)
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
