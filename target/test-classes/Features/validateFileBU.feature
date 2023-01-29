Feature: Lending Chanelling

#  @validateFile
#  Scenario: Validate file approval form badan usaha
#    Given open browser and login as role maker
#    Then change exposure debitur and run jobs approval form
#    Then click button notifikasi
#      And verify notifikasi setelah proses file approval
#    Then verify data application form dan search application number status waiting for review dan click debtor detail
#      And verify data no applikasi 17karakter varchar appform
#      And verify data NPWP 15karakter numerik
#      And verify data jenis debitur B appform
#      And verify data nama debitur 40karakter appform
#      And verify data jangka waktu kredit batas bawah range
#      And verify data interest rate batas bawah range
#      And verify data plafon batas bawah range
#      And verify data nama debitur 39karakter appform
#      And verify data jangka waktu kredit antara batas atas dan bawah range
#      And verify data interest rate antara batas atas dan bawah range
#      And verify data plafon antara batas atas dan bawah range
#      And verify data jangka waktu kredit batas atas range
#      And verify data interest rate batas atas range
#      And verify data plafon batas atas range
#      And verify data dua data menggunakan NPWP sama di 1partner dengan plafon gabungan
#      And verify data data approval menggunakan NPWP sama di 2partner dengan plafon gabungan
#     Then Approve status and run jobs reaForm
#    Then user role maker logout

#  @validateFile
#  Scenario: Validate file realisasi form badan usaha
#    Given open browser and login as a role maker rea
#    Then click menu realisasi form
#    Then verify data realisasi form dan search application number status waiting for review dan click debtor detail
#      And verify data no applikasi 17karakter varchar
#      And verify data nama debitur 60karakter reabu
#      And verify data jenis debitur B reabu
#      And verify data alamat 50karakter varchar
#      And verify data alamat kelurahan 40karakter varchar
#      And verify data alamat kecamatan 40karakter varchar
#      And verify data alamat kode pos 5karakter numerik
#      And verify data alamat kode dati 4karakter sesuai maintenance table
#      And verify data nomor telepon 13karakter numerik
#      And verify data nomor akte 30karakter varchar reabu
#      And verify data tanggal berdiri 8karakter ddmmyyyy
#      And verify data nomor akte terakhir 30karakter varchar
#      And verify data tanggal akte terakhir 8karakter ddmmyyyy
#      And verify data bidang usaha 6karakter numerik sesuai maintenance table
#      And verify data NPWP 15karakter numerik dengan plafon
#      And verify data jangka waktu 3karakter numerik maintanance table
#      And verify data jangka kredir 3karakter varchar seuai maintenance table
#      And verify data plafon 15karakter numerik
#      And verify data interest rate 5karakter numerik
#      And verify data nomor PK 100karakter varchar
#      And verify data tanggal akad 8karakter ddmmyyyy
#      And verify data tanggal angsuran I 8karakter ddmmyyyy
#      And verify data jenis penggunaan 1karakter char sesuai maintenance table
#      And verify data sektor ekonomi 6karakter sesuai maintenance table
#      And verify data omzet 17karakter numerik
#      And verify data go public 1karakter sesuai maintenance table
#      And verify data sandi golongan debitur sesuai maintenance table
#      And verify data penghasilan kotor per tahun 15karakter numerik
#      And verify data bentuk badan usaha sesuai maintenance table
#      And verify data tempat berdiri badan usaha 30karakter varchar
#      And verify data nama debitur 59karakter reabu
#      And verify data alamat 49karakter varchar
#      And verify data alamat kelurahan 39karakter varchar
#      And verify data alamat kecamatan 39karakter varchar
#      And verify data nomor telepon 12karakter numerik
#      And verify data nomor akte 29karakter varchar reabu
#      And verify data nomor akte terakhir 29karakter varchar
#      And verify data nomor PK 99karakter varchar
#      And verify data tempat berdiri badan usaha 29karakter varchar
#    Then user role maker logout

  @validateFile
  Scenario: Validate file realisasi form pengurus
    Given open browser and login as a role maker rea
    Then click menu realisasi form
    Then verify data realisasi form dan search application number status waiting for review dan click debtor detail
      And verify data nomor aplikasi 17karakter varchar
      And verify data data pengurus lebih dari 1 dalam 1file pengurus
      And verify data nomor urut pengurus 2karakter numerik
      And verify data jumlah pengurus 2karakter numerik
      And verify data sandi jabatan BI 1karakter numerik
      And verify data pangsa kepemilikan 5karakter numerik
      And verify data bentuk pengurus1
      And verify data modal dasar 13karakter numerik
      And verify data modal disetor 13karakter numerik
      And verify data modal ditempatkan 13karakter numerik
      And verify data NPWP pengurus 15karakter numerik
      And verify data nama pengurus 60karakter varchar
      And verify data alamat pengurus 40karakter varchar
      And verify data alamat kelurahan pengurus 40karakter varchar
      And verify data alamat kecamatan pengurus 40karakter varchar
      And verify data alamat kode dati 4karakter numerik
      And verify data nomor KTP 16karakter numerik
      And verify data nomor akte 30karakter varchar pengurus
      And verify data tanggal lahir 8karakter numerik ddmmyyyy
      And verify data tanggal akte 8karakter numerik ddmmyyyy
      And verify data kode dati II tempat lahir 4karakter numerik
      And verify data jenis kelamin pengurus B
      And verify data sandi jabatan BI 2karakter numerik
      And verify data modal dasar 12karakter numerik
      And verify data modal disetor 12karakter numerik
      And verify data modal ditempatkan 12karakter numerik
      And verify data nama pengurus 59karakter varchar
      And verify data alamat pengurus 39karakter varchar
      And verify data alamat kelurahan pengurus 39karakter varchar
      And verify data alamat kecamatan pengurus 39karakter varchar
      And verify data nomor akte 29karakter varchar pengurus
      And verify data jenis kemanin pengurus M
    Then user role maker logout




