package com.runner;

import com.Utis.*;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        org.hibernate.Session s = NewHibernateUtil.getSessionFactory().openSession();
        Transaction t1 = s.beginTransaction();

        // Вывести талон резервации парковочного места, на котором стоял автомобиль синего цвета
        String reservationOfBlueCar = "from Reservation as r where r.idDriver in (select d.id from Driver as d where d.id in (select a.idDriver from Auto as a where a.color = :color))";
        List<Reservation> hibQuery = s.createQuery(reservationOfBlueCar).setParameter("color", "blue").list();

        for (Reservation r : hibQuery) {
            System.out.println("Талон резервации парковочного места автомобилем синего цвета: " + r.toString());
        }

        // Вывести информацию о всех водителях
        List<Driver> drivers = s.createQuery("from Driver").list();

        System.out.print("\nВодители:\n");
        for (Driver d : drivers) {
            System.out.println("Водитель: " + d.getId() + d + "\n");
        }

        // Вывести информацию о водителях, которые потратили на бронировку места менее 400 ден. единиц
        String threeOrLess = "from Driver as d where d.id in (select r.idDriver from Reservation as r where r.id in (select p.idReservation from Payment as p where p.price < :price and p.paymentStatus = :pstatus))";
        List<Driver> seekingDrivers = s
                .createQuery(threeOrLess)
                .setParameter("price", 400)
                .setParameter("pstatus", "Accepted")
                .list();

        System.out.print("\nВодители, которые потратили на бронировку места менее 400 ден. единиц: ");
        for (Driver d : seekingDrivers) {
            System.out.println(d + "\n");
        }

        //Вывести информацию о доступных парковочных местах для легковых автомобилей
        String availLots = "from Parkinglot as l where l.lotStatus = :lotStatus and l.lotType = :lotType";
        List<Parkinglot> lots = s
                .createQuery(availLots)
                .setParameter("lotStatus", "Available")
                .setParameter("lotType", "Small")
                .list();

        System.out.print("\nДоступные парковочные места для легковых авто: ");
        for (Parkinglot l : lots) {
            System.out.println(l + "\n");
        }

        s.flush();
        t1.commit();

        s.close();
    }

}
