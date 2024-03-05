package com.dantes.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dantes.demo.entities.Vendor;
import com.dantes.demo.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	VendorService vendorService;
//  ClassName objectName (pattern) as above

	// This is an equivalent of get entity set (getVendors)
	@RequestMapping("/vendor")
	public HashMap<String, Vendor> getVendors() {
		return vendorService.getAllVendors();
	}

	@RequestMapping("/vendor/{vendorId}")
	public Vendor getSingleVendor(@PathVariable("vendorId") String vendorId) {
		return vendorService.getVendorByKey(vendorId);
	}

	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myVendorData) {
		return vendorService.createVendor(myVendorData);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/vendor")
	public Vendor updateVendor(@RequestBody Vendor myUpdateVendor) {
		return vendorService.updateVendor(myUpdateVendor);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/vendor/{vendorId}")
	public void deleteVendor(@PathVariable("vendorId") String vendorId) {
		vendorService.deleteVendor(vendorId);
	}

}
