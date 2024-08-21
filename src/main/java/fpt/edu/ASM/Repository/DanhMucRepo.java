package fpt.edu.ASM.Repository;

import fpt.edu.ASM.Connect.HibernateUtils;
import fpt.edu.ASM.Model.DanhMuc;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DanhMucRepo {
    Session session;

    public ArrayList<DanhMuc> getALl() {
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<DanhMuc> list = (ArrayList<DanhMuc>) session.createQuery("from DanhMuc").list();
        session.close();
        return list;
    }

    public DanhMuc getDetail(Integer id) {
        session = HibernateUtils.getFACTORY().openSession();
        DanhMuc list = (DanhMuc) session.createQuery("from DanhMuc where id = :id_1")
                .setParameter("id_1",id).getSingleResult();
        session.close();
        return list;
    }

    public void add(DanhMuc dm) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(dm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public void delete(DanhMuc dm) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(dm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public void update(DanhMuc dm) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(dm);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }


}
