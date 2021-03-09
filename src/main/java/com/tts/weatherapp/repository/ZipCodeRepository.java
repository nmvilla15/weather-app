package com.tts.weatherapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.weatherapp.model.ZipCode;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
	
	ZipCode findByZipCode(String zip);
	
	@Query(value = "SELECT ZIP_CODE FROM ZIP_CODE ORDER BY CREATED_AT DESC LIMIT 10",
			nativeQuery = true)
	List<String> findMostRecent();

}
