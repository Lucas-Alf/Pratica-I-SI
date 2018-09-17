/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author lukin
 */
public class HibernateFactory {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            File configFile = new File("src/Factory/hibernate.cfg.xml");
            Configuration config = new Configuration();
            config.configure(configFile);
            sessionFactory = config.buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            JOptionPane.showMessageDialog(new JFrame(), "Não foi possivel se conectar ao banco de dados.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
