import java.sql.*;
import java.util.*;

public class JDBCTest03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        //1.注册数据库驱动
        ResourceBundle bundle = ResourceBundle.getBundle("JDBC");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        try {
            //1.注册数据库驱动
            Class.forName(driver);

            //2.创建数据库链接对象
            conn = DriverManager.getConnection(url,user,password);

            //3.创建数据操作对象
            statement = conn.createStatement();

            //4.执行Sql语句(执行增、删、改用executeUpdate)
            //（执行查询用executeQuery）\
            String sql = "select * from dept";
            resultSet = statement.executeQuery(sql);//专门执行DQL语句的方法，返回ResultSet对象
            //5.处理返回结果数据集
            //re.next 指针开始指向表外，调用该方法时指针向下移动一位，若有值则返回True，反之返回false
            while (resultSet.next()){
                /*//JDBC中所有下标从1开始
                String one = resultSet.getString(1); //取第一个数据
                String two = resultSet.getString(2);
                String three = resultSet.getString(3);
*/
                //以数据查询结果集中列名来获取数据，如果查询语句中列名有变动则按找新列名获取对应数据
                //getString返回String类型 ， getDouble返回Double类型,getInt返回int类型
                String one = resultSet.getString("DEPTNO");
                String two = resultSet.getString("DNAME");
                String three = resultSet.getString("LOC");


                System.out.println("|" + one + "|" + two + "|" + three + "|");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源（释放时按创建顺序，从后往前依次关闭）
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
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
