import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * @author percy
 * @create 2019-02-04  上午9:30
 * @descreption:
 **/
public class jdbcTemplateDemo1 {
    private static DriverManagerDataSource driveManagerSource;
    private static JdbcTemplate jdbcTemplate;
    private static String sql;
    static {
        driveManagerSource = new DriverManagerDataSource();
        driveManagerSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driveManagerSource.setUrl("jdbc:mysql:///supermarket?useUnicode=true&useSSL=false&characterEncoding=utf8");
        driveManagerSource.setUsername("root");
        driveManagerSource.setPassword("china0420");
        jdbcTemplate = new JdbcTemplate(driveManagerSource);

    }
    public static void main(String[] args) {
        if (jdbcTemplateDemo1.add()) {
            System.out.println("成功....");
        }else {
            System.out.println("失败....");
        }
        System.out.println(jdbcTemplateDemo1.getCount());
        System.out.println(jdbcTemplateDemo1.getObject("胡鹏涛").toString());
        System.out.println(jdbcTemplateDemo1.getallObject().toString());
    }

    private static boolean add(){
        sql = "insert into USER values(?,?,?)";
        try {
            if(jdbcTemplate.update(sql,"S0006","袁华1","123")>0){

                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }


    }
    private static boolean updata(){
        sql = "UPDATE USER set password=? where name=?";
        try {
            if(jdbcTemplate.update(sql,"321","yh")>0){

                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
    private static boolean delete(){
        sql = "DELETE FROM USER where name=?";
        try {
            if(jdbcTemplate.update(sql,"123")>0){

                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
    private static int getCount(){
        sql= "select count(*) from USER ";
        int count=jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }
    private static user getObject(String str){
        sql= "select * from USER WHERE name=?";
        user u=jdbcTemplate.queryForObject(sql,new MyRowMapper(),str);
        return u;
    }
    private static List<user> getallObject(){
        sql= "select * from USER";
        List<user> u=jdbcTemplate.query(sql,new MyRowMapper());
        return u;
    }
}
