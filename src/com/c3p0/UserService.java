package com.c3p0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author percy
 * @create 2019-02-04  下午1:19
 * @descreption:
 **/
public class UserService {

    private UserDaoImpl userDao;

    private void add(){
        userDao.add();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.add();
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

}
