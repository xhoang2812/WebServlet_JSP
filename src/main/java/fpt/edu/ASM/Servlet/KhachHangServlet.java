package fpt.edu.ASM.Servlet;

import fpt.edu.ASM.Model.KhachHang;
import fpt.edu.ASM.Repository.KhachHangRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({"/khach-hang/list","/khach-hang/add","/khach-hang/delete","/khach-hang/detail","/khach-hang/update"})
public class KhachHangServlet extends HttpServlet {

    private ArrayList<KhachHang> listKh;
    private final KhachHangRepo khachHangRepo = new KhachHangRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/khach-hang/list")) {
            hienThi(req, resp);
        }else if(uri.equals("/khach-hang/delete")){
            delete(req,resp);
        }else if(uri.equals("/khach-hang/detail")) {
            detail(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        KhachHang kh = khachHangRepo.getDetail(id);
        khachHangRepo.delete(kh);
        resp.sendRedirect("/khach-hang/list");
    }
    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        KhachHang khDetail = khachHangRepo.getDetail(id);
        req.setAttribute("khDetail",khDetail);
        req.getRequestDispatcher("/KhachHang/detailKhachHang.jsp").forward(req, resp);
    }

    public void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listKh = khachHangRepo.getAll();
        req.setAttribute("listKh", listKh);
        req.getRequestDispatcher("/KhachHang/listKhachHang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/khach-hang/add")){
            String hoTen = req.getParameter("hoTen");
            String diaChi = req.getParameter("diaChi");
            String sdt = req.getParameter("sdt");
            String trangThai = req.getParameter("trangThai");
            KhachHang kh = new KhachHang();
            kh.setHoTen(hoTen);
            kh.setDiaChi(diaChi);
            kh.setSdt(sdt);
            kh.setTrangThai(trangThai);
            kh.setNgayTao(new Date());
            kh.setNgaySua(null);
            khachHangRepo.add(kh);
            resp.sendRedirect("/khach-hang/list");
        }else if(uri.equals("/khach-hang/update")){
            update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        KhachHang kh = khachHangRepo.getDetail(id);
        String hoTen = req.getParameter("hoTen");
        String diaChi = req.getParameter("diaChi");
        String sdt = req.getParameter("sdt");
        String trangThai = req.getParameter("trangThai");
        kh.setHoTen(hoTen);
        kh.setDiaChi(diaChi);
        kh.setSdt(sdt);
        kh.setTrangThai(trangThai);
        kh.setNgaySua(new Date());
        khachHangRepo.update(kh);
        resp.sendRedirect("/khach-hang/list");
    }


}


