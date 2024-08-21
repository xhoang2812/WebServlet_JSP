package fpt.edu.ASM.Repository;

import fpt.edu.ASM.Connect.HibernateUtils;
import fpt.edu.ASM.Model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamRepo {

    Session session;

    public ArrayList<SanPham> getAll(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<SanPham> list = (ArrayList<SanPham>) session.createQuery("from SanPham ").list();
        session.close();
        return list;
    }
    public SanPham getDetail(Integer id){
        session = HibernateUtils.getFACTORY().openSession();
        SanPham list = (SanPham) session.createQuery("from SanPham where id = :id_1")
                                    .setParameter("id_1",id).getSingleResult();
        session.close();
        return list;
    }

    public void add(SanPham sp){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(SanPham sp){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(SanPham sp){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(sp);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }




    public static void main(String[] args) {
        ArrayList<SanPham> list = new SanPhamRepo().getAll();
       for (SanPham sp : list){
           System.out.println(sp.toString());
       }
    }
}
