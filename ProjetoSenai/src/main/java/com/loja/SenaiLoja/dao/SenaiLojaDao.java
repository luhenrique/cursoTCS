package com.loja.SenaiLoja.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loja.SenaiLoja.model.Product;
import com.loja.SenaiLoja.repository.SenaiLojaRepository;



	@Service
	@Transactional
	public class SenaiLojaDao {
		@Autowired(required=true)
		private SenaiLojaRepository repo;
		
		public List<Product> listAll(){
			return repo.findAll();
		}
		
		public Product get(long id) {
			return repo.findById(id).get();
		}
		
		
		public void save(Product product) {
			repo.save(product);
		}
		
		public void delete(long id) {
			repo.deleteById(id);
		}
	
		
	}
