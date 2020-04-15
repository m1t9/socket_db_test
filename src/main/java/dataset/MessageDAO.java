package dataset;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class MessageDAO {

    private Session session;

    public MessageDAO(Session session) {
        this.session = session;
    }

    public MessageDataSet get(long id) throws HibernateException {
        return (MessageDataSet) session.get(MessageDataSet.class, id);
    }

    public long getMessageId(String message) throws HibernateException {
        Criteria criteria = session.createCriteria(MessageDataSet.class);
        return ((MessageDataSet) criteria.add(Restrictions.eq("message", message)).uniqueResult()).getId();
    }

    public long insertMessage(String message) throws HibernateException {
        return (Long) session.save(new MessageDataSet(message));
    }

}
