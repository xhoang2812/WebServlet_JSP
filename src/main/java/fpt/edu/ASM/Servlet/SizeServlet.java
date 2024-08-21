package fpt.edu.ASM.Servlet;

import fpt.edu.ASM.Model.Size;
import fpt.edu.ASM.Repository.SizeRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({"/size/list","/size/add","/size/delete","/size/detail","/size/update"})
public class SizeServlet extends HttpServlet {

    ArrayList<Size> listSize;
    SizeRepo sizeRepo = new SizeRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.equals("/size/list")){
            hienThi(req,resp);
        }else if(uri.equals("/size/delete")){
            Integer id = Integer.parseInt(req.getParameter("id"));
            Size sz = sizeRepo.getDetail(id);
            sizeRepo.delete(sz);
            resp.sendRedirect("/size/list");
        }else if(uri.equals("/size/detail")){
            Integer id = Integer.parseInt(req.getParameter("id"));
            Size szDetail = sizeRepo.getDetail(id);
            req.setAttribute("szDetail",szDetail);
            req.getRequestDispatcher("/Size/detailSize.jsp").forward(req,resp);
        }

    }

    public void hienThi(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        listSize = sizeRepo.getALl();
        req.setAttribute("listSize",listSize);
        req.getRequestDispatcher("/Size/listSize.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.equals("/size/add")){
            String maSize = req.getParameter("maSize");
            String tenSize = req.getParameter("tenSize");
            String trangThai = req.getParameter("trangThai");
            Size sz = new Size();
            sz.setMaSize(maSize);
            sz.setTenSize(tenSize);
            sz.setTrangThai(trangThai);
            sz.setNgayTao(new Date());
            sz.setNgaySua(null);
            sizeRepo.add(sz);
            resp.sendRedirect("/size/list");
        }else if(uri.equals("/size/update")){
            String maSize = req.getParameter("maSize");
            String tenSize = req.getParameter("tenSize");
            String trangThai = req.getParameter("trangThai");
            Integer id = Integer.parseInt(req.getParameter("id"));
            Size sz = sizeRepo.getDetail(id);
            sz.setMaSize(maSize);
            sz.setTenSize(tenSize);
            sz.setTrangThai(trangThai);
            sz.setNgaySua(new Date());
            sizeRepo.update(sz);
            resp.sendRedirect("/size/list");
        }
    }
}
