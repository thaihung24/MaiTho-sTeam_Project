package com.k19.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;
import com.k19.models.memberJPA;

import connection.dbUtil;

public class memberJPADAO {
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    private static EntityTransaction trans = null;

    public void insertMember(final memberJPA member) {

        try {
            emf = dbUtil.getEMF();
            em = emf.createEntityManager();
            trans = em.getTransaction();
            trans.begin();
            // insert
            em.persist(member);
            trans.commit();
        } catch (NoResultException e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static memberJPA selectMember(final String username) {
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        // query
        String query = "SELECT u from member u " + "WHERE u.username = :username";
        // retrieve
        TypedQuery<memberJPA> q = em.createQuery(query, memberJPA.class);
        q.setParameter("username", username);
        memberJPA member = null;
        try {
            member = q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
        return member;
    }

    public static memberJPA checkMember(final String uname, final String password) {
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        // query
        String query = "SELECT u from member u " + "WHERE u.username = :username and u.password = :password";
        // retrieve
        TypedQuery<memberJPA> q = em.createQuery(query, memberJPA.class);
        q.setParameter("username", uname);
        q.setParameter("password", password);
        memberJPA member = null;
        try {
            member = q.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
        return member;

    }
}
