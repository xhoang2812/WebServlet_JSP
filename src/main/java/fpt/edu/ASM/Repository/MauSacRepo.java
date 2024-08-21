package fpt.edu.ASM.Repository;

import fpt.edu.ASM.Connect.HibernateUtils;
import fpt.edu.ASM.Model.KhachHang;
import fpt.edu.ASM.Model.MauSac;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class MauSacRepo {
    Session session;
    public ArrayList<MauSac> getAll(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<MauSac> list = (ArrayList<MauSac>) session.createQuery("from MauSac ").list();
        session.close();
        return  list;
    }
    public MauSac getDetail(Integer id) {
        session = HibernateUtils.getFACTORY().openSession();
        MauSac list = (MauSac) session.createQuery("from MauSac where id = :id_1")
                .setParameter("id_1", id).getSingleResult();
        session.close();
        return list;
    }

    public void add(MauSac ms){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void delete(MauSac ms){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(MauSac ms){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(ms);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
}
