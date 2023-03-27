package randomValue;

import net.bytebuddy.build.Plugin;
import org.apache.batik.parser.LengthListHandler;
import org.apache.tools.ant.taskdefs.Length;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateRandomDataRepayment {

    public String noBayar(int Length) {

        String pattern = "HHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String datenow = simpleDateFormat.format(new Date());
        String time = datenow;

        String chars = "1234567890ACBDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = Length - time.length();
        Random rnd = new Random();
        StringBuilder noPembayaran = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            noPembayaran.append(chars.charAt(rnd.nextInt(chars.length())));
        return time + noPembayaran;
    }

    public String tglBayar() {
        String pattern = "ddMMyyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateBayar = simpleDateFormat.format(new Date());

        return dateBayar;
    }

    public String nomPokok(String nominalPokok) {
        return String.valueOf(nominalPokok);
    }
    public String nomBunga(String nominalBunga) {
        return String.valueOf(nominalBunga);
    }
    public String nomDenda(String  nominalDenda) {
        return String.valueOf(nominalDenda);
    }
    public String addInterest(String addInterest) {
        return String.valueOf(addInterest);
    }
}
