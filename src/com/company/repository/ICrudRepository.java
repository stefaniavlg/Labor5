package com.company.repository;

/**
 * CRUD operations repository interface
 */
public interface ICrudRepository<E> {

    /**Find the entity with the specified idEntity
     * @param idEntity
     * @return
     */
    E findOne(Long idEntity);

    /**Find all entities
     * @return all entities
     */
    Iterable<E> findAll();

    /**Save an entity
     * @param entity
     * @return null(save) or entity(id already exists)
     */
    E save(E entity);

    /**
     * Removes the entity with the specified id
     * @param id
     * @return entity or null (id not found)
     */
    E delete(Long id);

    /**Update entity
     * @param entity
     * @return null(update) or entity(id doesn't exist)
     */
    E update(E entity);
}
