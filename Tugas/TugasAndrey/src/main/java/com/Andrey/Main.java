package com.Andrey;

import org.hibernate.Session;

public class Main {
    static Session session = HibernateUtil.getSessionFactory().openSession();
    public static void main(String[] args) {
        session.beginTransaction();

        // buat objek untuk Satu data ke database siswa
        Student student = new Student("Javin",18,"IMT");
        session.save(student);
        Student student2 = new Student("Pri",20,"CBM");
        session.save(student2);
        
        //Set/Update salah satu colomn di database siswa
        Student student3 = session.get(Student.class, 8);
        student2.setMajor("IMT");
        session.update(student3);

        // Menghapus/Delete data student di database Siswa
        Student studentToDelete = session.get(Student.class, 5);
        if (studentToDelete != null) {
            session.delete(studentToDelete);
            System.out.println("Student Berhasil Dihapus" + " Dengan ID :" + studentToDelete.getId() + "," + " Dengan Nama :" + studentToDelete.getName());
        }

        // Mengambil data/Select dari database untuk memastikan data telah masuk
        Student retrieved = session.get(Student.class, student2.getId());

        if (retrieved != null) {
            System.out.println("Retrieved/Ambil: " + retrieved.getName() + ", " + retrieved.getAge() + ", " + retrieved.getMajor());
        } else {
            System.out.println("Tidak Ada Data Student yang didapat:" + student2.getId());
        }

        // Commit transaksi dan tutup session
        session.getTransaction().commit();
        session.close();
        
        HibernateUtil.shutdown();
    }
}

