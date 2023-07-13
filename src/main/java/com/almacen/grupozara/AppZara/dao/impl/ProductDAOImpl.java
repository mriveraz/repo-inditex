package com.almacen.grupozara.AppZara.dao.impl;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.almacen.grupozara.AppZara.dao.ProductDAO;
import com.almacen.grupozara.AppZara.models.Product;
import com.almacen.grupozara.AppZara.utility.HibernateUtil;



public class ProductDAOImpl implements ProductDAO {

	@Override
	public void SaveProduct(Product product) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// begin transaction
			session.beginTransaction();
			session.save(product);
			try {
				transaction.commit();
			} catch (Exception e) {

				if (transaction != null) {
					try {
						transaction.rollback();
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SystemException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}

		}

	}

}
