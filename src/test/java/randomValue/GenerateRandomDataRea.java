package randomValue;

import elementsPage.Const;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class GenerateRandomDataRea {

    int x = 1; int xx = 0;
    public String tanggalAkad() {
        LocalDate today = LocalDate.now();
        String formattedToday = today.format(DateTimeFormatter.ofPattern(Const.glPattern));
        return formattedToday;
    }

    public String angsuranPertama(String cd_company, String jangkaWaktu) {

        if (cd_company.equals("L000030") || cd_company.equals("L000132") || cd_company.equals("L000058") || cd_company.equals("L000040") || cd_company.equals("L000001") || cd_company.equals("L000017") || cd_company.equals("L000014") || cd_company.equals("L000130")) {
            String[] date1 = {"01", "02", "03", "04"};
            String[] date2 = {"05", "06", "07", "08", "09", "10", "11"};
            String[] date3 = {"12", "13", "14", "15", "16", "17", "18"};
            String[] date4 = {"19", "20", "21", "22", "23", "24", "25"};
            String[] date5 = {"26", "27", "28", "29", "30", "31"};

            String angsurCond1 = "26", angsurCond2 = "05", angsurCond3 = "12", angsurCond4 = "19", angsurCond5 = "26";

            LocalDate dt = LocalDate.now();
            String dtNow = dt.format(DateTimeFormatter.ofPattern("dd"));

            LocalDate today = LocalDate.now();
            String formattedToday = today.format(DateTimeFormatter.ofPattern("MMyyyy"));

            LocalDate nextMonth = today.plusMonths(1);
            String fnextMonth = nextMonth.format(DateTimeFormatter.ofPattern("MMyyyy"));


            if (Arrays.deepToString(date1).contains(dtNow)) {
                return angsurCond1 + formattedToday;

            } else if (Arrays.deepToString(date2).contains(dtNow)) {
                return angsurCond2 + fnextMonth;

            } else if (Arrays.deepToString(date3).contains(dtNow)) {
                return angsurCond3 + fnextMonth;

            } else if (Arrays.deepToString(date4).contains(dtNow)) {
                return angsurCond4 + fnextMonth;

            } else if (Arrays.deepToString(date5).contains(dtNow)) {
                return angsurCond5 + fnextMonth;

            }
        } else if (cd_company.equals("L000002") || cd_company.equals("L000052") || cd_company.equals("L000053")) {

            LocalDate today = LocalDate.now().plusMonths(Long.parseLong(jangkaWaktu));
            String formattedToday = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
            return formattedToday;


        } else {
            LocalDate today = LocalDate.now();
            LocalDate nextMonth = today.plusMonths(1);
            String fnextMonth = nextMonth.format(DateTimeFormatter.ofPattern("MMyyyy"));
            return "25" + fnextMonth;
        }
        return "null";
    }

    public String cd_sektorEkonomi(String envi) {
        if (envi.equals("E2E")) {
            return "451000";
        } else {
            return "261000"; //31400 10000  261000
        }
    }

    public String TglBerdiriAwal() {

        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDateTime localDate   = LocalDateTime.now().minusDays(1);

        LocalDateTime PastDate    = localDate.minusDays(x);
        String dataAwal           = PastDate.format(dateTime);

        if (x%3==0){
            x +=31;
        }
        for ( int x = 1 ; x < 3 ; x++ )
            //System.out.println(dt);
            dataAwal.toString();
        x++;
        return dataAwal;
    }

    public String TglBerdiriAkir() {
        DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDateTime localDate    = LocalDateTime.now();
        String formatLocalDate     = localDate.format(dateTime);

        LocalDateTime PastDate = localDate.minusDays(xx);
        String dataAkhir = PastDate.format(dateTime);

        if (!dataAkhir.equals(formatLocalDate)){
            xx +=2;
        }
        for ( int xx = 1 ; xx < 3 ; xx++ )
            //System.out.println(dt);
            dataAkhir.toString();
        xx++;
        return dataAkhir;
    }

    public String JenisPenggunaan() {
        String chars = "123";
        int len = 1;
        Random rnd = new Random();
        StringBuilder JP = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            JP.append(chars.charAt(rnd.nextInt(chars.length())));
        return JP.toString();
    }

    public String RandomValue() {
        String chars = "123";
        int len = 1;
        Random rnd = new Random();
        StringBuilder RV = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            RV.append(chars.charAt(rnd.nextInt(chars.length())));
        return RV.toString();
    }

}
