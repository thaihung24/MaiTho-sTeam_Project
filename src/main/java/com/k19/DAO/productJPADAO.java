package com.k19.DAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.k19.models.productJPA;

import connection.dbUtil;

public class productJPADAO {

    // insert
    public void insertProduct(final productJPA product) throws ClassNotFoundException, SQLException {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
        try {
            emf = dbUtil.getEMF();
            em = emf.createEntityManager();
            trans = em.getTransaction();
            trans.begin();
            // insert
            em.persist(product);
            trans.commit();
        } catch (NoResultException e) {
            e.printStackTrace();
            trans.rollback();
        } catch (NullPointerException e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }
    // select single
    public static productJPA selectProduct(final String productCode) throws ClassNotFoundException, SQLException {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        productJPA product = null;
        try {
            product = em.find(productJPA.class, productCode);
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return product;
    }
    //  select 
    public static List<productJPA> selectProducts(String classify,String sort) {
        EntityManager em = dbUtil.getEMF().createEntityManager();
        String qString = "SELECT u from productJPA u ";
        if(classify!=null)
        {
            qString+="WHERE u.classify = :classify ";
        }
        if(sort!=null)
        {
            qString+="ORDER BY u.price "+sort;
        }
        if(classify==null)
        {
            TypedQuery<productJPA> q = em.createQuery(qString, productJPA.class);
            List<productJPA> products;
            try {
                products = q.getResultList();
                if (products == null || products.isEmpty())
                    products = null;
            } finally {
                em.close();
            }
            return products;
        }
        else{
            TypedQuery<productJPA> q = em.createQuery(qString, productJPA.class);
            q.setParameter("classify", classify);
            List<productJPA> products;
            try {
                products = q.getResultList();
                if (products == null || products.isEmpty())
                    products = null;
            } finally {
                em.close();
            }
            return products;
        }
    }
}