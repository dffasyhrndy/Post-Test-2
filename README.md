### Daffa Syahrandy Husain - 2409116069
---

## Deskripsi Singkat
Program **To-Do List** ini dibuat menggunakan bahasa Java dengan konsep **CRUD (Create, Read, Update, Delete)**.  
Program memungkinkan pengguna untuk:
- Menambahkan kegiatan baru dengan nama dan tanggal.
- Melihat daftar kegiatan beserta statusnya.
- Mengupdate kegiatan (nama, tanggal, dan status).
- Menghapus kegiatan tertentu.
- Mencari kegiatan berdasarkan keyword.
- Keluar dari program.

---

## Alur Program
1. **Tampilan Menu Utama**  
   User diberikan 6 pilihan menu: Tambah, Lihat, Update, Hapus, Cari, atau Keluar.  
   Input menu diproses menggunakan `switch-case`.

<img width="573" height="186" alt="image" src="https://github.com/user-attachments/assets/a51a1e29-7ae3-4ff0-ae73-53ad4a31d30d" />

2. **Tambah Kegiatan (Create)**  
   - Memasukkan nama kegiatan dan tanggal.  
   - Data disimpan ke dalam objek `Kegiatan` yang memiliki atribut nama, tanggal, dan status.  

<img width="429" height="294" alt="image" src="https://github.com/user-attachments/assets/84acd7e1-38fa-4cab-9312-462489691737" />

3. **Lihat Daftar Kegiatan (Read)**  
   - Jika daftar kosong → tampil pesan "Belum Ada Kegiatan".  
   - Jika ada → tampil semua kegiatan dengan format:

<img width="612" height="253" alt="image" src="https://github.com/user-attachments/assets/0886705c-0cbf-4984-bc04-0f09350a748c" />

4. **Update Kegiatan (Update)**  
   - Pilih nomor kegiatan.  
   - Bisa ubah nama, tanggal, status.  
   - Input kosong → data lama tetap dipertahankan.  

<img width="636" height="520" alt="image" src="https://github.com/user-attachments/assets/48453c25-e705-43c4-a124-e535945813c6" />

5. **Hapus Kegiatan (Delete)**  
   - Pilih nomor kegiatan yang ingin dihapus.  
   - Data dihapus dari list.  

<img width="672" height="526" alt="image" src="https://github.com/user-attachments/assets/5fdd8576-078b-4e8c-a6ac-69ac3074a41b" />

6. **Cari Kegiatan (Search)**  
   - User mengetikkan keyword pencarian.  
   - Program menampilkan kegiatan yang mengandung kata tersebut pada nama.  
   - Jika tidak ada hasil, tampil pesan "Kegiatan tidak ditemukan".  

<img width="605" height="237" alt="image" src="https://github.com/user-attachments/assets/16ddb43d-886c-4b43-a577-51f6d1cfff15" />

7. **Keluar Program**  
   - Program berhenti saat user memilih menu `6`.  

<img width="491" height="195" alt="image" src="https://github.com/user-attachments/assets/011a00af-00ea-4af4-9637-fcfe8ccefbfc" />

---

## Penerapan MVC
Program ini menggunakan arsitektur **MVC (Model-View-Controller)** dengan 4 package:

<img width="501" height="235" alt="image" src="https://github.com/user-attachments/assets/39751627-cc00-4aec-822c-83854a4ea71a" />

1. **model**  
   Berisi class `Kegiatan.java` yang menyimpan struktur data kegiatan (nama, tanggal, status).  
2. **view**  
   Berisi `MainView.java`, tempat semua interaksi dengan pengguna (tampilan menu, input, dan output).  
3. **controller**  
   Berisi `KegiatanController.java`, tempat logika CRUD (tambah, lihat, update, hapus, cari).  
4. **main**  
   Berisi `Main.java` sebagai entry point yang memanggil view untuk menjalankan program.
   
---

## Validasi Input
Program dilengkapi validasi sederhana agar lebih aman digunakan:
- **Menu** → hanya menerima angka, input selain angka akan diminta ulang.  
- **Tanggal** → dimasukkan satu per satu (hari, bulan, tahun) dan tidak boleh bernilai negatif atau nol.  
- **Status Update** → hanya menerima angka `1` (Selesai) atau `2` (Belum Selesai).  

---
