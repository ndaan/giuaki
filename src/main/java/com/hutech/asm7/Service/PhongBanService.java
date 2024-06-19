package com.hutech.asm7.Service;


import com.hutech.asm7.Model.PhongBan;
import com.hutech.asm7.Repository.PhongBanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PhongBanService {

    private final PhongBanRepository phongBanRepository;

    /**
     * Retrieve all phong ban from the database.
     * @return a list of phong ban
     */
    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }

    /**
     * Retrieve a phong ban by its id.
     * @param id the id of the phong ban to retrieve
     * @return an Optional containing the found phong ban or empty if not found
     */
    public Optional<PhongBan> getPhongBanById(Long id) {
        return phongBanRepository.findById(id);
    }

    /**
     * Add a new phong ban to the database.
     * @param phongBan the phong ban to add
     */
    public void addPhongBan(PhongBan phongBan) {
        phongBanRepository.save(phongBan);
    }

    /**
     * Update an existing phong ban.
     * @param phongBan the phong ban with updated information
     */
    public void updatePhongBan(@NotNull PhongBan phongBan) {
        PhongBan existingPhongBan = phongBanRepository.findById(phongBan.getId())
                .orElseThrow(() -> new IllegalStateException("Phong ban with ID " +
                        phongBan.getId() + " does not exist."));
        existingPhongBan.setTenPhong(phongBan.getTenPhong());
        phongBanRepository.save(existingPhongBan);
    }

    /**
     * Delete a phong ban by its id.
     * @param id the id of the phong ban to delete
     */
    public void deletePhongBanById(Long id) {
        if (!phongBanRepository.existsById(id)) {
            throw new IllegalStateException("Phong ban with ID " + id + " does not exist.");
        }
        phongBanRepository.deleteById(id);
    }
}
