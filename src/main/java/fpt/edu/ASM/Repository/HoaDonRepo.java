package fpt.edu.ASM.Repository;

import fpt.edu.ASM.Connect.HibernateUtils;
import fpt.edu.ASM.Model.HoaDon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HoaDonRepo {
    Session session;

    public ArrayList<HoaDon> getAll(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) session.createQuery("from HoaDon where trangThai = 'Chua Thanh Toan'").list();
        session.close();
        return list;
    }
    public ArrayList<HoaDon> getAllByTrangThai(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<HoaDon> list = (ArrayList<HoaDon>) session.createQuery("from HoaDon where trangThai = 'Da Thanh Toan'").list();
        session.close();
        return list;
    }

    public HoaDon getDetail(Integer id){
        session = HibernateUtils.getFACTORY().openSession();
        HoaDon hd = (HoaDon) session.createQuery("from HoaDon where id = :id_1").setParameter("id_1",id).getSingleResult();
        session.close();
        return hd;
    }

    public HoaDon add(HoaDon hd){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hd);
            transaction.commit();
            session.refresh(hd);
            return hd;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            throw e;
        }

    }
    public void update(HoaDon hd){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(HoaDon hd){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(hd);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public static void main(String[] args) {
        ArrayList<HoaDon> list = new HoaDonRepo().getAll();
        for (HoaDon hd : list){
            System.out.println(hd.toString());
        }
    }

}
