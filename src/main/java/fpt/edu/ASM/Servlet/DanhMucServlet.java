package fpt.edu.ASM.Servlet;

import fpt.edu.ASM.Model.DanhMuc;
import fpt.edu.ASM.Repository.DanhMucRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({"/danh-muc/list","/danh-muc/add","/danh-muc/detail","/danh-muc/delete","/danh-muc/update"})
public class DanhMucServlet extends HttpServlet {

    ArrayList<DanhMuc> listDanhMuc;
    DanhMucRepo danhMucRepo = new DanhMucRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/danh-muc/list")){
            hienThi(req,resp);
        }else if(uri.equals("/danh-muc/detail")){
            detail(req,resp);
        }else if(uri.equals("/danh-muc/delete")){
            delete(req,resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        System.out.println(req.getParameter("id")   );
        DanhMuc danhMuc = danhMucRepo.getDetail(id);
        danhMucRepo.delete(danhMuc);
        resp.sendRedirect("/danh-muc/list");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        DanhMuc dmDetail = danhMucRepo.getDetail(id);
        req.setAttribute("dmDetail",dmDetail);
        req.getRequestDispatcher("/DanhMuc/detailDanhMuc.jsp").forward(req,resp);
    }

    public void hienThi(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        listDanhMuc = danhMucRepo.getALl();
        req.setAttribute("listDanhMuc",listDanhMuc);
        req.getRequestDispatcher("/DanhMuc/listDanhMuc.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/danh-muc/add")){
            String ma = req.getParameter("maDanhMuc");
            String ten = req.getParameter("tenDanhMuc");
            String trangThai = req.getParameter("trangThai");
            DanhMuc dm = new DanhMuc();
            dm.setMaDanhMuc(ma);
            dm.setTenDanhMuc(ten);
            dm.setTrangThai(trangThai);
            dm.setNgayTao(new Date());
            danhMucRepo.add(dm);
            resp.sendRedirect("/danh-muc/list");
        }else if(uri.contains("/danh-muc/update")){
            update(req,resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        DanhMuc danhMuc = danhMucRepo.getDetail(id);
        String ma = req.getParameter("maDanhMuc");
        String ten = req.getParameter("tenDanhMuc");
        String trangThai = req.getParameter("trangThai");
        danhMuc.setTenDanhMuc(ten);
        danhMuc.setMaDanhMuc(ma);
        danhMuc.setTrangThai(trangThai);
        danhMuc.setNgaySua(new Date());
        danhMucRepo.update(danhMuc);
        resp.sendRedirect("/danh-muc/list");
    }


}
