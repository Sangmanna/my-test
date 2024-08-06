package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Perks;

@Repository
public interface PerksRepository extends JpaRepository<Perks, String>{
	
	public List<Perks> findAllByPerkStatusTrue();

}
