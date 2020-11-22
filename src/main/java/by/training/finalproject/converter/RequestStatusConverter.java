package by.training.finalproject.converter;

import by.training.finalproject.entity.RequestStatus;

import javax.persistence.AttributeConverter;

public class RequestStatusConverter implements AttributeConverter<RequestStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(RequestStatus requestStatus) {
        return requestStatus.getId();
    }

    @Override
    public RequestStatus convertToEntityAttribute(Integer integer) {
        return RequestStatus.getStatusById(integer);
    }
}
