package fpt.edu.ASM.Servlet;

import fpt.edu.ASM.Model.HoaDon;
import fpt.edu.ASM.Model.HoaDonChiTiet;
import fpt.edu.ASM.Repository.HoaDonChiTietRepo;
import fpt.edu.ASM.Repository.HoaDonRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/hoa-don/list","/hoa-don-ct/detail"})
public class HoaDonServlet extends HttpServlet {
    ArrayList<HoaDon> listHd = new ArrayList<>();
    ArrayList<HoaDonChiTiet> listHdct = new ArrayList<>();

    HoaDonRepo hoaDonRepo = new HoaDonRepo();
    HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.equals("/hoa-don/list")){
            listHd = hoaDonRepo.getAllByTrangThai();
            req.setAttribute("listHd",listHd);
            req.getRequestDispatcher("/HoaDonCT.jsp").forward(req,resp);
        }
        else if(uri.equals("/hoa-don-ct/detail")){
            Integer idHoaDon = Integer.parseInt(req.getParameter("idHoaDon"));
            HoaDon hdDetail = hoaDonRepo.getDetail(idHoaDon);
            listHdct = hoaDonChiTietRepo.getDetail(idHoaDon);
            req.setAttribute("listHdct",listHdct);
            req.setAttribute("listHd",listHd);
            req.getRequestDispatcher("/HoaDonCT.jsp").forward(req,resp);
        }
    }
}
