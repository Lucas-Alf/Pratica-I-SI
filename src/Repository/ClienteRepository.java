package Repository;

import Entity.Cliente;
import Factory.HibernateFactory;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author lukin
 */
public class ClienteRepository {
    SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    public List<Cliente> lista(String nome) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createSQLQuery("SELECT * FROM Cliente WHERE Nome LIKE :nome ORDER BY Nome")
                    .addEntity(Cliente.class)
                    .setParameter("nome", "%" + nome.toUpperCase() + "%");
            return query.list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new Error(ex.getMessage());
        } finally {
            session.close();
        }
    }

    public void atualizaStore(String descricao) {
//        ClienteTableModel model = (ClienteTableModel) brwCliente.jTableCliente.getModel();
//        model.clear();
//        model.addList(new ClienteRepository().lista(descricao));
//        brwCliente.jTableCliente.setModel(model);
    }

    public Cliente buscaPorCpf(String cpf) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createSQLQuery("SELECT * FROM Cliente WHERE Cpf = :cpf")
                    .addEntity(Cliente.class)
                    .setParameter("cpf", cpf);
            return (Cliente) query.uniqueResult();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new Error(ex.getMessage());
        } finally {
            session.close();
        }
    }

    public void gravar(Cliente Cliente) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(Cliente);
            session.getTransaction().commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            session.getTransaction().rollback();
            throw new Error(ex.getMessage());
        } finally {
            session.close();
        }
    }

    public void excluir(String cpf) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Query query = session.createSQLQuery("DELETE FROM Cliente WHERE Cpf = :cpf")
                    .setParameter("cpf", cpf);
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
