package com.hutech.asm7.Service;

import com.hutech.asm7.Model.NhanVien;
import com.hutech.asm7.Repository.NhanVienRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NhanVienService {

    @Autowired
    private final NhanVienRepository nhanvienRepository;
    // Retrieve all products from the database
    public List<NhanVien> getAllNhanvien() {
        return nhanvienRepository.findAll();
    }
    // Retrieve a product by its id
    public Optional<NhanVien> getNhanVienById(Long id) {
        return nhanvienRepository.findById(id);
    }
    // Add a new product to the database
    public NhanVien addNhanVien(NhanVien nhanvien) {
        return nhanvienRepository.save(nhanvien);
    }
    // Update an existing product
    public NhanVien updateNhanVien(@NotNull NhanVien nhanVien) {
        NhanVien existingNhanVien =nhanvienRepository.findById(nhanVien.getId())
                .orElseThrow(() -> new IllegalStateException("Product with ID " +
                        nhanVien.getId() + " does not exist."));
        existingNhanVien.setTenNv(nhanVien.getTenNv());
        existingNhanVien.setMaNv(nhanVien.getMaNv());
        existingNhanVien.setPhai(nhanVien.getPhai());
        existingNhanVien.setLuong(nhanVien.getLuong());
        existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanVien.setPhongBan(nhanVien.getPhongBan());

        return nhanvienRepository.save(existingNhanVien);
    }
    // Delete a product by its id
    public void deleteNhanVienById(Long id) {
        if (!nhanvienRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        nhanvienRepository.deleteById(id);
    }}

