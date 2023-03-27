package testData;

import elementsPage.Const;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData {
    public String[] cellDataValue;
    public String environment;
    public String namaDebitur;
    public String companyName;
    public String cd_company;
    public String kode_produk;
    public String jumlahData;
    public String tagName;
    public String timeStamp;
    public String noAppp;
    public String nik;
    static ReadTestData readTestData = new ReadTestData();
    static int columnCodeUAT = 1;
    static int columnDescUAT = 2;
    static int columnCodeE2E = 4;
    static int columnDescE2E = 5;

    public String[] testData() {
        try {
            ZipSecureFile.setMinInflateRatio(0);
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);
            XSSFSheet sheet = workbook.getSheet(Const.sheetTestData);

            environment = sheet.getRow(1).getCell(0).getStringCellValue();
            namaDebitur = sheet.getRow(1).getCell(1).getStringCellValue();
            companyName = sheet.getRow(1).getCell(2).getStringCellValue();
            cd_company = sheet.getRow(1).getCell(3).getStringCellValue();
            kode_produk = sheet.getRow(1).getCell(4).getStringCellValue();
            jumlahData = sheet.getRow(1).getCell(5).getStringCellValue();
            timeStamp = sheet.getRow(1).getCell(6).getStringCellValue();
            tagName = sheet.getRow(1).getCell(7).getStringCellValue();
            noAppp = sheet.getRow(1).getCell(8).getStringCellValue();
            nik = sheet.getRow(1).getCell(9).getStringCellValue();
            cellDataValue = new String[]{environment, namaDebitur, companyName, cd_company, kode_produk, jumlahData};

            workbook.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return cellDataValue;
    }

    public static String testCaseID(int i) {
        String _case = null;
        readTestData.testData();

        try {
            XSSFSheet sheet = null;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthFileValidation + Const.fileNMScenario);

            switch (readTestData.tagName){

                case "approvalForm":
                    sheet = workbook.getSheet(Const.sheetApprovalFormBU);
                    break;
                case "realizationForm":
                    sheet = workbook.getSheet(Const.sheetRealizationFormBU);
                    break;
                case "validationApprovalFile":
                    sheet = workbook.getSheet(Const.sheetApprovalFileBU);
                    break;
                case "validationRealizationFile":
                    sheet = workbook.getSheet(Const.sheetRealisasiFileBU);
                    break;
                case "validationRepaymentFile":
                    sheet = workbook.getSheet(Const.sheetRepaymentFileBU);
                    break;
                case "repaymentForm":
                    sheet = workbook.getSheet(Const.sheetRepaymentFormBU);
                    break;
            }
            _case = sheet.getRow(i + 1).getCell(1).getStringCellValue();

            workbook.close();
            return _case;
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
    }
    public static String testCaseName(int i) {
        String _case = null;
        readTestData.testData();

        try {
            XSSFSheet sheet = null;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthFileValidation + Const.fileNMScenario);

            switch (readTestData.tagName){

                case "approvalForm":
                    sheet = workbook.getSheet(Const.sheetApprovalFormBU);
                    break;
                case "realizationForm":
                    sheet = workbook.getSheet(Const.sheetRealizationFormBU);
                    break;
                case "validationApprovalFile":
                    sheet = workbook.getSheet(Const.sheetApprovalFileBU);
                    break;
                case "validationRealizationFile":
                    sheet = workbook.getSheet(Const.sheetRealisasiFileBU);
                    break;
                case "validationRepaymentFile":
                    sheet = workbook.getSheet(Const.sheetRepaymentFileBU);
                    break;
                case "repaymentForm":
                    sheet = workbook.getSheet(Const.sheetRepaymentFormBU);
                    break;
            }
            _case = sheet.getRow(i + 1).getCell(4).getStringCellValue();

            workbook.close();
            return _case;
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
    }

    public static String expectedResult(int i) {
        String _expectedResult = null;
        XSSFSheet sheet = null;
        readTestData.testData();
        try {
            ZipSecureFile.setMinInflateRatio(0);
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthFileValidation + Const.fileNMScenario);
            switch (readTestData.tagName){

                case "approvalForm":
                    sheet = workbook.getSheet(Const.sheetApprovalFormBU);
                    break;
                case "realizationForm":
                    sheet = workbook.getSheet(Const.sheetRealizationFormBU);
                    break;
                case "validationApprovalFile":
                    sheet = workbook.getSheet(Const.sheetApprovalFileBU);
                    break;
                case "validationRealizationFile":
                    sheet = workbook.getSheet(Const.sheetRealisasiFileBU);
                    break;
                case "validationRepaymentFile":
                    sheet = workbook.getSheet(Const.sheetRepaymentFileBU);
                    break;
                case "repaymentForm":
                    sheet = workbook.getSheet(Const.sheetRepaymentFormBU);
                    break;
            }

            _expectedResult = sheet.getRow(i + 1).getCell(5).getStringCellValue();

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _expectedResult;
    }
    public static String expectedNoted(int i) {
        String _expectedResult = null;
        XSSFSheet sheet = null;
        readTestData.testData();
        try {
            ZipSecureFile.setMinInflateRatio(0);
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthFileValidation + Const.fileNMScenario);
            switch (readTestData.tagName){

                case "approvalForm":
                    sheet = workbook.getSheet(Const.sheetApprovalFormBU);
                    break;
                case "realizationForm":
                    sheet = workbook.getSheet(Const.sheetRealizationFormBU);
                    break;
                case "validationApprovalFile":
                    sheet = workbook.getSheet(Const.sheetApprovalFileBU);
                    break;
                case "validationRealizationFile":
                    sheet = workbook.getSheet(Const.sheetRealisasiFileBU);
                    break;
                case "validationRepaymentFile":
                    sheet = workbook.getSheet(Const.sheetRepaymentFileBU);
                    break;
            }

            _expectedResult = sheet.getRow(i + 1).getCell(10).getStringCellValue();

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _expectedResult;
    }

    public String[] testDataMaintananceTable() {
        readTestData.testData();
        try {
            ZipSecureFile.setMinInflateRatio(0);
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);
            XSSFSheet sheet = workbook.getSheet(Const.sheetTestDataMaintananceTable);

//            String jenisKreditI_1      = sheet.getRow(2).getCell(1).getStringCellValue();
//            String jenisKreditV_1      = sheet.getRow(2).getCell(2).getStringCellValue();
//            String jenisPenggunaanI_1  = sheet.getRow(6).getCell(1).getRawValue();
//            String jenisPenggunaanV_1  = sheet.getRow(6).getCell(2).getStringCellValue();
//            String kodeDatiI_1         = sheet.getRow(10).getCell(1).getStringCellValue();
//            String kodeDatitV_1        = sheet.getRow(10).getCell(2).getStringCellValue();
//            String bidangUsahaI_1      = sheet.getRow(14).getCell(1).getRawValue();
//            String bidangUsahaV_1      = sheet.getRow(14).getCell(2).getStringCellValue();
//            String bentukBadanUsahaI_1 = sheet.getRow(18).getCell(1).getRawValue();
//            String bentukBadanUsahaV_1 = sheet.getRow(18).getCell(2).getStringCellValue();
//            String sektorEkonomiI_1    = sheet.getRow(22).getCell(1).getRawValue();
//            String sektorEkonomiV_1    = sheet.getRow(22).getCell(2).getStringCellValue();
//            String goPublicI_1         = sheet.getRow(26).getCell(1).getRawValue();
//            String goPublicV_1         = sheet.getRow(26).getCell(2).getStringCellValue();
//            String sandiGolDebtI_1     = sheet.getRow(30).getCell(1).getStringCellValue();
//            String sandiGolDebtV_1     = sheet.getRow(30).getCell(2).getStringCellValue();
//
//            String sektorEkonomiI_2    = sheet.getRow(22).getCell(5).getStringCellValue();
//            String sektorEkonomiV_2    = sheet.getRow(22).getCell(6).getStringCellValue();

            String jenisKreditI_1      = sheet.getRow(2).getCell(5).getStringCellValue();
            String jenisKreditV_1      = sheet.getRow(2).getCell(6).getStringCellValue();
            String jenisKreditI_2      = sheet.getRow(3).getCell(5).getStringCellValue();
            String jenisKreditV_2      = sheet.getRow(3).getCell(6).getStringCellValue();
            String jenisKreditI_3      = sheet.getRow(4).getCell(5).getStringCellValue();
            String jenisKreditV_3      = sheet.getRow(4).getCell(6).getStringCellValue();
            String jenisKreditI_4      = sheet.getRow(5).getCell(5).getStringCellValue();
            String jenisKreditV_4      = sheet.getRow(5).getCell(6).getStringCellValue();
            String jenisKreditI_5      = sheet.getRow(6).getCell(5).getStringCellValue();
            String jenisKreditV_5      = sheet.getRow(6).getCell(6).getStringCellValue();
            String jenisKreditI_6      = sheet.getRow(7).getCell(5).getStringCellValue();
            String jenisKreditV_6      = sheet.getRow(7).getCell(6).getStringCellValue();
            String jenisPenggunaanI_1  = sheet.getRow(10).getCell(5).getRawValue();
            String jenisPenggunaanV_1  = sheet.getRow(10).getCell(6).getStringCellValue();
            String jenisPenggunaanI_2  = sheet.getRow(11).getCell(5).getRawValue();
            String jenisPenggunaanV_2  = sheet.getRow(11).getCell(6).getStringCellValue();
            String kodeDatiI_1         = sheet.getRow(18).getCell(5).getStringCellValue();
            String kodeDatitV_1        = sheet.getRow(18).getCell(6).getStringCellValue();
            String kodeDatiI_2         = sheet.getRow(19).getCell(5).getStringCellValue();
            String kodeDatitV_2        = sheet.getRow(19).getCell(6).getStringCellValue();
            String bidangUsahaI_1      = sheet.getRow(26).getCell(5).getRawValue();
            String bidangUsahaV_1      = sheet.getRow(26).getCell(6).getStringCellValue();
            String bidangUsahaI_2      = sheet.getRow(27).getCell(5).getRawValue();
            String bidangUsahaV_2      = sheet.getRow(27).getCell(6).getStringCellValue();
            String bidangUsahaI_3      = sheet.getRow(28).getCell(5).getRawValue();
            String bidangUsahaV_3      = sheet.getRow(28).getCell(6).getStringCellValue();
            String bidangUsahaI_4      = sheet.getRow(29).getCell(5).getRawValue();
            String bidangUsahaV_4      = sheet.getRow(29).getCell(6).getStringCellValue();
            String bidangUsahaI_5      = sheet.getRow(30).getCell(5).getRawValue();
            String bidangUsahaV_5      = sheet.getRow(30).getCell(6).getStringCellValue();
            String bidangUsahaI_6      = sheet.getRow(31).getCell(5).getRawValue();
            String bidangUsahaV_6      = sheet.getRow(31).getCell(6).getStringCellValue();
            String bentukBadanUsahaI_1 = sheet.getRow(34).getCell(5).getRawValue();
            String bentukBadanUsahaV_1 = sheet.getRow(34).getCell(6).getStringCellValue();
            String bentukBadanUsahaI_2 = sheet.getRow(35).getCell(5).getRawValue();
            String bentukBadanUsahaV_2 = sheet.getRow(35).getCell(6).getStringCellValue();
            String bentukBadanUsahaI_3 = sheet.getRow(36).getCell(5).getRawValue();
            String bentukBadanUsahaV_3 = sheet.getRow(36).getCell(6).getStringCellValue();
            String sektorEkonomiI_1    = sheet.getRow(42).getCell(5).getRawValue();
            String sektorEkonomiV_1    = sheet.getRow(42).getCell(6).getStringCellValue();
            String sektorEkonomiI_2    = sheet.getRow(43).getCell(5).getStringCellValue();
            String sektorEkonomiV_2    = sheet.getRow(43).getCell(6).getStringCellValue();
            String goPublicI_1         = sheet.getRow(50).getCell(5).getRawValue();
            String goPublicV_1         = sheet.getRow(50).getCell(6).getStringCellValue();
            String sandiGolDebtI_1     = sheet.getRow(58).getCell(5).getStringCellValue();
            String sandiGolDebtV_1     = sheet.getRow(58).getCell(6).getStringCellValue();
            String sandiGolDebtI_2     = sheet.getRow(59).getCell(5).getStringCellValue();
            String sandiGolDebtV_2     = sheet.getRow(59).getCell(6).getStringCellValue();

            if (readTestData.environment.equals("E2E")) {
                cellDataValue = new String[]{jenisKreditI_1,jenisKreditV_1,
                        jenisPenggunaanI_1,jenisPenggunaanV_1,
                        kodeDatiI_1,kodeDatitV_1,
                        bidangUsahaI_1,bidangUsahaV_1,
                        bentukBadanUsahaI_1,bentukBadanUsahaV_1,
                        sektorEkonomiI_1,sektorEkonomiV_1,
                        goPublicI_1,goPublicV_1,
                        sandiGolDebtI_1,sandiGolDebtV_1};
            } else{
                cellDataValue = new String[]{jenisKreditI_1,jenisKreditV_1,
                        jenisPenggunaanI_1,jenisPenggunaanV_1,
                        kodeDatiI_1,kodeDatitV_1,
                        bidangUsahaI_1,bidangUsahaV_1,
                        bentukBadanUsahaI_1,bentukBadanUsahaV_1,
                        sektorEkonomiI_2,sektorEkonomiV_2,
                        goPublicI_1,goPublicV_1,
                        sandiGolDebtI_1,sandiGolDebtV_1};
            }
            workbook.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return cellDataValue;
    }
    public static String enumerasiDatiII(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 1;
        int endRow = 6;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiBidangUsaha(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 7;
        int endRow = 12;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiJenisKredit(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 13;
        int endRow = 18;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiJenisPenggunaan(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 19;
        int endRow = 24;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiSektorEkonomi(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 25;
        int endRow = 30;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiGoPublic(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 31;
        int endRow = 36;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiSandiGolongan(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 37;
        int endRow = 42;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiBentukBadanUsaha(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 43;
        int endRow = 48;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiSandiJabatan(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 49;
        int endRow = 54;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiBentukPengurus(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 55;
        int endRow = 60;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
    public static String enumerasiJnsKelPengurus(String codeEnumerasi) {
        String _case = null;
        readTestData.testData();

        int startRow = 61;
        int endRow = 64;

        try {
            XSSFSheet sheet;
            XSSFWorkbook workbook = new XSSFWorkbook(Const.pthTestData);

            sheet = workbook.getSheet("mapping_enumerasi");

            assert sheet != null;
            if (readTestData.environment.equals(Const.uat_environment)) {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeUAT).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescUAT).getStringCellValue();
                    }
                }
            } else {
                for (int x = 0; x < endRow; x++) {
                    _case = sheet.getRow(x + startRow).getCell(columnCodeE2E).getStringCellValue();
                    if (codeEnumerasi.equals(_case)) {
                        workbook.close();
                        return _case = sheet.getRow(x + startRow).getCell(columnDescE2E).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return _case;
        }
        return null;
    }
}
