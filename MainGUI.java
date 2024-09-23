import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    
    private JTextArea displayArea;
    private JButton btnSipilPria, btnSipilWanita, btnElektroPria, btnElektroWanita;
    private JButton btnKedokteranPria, btnKedokteranWanita, btnManajemenPria, btnManajemenWanita;

    public MainGUI() {
        // Set up the frame
        setTitle("Informasi Mahasiswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Create buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 2));

        btnSipilPria = new JButton("Mahasiswa Sipil Pria 2019");
        btnSipilWanita = new JButton("Mahasiswa Sipil Wanita 2019");
        btnElektroPria = new JButton("Mahasiswa Elektro Pria 2020");
        btnElektroWanita = new JButton("Mahasiswa Elektro Wanita 2020");
        btnKedokteranPria = new JButton("Mahasiswa Kedokteran Pria 2021");
        btnKedokteranWanita = new JButton("Mahasiswa Kedokteran Wanita 2021");
        btnManajemenPria = new JButton("Mahasiswa Manajemen Pria 2018");
        btnManajemenWanita = new JButton("Mahasiswa Manajemen Wanita 2018");

        buttonPanel.add(btnSipilPria);
        buttonPanel.add(btnSipilWanita);
        buttonPanel.add(btnElektroPria);
        buttonPanel.add(btnElektroWanita);
        buttonPanel.add(btnKedokteranPria);
        buttonPanel.add(btnKedokteranWanita);
        buttonPanel.add(btnManajemenPria);
        buttonPanel.add(btnManajemenWanita);

        // Add action listeners to buttons
        btnSipilPria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MahasiswaTeknikSipilPria mahasiswa = new MahasiswaTeknikSipilPria("Budi", "123456", 2019);
                tampilkanInfo(mahasiswa);
            }
        });

        btnSipilWanita.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MahasiswaTeknikSipilWanita mahasiswa = new MahasiswaTeknikSipilWanita("Dewi", "654321", 2019);
                tampilkanInfo(mahasiswa);
            }
        });



        // Add components to frame
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    // Method to display student info
    public void tampilkanInfo(MahasiswaUndip mahasiswa) {
        displayArea.append(mahasiswa.info() + "\n");
        displayArea.append("---------------------------------------------\n");
    }

    public static void main(String[] args) {
        // Run the GUI application
        new MainGUI();
    }
}

// Kelas MahasiswaUndip dan kelas turunan lainnya sama seperti sebelumnya
class MahasiswaUndip {
    protected String nama;
    protected String nim;
    protected String fakultas;

    public MahasiswaUndip(String nama, String nim, String fakultas) {
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
    }

    public String info() {
        return "Nama: " + nama + ", NIM: " + nim + ", Fakultas: " + fakultas;
    }
}

class MahasiswaFakultasTeknik extends MahasiswaUndip {
    public MahasiswaFakultasTeknik(String nama, String nim) {
        super(nama, nim, "Fakultas Teknik");
    }
}

class MahasiswaTeknikSipil extends MahasiswaFakultasTeknik {
    public MahasiswaTeknikSipil(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public String info() {
        return super.info() + ", Program Studi: Teknik Sipil";
    }
}

class MahasiswaTeknikSipilAngkatan extends MahasiswaTeknikSipil {
    private int tahunAngkatan;

    public MahasiswaTeknikSipilAngkatan(String nama, String nim, int tahunAngkatan) {
        super(nama, nim);
        this.tahunAngkatan = tahunAngkatan;
    }

    @Override
    public String info() {
        return super.info() + ", Tahun Angkatan: " + tahunAngkatan;
    }
}

class MahasiswaTeknikSipilPria extends MahasiswaTeknikSipilAngkatan {
    public MahasiswaTeknikSipilPria(String nama, String nim, int tahunAngkatan) {
        super(nama, nim, tahunAngkatan);
    }

    @Override
    public String info() {
        return super.info() + ", Jenis Kelamin: Pria";
    }
}

class MahasiswaTeknikSipilWanita extends MahasiswaTeknikSipilAngkatan {
    public MahasiswaTeknikSipilWanita(String nama, String nim, int tahunAngkatan) {
        super(nama, nim, tahunAngkatan);
    }

    @Override
    public String info() {
        return super.info() + ", Jenis Kelamin: Wanita";
    }
}

// Class MahasiswaTeknikElektro, MahasiswaKedokteranUmum, MahasiswaManajemen, dll sama seperti sebelumnya
// ...
