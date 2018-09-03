package Repository;

import Entity.Carro;
import Factory.HibernateFactory;
import Model.CarroTableModel;
import View.GridCarro;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CarroRepository {

    SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    public List<Carro> lista(String nome) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createSQLQuery("SELECT * FROM Carro WHERE Nome LIKE :nome ORDER BY Id")
                    .addEntity(Carro.class)
                    .setParameter("nome", "%" + nome.toUpperCase() + "%");
            return query.list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new Error(ex.getMessage());
        } finally {
            session.close();
        }
    }

    public int proximaSequencia() {
        //CREATE SEQUENCE carros MINVALUE 1
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createSQLQuery("SELECT nextval('carros')");
            return Integer.parseInt(query.uniqueResult().toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new Error(ex.getMessage());
        } finally {
            session.close();
        }
    }

    public void atualizaStore(String descricao) {
        CarroTableModel model = (CarroTableModel) GridCarro.jTableCarro.getModel();
        model.clear();
        model.addList(new CarroRepository().lista(descricao));
        GridCarro.jTableCarro.setModel(model);
    }

    public Carro buscaPorId(int Id) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createSQLQuery("SELECT * FROM Carro WHERE Id = :Id")
                    .addEntity(Carro.class)
                    .setParameter("Id", Id);
            return (Carro) query.uniqueResult();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new Error(ex.getMessage());
        } finally {
            session.close();
        }
    }

    public void gravar(Carro carro) {
        if (carro.getId() == 0) {
            carro.setId(proximaSequencia());
        }
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(carro);
            session.getTransaction().commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            session.getTransaction().rollback();
            throw new Error(ex.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluir(int id) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Query query = session.createSQLQuery("DELETE FROM carro WHERE Id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new Error(ex.getMessage());
        } finally {
            session.close();
        }
    }
}
