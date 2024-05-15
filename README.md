# Java_Persistence_And

*Didalam Folder Tugas Masuk ke Dalam TugasAndrey*
*Setelah Itu Masuk Ke Folder src/main/java/com/Andrey Di Folder Andrey Terdapat File Java nya*

# File HibernateUtil.java berisi method yang dimana dapat menghubungkan ke database dengan import Session

*File class HibernateUtil, yang menyediakan utilitas untuk mengelola objek SessionFactory Hibernate. SessionFactory sangat penting untuk membuat sesi yang berinteraksi dengan database relasional menggunakan Hibernate.*

Fungsi:

Membuat satu instance SessionFactory selama inisialisasi aplikasi.
Menyediakan metode untuk mendapatkan SessionFactory untuk bagian lain dari aplikasi Anda.
Menangani potensi pengecualian selama konfigurasi.
Menawarkan cara untuk menutup SessionFactory dengan baik dan membebaskan sumber daya saat aplikasi selesai.

*File Class Student*

File ini berisi definisi class Student yang digunakan untuk memetakan data mahasiswa ke dalam objek Java. Class ini akan digunakan bersama dengan Hibernate untuk persistensi data mahasiswa ke dalam database relasional.

# Anotasi:

@Entity: Menandakan bahwa class ini mewakili entitas database (tabel students dalam kasus ini).
@Table(name = "students"): Menentukan nama tabel di database yang akan dipetakan ke class Student.
@Id: Menandai atribut id sebagai primary key dari entitas.
@GeneratedValue(strategy = GenerationType.IDENTITY): Mengatur agar nilai id secara otomatis dihasilkan oleh database (biasanya menggunakan auto-increment).
@Column(name = "name", nullable = false): Mendefinisikan atribut name yang dipetakan ke kolom name pada tabel students, dan kolom tersebut tidak boleh kosong (nullable = false).
Serupa dengan @Column
@Column(name = "age", nullable = false) untuk atribut age.
@Column(name = "major", nullable = false) untuk atribut major.
Atribut:

private int id: Menahan ID mahasiswa (primary key).
private String name: Menahan nama mahasiswa.
private int age: Menahan usia mahasiswa.
private String major: Menahan jurusan mahasiswa.

# Metode:

# Getter dan Setter:
Metode getId(), setId(int id), getName(), setName(String name), dan seterusnya menyediakan cara untuk mengakses dan memodifikasi nilai atribut objek Student.
Konstruktor:
public Student(String name, int age, String major): Konstruktor yang memungkinkan inisialisasi objek Student dengan nilai awal untuk atributnya.
public Student(): Konstruktor tanpa argumen, berguna untuk keperluan Hibernate.
Metode Override:

@Override public int hashCode(): Mengimplementasikan metode hashCode() untuk menghasilkan hash code objek Student berdasarkan atributnya.
@Override public boolean equals(Object obj): Mengimplementasikan metode equals() untuk membandingkan objek Student dengan objek lain berdasarkan atributnya.

*File Class Main*

File Main.java ini merupakan contoh implementasi penggunaan class Student dan Hibernate untuk mengelola data mahasiswa di database.

Operasi yang Dilakukan:

Membuka Sesi (Session):

Program ini pertama kali membuka sesi ke database menggunakan HibernateUtil.getSessionFactory().openSession().
Memulai Transaksi (Begin Transaction):

Transaksi digunakan untuk mengelompokkan operasi database. session.beginTransaction() memulai transaksi baru.
Menyimpan Data (Save):

Dua objek Student baru dibuat (Javin, 18, "IMT" dan Pri, 20, "CBM").
Metode session.save(student) digunakan untuk menyimpan objek Student ke database.
Memperbarui Data (Update):

Program mengambil objek Student dengan ID 8 dari database menggunakan session.get(Student.class, 8).
Jika objek ditemukan, jurusan (major) diperbarui menjadi "IMT" menggunakan student.setMajor("IMT").
Perubahan ini disimpan ke database menggunakan session.update(student).
Menghapus Data (Delete):

Program mengambil objek Student dengan ID 5 dari database menggunakan session.get(Student.class, 5).
Jika objek ditemukan, program menghapusnya dari database menggunakan session.delete(studentToDelete).
Pesan konfirmasi dicetak setelah penghapusan berhasil.
Mengambil Data (Get):

Program mengambil objek Student dengan ID yang sama dengan objek student2 yang sebelumnya disimpan.
Jika objek ditemukan, program mencetak detailnya (nama, umur, jurusan).
Komit Transaksi dan Tutup Sesi (Commit Transaction & Close Session):

session.getTransaction().commit() digunakan untuk mengkonfirmasi perubahan yang dilakukan selama transaksi.
session.close() menutup sesi yang dibuka sebelumnya.
Shutdown SessionFactory:

Terakhir, program memanggil HibernateUtil.shutdown() untuk menutup SessionFactory dan melepaskan sumber daya yang terkait.
