package fpt.edu.ASM.Servlet;

import fpt.edu.ASM.Model.MauSac;
import fpt.edu.ASM.Model.SanPham;
import fpt.edu.ASM.Model.SanPhamChiTiet;
import fpt.edu.ASM.Model.Size;
import fpt.edu.ASM.Repository.MauSacRepo;
import fpt.edu.ASM.Repository.SanPhamChiTietRepo;
import fpt.edu.ASM.Repository.SanPhamRepo;
import fpt.edu.ASM.Repository.SizeRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({"/san-pham-chi-tiet/list", "/san-pham-chi-tiet/add", "/san-pham-chi-tiet/delete", "/san-pham-chi-tiet/detail", "/san-pham-chi-tiet/update"})
public class SanPhamChiTietServlet extends HttpServlet {
    SanPhamRepo sanPhamRepo = new SanPhamRepo();
    SizeRepo sizeRepo = new SizeRepo();
    MauSacRepo mauSacRepo = new MauSacRepo();
    SanPhamChiTietRepo sanPhamChiTietRepo = new SanPhamChiTietRepo();
    ArrayList<SanPhamChiTiet> listSpct;
    ArrayList<SanPham> listSp;
    ArrayList<Size> listSz;
    ArrayList<MauSac> listMs;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/san-pham-chi-tiet/list")) {
            hienThi(req, resp);
        }else if (uri.equals("/san-pham-chi-tiet/delete")){
            xoa(req,resp);
        }else if(uri.equals("/san-pham-chi-tiet/detail")){
            detail(req,resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/san-pham-chi-tiet/add")) {
            this.add(req, resp);
        }else if(uri.equals("/san-pham-chi-tiet/update")){
            this.update(req,resp);
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Double giaban = Double.parseDouble(req.getParameter("giaBan"));
        Double soLuongTon = Double.parseDouble(req.getParameter("soLuongTon"));
        String trangThai = req.getParameter("trangThai");
        Integer idSp = Integer.parseInt(req.getParameter("tenSanPham"));
        Integer idMs = Integer.parseInt(req.getParameter("tenMau"));
        Integer idSz = Integer.parseInt(req.getParameter("tenSize"));
        SanPham sp = new SanPham();
        sp.setId(idSp);
        MauSac ms = new MauSac();
        ms.setId(idMs);
        Size sz = new Size();
        sz.setId(idSz);
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setSanPham(sp);
        spct.setMauSac(ms);
        spct.setSize(sz);
        spct.setGiaBan(giaban);
        spct.setSoLuongTon(soLuongTon);
        spct.setTrangThai(trangThai);
        spct.setNgayTao(new Date());
        sanPhamChiTietRepo.add(spct);
        resp.sendRedirect("/san-pham-chi-tiet/list");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Lấy id để tìm đc sản phẩm cần sửa
        Integer id = Integer.parseInt(req.getParameter("id"));
        SanPhamChiTiet spct = sanPhamChiTietRepo.getDetail(id);

        //Get paramet
        Double giaban = Double.parseDouble(req.getParameter("giaBan"));
        Double soLuongTon = Double.parseDouble(req.getParameter("soLuongTon"));
        String trangThai = req.getParameter("trangThai");

        //Lấy id_FK
        Integer idSp = Integer.parseInt(req.getParameter("tenSanPham"));
        Integer idMs = Integer.parseInt(req.getParameter("tenMau"));
        Integer idSz = Integer.parseInt(req.getParameter("tenSize"));

        //Goi Enity lấy Fk
        SanPham sp = new SanPham();
        sp.setId(idSp);
        MauSac ms = new MauSac();
        ms.setId(idMs);
        Size sz = new Size();
        sz.setId(idSz);

        //Set lại spct cần sửa
        spct.setSanPham(sp);
        spct.setMauSac(ms);
        spct.setSize(sz);
        spct.setGiaBan(giaban);
        spct.setSoLuongTon(soLuongTon);
        spct.setTrangThai(trangThai);
        spct.setNgaySua(new Date());
        sanPhamChiTietRepo.update(spct);
        resp.sendRedirect("/san-pham-chi-tiet/list");
    }

    public void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listSp = sanPhamRepo.getAll();
        listMs = mauSacRepo.getAll();
        listSz = sizeRepo.getALl();
        listSpct = sanPhamChiTietRepo.getAll();
        req.setAttribute("listSpct", listSpct);
        req.setAttribute("listSp", listSp);
        req.setAttribute("listMs", listMs);
        req.setAttribute("listSz", listSz);
        req.getRequestDispatcher("/SanPhamChiTiet/listSanPhamChiTiet.jsp").forward(req, resp);
    }
    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        SanPhamChiTiet spctDetail = sanPhamChiTietRepo.getDetail(id);
        listSp = sanPhamRepo.getAll();
        listMs = mauSacRepo.getAll();
        listSz = sizeRepo.getALl();
        req.setAttribute("listSp", listSp);
        req.setAttribute("listMs", listMs);
        req.setAttribute("listSz", listSz);
        req.setAttribute("spctDetail",spctDetail);
        req.getRequestDispatcher("/SanPhamChiTiet/detailSanPhamChiTiet.jsp").forward(req,resp);
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietRepo.getDetail(id);
        sanPhamChiTietRepo.delete(sanPhamChiTiet);
        resp.sendRedirect("/san-pham-chi-tiet/list");
    }
}
