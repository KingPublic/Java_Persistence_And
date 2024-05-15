// package com.Andrey;

// import java.util.ArrayList;
// import java.util.List;

// import javax.persistence.*;

// import org.hibernate.Session;

// public class SiswaCRUD {
//     static Session session = HibernateUtil.getSessionFactory().openSession();
//     public static void main(String[] args) {
        
//         EntityManagerFactory factory = Persistence.createEntityManagerFactory("Siswa_PU");
//         EntityManager entityManager = factory.createEntityManager();

//         // Hapus semua data siswa
//         EntityTransaction transaction = entityManager.getTransaction();
//         transaction.begin();

//         // Query query = entityManager.createQuery("DELETE FROM Siswa");
//         // query.executeUpdate();

//         // transaction.commit();
//         // System.out.println("Semua data siswa telah dihapus.");

//         // Pilih semua data siswa (setelah dihapus, seharusnya kosong)
//         // transaction = entityManager.getTransaction();
//         // transaction.begin();

//         Query selectQuery = entityManager.createQuery("SELECT * FROM Database Siswa ");
//         List<Student> siswaList = selectQuery.getResultList();

//         if (siswaList.isEmpty()) {
//             System.out.println("Tidak ada data siswa yang ditemukan.");
//         } else {
//             for (Student siswa : siswaList) {
//                 System.out.println("ID: " + siswa.getId());
//                 System.out.println("Nama: " + siswa.getName());
//                 System.out.println("Kelas: " + siswa.getMajor());
//             }
//         }

//         transaction.commit();
//         entityManager.close();
//         factory.close();
//     }
// }
