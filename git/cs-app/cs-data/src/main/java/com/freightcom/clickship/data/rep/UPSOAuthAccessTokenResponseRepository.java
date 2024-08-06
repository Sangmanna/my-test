package com.freightcom.clickship.data.rep;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.CarrierAccount;
import com.freightcom.clickship.data.entity.UPSOAuthAccessTokenResponse;

@Repository
public interface UPSOAuthAccessTokenResponseRepository extends JpaRepository<UPSOAuthAccessTokenResponse, String> {
	UPSOAuthAccessTokenResponse getByCarrierAccount(CarrierAccount carrierAccount);
	Optional<UPSOAuthAccessTokenResponse> findByRefreshToken(String refreshToken);
}
