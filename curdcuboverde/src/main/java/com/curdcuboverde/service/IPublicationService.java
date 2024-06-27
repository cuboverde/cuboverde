package com.curdcuboverde.service;

import com.curdcuboverde.entity.Publication;

import java.util.List;

public interface IPublicationService {


    List<Publication> findByCategory(Long id);

    List<Publication> findAllAproved();

    List<Publication> findByUser(Long id);
}
