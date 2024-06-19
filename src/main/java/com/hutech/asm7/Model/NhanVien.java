package com.hutech.asm7.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ma Nv is required")
    @Size(max = 3, message = "Mã nhân viên phải ít hơn 3 ký tự")
    private String MaNv;

    @NotEmpty(message = "Ten Nv is required")
    @Size(max = 100, message = "Tên nhân viên phải ít hơn 100 ký tự")
    private String TenNv;

    @NotEmpty(message = "Phai is required")
    @Size(max = 3, message = "Phái phải ít hơn 3 ký tự")
    private String Phai;

    @NotNull(message = "Luong is required")
    @Min(value = 0, message = "Lương phải lớn hơn hoặc bằng 0")
    private double Luong;

    @NotEmpty(message = "Noi Sinh is required")
    @Size(max = 100, message = "Nơi sinh phải ít hơn 100 ký tự")
    private String NoiSinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PhongBan phongBan;

    @NotEmpty(message = "Img Url is required")
    @Size(max = 255, message = "Img Url phải ít hơn 255 ký tự")
    private String ImgUrl;
}