package fpt.edu.ASM.Repository;

import fpt.edu.ASM.Connect.HibernateUtils;
import fpt.edu.ASM.Model.HoaDon;
import fpt.edu.ASM.Model.HoaDonChiTiet;
import fpt.edu.ASM.Model.SanPhamChiTiet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class HoaDonChiTietRepo {
    Session session;

    public ArrayList<HoaDonChiTiet> getAll(){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<HoaDonChiTiet> list = (ArrayList<HoaDonChiTiet>) session.createQuery("from HoaDonChiTiet").list();
        session.close();
        return list;
    }

    public ArrayList<HoaDonChiTiet> getDetail(Integer id){
        session = HibernateUtils.getFACTORY().openSession();
        ArrayList<HoaDonChiTiet> hdct = (ArrayList<HoaDonChiTiet>) session.createQuery("from HoaDonChiTiet where hoaDon.id = :id_1").setParameter("id_1",id).getResultList();
        session.close();
        return hdct;
    }

    public HoaDonChiTiet getDetailSingle(Integer id){
        session = HibernateUtils.getFACTORY().openSession();
        HoaDonChiTiet hdct = (HoaDonChiTiet) session.createQuery("from HoaDonChiTiet where id = :id_1").setParameter("id_1",id).getSingleResult();
        session.close();
        return hdct;
    }

    public HoaDonChiTiet getDetailSingleSPCT(Integer id, Integer idHoaDon){
        session = HibernateUtils.getFACTORY().openSession();
        HoaDonChiTiet hdct = (HoaDonChiTiet) session.createQuery("from HoaDonChiTiet where sanPhamChiTiet.id = :id_1 and hoaDon.id = :id_2 ").setParameter("id_1",id).setParameter("id_2",idHoaDon).getSingleResult();
        session.close();
        return hdct;
    }

    public void add(HoaDonChiTiet hdct){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void update(HoaDonChiTiet hdct){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
    public void delete(HoaDonChiTiet hdct){
        session = HibernateUtils.getFACTORY().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(hdct);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
