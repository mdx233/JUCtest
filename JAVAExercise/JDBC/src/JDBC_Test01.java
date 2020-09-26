import java.sql.*;
/*
* 注册驱动的第一种写法
*   Driver driver = new com.mysql.jdbc.Driver(); //com.mysql.jdbc 下的Driver类实现了java.sql.Driver 下的Driver接口
    DriverManager.registerDriver(driver);
*
* */
public class JDBC_Test01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        try {
            //1.注册驱动
            Driver driver = new com.mysql.jdbc.Driver(); //com.mysql.jdbc 下的Driver类实现了java.sql.Driver 下的Driver接口
            DriverManager.registerDriver(driver);
            //2.获取链接
            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "1913";
            conn = DriverManager.getConnection(url,user,password);

            //System.out.println("数据库链接对象 = " + conn);

            //3.获取数据库操作对象
            state = conn.createStatement();
            //4.执行sql语句
            int i = state.executeUpdate("insert dept(DEPTNO,DNAME,LOC) value(50,'吃饭位','芜湖')");
            System.out.println(i == 1 ? "新增成功！":"新增失败！");


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.释放资源
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
