package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AddressBook;
import com.freightcom.clickship.data.entity.AddressBookPalletPreference;

@Repository
public interface AddressBookPalletPreferenceRepository extends JpaRepository<AddressBookPalletPreference, String> {
	
	public void deleteByAddressBook(AddressBook addressBook);
	
	public AddressBookPalletPreference findByAddressBook(AddressBook addressBook);

	public AddressBookPalletPreference findByAddressBook_Id(String addressBookId);
	
}
