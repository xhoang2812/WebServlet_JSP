package fpt.edu.ASM.Servlet;

import fpt.edu.ASM.Model.MauSac;
import fpt.edu.ASM.Repository.MauSacRepo;
import jakarta.persistence.Entity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({"/mau-sac/list","/mau-sac/add","/mau-sac/delete","/mau-sac/detail","/mau-sac/update"})
public class MauSacServlet extends HttpServlet {
    ArrayList<MauSac> listMauSac;
    MauSacRepo mauSacRepo = new MauSacRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/mau-sac/list")){
            hienThi(req,resp);
        }else if(uri.equals("/mau-sac/delete")){
            Integer id = Integer.parseInt(req.getParameter("id"));
            MauSac ms = mauSacRepo.getDetail(id);
            mauSacRepo.delete(ms);
            resp.sendRedirect("/mau-sac/list");
        }else if(uri.equals("/mau-sac/detail")){
            Integer id = Integer.parseInt(req.getParameter("id"));
            MauSac msDetail = mauSacRepo.getDetail(id);
            req.setAttribute("msDetail",msDetail);
            req.getRequestDispatcher("/MauSac/detailMauSac.jsp").forward(req,resp);
        }
    }

    public void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listMauSac = mauSacRepo.getAll();
        req.setAttribute("listMauSac",listMauSac);
        req.getRequestDispatcher("/MauSac/listMauSac.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/mau-sac/add")){
            String tenMau = req.getParameter("tenMau");
            String maMau = req.getParameter("maMau");
            String trangThai = req.getParameter("trangThai");
            MauSac ms = new MauSac();
            ms.setMaMau(maMau);
            ms.setTenMau(tenMau);
            ms.setTrangThai(trangThai);
            ms.setNgayTao(new Date());
            ms.setNgaySua(null);
            mauSacRepo.add(ms);
            resp.sendRedirect("/mau-sac/list");
        }else if(uri.equals("/mau-sac/update")){
            Integer id = Integer.parseInt(req.getParameter("id"));
            MauSac ms = mauSacRepo.getDetail(id);
            String tenMau = req.getParameter("tenMau");
            String maMau = req.getParameter("maMau");
            String trangThai = req.getParameter("trangThai");
            ms.setMaMau(maMau);
            ms.setTenMau(tenMau);
            ms.setTrangThai(trangThai);
            ms.setNgaySua(new Date());
            mauSacRepo.update(ms);
            resp.sendRedirect("/mau-sac/list");
        }
    }
}
