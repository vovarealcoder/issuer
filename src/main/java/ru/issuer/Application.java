package ru.issuer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.issuer.dao.manager.UserManager;
import ru.issuer.dao.model.Users;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //Object userDaoImpl = context.getBean("userDaoImplement");
        Object sessionFactory = context.getBean("sessionFactory");

        System.out.println(sessionFactory);
        SessionFactory factory = (SessionFactory) sessionFactory;
        Session session = factory.openSession();
        List<Users> from_users_ = session.createQuery("from Users", Users.class).list();
        Logger logger = LoggerFactory.getLogger("test");
        for (Users users : from_users_) {
            logger.info(String.valueOf(users));
        }
        UserManager userRepository = (UserManager) context.getBean("umgr");
        /*List<Users> allUsers = userRepository.getAllUsers();
        for (Users allUser : allUsers) {
            logger.info("repo: " + allUser);
        }
        Users build = Users.builder().login("test").email("aaa@ff.ru").password("aassdd").build();
        try {
            int user = userRepository.create(build);
        } catch (DaoException e) {
            logger.error(e, e);
        }
        logger.info("id: " + build);*/
       /* try {
            userRepository.insertUsers();
        }catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }*/
    }
}
