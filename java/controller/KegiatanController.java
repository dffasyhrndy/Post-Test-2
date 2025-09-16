package controller;

import model.Kegiatan;
import java.util.ArrayList;

public class KegiatanController {
    private ArrayList<Kegiatan> daftarKegiatan = new ArrayList<>();

    public void tambahKegiatan(String nama, String tanggal) {
        daftarKegiatan.add(new Kegiatan(nama, tanggal));
        System.out.println("Kegiatan Berhasil Ditambahkan");
    }

    public ArrayList<Kegiatan> getDaftarKegiatan() {
        return daftarKegiatan;
    }

    public void updateKegiatan(int idx, String newNama, String newTanggal, int pilihStatus) {
        if (idx >= 0 && idx < daftarKegiatan.size()) {
            Kegiatan keg = daftarKegiatan.get(idx);

            if (!newNama.isEmpty()) keg.setNama(newNama);
            if (!newTanggal.isEmpty()) keg.setTanggal(newTanggal);

            if (pilihStatus == 1) keg.setStatus("Selesai");
            else if (pilihStatus == 2) keg.setStatus("Belum Selesai");

            System.out.println("Kegiatan Berhasil di Update!");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public void hapusKegiatan(int idx) {
        if (idx >= 0 && idx < daftarKegiatan.size()) {
            daftarKegiatan.remove(idx);
            System.out.println("Kegiatan Berhasil Dihapus!");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    public void cariKegiatan(String keyword) {
        boolean ketemu = false;
        for (int i = 0; i < daftarKegiatan.size(); i++) {
            Kegiatan k = daftarKegiatan.get(i);
            if (k.getNama().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println((i + 1) + ". " + k.getNama() +
                        " | Tanggal: " + k.getTanggal() +
                        " | Status : " + k.getStatus());
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("Tidak ada kegiatan yang cocok dengan keyword: " + keyword);
        }
    }
}
