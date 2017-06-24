package com.other;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Adres {

	public final String  adress = "264";
	public final String code = "32-400";
	
	
	@Override
	public String toString() {
		return "Adres [adress=" + adress + ", code=" + code + "]";
	}
	
	
}
