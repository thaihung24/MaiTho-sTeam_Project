package com.k19.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.k19.models.memberJPA;

import connection.dbUtil;

public class memberJPADAO {

    public void insertMember(final memberJPA member) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
        try {
            // emf = dbUtil.getEMF();
            emf = Persistence.createEntityManagerFactory("k19WebApp");
            em = emf.createEntityManager();
            trans = em.getTransaction();
            trans.begin();
            // insert
            em.persist(member);
            trans.commit();
        } catch (NoResultException e) {
            e.printStackTrace();
            trans.rollback();
        } catch (NullPointerException e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            if (em != null) {
                em.close();

            }
        }
    }

    public static memberJPA selectMember(final String username) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
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
            if (em != null) {
                em.close();

            }
        }
        return member;
    }

    public static memberJPA selectMemberbyId(int _id) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        memberJPA member = null;
        try {
            member = em.find(memberJPA.class, _id);
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return member;
    }

    public static memberJPA checkMember(final String uname, final String password) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
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
            if (em != null) {
                em.close();

            }
        }
        return member;

    }

    public void updateMember(memberJPA member) {
        //
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
        // make entity manager
        // emf = dbUtil.getEMF();
        // em = emf.createEntityManager();
        //
        //
        // start trans
        try {
            emf = Persistence.createEntityManagerFactory("k19WebApp");
            em = emf.createEntityManager();
            trans = em.getTransaction();
            trans.begin();
            em.merge(member);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
// Front-end
// Back-end
// Database