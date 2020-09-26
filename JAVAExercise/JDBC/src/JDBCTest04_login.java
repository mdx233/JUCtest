import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JDBCTest04_login {
/*
* 实现功能：
*   1、需求：
*       模拟用户登录功能的实现
*   2、业务描述：
*       程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码
*       用户输入用户名和密码之后，提交信息，java程序收集到用户信息
*       java程序连接数据库验证用户名和密码是否合法
*       合法：显示登录成功
*       不合法：显示登录失败
*   3、当前程序存在问题：
*       用户名：
        fasa
        密码：
        fasa' or '1'='1
        登录成功
        这种现象被称为SQL注入。
     4、导致SQL注入的原因是什么？
*       用户输入的信息中含有sql语句关键字，并且这些关键字参与sql语句的编译过程，
*       导致sql语句的原意被扭曲，进而达到sql注入。
*
* */
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
        Statement statement = null;
        ResultSet rs = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "1913";
            conn = DriverManager.getConnection(url,user,password);

            statement = conn.createStatement();

            String sql = "select * from t_user where loginName = '"+ userInfo.get("loginName")+"' and loginPwd = '"+ userInfo.get("loginpwd") +"'";
            rs = statement.executeQuery(sql);

            if (rs.next()){
                loginSuccess = true;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
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
