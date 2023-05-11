package randomValue;

import io.cucumber.java.ht.Le;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GeneratePengurus {

    public String rdNum(int Length) {
        String chars = "1234567890";
        Random rnd = new Random();
        int n = Length;
        StringBuilder rd = new StringBuilder(n);

        for (int i = 0; i < n; i++)
            rd.append(chars.charAt(rnd.nextInt(chars.length())));
        return rd.toString();
    }
    public String rdSym(int Length) {
        String chars = ".,'-/&";
        Random rnd = new Random();
        int n = Length;
        StringBuilder rd = new StringBuilder(n);

        for (int i = 0; i < n; i++)
            rd.append(chars.charAt(rnd.nextInt(chars.length())));
        return rd.toString();
    }

    public String nomorUrutPengurus(String urutan) {
        String chars = urutan;
        return chars.toString();
    }
    public String jumlahPengurus() {
        String chars = "4";
        return chars;
    }
    public String sandiJabatanBI(int n) {
//        String sjbi = null;
//        if (n == 1){
//            sjbi = "1";
//        } else if (n == 2) {
//            sjbi = "10";
//        }
//        return sjbi.toString();
        return String.valueOf(n);
    }
    public String pangsaKepemilikan(String jumlahPangsa) {
        String pangsa = jumlahPangsa;
        return pangsa;
    }
    public String bentukPengurus(String bentukPengurus) {
        String chars = bentukPengurus;
        return chars;
    }
    public String modalDasar(int n) {
        String chars = "123456789";
        Random rnd = new Random();
        String zero = "0000000";
        int length = n - zero.length();
        StringBuilder md = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            md.append(chars.charAt(rnd.nextInt(chars.length())));
        return  zero + md;

    }
    public String modalDisetor(int n) {
        String chars = "123456789";
        Random rnd = new Random();
        String zero = "0000000";
        int length = n - zero.length();
        StringBuilder md = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            md.append(chars.charAt(rnd.nextInt(chars.length())));
        return  zero + md;

    }
    public String modalDitempatkan(int n) {
        String chars = "123456789";
        Random rnd = new Random();
        String zero = "0000000";
        int length = n - zero.length();
        StringBuilder md = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            md.append(chars.charAt(rnd.nextInt(chars.length())));
        return  zero + md;

    }
    public String npwp() {
        String chars = "1234567890";
        Random rnd = new Random();
        int n = 15;
        StringBuilder npwp = new StringBuilder(n);

        for (int i = 0; i < n; i++)
            npwp.append(chars.charAt(rnd.nextInt(chars.length())));
        return npwp.toString();
    }
    public String namaPengurus(int Length) {
        String name = "Cemplunk Hardiansyah "+rdSym(4)+ "Panca Mahendra Dimas Tampubolon Pangestu Dabukke Kayun Prasasta Wadi Winarno";
        String sbName = name.substring(0,Length);
        return sbName;


    }
    public String alamatPengurus(int n) {
        String chars = "Jalan Kemang Raya Bhayangkara "+rdSym(3)+"No."+rdNum(2)+" RT"+rdNum(3)+"/RW"+rdNum(3);
        String sbString = chars.substring(0,n);
        return sbString;
    }
    public String alamatKelurahan(int n) {
        String[] list1 = {"Kelurahan Cibabat ", "Kelurahan Citeureup ", "Kelurahan Cipageuran ", "Kelurahan Pasirkaliki "};
        Random r1 = new Random();
        String ls = list1[r1.nextInt(list1.length)];
        int ls2 = n - ls.length() ;
        return ls + rdNum(ls2);



    }
    public String alamatKecamatan(int n) {
        String[] list1 = {"kecamatan Cimahi ", "kecamatan Cileunyi ", "kecamatan Bojongsoang ", "kecamatan Rancaekek "};
        Random r1 = new Random();
        String ls = list1[r1.nextInt(list1.length)];
        int ls2 = n - ls.length() ;
        return ls + rdNum(ls2);
    }
    public String alamatDati() {
        String chars = "0113";
        return chars;
    }
    public String noKtp() {
        String chars = "1234567890";
        int n = 16;
        Random rnd = new Random();
        StringBuilder nk = new StringBuilder(n);

        for (int i = 0; i < n; i++)
            nk.append(chars.charAt(rnd.nextInt(chars.length())));
        return nk.toString();
    }
    public String noAkte(int n) {
        String chars = "1234567890";
        Random rnd = new Random();
        StringBuilder na = new StringBuilder(n);

        for (int i = 0; i < n; i++)
            na.append(chars.charAt(rnd.nextInt(chars.length())));
        return na.toString();
    }
    public String tglLahir(){
        String chars = "29022023";
        return chars;
    }
    public String tglAkte(){
        String chars = "10102023";
        return chars;
    }
    public String alamatDatiLhr() {
        String chars = "0111";
        return chars;
    }
    public String jnsKelamin(String n) {
        String chars = n;
        return chars;
    }
}
