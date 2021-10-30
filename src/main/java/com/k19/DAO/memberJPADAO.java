package com.k19.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.google.gson.Gson;
import com.k19.models.lineItem;
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
            System.out.println(emf);
            System.out.println(em);

            // insert
            em.persist(member);
            trans.commit();
        } catch (NoResultException e) {
            e.printStackTrace();
            trans.rollback();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();

            }
        }
    }

    public static memberJPA selectMember(final String username) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
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

    public static memberJPA checkMember(final String uname, final String password) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
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

    public static int updateMember(memberJPA member) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction trans = null;
        // make entity manager
        emf = dbUtil.getEMF();
        em = emf.createEntityManager();
        // get data
        String firstName = member.getFirstName();
        String lastName = member.getLastName();
        String email = member.getEmail();
        String contact = member.getContact();
        String gentle = member.getGentle();
        String uname = member.getUsername();
        // query
        String query = "Update member set firstName = :firstname, " + "lastName = :lastname," + "email = :email,"
                + "gentle = :gentle," + "contact = :contact" + "Where username =:username";
        Query q = em.createQuery(query);
        q.setParameter("firstname", firstName);
        q.setParameter("lastName", lastName);
        q.setParameter("email", email);
        q.setParameter("gentle", contact);
        q.setParameter("contact", gentle);
        q.setParameter("username", uname);
        //
        // start trans
        int count = 0;
        // 0 is failure
        // !0 is true
        try {
            trans.begin();
            count = q.executeUpdate();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            em.close();
        }
        return count;
    }
}
// Front-end
// Back-end
// Database