Feature: Lending Chanelling

  @realizationForm
  Scenario: Realization Form
    Given open browser and login as a role ldap maker
    Then click icon notifikasi and verify notifikasi saat data realisasi masuk LOS
#      And verify notifikasi setelah file masuk
    Then click menu realization
#    Then verify data form table realization dan search application number berdasarkan status
#      And verify data realisasi form dengan status waiting approval
#    Then verify data form table realisasi
#      And verify data realisasi source
#      And verify data realisasi application no
#      And verify data realisasi debtor name
#      And verify data realisasi partner
#      And verify data realisasi date
#      And verify data realisasi loan amount
#      And verify data realisasi rate
#    Then click debtor name realisasi
#      And verify data detail realisasi partner
#      And verify data detail realisasi debtor name
#      And verify data detail realisasi status
#      And verify data detail realisasi app no
#      And verify data detail realisasi tanggal pengajuan
#      And verify data detail realisasi jenis debitur
#      And verify data detail realisasi plafon
#      And verify data detail realisasi jangka waktu
#      And verify data detail realisasi interest rate
#      And verify data detail realisasi jenis kredit
#      And verify data detail realisasi jenis penggunaan
#      And verify data detail realisasi nomor PK
#      And verify data detail realisasi tanggal akad
#      And verify data detail realisasi tanggal angsuran I
#      And verify data detail realisasi nomor NPWP
#      And verify data detail realisasi no telp
#      And verify data detail realisasi alamat
#      And verify data detail realisasi alamat kelurahan
#      And verify data detail realisasi alamat kecamatan
#      And verify data detail realisasi alamat kode pos
#      And verify data detail realisasi alamat kode DATI II
#      And verify data detail realisasi bidang usaha
#      And verify data detail realisasi bentuk badan usaha
#      And verify data detail realisasi sektor ekonomi
#      And verify data detail realisasi go public
#      And verify data detail realisasi sandi golongan debitur
#      And verify data detail realisasi penghasilan kotor per tahun
#      And verify data detail realisasi omzet
#      And verify data detail realisasi no akte
#      And verify data detail realisasi no akte terakhir
#      And verify data detail realisasi tanggal akte terakhir
#      And verify data detail realisasi tanggal berdiri
#      And verify data detail realisasi tempat berdiri badan usaha
#    Then verify detail pengurus
#      And verifikasi data No Aplikasi 17karakter
#      And verifikasi data no urut pengurus 2karakter numerik
#      And verifikasi data no jumlah pengurus 2karakter numerik
#      And verifikasi data sandi jabatan BI 2karakter numerik
#      And verifikasi data pangsa kepemilikan 5karakter numerik
#      And verifikasi data bentuk pengurus 1karakter
#      And verifikasi data modal dasar 12karakter numerik
#      And verifikasi data modal disetor 12karakter numerik
#      And verifikasi data modal ditempatkan 12karakter numerik
#      And verifikasi data NPWP pengurus 15karakter numerik
#      And verifikasi data nama pengurus 59karakter varchar
#      And verifikasi data alamat pengurus 39karakter varchar
#      And verifikasi data alamat keluarahn 39karakter varchar
#      And verifikasi data alamat kecamatan 39karakter varchar
#      And verifikasi data alamat datiII 4karakter numerik
#      And verifikasi data no akte 29karakter varchar
#      And verifikasi data tgl akte 8karakter varchar
#      And verifikasi jenis kelamin pengurusB bentuk pengurus1
#      And verifikasi input ktp 16karakter numerik
#      And verifikasi tgl lahir 8karakter numerik ddmmyyyy
#      And verifikasi dati 11tempat lahir 4karakter numerik
##    Open and Verify Pengurus 2
#      And verifikasi data sandi jabatan BI 1karakter numerik
#      And verifikasi data modal dasar 13karakter numerik
#      And verifikasi data modal disetor 13karakter numerik
#      And verifikasi data modal ditempatkan 13karakter numerik
#      And verifikasi data nama pengurus 60karakter varchar
#      And verifikasi data alamat pengurus 40karakter varchar
#      And verifikasi data alamat kelurahan 40karakter varchar
#      And verifikasi data alamat kecamatan 40karakter varchar
#      And verifikasi data no akte 30karakter varchar
#      And verifikasi jenis kelamin pengurusM bentuk pengurus1
#      And verifikasi pengurus>1 dalam 1file pengurus
#      And verifikasi jenis kelamin pengurusL bentuk pengurus2
#      And verifikasi jenis kelamin pengurusP bentuk pengurus2
#      And verifikasi no aplikasi 30karakter
#    Then verify no akte dan tangggal akte
#      And verify tanggal akte terakhir sama dengan hari ini
#      And verify tanggal akte terakhir kemarin
#      And verify tanggal berdiri dan tanggal akte terakhir sama serta no akte dan no akte terakhir sama
#      And verify tanggal berdiri dan tanggal akte terakhir berbeda serta no akte dan no akte terakhir berbeda
#      And verify tanggal berdiri dan tanggal akte terakhir berbeda serta no akte dan no akte terakhir sama
#    Then click debtor name rea merubah status waiting approval
#      And click debtor name rea status waiting approval dengan klik approve
#      And click debtor name rea status waiting approval dengan klik approve lalu saat confirm box klik tidak
#      And click debtor name rea status waiting approval dengan klik approve lalu saat confirm box klik ya
#      And click debtor name rea status waiting approval dengan klik reject
#      And click debtor name rea status waiting approval dengan klik dan pilih reject reason dokumen pendukung tidak sesuai dan deskripsi 5000karakter lalu klik reject
#      And click debtor name rea status waiting approval dengan klik dan pilih reject reason pengajuan ditolak dan deskripsi 49999karakter lalu klik reject
#      And click debtor name rea status waiting approval dengan klik dan pilih reject reason dan deskripsi kosong lalu klik reject
#    Then click debtor name rea untuk melihat status waiting approval & approved & rejected
#      And click debtor name rea dengan status waiting approval
#      And click debtor name rea dengan status approved
#      And click debtor name rea dengan status rejected
#    Then reconsume data dengan merubah data alamat setiap status
#      And reconsume dengan no aplikasi status rejected
#      And reconsume dengan no aplikasi status approved
#      And reconsume dengan no aplikasi status waiting approval
#    Then verify status expired
#      And reconsume dengan no aplikasi status expired
#      And verify data realisasi form dengan status approval expired
#      And click debtor name rea dengan status expired
    Then verify status pending
       And verify data realisasi form dengan status pending
      And click debtor name rea dengan status pending
      And reconsume dengan no aplikasi status pending
#    Then change all status for repayment
    Then user ldap logout