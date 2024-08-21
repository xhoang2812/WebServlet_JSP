package fpt.edu.ASM.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ctsp")
public class SanPhamChiTiet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size size;

    @Column(name = "gia_ban")
    private Double giaBan;

    @Column(name = "so_luong_ton")
    private Double soLuongTon;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_sua")
    private Date ngaySua;

    @Override
    public String toString() {
        return "SanPhamChiTiet{" +
                "id=" + id +
                ", idSanPham=" + sanPham.getId() +
                ", idMauSac=" + mauSac.getId()+
                ", idSize=" + size.getId() +
                ", giaBan=" + giaBan +
                ", soLuongTon=" + soLuongTon +
                ", trangThai='" + trangThai + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                '}';
    }
}
