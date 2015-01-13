package com.saifiahmada.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saifiahmada.spring.domain.Kontak;
import com.saifiahmada.spring.repository.KontakRepository;

@RestController
public class KontakController {
	
	@Autowired
	private KontakRepository kontakRepository;
	
	@RequestMapping(value = "/save/{nama}/{alamat}/{noTelp}")
	public String save(@PathVariable String nama, @PathVariable String alamat, @PathVariable String noTelp){
		
		Kontak k = new Kontak();
		k.setNama(nama);
		k.setAlamat(alamat);
		k.setNoTelp(noTelp);
		
		kontakRepository.save(k);
		
		return "simpan data kontak [ " + nama + " ] sukses";
	}
	
	@RequestMapping(value = "/list")
	public List<Kontak> list(){
		return kontakRepository.findAll();
	}

}
