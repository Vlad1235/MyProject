package com.project.contactstorage.SupplierContactStorage.dao;

import com.project.contactstorage.SupplierContactStorage.entity.Supplier;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class SupplierDaoImpl implements SupplierDao {

    //инициплизируем поле EntityManager
    private EntityManager theEntityManager;

    @Autowired
    public SupplierDaoImpl(EntityManager theEntityManager) {
        this.theEntityManager = theEntityManager;
    }

    @Override
    public List<Supplier> getSuppliers() {
        // позвращаем текущую сессию
        Session currentSession = theEntityManager.unwrap(Session.class);

        // создаем запрос
        Query<Supplier> theQuery = currentSession.createQuery("FROM Supplier",Supplier.class);

        //возвращаем список поставщиков
        List<Supplier> suppliers = theQuery.getResultList();

    return suppliers;
    }

    @Override
    public void saveSupplier(Supplier theSupplier) {
        Session currentSession = theEntityManager.unwrap(Session.class);

        // используем метод и для обновления и для записи нового поставщика
        currentSession.saveOrUpdate(theSupplier);

    }

    @Override
    public Supplier findById(int theId) {
        Session currentSession = theEntityManager.unwrap(Session.class);

        // возращаем поставщика по переданному айдишнику
        Supplier theSupplier = currentSession.get(Supplier.class,theId);

        return  theSupplier;
    }

    @Override
    public void deleteSupplier(int theId) {
        Session currentSession = theEntityManager.unwrap(Session.class);

        //удаление поставщика по заданному айдишнику
        Query theQuery = currentSession.createQuery("delete FROM Supplier WHERE id=:supplierId");
        theQuery.setParameter("supplierId", theId);
        theQuery.executeUpdate();
    }
}
