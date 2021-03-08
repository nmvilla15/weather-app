package com.tts.weatherapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.weatherapp.model.ZipCode;

public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {

}
