package fpt.edu.ASM.Repository;

import fpt.edu.ASM.Connect.HibernateUtils;
import fpt.edu.ASM.Model.KhachHang;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class KhachHangRepo {
    Session session;

    public ArrayList<KhachHang> getAll() {
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<KhachHang> list = (ArrayList<KhachHang>) session.createQuery("from KhachHang ").list();
        session.close();
        return list;
    }

    public KhachHang getDetail(Integer id) {
        session = HibernateUtils.getFACTORY().openSession();
        KhachHang list = (KhachHang) session.createQuery("from KhachHang where id = :id_1")
                .setParameter("id_1", id).getSingleResult();
        session.close();
        return list;
    }

    public KhachHang getDetailByPhone(String sdt) {
        session = HibernateUtils.getFACTORY().openSession();
        KhachHang list = (KhachHang) session.createQuery("from KhachHang where sdt = :sdt_1")
                .setParameter("sdt_1", sdt).getSingleResult();
        session.close();
        return list;
    }

    public KhachHang getDetailBySDT(String sdt) {
        session = HibernateUtils.getFACTORY().openSession();
        KhachHang list = (KhachHang) session.createQuery("from KhachHang where sdt = :sdt_1")
                .setParameter("sdt_1",sdt).getSingleResult();
        session.close();
        return list;
    }

    public void add(KhachHang kh) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public void delete(KhachHang kh) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public void update(KhachHang kh) {
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(kh);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        session.close();
    }

    public static void main(String[] args) {
        ArrayList<KhachHang> list = new KhachHangRepo().getAll();
        for (KhachHang kh : list) {
            System.out.println(kh.toString());
        }
    }
}
