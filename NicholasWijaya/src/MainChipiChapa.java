import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainChipiChapa {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<PT_ChipiChapa> arrChipiChapa = new ArrayList<PT_ChipiChapa>();

	void menu() {
		System.out.println("PT ChipiChapa");
		System.out.println("================");
		System.out.println("1. insert data karyawan");
		System.out.println("2. view data karyawan");
		System.out.println("3. update data karyawan");
		System.out.println("4. delete data karyawan");

	}

	public String id() {
		char firstChar = (char) (rand.nextInt(26) + 'A');
		char secondChar = (char) (rand.nextInt(26) + 'A');
		String randNumber = String.format("%04d", rand.nextInt(10000));
		String result = String.valueOf(firstChar) + String.valueOf(secondChar) + "-" + randNumber;

		return result;
	}

	boolean kodeUnik(String kode) {
		for (int i = 0; i < arrChipiChapa.size(); i++) {
			if (arrChipiChapa.get(i).kode.equals(kode)) {
				return false;
			}
		}
		return true;
	}

	void sorting() {
		for (int i = 0; i < arrChipiChapa.size(); i++) {
			for (int j = 0; j < arrChipiChapa.size() - i - 1; j++) {

				String firstName = arrChipiChapa.get(j).nama;
				String secondName = arrChipiChapa.get(j + 1).nama;

				if (firstName.compareTo(secondName) > 0) {
					PT_ChipiChapa temp = arrChipiChapa.get(j);
					arrChipiChapa.set(j, arrChipiChapa.get(j + 1));
					arrChipiChapa.set(j + 1, temp);
				}
			}
		}
	}

	void insert() {
		String kode;
		while (true) {
			kode = id();
			if (kodeUnik(kode) == true) {
				break;
			}
		}

		String nama;
		while (true) {
			System.out.print("Input nama karyawan [>=3]: ");
			nama = scan.nextLine();
			if (nama.length() >= 3) {
				break;
			}
		}

		String jenisKelamin;
		while (true) {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan]: ");
			jenisKelamin = scan.nextLine();
			if (jenisKelamin.equals("Laki-laki")) {
				break;
			} else if (jenisKelamin.equals("Perempuan")) {
				break;
			}

		}

		String jabatan;
		Integer gaji;
		while (true) {
			System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
			jabatan = scan.nextLine();
			if (jabatan.equals("Manager")) {
				gaji = 8000000;
				break;
			} else if (jabatan.equals("Supervisor")) {
				gaji = 6000000;
				break;
			} else if (jabatan.equals("Admin")) {
				gaji = 4000000;
				break;
			}
		}

		System.out.println("Berhasil menambahkan karyawan dengan id " + kode);
		System.out.println("Enter to return");
		scan.nextLine();

		PT_ChipiChapa ptChipi = new PT_ChipiChapa(kode, nama, jenisKelamin, jabatan, gaji);
		arrChipiChapa.add(ptChipi);
	}

	void view() {
		if (arrChipiChapa.isEmpty()) {
			System.out.println("Tidak ada data karyawan");
		} else {
			sorting();
			System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n", "No", "Kode Karyawan", "Nama Karyawan",
					"Jenis Kelamin", "Jabatan", "Gaji Karyawan");
			for (int i = 0; i < arrChipiChapa.size(); i++) {
				System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15d\n", i + 1, arrChipiChapa.get(i).kode,
						arrChipiChapa.get(i).nama, arrChipiChapa.get(i).jenisKelamin, arrChipiChapa.get(i).jabatan,
						arrChipiChapa.get(i).gaji);
			}
		}

	}

	void update() {
		if (arrChipiChapa.isEmpty()) {
			System.out.println("Tidak ada data karyawan");
		} else {
			sorting();
			System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n", "No", "Kode Karyawan", "Nama Karyawan",
					"Jenis Kelamin", "Jabatan", "Gaji Karyawan");
			for (int i = 0; i < arrChipiChapa.size(); i++) {
				System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15d\n", i + 1, arrChipiChapa.get(i).kode,
						arrChipiChapa.get(i).nama, arrChipiChapa.get(i).jenisKelamin, arrChipiChapa.get(i).jabatan,
						arrChipiChapa.get(i).gaji);
			}
		}

		int angka;
		while (true) {
			System.out.print("Input nomor urutan karyawan yang ingin di update : ");
			angka = scan.nextInt();
			scan.nextLine();
			if (angka > 0 && angka <= arrChipiChapa.size()) {

				PT_ChipiChapa pilihan = arrChipiChapa.get(angka - 1);
				String namaBaru;
				while (true) {
					System.out.print("Input nama karyawan [>=3]: ");
					namaBaru = scan.nextLine();
					if (namaBaru.length() >= 3) {
						pilihan.nama = namaBaru;
						break;
					}
				}

				String jenisKelaminBaru;
				while (true) {
					System.out.print("Input jenis kelamin [Laki-laki | Perempuan]: ");
					jenisKelaminBaru = scan.nextLine();
					if (jenisKelaminBaru.equals("Laki-laki")) {
						pilihan.jenisKelamin = jenisKelaminBaru;
						break;
					} else if (jenisKelaminBaru.equals("Perempuan")) {
						pilihan.jenisKelamin = jenisKelaminBaru;
						break;
					}

				}

				String jabatanBaru;
				Integer gajiBaru;
				while (true) {
					System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
					jabatanBaru = scan.nextLine();
					if (jabatanBaru.equals("Manager")) {
						gajiBaru = 8000000;
						pilihan.jabatan = jabatanBaru;
						pilihan.gaji = gajiBaru;
						break;
					} else if (jabatanBaru.equals("Supervisor")) {
						gajiBaru = 6000000;
						pilihan.jabatan = jabatanBaru;
						pilihan.gaji = gajiBaru;
						break;
					} else if (jabatanBaru.equals("Admin")) {
						gajiBaru = 4000000;
						pilihan.jabatan = jabatanBaru;
						pilihan.gaji = gajiBaru;
						break;
					}
				}

				System.out.println("Berhasil mengupdate karyawan dengan id " + pilihan.kode);
				System.out.println("ENTER to return");
				scan.nextLine();

				break;
			} else if (angka == 0) {
				break;
			}
		}

	}

	void delete() {
	    if (arrChipiChapa.isEmpty()) {
	        System.out.println("Tidak ada data karyawan");
	    } else {
	        sorting();
	        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n", "No", "Kode Karyawan", "Nama Karyawan",
	                "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
	        for (int i = 0; i < arrChipiChapa.size(); i++) {
	            System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15d\n", i + 1, arrChipiChapa.get(i).kode,
	                    arrChipiChapa.get(i).nama, arrChipiChapa.get(i).jenisKelamin, arrChipiChapa.get(i).jabatan,
	                    arrChipiChapa.get(i).gaji);
	        }
	    }

	    int angka;
	    while (true) {
	        System.out.print("Input nomor urutan karyawan yang ingin dihapus : ");
	        angka = scan.nextInt();
	        scan.nextLine();
	        if (angka > 0 && angka <= arrChipiChapa.size()) {
	            PT_ChipiChapa pilihan = arrChipiChapa.remove(angka - 1);
	            System.out.println("Berhasil menghapus karyawan dengan id " + pilihan.kode);
	            System.out.println("ENTER to return");
	            scan.nextLine();
	            break;
	        } else if (angka == 0) {
	            break;
	        }
	    }
	}

	public MainChipiChapa() {
		while (true) {
			menu();
			System.out.print(">> ");
			int pilih = scan.nextInt();
			scan.nextLine();
			if (pilih == 1) {
				insert();
			} else if (pilih == 2) {
				view();
			} else if (pilih == 3) {
				update();
			} else if (pilih == 4) {
				delete();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainChipiChapa();
	}

}
