Feature: Lending Chanelling

  @realizationForm
  Scenario: Realization Form
    Given open browser and login as a role ldap maker
    Then click icon notifikasi and verify notifikasi saat data realisasi masuk LOS
      And verify notifikasi setelah file masuk
    Then click menu realization
    Then verify data form table realization dan search application number berdasarkan status
      And verify data realisasi form dengan status waiting approval
      And verify data realisasi form dengan status pending
      And verify data realisasi form dengan status approval expired
    Then verify data form table realisasi
      And verify data realisasi source
      And verify data realisasi application no
      And verify data realisasi debtor name
      And verify data realisasi partner
      And verify data realisasi date
      And verify data realisasi loan amount
      And verify data realisasi rate
    Then click debtor name realisasi
      And verify data detail realisasi partner
      And verify data detail realisasi debtor name
      And verify data detail realisasi status
      And verify data detail realisasi app no
      And verify data detail realisasi tanggal pengajuan
      And verify data detail realisasi jenis debitur
      And verify data detail realisasi plafon
      And verify data detail realisasi jangka waktu
      And verify data detail realisasi interest rate
      And verify data detail realisasi jenis kredit
      And verify data detail realisasi jenis penggunaan
      And verify data detail realisasi nomor PK
      And verify data detail realisasi tanggal akad
      And verify data detail realisasi tanggal angsuran I
      And verify data detail realisasi nomor NPWP
      And verify data detail realisasi no telp
      And verify data detail realisasi alamat
      And verify data detail realisasi alamat kelurahan
      And verify data detail realisasi alamat kecamatan
      And verify data detail realisasi alamat kode pos
      And verify data detail realisasi alamat kode DATI II
      And verify data detail realisasi bidang usaha
      And verify data detail realisasi bentuk badan usaha
      And verify data detail realisasi sektor ekonomi
      And verify data detail realisasi go public
      And verify data detail realisasi sandi golongan debitur
      And verify data detail realisasi penghasilan kotor per tahun
      And verify data detail realisasi omzet
      And verify data detail realisasi no akte
      And verify data detail realisasi no akte terakhir
      And verify data detail realisasi tanggal akte terakhir
      And verify data detail realisasi tanggal berdiri
      And verify data detail realisasi tempat berdiri badan usaha
    Then verify no akte dan tangggal akte
      And verify tanggal akte terakhir sama dengan hari ini
      And verify tanggal akte terakhir kemarin
      And verify tanggal berdiri dan tanggal akte terakhir sama serta no akte dan no akte terakhir sama
      And verify tanggal berdiri dan tanggal akte terakhir berbeda serta no akte dan no akte terakhir berbeda
      And verify tanggal berdiri dan tanggal akte terakhir berbeda serta no akte dan no akte terakhir sama
    Then click debtor name rea merubah status waiting approval
      And click debtor name rea status waiting approval dengan klik approve
      And click debtor name rea status waiting approval dengan klik approve lalu saat confirm box klik tidak
      And click debtor name rea status waiting approval dengan klik approve lalu saat confirm box klik ya
      And click debtor name rea status waiting approval dengan klik reject
      And click debtor name rea status waiting approval dengan klik dan pilih reject reason dokumen pendukung tidak sesuai dan deskripsi 5000karakter lalu klik reject
      And click debtor name rea status waiting approval dengan klik dan pilih reject reason pengajuan ditolak dan deskripsi 49999karakter lalu klik reject
      And click debtor name rea status waiting approval dengan klik dan pilih reject reason dan deskripsi kosong lalu klik reject
    Then click debtor name rea untuk melihat status waiting approval & approved & rejected &  pending & expired
      And click debtor name rea dengan status waiting approval
      And click debtor name rea dengan status approved
      And click debtor name rea dengan status rejected
      And click debtor name rea dengan status pending
      And click debtor name rea dengan status expired
    Then reconsume data dengan merubah data alamat setiap status
      And reconsume dengan no aplikasi status rejected
      And reconsume dengan no aplikasi status approved
      And reconsume dengan no aplikasi status waiting approval
      And reconsume dengan no aplikasi status expired
      And reconsume dengan no aplikasi status pending
    Then user ldap logout






