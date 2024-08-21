package fpt.edu.ASM.Servlet;

import fpt.edu.ASM.Model.DanhMuc;
import fpt.edu.ASM.Model.SanPham;
import fpt.edu.ASM.Repository.DanhMucRepo;
import fpt.edu.ASM.Repository.SanPhamRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({"/san-pham/list", "/san-pham/add", "/san-pham/delete","/san-pham/detail","/san-pham/update"})
public class SanPhamServlet extends HttpServlet {
    ArrayList<SanPham> listSanPham;
    SanPhamRepo sanPhamRepo = new SanPhamRepo();
    ArrayList<DanhMuc> listDanhMuc;
    DanhMucRepo danhMucRepo = new DanhMucRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/san-pham/list")) {
            hienThi(req, resp);
        } else if (uri.contains("/san-pham/delete")) {
            this.delete(req, resp);
        }else if(uri.contains("/san-pham/detail")){
            this.detail(req,resp);
        }
    }
    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        SanPham sanPhamDetail = sanPhamRepo.getDetail(id);
        listDanhMuc = danhMucRepo.getALl();
        req.setAttribute("listDanhMuc", listDanhMuc);
        req.setAttribute("sanPhamDetail",sanPhamDetail);
        req.getRequestDispatcher("/SanPham/detailSanPham.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        //Lấy thông tin sản phẩm theo id
        SanPham sanPham = sanPhamRepo.getDetail(id);
        sanPhamRepo.delete(sanPham);
        resp.sendRedirect("/san-pham/list");

    }

    public void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listSanPham = sanPhamRepo.getAll();
        listDanhMuc = danhMucRepo.getALl();
        req.setAttribute("listDanhMuc", listDanhMuc);
        req.setAttribute("listSanPham", listSanPham);
        req.getRequestDispatcher("/SanPham/listSanPham.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/san-pham/add")) {
           add(req,resp);
        }else if(uri.equals("/san-pham/update")){
            update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        SanPham sanPham = sanPhamRepo.getDetail(id);
        String maSanPham = req.getParameter("maSanPham");
        String tenSanPham = req.getParameter("tenSanPham");
        String trangThai = req.getParameter("trangThai");
        Integer danhMucId = Integer.parseInt(req.getParameter("danhMuc"));
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setId(danhMucId);
        sanPham.setId(id);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setMaSanPham(maSanPham);
        sanPham.setTrangThai(trangThai);
        sanPham.setDanhMuc(danhMuc);
        sanPham.setNgaySua(new Date());
        sanPhamRepo.update(sanPham);
        resp.sendRedirect("/san-pham/list");
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maSanPham = req.getParameter("maSanPham");
        String tenSanPham = req.getParameter("tenSanPham");
        String trangThai = req.getParameter("trangThai");
        Integer danhMucId = Integer.parseInt(req.getParameter("danhMuc"));

        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setId(danhMucId);

        SanPham sp = new SanPham();
        sp.setMaSanPham(maSanPham);
        sp.setTenSanPham(tenSanPham);
        sp.setTrangThai(trangThai);
        sp.setDanhMuc(danhMuc);
        sp.setNgayTao(new Date());
        sp.setNgaySua(null);
        sanPhamRepo.add(sp);
        resp.sendRedirect("/san-pham/list");
    }


}
