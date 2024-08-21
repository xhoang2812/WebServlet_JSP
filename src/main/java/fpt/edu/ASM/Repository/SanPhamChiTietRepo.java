package fpt.edu.ASM.Repository;

import fpt.edu.ASM.Connect.HibernateUtils;
import fpt.edu.ASM.Model.SanPhamChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class SanPhamChiTietRepo {

    Session session;

    public ArrayList<SanPhamChiTiet> getAll(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<SanPhamChiTiet> list = (ArrayList<SanPhamChiTiet>) session.createQuery("from SanPhamChiTiet ").list();
        session.close();
        return list;
    }

    public void add(SanPhamChiTiet spct){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(spct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(SanPhamChiTiet spct){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(spct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(SanPhamChiTiet spct){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(spct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public SanPhamChiTiet getDetail(Integer id){
        session = HibernateUtils.getFACTORY().openSession();
        SanPhamChiTiet spct = (SanPhamChiTiet) session.createQuery("from SanPhamChiTiet where id = :id_1")
                .setParameter("id_1",id).getSingleResult();
        session.close();
        return spct;
    }


    public static void main(String[] args) {
        ArrayList<SanPhamChiTiet> list = new SanPhamChiTietRepo().getAll();
        for (SanPhamChiTiet spct : list){
            System.out.println(spct.toString());
        }
    }
}
