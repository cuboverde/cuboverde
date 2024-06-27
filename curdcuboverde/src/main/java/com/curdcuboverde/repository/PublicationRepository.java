package com.curdcuboverde.repository;
import com.curdcuboverde.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    @Query("SELECT p from Publication p where p.IdCategory = :idC")
    List<Publication> findByCategory(Long idC);

    @Query("SELECT p from Publication p where p.Approved = '1'")
    List<Publication> findAllAproved();

    @Query("SELECT p from Publication p where p.IdUser = :idU")
    List<Publication> findByUser(Long idU);
}
