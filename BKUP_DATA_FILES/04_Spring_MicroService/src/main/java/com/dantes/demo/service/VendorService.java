package com.dantes.demo.service;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.dantes.demo.entities.Vendor;

@Component

public class VendorService {

	// Similar like internal table in ABAP
	HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();

	@Autowired
	Vendor ven1;
	@Autowired
	Vendor ven2;
	@Autowired
	Vendor ven3;

	private void fillVendors() {
		// append Work area to Itab
		vendors.put("1", ven1);
		vendors.put("2", ven2);
		vendors.put("3", ven3);
	}

	public void VendorService() {
		fillVendors();
	}

	public HashMap<String, Vendor> getAllVendors() {
		fillVendors();
		return vendors;
	}

	public Vendor getVendorByKey(String vendorId) {
// read table itab into workarea with key id = id
		fillVendors();
		return (Vendor) vendors.get(vendorId);
	}

	public Vendor createVendor(Vendor vendor) {
//	vendor.setCompanyName("Change Data");
		fillVendors();
//		vendors.put("4", ven3);   // this will use the 3rd value variable ven3 and bring the same value  

// this will bring the new value which is passed for creation ONLY static 4th object
// Realtime scenario this should be dynamically increased checking the dataset count from DB

		vendors.put("4", vendor);
		return vendor;
	}

	public Vendor updateVendor(Vendor vendor) {
		fillVendors();

// to update only the 4th object in data set 
// Realtime scenario dynamic numbering should be implemented obtaining from postman end

		vendors.put("4", vendor);
		return vendor;
	}

	public void deleteVendor(String vendorId) {
		fillVendors();
// deletion based on given vendor id works well 		
		vendors.remove(vendorId);
	}

}
