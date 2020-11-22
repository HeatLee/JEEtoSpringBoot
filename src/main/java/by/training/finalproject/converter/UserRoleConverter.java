package by.training.finalproject.converter;

import by.training.finalproject.entity.UserRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserRoleConverter implements AttributeConverter<UserRole, Integer> {
    @Override
    public Integer convertToDatabaseColumn(UserRole userRole) {
        return userRole.getId();
    }

    @Override
    public UserRole convertToEntityAttribute(Integer integer) {
        return UserRole.getRoleById(integer);
    }
}
