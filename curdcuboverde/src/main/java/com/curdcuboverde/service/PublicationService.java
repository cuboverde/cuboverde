package com.curdcuboverde.service;

import com.curdcuboverde.entity.Publication;
import com.curdcuboverde.repository.CategoriesRepository;
import com.curdcuboverde.repository.PublicationRepository;
import com.curdcuboverde.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PublicationService implements IPublicationService{
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Publication> getPublications(){

        return publicationRepository.findAll();
    }

    public Optional<Publication> getPublications(Long id){

        return publicationRepository.findById(id);
    }

    public Optional<Publication> saveOrUpdate(Publication publication){
        if(userRepository.findById(publication.getIdUser()).isPresent() &&
                categoriesRepository.findById(publication.getIdCategory()).isPresent()){

            publicationRepository.save(publication);
            return publicationRepository.findById(publication.getIdPublication());
        }
        else{
            return Optional.empty();
        }


    }

    public void incrementLikes(Long id){
        Long likes;
        Publication incrementLike = publicationRepository.findById(id).get();
        likes = (incrementLike.getLikes() + 1);
        incrementLike.setLikes(likes);

        publicationRepository.save(incrementLike);
    }

    public void incrementShareds(Long id){
        Long Shares;
        Publication incrementS = publicationRepository.findById(id).get();
        Shares = (incrementS.getShared() + 1);
        incrementS.setShared(Shares);

        publicationRepository.save(incrementS);

    }

    public void incrementFavorites(Long id){
        Long favorites;
        Publication incrementF = publicationRepository.findById(id).get();
        favorites = (incrementF.getFavorites() + 1);
        incrementF.setFavorites(favorites);

        publicationRepository.save(incrementF);

    }

    public void updatePublication(Long id, Publication publication){
        Publication updatePublication = publicationRepository.findById(id).get();
        updatePublication.setDescriptionPublication(publication.getDescriptionPublication());
        updatePublication.setTypePublication(publication.getTypePublication());
        updatePublication.setTitlePublication(publication.getTitlePublication());
        updatePublication.setIdCategory(publication.getIdCategory());
        updatePublication.setIdUser(publication.getIdUser());

        publicationRepository.save(updatePublication);
    }

    public Optional<Publication> approvePublication(Long id){
        Publication publicationAprove = publicationRepository.findById(id).get();
        publicationAprove.setApproved("1");

        publicationRepository.save(publicationAprove);
        return publicationRepository.findById(id);
    }

    public void delete(Long id){

        publicationRepository.deleteById(id);
    }

    @Override
    public List<Publication> findByCategory(Long id) {

        return publicationRepository.findByCategory(id);
    }

    @Override
    public List<Publication> findAllAproved() {

        return publicationRepository.findAllAproved();
    }

    @Override
    public List<Publication> findByUser(Long id) {

        return publicationRepository.findByUser(id);
    }
}
