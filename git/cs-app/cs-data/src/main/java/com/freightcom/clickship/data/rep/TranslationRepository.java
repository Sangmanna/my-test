package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Translation;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, String> {
	@Query("select en from Translation")
    public List<String> findAllEnText();
	
	// Ideally this should be one but sometimes it returns multiple. which needs to be fixed if root cause is found.
	@Query("SELECT ts FROM Translation ts WHERE ts.en = :enText")
	public List<Translation> findByEn(@Param("enText") String enText);
	
	public List<Translation> findAllByOrderByUpdateDatetime();
}