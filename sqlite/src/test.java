import java.sql.*;
public class test {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");//驱动
                //jdbc:sqlite:E:\sqlite\mysqlite.sqlite 这里是地址
            conn = DriverManager.getConnection("jdbc:sqlite:E:\\sqlite\\mysqlite.sqlite");
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM peop");
            while (rs.next()){
                System.out.println("--------------------");
                System.out.print("id:"+rs.getString("id"));
                System.out.print("    name:"+rs.getString("name"));
                System.out.println("    age:"+rs.getString("age"));

            }

        }catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        }
        catch (SQLException sqlex){
            System.out.println(sqlex.getMessage());
            sqlex.printStackTrace();
        }
        finally {
            try {
                rs.close();
                statement.close();
                conn.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    }

