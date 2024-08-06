package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Branding;
import com.freightcom.clickship.data.entity.BrandingEmailSettings;

@Repository
public interface BrandingEmailSettingsRepository extends JpaRepository<BrandingEmailSettings, String> {
	
	public BrandingEmailSettings findByBrandingAndTemplateCodeAndEnabledIsTrue(Branding branding, String templateCode);
	
}
