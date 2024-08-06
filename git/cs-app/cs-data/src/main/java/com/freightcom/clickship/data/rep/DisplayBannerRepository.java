package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.DisplayBanner;

@Repository
public interface DisplayBannerRepository extends JpaRepository<DisplayBanner, String> {
    
    public List<DisplayBanner> findByAppPageNameInAndActiveIsTrue(List<String> list);

}
