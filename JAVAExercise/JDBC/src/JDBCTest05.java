import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
*   解决sql注入问题：
*       只要用户提供的信息不参与SQL语句的编译过程，问题就解决了。
*       即使用户提供的信息中含有SQL语句的关键字，但是没有参与编译，不起作用。
*       想要用户提供的信息不参与SQL语句的编译，那么必须使用java.sql.PreparedStatement
*       PreparedStatement接口继承了java.sql.Statement
*       PreparedStatement是属于预编译的数据库操作对象
*       PreparedStatement的原理是，预先对sql语句的框架进行编译，然后再给sql语句传“值”。
*
*   解决sql注入的关键
*       即使用户提交的数据中有sql语句的关键字，但用户提交语句不参与编译
*
*   Statement和PreparedStatement的区别
*       Statement存在sql注入问题，PreparedStatement解决了sql注入问题
*       Statement是编译一次执行一次，PreparedStatement编译一次执行多次，PreparedStatement效率高一些。
*       PreparedStatement会在编译阶段做安全检查，给占位符传值的时候会进行检查。
*
*       综上所述：PreparedStatement使用较多，只有在业务方面要求使用sql注入的时候才使用Statement（凡是业务方面需要使用sql语句拼接的），Statement使用极少
*
*
    * JDBC事物机制：
     *   1、JDBC中的事物总是自动提交的，
     *       只要执行任意的一条DML语句，则自动提交一次。这是JDBC默认的事物行为
     *       但是实际的业务当中，通常都是N条DML语句共同联合才能完成的，必须保证
     *       他们这些DML语句在同一个事物中同时成功或者失败。
*       重点三行代码
*           conn.setAutoCommit(false); //关闭事物自动提交
*           conn.commit(); //自动提交事务，实现数据库的改动
*           conn.rollback(); //事物回滚
* */


public class JDBCTest05 {
    public static void main(String[] args) {
        //初始化界面
        Map<String,String> userInfo = initUI();
        //验证用户界面
        boolean loginSuccess = login(userInfo);
        //最后输出
        System.out.println(loginSuccess ? "登录成功":"登录失败");

    }

    private static boolean login(Map<String, String> userInfo) {
        Boolean loginSuccess = false;
        //JDBC代码
        Connection conn = null;
        //预编译数据库操作对象
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "1913";
            conn = DriverManager.getConnection(url,user,password);
            conn.setAutoCommit(false); //关闭事物自动提交

            //sql语句的框子，其中一个？，表示一个占位符，一个？将来接收一个“值”，注意：占位符（？）不能使用单引号括起来
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";
            //程序执行到此处，会发送sql语句框子给DBMS,然后DBMS进行sql语句的预先编译.
            ps = conn.prepareStatement(sql);
           //给占位符？传值（第1个问号下标是1，第2个问号下标是2，JDBC中所有下标从1开始）
            ps.setString(1,userInfo.get("loginName"));
            ps.setString(2,userInfo.get("loginpwd"));

            rs = ps.executeQuery();

            if (rs.next()){
                loginSuccess = true;
            }
            //当代码能执行到这一步的时候说明上面语句没有出现异常
            conn.commit(); //自动提交事务，实现数据库的改动


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            //如果事务出现异常则事物回滚
            if (conn != null) { //先判断是否为null，防止空指针异常
                try {
                    conn.rollback(); //事物回滚
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps!= null) {
                try {
                    ps.close();
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

        return loginSuccess;
    }

    private static Map<String,String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("用户名：");
        String loginName = s.nextLine();

        System.out.println("密码：");
        String loginPwd = s.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginpwd",loginPwd);


        return userLoginInfo;
    }
}
