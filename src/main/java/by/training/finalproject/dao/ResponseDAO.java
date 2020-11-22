package by.training.finalproject.dao;

import by.training.finalproject.entity_legacy.Request;
import by.training.finalproject.entity_legacy.Response;
import by.training.finalproject.exception.DAOException;

public interface ResponseDAO<T> extends CommonDAO<T> {

    boolean isContainsRoom(int id) throws DAOException;

    Request getRequestByRoomId(int id) throws DAOException;

    Response getResponseByRequestId(int id) throws DAOException;
}
