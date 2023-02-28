package randomValue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateRandomDataApp {
    public String timeStamp;

    public String nomorAplikasi(int Length) {

        String pattern = "HHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate = simpleDateFormat.format(new Date());
        timeStamp = fdate;

        String chars = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = Length;
        Random rnd = new Random();
        StringBuilder nomoraplikasi = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nomoraplikasi.append(chars.charAt(rnd.nextInt(chars.length())));
        return nomoraplikasi + timeStamp;
    }

    public String nik() {
        String chars = "1234567891111213141516171819245";
        int len = 16;
        Random rnd = new Random();
        StringBuilder nik = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nik.append(chars.charAt(rnd.nextInt(chars.length())));
        return nik.toString();
    }

    public String npwp() {
        String chars = "1234567891111213141516171819234";
        int len = 15;
        Random rnd = new Random();
        StringBuilder npwp = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            npwp.append(chars.charAt(rnd.nextInt(chars.length())));
        return npwp.toString();

    }

    public String jenisDebitur() {
        String chars = "B";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jenisdebitur = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jenisdebitur.append(chars.charAt(rnd.nextInt(chars.length())));
        return jenisdebitur.toString();
    }

    public String namaDebitur() {

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = 4;
        Random rnd = new Random();
        StringBuilder namadebitur = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            namadebitur.append(chars.charAt(rnd.nextInt(chars.length())));
        return namadebitur + timeStamp;
    }

    public String jangkaWaktu(String cd_company) {
        String jangkaWaktu;
        switch (cd_company) {
            case "L000030":
            case "L000132":
            case "L000040":
            case "L000001":
            case "L000002":
            case "L000017":
            case "L000023":
            case "L000014":
            case "L000130":
            case "L000052":
            case "L000058":
            case "L000053":
            case "L000005":
                jangkaWaktu = "006";
                return jangkaWaktu;
            case "L000133":
            case "L000004":
                jangkaWaktu = "036";
                return jangkaWaktu;
        }
        return null;
    }

    public String interestRate(String cd_company) {
        String interestRate;
        switch (cd_company) {
            case "L000030":
            case "L000132":
            case "L000058":
            case "L000040":
            case "L000001":
            case "L000002":
            case "L000017":
            case "L000023":
            case "L000014":
            case "L000130":
            case "L000052":
            case "L000053":
            case "L000005":
                interestRate = "01175";
                return interestRate;
            case "L000133":
                interestRate = "01025";
                return interestRate;
            case "L000004":
                interestRate = "01015";
                return interestRate;
        }
        return null;
    }

    public String plafonKredit(String cd_company) {
        String chars = "123456789";
        int len = 1;
        Random rnd = new Random();
        StringBuilder plafonkredit = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            plafonkredit.append(chars.charAt(rnd.nextInt(chars.length())));

        switch (cd_company) {
            case "L000001":
            case "L000002":
            case "L000052":
            case "L000053":
            case "L000005":
                return "0000001"+plafonkredit+"0000000";
            case "L000030":
                return "000005"+plafonkredit+"00000000";
        }
        return null;

    }
}
