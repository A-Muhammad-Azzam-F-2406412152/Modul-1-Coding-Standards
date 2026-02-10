## Reflection 1

### Clean Code & Secure Coding Practices
Dalam pengembangan modul ini, saya telah menerapkan beberapa prinsip **Clean Code** dan **Secure Coding** untuk memastikan kualitas kode yang baik:
1.  **Meaningful Names:** Saya menggunakan nama variabel, method, dan class yang jelas serta deskriptif (seperti `ProductRepository`, `create`, `findById`) sehingga kode menjadi *self-documenting* dan mudah dipahami tanpa perlu banyak komentar.
2.  **Single Responsibility Principle (SRP):** Saya memisahkan tanggung jawab dengan jelas antara `Controller` (mengatur request HTTP), `Service` (logika bisnis), dan `Repository` (akses data). Hal ini membuat kode lebih modular dan mudah dipelihara.
3.  **Secure Coding:** Saya menerapkan penggunaan **UUID** untuk `productId` menggantikan integer berurutan. Hal ini mencegah serangan *ID Enumeration* di mana pihak luar bisa menebak ID produk lain dengan mudah, serta memastikan keamanan data yang lebih baik.

### Areas for Improvement
Setelah mengevaluasi kode, saya menemukan ruang untuk perbaikan. Saat ini, belum ada validasi input yang ketat (misalnya, nama produk boleh kosong atau kuantitas negatif). Perbaikannya adalah dengan menambahkan validasi di sisi server (menggunakan Java Bean Validation) dan di sisi klien untuk memastikan integritas data sebelum diproses.

## Reflection 2

### 1. Unit Testing & Code Coverage
Menulis unit test memberikan rasa percaya diri bahwa fitur yang saya buat berjalan sesuai spesifikasi dan terlindungi dari regresi (error akibat perubahan kode di masa depan).
* **Berapa banyak tes?** Tidak ada angka pasti, namun tes harus mencakup *positive case* (alur normal), *negative case* (input salah/error), dan *edge cases* (batas nilai).
* **100% Code Coverage:** Mencapai 100% code coverage **tidak menjamin** kode bebas dari *bug*. Coverage hanya mengukur baris kode yang dieksekusi, tetapi tidak mendeteksi kesalahan logika bisnis atau skenario yang terlewat (*missing requirements*). Oleh karena itu, kualitas skenario tes lebih penting daripada sekadar mengejar angka coverage.

### 2. Functional Test Cleanliness
Jika saya membuat functional test baru dengan menyalin prosedur setup dan variabel instance dari `CreateProductFunctionalTest.java`, maka akan timbul masalah pada kebersihan kode (*clean code*).
* **Code Duplication:** Menyalin kode setup (`serverPort`, `baseUrl`, dll) ke banyak file melanggar prinsip **DRY (Don't Repeat Yourself)**. Kode menjadi kotor, redundan, dan sulit dirawat.
* **Masalah Maintenance:** Jika konfigurasi setup berubah, saya harus mengubahnya di setiap file satu per satu, yang rentan terhadap kesalahan.
* **Solusi:** Sebaiknya buat sebuah **Base Test Class** yang berisi semua konfigurasi umum. Kelas test fungsional lainnya cukup melakukan *extends* ke kelas base tersebut, sehingga kode menjadi lebih bersih dan *reusable*.