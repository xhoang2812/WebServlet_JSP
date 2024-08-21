package fpt.edu.ASM.Servlet;

import fpt.edu.ASM.Model.*;
import fpt.edu.ASM.Repository.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.security.auth.login.AccountExpiredException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet({"/ban-hang", "/hoa-don/detail", "/hoa-don/delete",
        "/hoa-don/thanh-toan",
        "/hoa-don/add", "/hoa-don-chi-tiet/delete", "/khach-hang/detail-phone", "/hoa-don-chi-tiet/add"})
public class BanHangServlet extends HttpServlet {

    ArrayList<HoaDon> listHd = new ArrayList<>();
    ArrayList<HoaDonChiTiet> listHdct = new ArrayList<>();
    ArrayList<SanPhamChiTiet> listSpct = new ArrayList<>();

    KhachHangRepo khachHangRepo = new KhachHangRepo();
    SanPhamChiTietRepo sanPhamChiTietRepo = new SanPhamChiTietRepo();
    HoaDonRepo hoaDonRepo = new HoaDonRepo();
    HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();

    Double tongTien = Double.valueOf(0);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals("/ban-hang")) {
            listSpct = sanPhamChiTietRepo.getAll();
            listHd = hoaDonRepo.getAll();
            req.setAttribute("listSpct", listSpct);
            req.setAttribute("listHd", listHd);
            req.getRequestDispatcher("/x.jsp").forward(req, resp);

        } else if (uri.equals("/khach-hang/detail-phone")) {
            String timKiem = req.getParameter("timKiem");
            req.setAttribute("sdt", timKiem);
            KhachHang khDetailByPhone = khachHangRepo.getDetailByPhone(timKiem);
            req.setAttribute("khDetailByPhone", khDetailByPhone);
            req.setAttribute("listSpct", listSpct);
            req.setAttribute("listHd", listHd);
            req.getRequestDispatcher("/x.jsp").forward(req, resp);

        } else if (uri.equals("/hoa-don/add")) {
            String timKiem = req.getParameter("timKiem");
            KhachHang kh = khachHangRepo.getDetailBySDT(timKiem);
            HoaDon hd = new HoaDon();
            kh.getId();
            if (timKiem.isEmpty()) {
                hd.setKhachHang(null);
            } else {
                hd.setKhachHang(kh);
            }
            hd.setTrangThai("Chua Thanh Toan");
            hd.setNgayTao(new Date());
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("hoaDon", hoaDonRepo.add(hd));
            resp.sendRedirect("/ban-hang");

        } else if (uri.contains("/hoa-don/detail")) {
            Integer idHoaDon = Integer.parseInt(req.getParameter("idHoaDon"));
            HoaDon hdDetail = hoaDonRepo.getDetail(idHoaDon);
            listHdct = hoaDonChiTietRepo.getDetail(idHoaDon);
            HttpSession session = req.getSession();
            session.setAttribute("hoaDon", hdDetail);
            tongTien = Double.valueOf(0);
            for (HoaDonChiTiet hoaDonChiTiet : listHdct) {
                tongTien += hoaDonChiTiet.getTongTien();
            }
            req.setAttribute("tongTien", tongTien);
            req.setAttribute("listHdct", listHdct);
            req.setAttribute("hdDetail", hdDetail); 
            req.setAttribute("listSpct", listSpct);
            req.setAttribute("listHd", listHd);
            req.getRequestDispatcher("/x.jsp").forward(req, resp);

        } else if (uri.contains("/hoa-don/delete")) {
            Integer idHoaDon = Integer.parseInt(req.getParameter("idHoaDon"));
            HoaDon hdDetail = hoaDonRepo.getDetail(idHoaDon);
            hoaDonRepo.delete(hdDetail);
            resp.sendRedirect("/ban-hang");

        } else if (uri.contains("/hoa-don-chi-tiet/delete")) {
            HttpSession session = req.getSession();
            //Tạo đối tượng hd, spct
            HoaDon hd = (HoaDon) session.getAttribute("hoaDon");

            Integer idSPCT = Integer.parseInt(req.getParameter("idSanPhamChiTiet"));
            Integer idHoaDonChiTiet = Integer.parseInt(req.getParameter("idHoaDonChiTiet"));

            HoaDonChiTiet hdct = hoaDonChiTietRepo.getDetailSingle(idHoaDonChiTiet);
            SanPhamChiTiet spctDetail = sanPhamChiTietRepo.getDetail(idSPCT);

            Double soLuongTang = spctDetail.getSoLuongTon() + hdct.getSoLuongMua();
            spctDetail.setSoLuongTon(soLuongTang);
            sanPhamChiTietRepo.update(spctDetail);
            hoaDonChiTietRepo.delete(hdct);
            listSpct = sanPhamChiTietRepo.getAll();
            listHd = hoaDonRepo.getAll();
            req.setAttribute("listSpct", listSpct);
            req.setAttribute("listHd", listHd);
            resp.sendRedirect("/hoa-don/detail?idHoaDon=" + hd.getId());

        } else if (uri.contains("/hoa-don-chi-tiet/add")) {
            Integer idSPCT = Integer.parseInt(req.getParameter("idSanPhamChiTiet"));
            HttpSession session = req.getSession();
            //Tạo đối tượng hd, spct
            HoaDon hd = (HoaDon) session.getAttribute("hoaDon");
            SanPhamChiTiet spct = new SanPhamChiTiet();
            hd.getId();
            spct.setId(idSPCT);

            //Giảm số lượng sp
            SanPhamChiTiet spctDetail = sanPhamChiTietRepo.getDetail(idSPCT);
            Double soLuongGiam = spctDetail.getSoLuongTon() - 1.0;
            spctDetail.setSoLuongTon(soLuongGiam);
            sanPhamChiTietRepo.update(spctDetail);

            int dem = 0;
            for (HoaDonChiTiet hdct : hoaDonChiTietRepo.getAll()) {
                if (hdct.getSanPhamChiTiet().getId().equals(idSPCT) && hdct.getHoaDon().getId().equals(hd.getId())) {
                    dem++;
                }
            }
            if (dem == 0) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setHoaDon(hd);
                hdct.setSanPhamChiTiet(spct);
                hdct.setSoLuongMua(1);
                hdct.setGiaBan(spctDetail.getGiaBan());
                hdct.setTongTien(hdct.getGiaBan() * hdct.getSoLuongMua());
                hdct.setNgayTao(new Date());
                hoaDonChiTietRepo.add(hdct);
            } else {
                HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepo.getDetailSingleSPCT(idSPCT,hd.getId());
                int soLuongTang = 1 + hoaDonChiTiet.getSoLuongMua();
                hoaDonChiTiet.setHoaDon(hd);
                hoaDonChiTiet.setSanPhamChiTiet(spct);
                hoaDonChiTiet.setSoLuongMua(soLuongTang);
                hoaDonChiTiet.setTongTien(hoaDonChiTiet.getGiaBan() * hoaDonChiTiet.getSoLuongMua());
                hoaDonChiTiet.setNgaySua(new Date());
                hoaDonChiTietRepo.update(hoaDonChiTiet);
            }

            listSpct = sanPhamChiTietRepo.getAll();
            listHd = hoaDonRepo.getAll();
            req.setAttribute("listSpct", listSpct);
            req.setAttribute("listHd", listHd);
            resp.sendRedirect("/hoa-don/detail?idHoaDon=" + hd.getId());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/hoa-don/thanh-toan")) {
            Integer idHoaDon = Integer.parseInt(req.getParameter("idHoaDon"));
            HoaDon hoaDonDetail = hoaDonRepo.getDetail(idHoaDon);
            hoaDonDetail.setTrangThai("Da thanh toan");
            hoaDonDetail.setNgaySua(new Date());
            hoaDonRepo.update(hoaDonDetail);
            resp.sendRedirect("/ban-hang");
        }
    }
}
