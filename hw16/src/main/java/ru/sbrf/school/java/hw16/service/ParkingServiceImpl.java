package ru.sbrf.school.java.hw16.repository;

import ru.sbrf.school.java.hw16.exception.CarNotFoundedException;
import ru.sbrf.school.java.hw16.exception.FullParkingException;
import ru.sbrf.school.java.hw16.exception.NumberOutOfParkingRangeException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingRepositoryImpl implements ParkingRepository {

    private static final Map<Integer, Boolean> parking = new HashMap<>();

    static {
        for (int i = 1; i <= 20; i++) {
            parking.put(i, false);
        }
    }

    @Override
    public Integer park() throws FullParkingException {
        for (int i = 1; i <= 20; i++) {
            if (!parking.get(i)) {
                parking.put(i, true);
                return i;
            }
        }
        throw new FullParkingException();
    }

    @Override
    public Boolean unpark(Integer number) throws CarNotFoundedException, NumberOutOfParkingRangeException {
        if (number > 20 || number < 1) {
            throw new NumberOutOfParkingRangeException();
        }
        if (!parking.get(number)) {
            throw new CarNotFoundedException();
        }
        return parking.put(number, false);
    }

    @Override
    public List<Integer> showFree() {
        return parking
                .entrySet()
                .stream()
                .filter(x -> !x.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
