package com.rajesh.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    //Fetch cars by brand
    @Query("select c from Car c where c.brand=?1")
    List<Car> findByBrand(String brand);

    //Fetch cars by brand using SQL
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);

    //Fetch cars by color
    List<Car> findByColor(String color);

    //Fetch cars by year
    List<Car> findByYear(int year);

    //Fetch cars by brand and model
    List<Car> findByBrandAndModel(String brand, String model);

    //Fetch cars by brand and color
    List<Car> findByBrandOrColor(String brand, String color);

    //Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByYearAsc(String brand);
}
