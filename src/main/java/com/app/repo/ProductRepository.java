package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	// Below 3 methods are same
	List<Product> findByProdCode(String prodCode);
	List<Product> findByProdCodeIs(String prodCode);
	List<Product> findByProdCodeEquals(String prodCode);
	
	//....... where pcost <? , pcost <=?
	List<Product> findByProdCostLessThan(Double prodCost);
	List<Product> findByProdCostLessThanEqual(Double prodCost);
	
	//....... where pcode=? or pcost <?
	List<Product> findByProdCodeOrProdCostLessThan(String prodCode, Double prodCost);
	
	//....... where pcode is not null
	List<Product> findByProdCodeIsNotNull();
	
	//....... where pcode like '%A%' (Having letter A)
	List<Product> findByProdCodeLike(String prodCode);
	List<Product> findByProdCodeContaining(String prodCode);
	
	//....... where pcost between ? and ?
	List<Product> findByProdCostBetween(Double pco1, Double pc2);
	
	//....... where pcode in(...)
	List<Product> findByProdCodeIn(List<String> codes);
	
	//....... where pcost=> order by pcode
	List<Product> findByProdCostOrderByProdCost(Double cost);
	
	//....... where pid=? or pcode is not null or pcost<? and order by pcode desc
	List<Product> findByProdIdOrProdCodeIsNotNullOrProdCostLessThanOrderByProdCodeDesc(Integer prodId, Double pcost);
	
}
