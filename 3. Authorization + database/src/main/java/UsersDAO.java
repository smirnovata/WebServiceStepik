import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;

//Для хранения данных пользователя используйте таблицу users:
//create table if not exists users (id bigint auto_increment, login varchar(256), password varchar(256), primary key (id));
//Сервер должен создавать таблицу при старте если она не существует.
//При получении запроса на signup сервлет должен обратиться к DBService и записать логин и пароль в таблицу.
public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet getById(BigInteger id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public UsersDataSet getUserByLogin(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return (UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
    }

    public BigInteger insertUser(String login, String password) throws HibernateException {
        return (BigInteger) session.save(new UsersDataSet(login, password));
    }
}
