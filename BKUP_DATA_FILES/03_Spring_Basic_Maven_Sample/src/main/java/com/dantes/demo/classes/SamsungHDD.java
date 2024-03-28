package com.dantes.demo.classes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component

public class SamsungHDD implements IHardDisk {

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return "Samsung hard disk is reading data at 10k rpm";
	}

	@Override
	public String write() {
		// TODO Auto-generated method stub
		return "Samsung hard disk is writing data at 5k rpm";
	}

}
