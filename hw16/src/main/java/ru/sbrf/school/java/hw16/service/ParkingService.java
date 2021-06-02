package ru.sbrf.school.java.hw16.repository;

import org.springframework.stereotype.Repository;
import ru.sbrf.school.java.hw16.exception.CarNotFoundedException;
import ru.sbrf.school.java.hw16.exception.FullParkingException;
import ru.sbrf.school.java.hw16.exception.NumberOutOfParkingRangeException;

import java.util.List;

@Repository
public interface ParkingRepository {

    Integer park() throws FullParkingException;

    Boolean unpark(Integer number) throws CarNotFoundedException, NumberOutOfParkingRangeException;

    List<Integer> showFree();
}
