Feature: Lending Channeling

  @approvalForm
  Scenario: Approval Form
  Given open browser and login as a role maker
  Then click menu approval form
  Then verify data form table
    And verify data source
    And verify data application no
    And verify data debtor name
    And verify data partner
    And verify data date
    And verify data loan amount
    And verify data rate
  Then click debtor name
    And verify data detail partner name
    And verify data detail debtor name
    And verify data detail status
    And verify data detail application no
    And verify data detail tanggal pengajuan
    And verify data detail jenis debitur
    And verify data detail plafon
    And verify data detail jangka waktu
    And verify data detail interest rate
    And verify data detail NIK
    And verify data detail NPWP
    And verify data detail Dokumen Pendukung(Tidak Upload Dokumen)
    And verify data detail Dokumen Pendukung(Upload Dokumen > 1file.zip)
    And verify data detail Dokumen Pendukung(Upload Dokumen 2kali isi file berbeda)
  Then click debtor name untuk merubah status recommended & not recommended
    And click debtor name dengan status waiting for review
    And memilih option recommended dan mengisi 5000karakter dan submit
    And memilih option not recommended dan mengisi 4999karakter dan submit
  Then click debtor name untuk merubah status approved & rejected
    And click debtor name dengan status waiting approval
    And memilih option keputusan approve dan mengisi 5000karakter dan submit
    And memilih option keputusan rejected dan mengisi 4999karakter dan submit
  Then click debtor name dengan status approved & rejected & approval expired
    And click debtor name dengan status approved
    And click debtor name dengan status rejected
  Then approved yang status waiting approval untuk persiapan data realisasi
    And click debtor name dengan status approval expired
  Then user maker logout
