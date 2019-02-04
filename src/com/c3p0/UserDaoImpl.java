package com.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author percy
 * @create 2019-02-04  下午1:20
 * @descreption:
 **/
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean add() {
        String sql = "insert into USER values(?,?,?)";
        try {
            if(jdbcTemplate.update(sql,"S0007","袁华2","123")>0){

                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
