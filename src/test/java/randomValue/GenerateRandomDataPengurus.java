package randomValue;

import java.util.Random;

public class GenerateRandomDataPengurus {

    public String nomorAplikasi() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = 10;
        Random rnd = new Random();
        StringBuilder nomoraplikasi = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nomoraplikasi.append(chars.charAt(rnd.nextInt(chars.length())));
        return nomoraplikasi.toString();
    }

    public String nomorUrutPengurus() {
        String chars = "1";
        int len = 1;
        Random rnd = new Random();
        StringBuilder nup = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nup.append(chars.charAt(rnd.nextInt(chars.length())));
        return nup.toString();
    }

    public String jumlahPengurus() {
        String chars = "1";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jp = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jp.append(chars.charAt(rnd.nextInt(chars.length())));
        return jp.toString();

    }

    public String sandiJabatanBI() {
        String chars = "01";
        String chars2 = "123";
        int len = 1;
        Random rnd = new Random();
        StringBuilder sjBI = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            sjBI.append(chars.charAt(rnd.nextInt(chars.length())));
            sjBI.append(chars2.charAt(rnd.nextInt(chars.length())));
        return sjBI.toString();
    }

    public String pangsaKepemilikan() {
        String chars = "1";
//        int[] s = new int[Integer.parseInt(chars)];
        int len = 1;
        Random rnd = new Random();
        StringBuilder pk = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            pk.append(chars.charAt(rnd.nextInt(chars.length())));
        return pk.toString();
    }

    public String bentukPengurus() {
        String chars = "1";
        int len = 1;
        Random rnd = new Random();
        StringBuilder bp = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            bp.append(chars.charAt(rnd.nextInt(chars.length())));
        return bp.toString();
    }

    public String modalDasar() {
        String chars = "0";
        int len = 5;
        Random rnd = new Random();
        StringBuilder md = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            md.append(chars.charAt(rnd.nextInt(chars.length())));
        return md.toString();
    }

    public String modalDisetor() {
        String chars = "0";
        int len = 5;
        Random rnd = new Random();
        StringBuilder md = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            md.append(chars.charAt(rnd.nextInt(chars.length())));
        return md.toString();
    }
    public String modalDitempatkan() {
        String chars = "0";
        int len = 5;
        Random rnd = new Random();
        StringBuilder md = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            md.append(chars.charAt(rnd.nextInt(chars.length())));
        return md.toString();
    }
    public String npwpPengurus() {
        String chars = "6789456789567789978765";
        int len = 15;
        Random rnd = new Random();
        StringBuilder npwpPengurus = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            npwpPengurus.append(chars.charAt(rnd.nextInt(chars.length())));
        return npwpPengurus.toString();
    }
    public String namaPengurus() {
        String chars = "zxcasdldkfgkafghiq";
        int len = 2;
        Random rnd = new Random();
        StringBuilder np = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            np.append(chars.charAt(rnd.nextInt(chars.length())));
        return np.toString();
    }
    public String alamatPengurus() {
        String chars = "12345678912131415161718192";
        int len = 2;
        Random rnd = new Random();
        StringBuilder plafonkredit = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            plafonkredit.append(chars.charAt(rnd.nextInt(chars.length())));
        return plafonkredit.toString();
    }
    public String alamatKelurahan() {
        String chars = "12345678911112131415161718192";
        int len = 6;
        Random rnd = new Random();
        StringBuilder ak = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            ak.append(chars.charAt(rnd.nextInt(chars.length())));
        return ak.toString();
    }
    public String alamatKecamatan() {
        String chars = "12345678911112131415161718192";
        int len = 6;
        Random rnd = new Random();
        StringBuilder ak = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            ak.append(chars.charAt(rnd.nextInt(chars.length())));
        return ak.toString();
    }
    public String alamatDatiII() {
        String chars = "3";
        int len = 1;
        Random rnd = new Random();
        StringBuilder adII = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            adII.append(chars.charAt(rnd.nextInt(chars.length())));
        return adII.toString();
    }
    public String noKTP() {
        String chars = "12345678911112131415161718192";
        int len = 15;
        Random rnd = new Random();
        StringBuilder nktp = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nktp.append(chars.charAt(rnd.nextInt(chars.length())));
        return nktp.toString();
    }
    public String noAkte() {
        String chars = "12345678911112131415161718192";
        int len = 3;
        Random rnd = new Random();
        StringBuilder nakte = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nakte.append(chars.charAt(rnd.nextInt(chars.length())));
        return nakte.toString();
    }
    public String tanggalLahir() {
        String chars = "12345678911112131415161718192";
        int len = 7;
        Random rnd = new Random();
        StringBuilder plafonkredit = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            plafonkredit.append(chars.charAt(rnd.nextInt(chars.length())));
        return plafonkredit.toString();
    }
    public String tanggalAkte() {
        String chars = "12345678911112131415161718192";
        int len = 7;
        Random rnd = new Random();
        StringBuilder plafonkredit = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            plafonkredit.append(chars.charAt(rnd.nextInt(chars.length())));
        return plafonkredit.toString();
    }
    public String DatiIITempatLahr() {
        String chars = "1";
        int len = 1;
        Random rnd = new Random();
        StringBuilder datiTempatLahir = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            datiTempatLahir.append(chars.charAt(rnd.nextInt(chars.length())));
        return datiTempatLahir.toString();
    }
    public String jenisKelamin() {
        String chars = "BM";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jk = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jk.append(chars.charAt(rnd.nextInt(chars.length())));
        return jk.toString();
    }
}
