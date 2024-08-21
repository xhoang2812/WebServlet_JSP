package fpt.edu.ASM.Repository;

import fpt.edu.ASM.Connect.HibernateUtils;
import fpt.edu.ASM.Model.DanhMuc;
import fpt.edu.ASM.Model.MauSac;
import fpt.edu.ASM.Model.Size;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SizeRepo {
    Session session;
    public ArrayList<Size> getALl(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<Size> list = (ArrayList<Size>) session.createQuery("from Size").list();
        session.close();
        return list;
    }
    public Size getDetail(Integer id) {
        session = HibernateUtils.getFACTORY().openSession();
        Size list = (Size) session.createQuery("from Size where id = :id_1")
                .setParameter("id_1", id).getSingleResult();
        session.close();
        return list;
    }

    public void add(Size sz){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sz);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void delete(Size sz){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(sz);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }
    public void update(Size sz){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sz);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public static void main(String[] args) {
        ArrayList<Size> list = new SizeRepo().getALl();
        for (Size sz : list){
            System.out.println(sz.toString());
        }

    }
}
