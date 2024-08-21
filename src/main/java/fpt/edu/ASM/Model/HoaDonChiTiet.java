package fpt.edu.ASM.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hdct")
public class HoaDonChiTiet {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "id_ctsp")
    private SanPhamChiTiet sanPhamChiTiet;

    @Column(name = "so_luong_mua")
    private Integer soLuongMua;

    @Column(name = "gia_ban")
    private Double giaBan;

    @Column(name = "tong_tien")
    private Double tongTien;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_sua")
    private Date ngaySua;

    @Override
    public String toString() {
        return "HoaDonChiTiet{" +
                "id=" + id +
                ", hoaDon=" + hoaDon +
                ", sanPhamChiTiet=" + sanPhamChiTiet +
                ", soLuongMua=" + soLuongMua +
                ", giaBan=" + giaBan +
                ", tongTien=" + tongTien +
                ", trangThai='" + trangThai + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                '}';
    }
}
