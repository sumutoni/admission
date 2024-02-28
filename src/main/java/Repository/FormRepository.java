package Repository;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Model.Form;

public class FormRepository {
    public boolean saveForm(Form form){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(form);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public List<Form> getForms(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Form> forms = null;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Query<Form> query = session.createQuery("FROM Form", Form.class);
            forms = query.getResultList();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return forms;
    }

    public Form getForm(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Form form = null;
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            Query<Form> query = session.createQuery("FROM Form where ID =: id", Form.class);
            query.setParameter("id", id);
            form = query.uniqueResult();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return form;
    }

    public boolean updateStatus(int id, String status){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            @SuppressWarnings("deprecation")
            Query query= session.createQuery("update Form set status =: status where ID =: id");
            query.setParameter("status", status);
            query.setParameter("id", id);
            int rowCount = query.executeUpdate(); // Execute the update operation
            transaction.commit(); // Commit the transaction
            return rowCount == 1; 
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }
}
