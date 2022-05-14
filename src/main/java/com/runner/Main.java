package com.runner;

import com.Utis.Auto;
import com.Utis.Driver;
import com.Utis.NewHibernateUtil;
import com.Utis.Reservation;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        org.hibernate.Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t1 = s.beginTransaction();

        String singleQuery = "from Reservation as r where r.idDriver in (select d.id from Driver as d where d.id in (select a.idDriver from Auto as a where a.color = :color))";
        List<Reservation> hibQuery = s.createQuery(singleQuery).setParameter("color", "blue").list();

        for (Reservation r : hibQuery) {
            System.out.println("Талон резервации парковочного места автомобилем синего цвета: " + r.toString());
        }

        s.flush();
        t1.commit();

        s.close();
    }

}
