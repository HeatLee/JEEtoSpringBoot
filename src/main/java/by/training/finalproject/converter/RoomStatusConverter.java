package by.training.finalproject.converter;

import by.training.finalproject.entity.RoomStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RoomStatusConverter implements AttributeConverter<RoomStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(RoomStatus roomStatus) {
        return roomStatus.getStatusId();
    }

    @Override
    public RoomStatus convertToEntityAttribute(Integer integer) {
        return RoomStatus.getStatusById(integer);
    }
}
