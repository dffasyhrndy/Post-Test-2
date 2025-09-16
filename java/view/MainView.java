package view;

import controller.KegiatanController;
import model.Kegiatan;
import java.util.Scanner;

public class MainView {
    private Scanner input = new Scanner(System.in);
    private KegiatanController controller = new KegiatanController();

    public void tampilkanMenu() {
        while (true) {
            System.out.println("\n=== PROGRAM TO DO LIST ===");
            System.out.println("1. Tambah Kegiatan");
            System.out.println("2. Lihat Daftar Kegiatan");
            System.out.println("3. Update Kegiatan");
            System.out.println("4. Hapus Kegiatan");
            System.out.println("5. Cari Kegiatan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            if (!input.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
                continue;
            }
            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Kegiatan/Tugas: ");
                    String nama = input.nextLine();

                    int dd;
                    while (true) {
                        System.out.print("Masukkan Tanggal (dd): ");
                        if (input.hasNextInt()) {
                            dd = input.nextInt();
                            if (dd >= 1 && dd <= 31) break;
                            else System.out.println("Tanggal harus 1 - 31.");
                        } else {
                            System.out.println("Input harus berupa angka!");
                            input.nextLine();
                        }
                    }

                    int mm;
                    while (true) {
                        System.out.print("Masukkan Bulan (MM): ");
                        if (input.hasNextInt()) {
                            mm = input.nextInt();
                            if (mm >= 1 && mm <= 12) break;
                            else System.out.println("Bulan harus 1 - 12.");
                        } else {
                            System.out.println("Input harus berupa angka!");
                            input.nextLine();
                        }
                    }

                    int yyyy;
                    while (true) {
                        System.out.print("Masukkan Tahun (yyyy): ");
                        if (input.hasNextInt()) {
                            yyyy = input.nextInt();
                            if (yyyy > 0) break;
                            else System.out.println("Tahun harus lebih dari 0.");
                        } else {
                            System.out.println("Input harus berupa angka!");
                            input.nextLine();
                        }
                    }
                    input.nextLine();
                    String tgl = String.format("%02d-%02d-%04d", dd, mm, yyyy);

                    controller.tambahKegiatan(nama, tgl);
                    break;

                case 2:
                    System.out.println("Daftar Kegiatan Anda");
                    if (controller.getDaftarKegiatan().isEmpty()) {
                        System.out.println("Belum Ada Kegiatan");
                    } else {
                        for (int i = 0; i < controller.getDaftarKegiatan().size(); i++) {
                            Kegiatan k = controller.getDaftarKegiatan().get(i);
                            System.out.println((i + 1) + ". " + k.getNama() +
                                    " | Tanggal: " + k.getTanggal() +
                                    " | Status : " + k.getStatus());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Daftar Kegiatan Anda");
                    if (controller.getDaftarKegiatan().isEmpty()) {
                        System.out.println("Belum Ada Kegiatan");
                    } else {
                        for (int i = 0; i < controller.getDaftarKegiatan().size(); i++) {
                            Kegiatan k = controller.getDaftarKegiatan().get(i);
                            System.out.println((i + 1) + ". " + k.getNama() +
                                    " | Tanggal: " + k.getTanggal() +
                                    " | Status : " + k.getStatus());
                        }
                    }
                    System.out.print("Pilih nomor kegiatan yang ingin diubah: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Input harus berupa angka!");
                        input.nextLine();
                        break;
                    }
                    int idx = input.nextInt() - 1;
                    input.nextLine();

                    System.out.print("Update Nama Kegiatan (kosongkan jika tidak diubah): ");
                    String newNama = input.nextLine();

                    String newTgl = "";
                    System.out.print("Apakah ingin mengubah tanggal? (y/n): ");
                    String pilihTanggal = input.nextLine();
                    if (pilihTanggal.equalsIgnoreCase("y")) {
                        int newDd;
                        while (true) {
                            System.out.print("Masukkan Tanggal (dd): ");
                            if (input.hasNextInt()) {
                                newDd = input.nextInt();
                                if (newDd >= 1 && newDd <= 31) break;
                                else System.out.println("Tanggal harus 1 - 31.");
                            } else {
                                System.out.println("Input harus berupa angka!");
                                input.nextLine();
                            }
                        }

                        int newMm;
                        while (true) {
                            System.out.print("Masukkan Bulan (MM): ");
                            if (input.hasNextInt()) {
                                newMm = input.nextInt();
                                if (newMm >= 1 && newMm <= 12) break;
                                else System.out.println("Bulan harus 1 - 12.");
                            } else {
                                System.out.println("Input harus berupa angka!");
                                input.nextLine();
                            }
                        }

                        int newYyyy;
                        while (true) {
                            System.out.print("Masukkan Tahun (yyyy): ");
                            if (input.hasNextInt()) {
                                newYyyy = input.nextInt();
                                if (newYyyy > 0) break;
                                else System.out.println("Tahun harus lebih dari 0.");
                            } else {
                                System.out.println("Input harus berupa angka!");
                                input.nextLine();
                            }
                        }
                        input.nextLine();
                        newTgl = String.format("%02d-%02d-%04d", newDd, newMm, newYyyy);
                    }

                    System.out.print("Update Status (1 = Selesai, 2 = Belum Selesai, 0 = tidak diubah): ");
                    int status = 0;
                    if (input.hasNextInt()) {
                        status = input.nextInt();
                        input.nextLine();
                    } else {
                        input.nextLine();
                        status = 0;
                    }

                    controller.updateKegiatan(idx, newNama, newTgl, status);
                    break;

                case 4:
                    System.out.println("Daftar Kegiatan Anda");
                    if (controller.getDaftarKegiatan().isEmpty()) {
                        System.out.println("Belum Ada Kegiatan");
                    } else {
                        for (int i = 0; i < controller.getDaftarKegiatan().size(); i++) {
                            Kegiatan k = controller.getDaftarKegiatan().get(i);
                            System.out.println((i + 1) + ". " + k.getNama() +
                                    " | Tanggal: " + k.getTanggal() +
                                    " | Status : " + k.getStatus());
                        }
                    }
                    System.out.print("Pilih nomor kegiatan yang ingin dihapus: ");
                    if (!input.hasNextInt()) {
                        System.out.println("Input harus berupa angka!");
                        input.nextLine();
                        break;
                    }
                    int del = input.nextInt() - 1;
                    input.nextLine();

                    controller.hapusKegiatan(del);
                    break;

                case 5:
                    System.out.print("Masukkan keyword pencarian: ");
                    String keyword = input.nextLine();
                    controller.cariKegiatan(keyword);
                    break;

                case 6:
                    System.out.println("Terima kasih telah menggunakan program To Do List");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
