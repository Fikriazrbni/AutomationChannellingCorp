Feature: Lending Chanelling2

#  @repaymentForm
#  Scenario: Repayment Form
#    Given open browser and user login application repaymentForm
##1
#    When Verifikasi isi filter Source
#      | All  |
#      | LOS  |
#      | NIKEL |
##2
#    Then View data dengan filter Source All
##3
#    And View data dengan filter Source LOS
##4
#    And View data dengan filter Source NIKEL
##5
#    And Verifikasi isi filter Pelunasan
##6
#    And View data dengan filter Pelunasan All
##7
#    And View data dengan filter Pelunasan Yes
##8
#    And View data dengan filter Pelunasan No
##9
#    And View data dengan filter Pelunasan Insurance
##10
#    And View data dengan filter Pelunasan Advance
##11
#    And Verifikasi isi filter Status
#      | All         |
#      | Waiting for approval |
#      | Pending Batch Run  |
#      | Approved       |
#      | Rejected       |
#      | Approval Expired   |
##12
#    And View data dengan filter Status All
#    And View data dengan filter Status_Waiting for approval
#    And View data dengan filter Status_Pending Batch Run
#    And View data dengan filter Status_Approved
#    And View data dengan filter Status_Rejected
#    And View data dengan filter Status_Approval Expired
#    And Verifikasi isi filter Partner
#    And View data dengan filter Partner_All
#    And View data dengan filter Partner_pilih salah satu
#    And Verifikasi isi filter Status Amount Repayment
#      | All     |
#      | Sesuai    |
#      | Kurang Bayar |
#      | Lebih Bayar |
#    And View data dengan filter Status Amount Repayment_All
#    And View data dengan filter Status Amount Repayment_Sesuai
#    And View data dengan filter Status Amount Repayment_Kurang Bayar
#    And View data dengan filter Status Amount Repayment_Lebih Bayar
#    And Verifikasi isi filter Status Batch No
#    And View data dengan filter Batch No_pilih salah satu
#    And Verifikasi filter search
#    And Verifikasi kolom Source untuk realisasi via LOS
#    And Verifikasi kolom Source untuk realisasi via NIKEL
#    And Verifikasi kolom Application No
#    And Verifikasi kolom Partner
#    And Verifikasi kolom Debtor Name
#    And Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment_N
#    And Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment_Y
#    And Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment_I
#    And Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment_A
#    And Verifikasi kolom Status setelah job repayment
#    And Verifikasi kolom Tanggal Pembayaran
#    And Verifikasi kolom Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok_ nominal bunga_ nominal denda_ dan additional interest
#    And Verifikasi kolom Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok_ nominal bunga_ dan additional interest (nominal denda kosong)
#    And Verifikasi kolom Total Tagihan
#    And Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment lebih kecil jumlah tagihan
#    And Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment sama dengan jumlah tagihan
#    And Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment lebih besar jumlah tagihan
#    And Verifikasi kolom Tanggal Masuk File
#    And Verifikasi kolom Batch No
#    And Verifikasi sorting kolom Status
#    And Verifikasi sorting kolom Tanggal Pembayaran
#    And Klik Previous pada Pagination
#    And Klik Next pada Pagination
#    And Klik page tertentu pada Pagination
#    And Verifikasi tanggal pada menu Repayment
#    And Verifikasi Total Nominal Approved
#    And Verifikasi Total Nominal Pembayaran
#    And Klik Bulk Approve-Check beberapa data-Klik Approve
#    And Klik Bulk Approve-Check beberapa data-Klik Approve-Klik Batal
#    And Klik Bulk Approve-Check beberapa data-Klik Approve-Klik Submit
#    And Klik Bulk Approve-Check All-Klik Approve
#    And Klik Bulk Approve-Check All-Klik Approve-Klik Batal
#    And Klik Bulk Approve-Check beberapa data-Klik Reject
#    And Klik Bulk Approve-Check beberapa data-Klik Reject-Klik Batal
#    And Klik Bulk Approve-Check beberapa data-Klik Reject-Klik Submit
#    And Klik Bulk Approve-Check All-Klik Reject
#    And Klik Bulk Approve-Check All-Klik Reject-Klik Batal
#    And Klik Bulk Approve-Tidak Check Data-Klik Approve
#    And Klik Bulk Approve-Tidak Check Data-Klik Reject
#    And Klik Bulk Edit-Check pada beberapa data status Pending Batch Run
#    And Klik Bulk Edit-Check All
#    And Klik Bulk Edit-Check pada beberapa data status Pending Batch Run-Klik Cancel
#    And Klik Bulk Edit-Check pada beberapa data status Pending Batch Run-Klik Change Status
#    And Klik Bulk Edit-Check All-Klik Cancel
#    And Approve data yang telah di update statusnya
#    And Reject data yang telah di update statusnya
#    And Klik Bulk Approve-Check beberapa data
#    And Klik Bulk Approve-Check beberapa data-Uncheck beberapa data
#    And Klik Bulk Approve-Check All
#    And Verifikasi card Detail-Tanggal Masuk File
#    And Verifikasi card Detail-Batch No
#    And Verifikasi card Detail-Nomor Aplikasi
#    And Verifikasi card Detail-Nama Debitur
#    And Verifikasi card Detail-Partner
#    And Verifikasi card Detail-Nomor Pembayaran
#    And Verifikasi card Detail-Status Amount Repayment dengan kondisi total pembayaran pada file repayment lebih kecil jumlah tagihan
#    And Verifikasi card Detail-Status Amount Repayment dengan kondisi total pembayaran pada file repayment sama dengan jumlah tagihan
#    And Verifikasi card Detail-Status Amount Repayment dengan kondisi total pembayaran pada file repayment lebih besar jumlah tagihan
#    And Verifikasi card Hasil Approval-Status (setelah job consume)
#    And Verifikasi card Hasil Approval-Approved by (setelah job consume)
#    And Verifikasi card Hasil Approval-Tanggal Approval (setelah job consume)
#    And Verifikasi card Hasil Approval-Type Reject Reason (setelah job consume)
#    And Verifikasi card Hasil Approval-Deskripsi (setelah job consume)
#    And Verifikasi card Data Partner-Tanggal Pembayaran
#    And Verifikasi card Data Partner-Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok_nominal bunga_nominal denda_dan additional interest
#    And Verifikasi card Data Partner-Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok_nominal bunga_dan additional interest (nominal denda kosong)
#    And Verifikasi card Data Partner-Pembayaran Pokok dengan kondisi pada file repayment terisi nominal pokok
#    And Verifikasi card Data Partner-Pembayaran Pokok dengan kondisi pada file repayment nominal pokok_0
#    And Verifikasi card Data Partner-Pembayaran Bunga dengan kondisi pada file repayment terisi nominal bunga
#    And Verifikasi card Data Partner-Pembayaran Bunga dengan kondisi pada file repayment nominal bunga_0
#    And Verifikasi card Data Partner-Pembayaran Denda dengan kondisi pada file repayment terisi nominal denda
#    And Verifikasi card Data Partner-Pembayaran Denda dengan kondisi pada file repayment nominal denda_0
#    And Verifikasi card Data Partner-Additional Interest dengan kondisi pada file repayment terisi Additional Interest
#    And Verifikasi card Data Partner-Additional Interest dengan kondisi pada file repayment Additional Interest_0
#    And Verifikasi card Data Partner-Status Pembayaran dengan kondisi Pelunasan pada file Repayment_N
#    And Verifikasi card Data Partner-Status Pembayaran dengan kondisi Pelunasan pada file Repayment_Y
#    And Verifikasi card Data Partner-Status Pembayaran dengan kondisi Pelunasan pada file Repayment_I
#    And Verifikasi card Data Partner-Status Pembayaran dengan kondisi Pelunasan pada file Repayment_A
#    And Verifikasi card Data BCAD-Tanggal Pembayaran Bulan Berjalan
#    And Verifikasi card Data BCAD-Total Tagihan
#    And Verifikasi card Data BCAD-Pembayaran Pokok Bulan Berjalan
#    And Verifikasi card Data BCAD-Pembayaran Bunga Bulan Berjalan
#    And Verifikasi card Data BCAD-Pembayaran Denda Bulan Berjalan
#    And Verifikasi card Data BCAD-Additional Interest Bulan Berjalan
#    And Klik Approve button di Halaman detail Repayment
#    And Klik Approve-Klik Tidak
#    And Klik Approve-Klik Ya
#    And Verifikasi card Hasil Approval setelah Approve data
#    And Klik Reject button di Halaman detail Repayment
#    And Verifikasi isi field Type Reject Reason
#    And Klik Reject-Klik Cancel
#    And Klik Reject-Mengisi Type Reject Reason-Tidak mengisi Description-Klik Submit
#    And Klik Reject-Tidak Mengisi Type Reject Reason-Mengisi Description-Klik Submit
#    And Klik Reject-Mengisi Type Reject Reason-Mengisi Description100_karakter_alfanumerik plus simbol-Klik Submit
#    And Klik Reject-Mengisi Type Reject Reason-Mengisi Description99_karakter_alfanumerik plus simbol-Klik Submit
#    And Verifikasi card Hasil Approval setelah Reject data
#    And Cek data repayment dengan status Waiting for Approval
#    And Cek data repayment dengan status Approved
#    And Cek data repayment dengan status Rejected
#    And Cek data repayment dengan status Pending Batch Run
#    And Cek data repayment dengan status Approval Expired
#    And Klik Edit pada data Waiting for Approval-Edit pada data-Klik Update
#    And Klik Edit pada data Rejected-Edit pada data-Klik Update
#    And Klik Edit pada data Pending Batch Run-Edit pada data-Klik Update
#    And Approve data yang diedit
#    And Reject data yang diedit
#    And Verifikasi card Hasil Approval setelah Bulk Approve data
#    And Verifikasi card Hasil Approval setelah Bulk Reject data


  @repaymentFormSorted
  Scenario: Repayment Form Sorted
#    Given user open browser and user login application repaymentForm
    When Verifikasi card Detail -Tanggal Masuk File
    And Verifikasi card Detail -Batch No
    And Verifikasi card Detail -Nomor Aplikasi
    And Verifikasi card Detail -Nama Debitur
    And Verifikasi card Detail -Partner
    And Verifikasi card Detail -Nomor Pembayaran
    And Verifikasi card Detail -Status Amount Repayment dengan kondisi total pembayaran pada file repayment< jumlah tagihan
    And Verifikasi card Detail -Status Amount Repayment dengan kondisi total pembayaran pada file repayment = jumlah tagihan
    And Verifikasi card Detail -Status Amount Repayment dengan kondisi total pembayaran pada file repayment > jumlah tagihan
    And Verifikasi card Hasil Approval -Status (setelah job consume)
    And Verifikasi card Hasil Approval -Approved by (setelah job consume)
    And Verifikasi card Hasil Approval -Tanggal Approval (setelah job consume)
    And Verifikasi card Hasil Approval -Type Reject Reason (setelah job consume)
    And Verifikasi card Hasil Approval -Deskripsi (setelah job consume)
    And Verifikasi card Data Partner -Tanggal Pembayaran
    And Verifikasi card Data Partner -Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok, nominal bunga, nominal denda, dan additional interest
    And Verifikasi card Data Partner -Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok, nominal bunga, dan additional interest (nominal denda kosong)
    And Verifikasi card Data Partner -Pembayaran Pokok dengan kondisi pada file repayment terisi nominal pokok
    And Verifikasi card Data Partner -Pembayaran Pokok dengan kondisi pada file repayment nominal pokok null
    And Verifikasi card Data Partner -Pembayaran Bunga dengan kondisi pada file repayment terisi nominal bunga
    And Verifikasi card Data Partner -Pembayaran Bunga dengan kondisi pada file repayment nominal bunga null
    And Verifikasi card Data Partner -Pembayaran Denda dengan kondisi pada file repayment terisi nominal denda
    And Verifikasi card Data Partner -Pembayaran Denda dengan kondisi pada file repayment nominal denda null
    And Verifikasi card Data Partner -Additional Interest dengan kondisi pada file repayment terisi Additional Interest
    And Verifikasi card Data Partner -Additional Interest dengan kondisi pada file repayment Additional Interest null
    And Verifikasi card Data Partner -Status Pembayaran dengan kondisi Pelunasan pada file Repayment = N
    And Verifikasi card Data Partner -Status Pembayaran dengan kondisi Pelunasan pada file Repayment = Y
    And Verifikasi card Data Partner -Status Pembayaran dengan kondisi Pelunasan pada file Repayment = I
    And Verifikasi card Data Partner -Status Pembayaran dengan kondisi Pelunasan pada file Repayment = A
    And Verifikasi kolom Tanggal Pembayaran
    And Verifikasi kolom Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok, nominal bunga, nominal denda, dan additional interest
    And Verifikasi kolom Total Pembayaran dengan kondisi pada file repayment terisi nominal pokok, nominal bunga, dan additional interest (nominal denda kosong)
    And Verifikasi kolom Total Tagihan
    And Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment< jumlah tagihan
    And Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment = jumlah tagihan
    And Verifikasi kolom Status Amount Pembayaran dengan kondisi total pembayaran pada file repayment > jumlah tagihan
    And Verifikasi kolom Tanggal Masuk File
    And Verifikasi kolom Batch No
    And Verifikasi kolom Status setelah job repayment
    And Verifikasi card Data BCAD -Tanggal Pembayaran Bulan Berjalan
    And Verifikasi card Data BCAD -Total Tagihan
    And Verifikasi card Data BCAD -Pembayaran Pokok Bulan Berjalan
    And Verifikasi card Data BCAD -Pembayaran Bunga Bulan Berjalan
    And Verifikasi card Data BCAD -Pembayaran Denda Bulan Berjalan
    And Verifikasi card Data BCAD -Additional Interest Bulan Berjalan
    And Klik Approve button di Halaman detail Repayment
    And Klik Approve button di Halaman detail Repayment klik approve dan tidak
    And Klik Approve button di Halaman detail Repayment klik approve dan ya
    And Verifikasi card Hasil Approval setelah Approve data
    And Klik Reject button di Halaman detail Repayment
    And Verifikasi isi field Type Reject Reason
    And Klik Reject button di Halaman detail Repayment klik reject dan tidak
    And Klik Reject dan Mengisi Type Reject Reason dan Tidak mengisi Description dan Klik Submit
    And Klik Reject dan Mengisi Type Reject Reason dan mengisi Description dan Klik Submit
    And Klik Reject dan Mengisi Type Reject Reason dan mengisi Description 100karakter dan Klik Submit
    And Klik Reject dan Mengisi Type Reject Reason dan mengisi Description 99karakter dan Klik Submit
    And Verifikasi card Hasil Approval setelah Reject data
    And Klik Bulk Approve Check beberapa data Klik Approve
    And Klik Bulk Approve Check beberapa data Klik Approve dan klik batal
    And Klik Bulk Approve Check beberapa data Klik Approve dan klik submit
    And Cek data repayment dengan status Waiting for Approval
    And Cek data repayment dengan status Approved
    And Cek data repayment dengan status Rejected
    And Cek data repayment dengan status Pending Batch Run
    And Cek data repayment dengan status Approval Expired
    And Klik Edit pada data Waiting for ApprovalEdit pada data Klik Update
    And Klik Edit pada data Rejected Edit pada data Klik Update
    And Klik Edit pada data Pending Batch Run Edit pada data Klik Update
    And Approve data yang diedit
    And Reject data yang diedit
    And Klik pada data status Waiting for Approval
    And Klik pada data status Approved
    And Klik pada data status Rejected
    And Klik pada data status Pending Batch Run
    And Klik pada data status Approval Expired
    And Consume repayment sysdate dengan tanggal pembayaran backdated (Akseleran, Indodana)
    And Consume repayment sysdate dengan tanggal pembayaran = sysdate
    And Consume repayment sysdate dengan tanggal pembayaran future (advance)
    And Consume repayment sysdate dengan kondisi gagal validasi (rejected by system)
    And Verifikasi data status Waiting for Approval dengan tanggal consume Hmin1
    And Verifikasi data status Approved dengan tanggal consume Hmin1
    And Verifikasi data status Rejected by Analyst dengan tanggal consume Hmin1
    And Verifikasi data status Pending Batch Run dengan tanggal consume Hmin1
    And Verifikasi data status Approval Expired dengan tanggal consume Hmin1
    And Verifikasi data status Approval Expired dengan tanggal consume Hmin1
    And Verifikasi isi filter Source
    And View data dengan filter Source: All
    And View data dengan filter Source: LOS
    And View data dengan filter Source: NIKEL
    And Verifikasi isi filter Pelunasan
    And View data dengan filter Pelunasan: All
    And View data dengan filter Pelunasan: Yes
    And View data dengan filter Pelunasan: No
    And View data dengan filter Pelunasan: Insurance
    And View data dengan filter Pelunasan: Advance
    And Verifikasi isi filter Status
    And View data dengan filter Status: All
    And View data dengan filter Status: Waiting for approval
    And View data dengan filter Status: Pending Batch Run
    And View data dengan filter Status: Approved
    And View data dengan filter Status: Rejected
    And View data dengan filter Status: Approval Expired
    And Verifikasi isi filter Partner
    And View data dengan filter Partner: All
    And View data dengan filter Partner: pilih salah satu
    And Verifikasi isi filter Status Amount Repayment
    And View data dengan filter Status Amount Repayment: All
    And View data dengan filter Status Amount Repayment: Sesuai
    And View data dengan filter Status Amount Repayment: Kurang Bayar
    And View data dengan filter Status Amount Repayment: Lebih Bayar
    And Verifikasi isi filter Status Batch No
    And View data dengan filter Batch No: pilih salah satu
    And Verifikasi filter search
    And Verifikasi kolom Source untuk realisasi via LOS
    And Verifikasi kolom Source untuk realisasi via NIKEL
    And Verifikasi kolom Application No
    And Verifikasi kolom Partner
    And Verifikasi kolom Debtor Name
    And Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment = N
    And Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment = Y
    And Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment = I
    And Verifikasi kolom Status Pembayaran dengan kondisi Pelunasan pada file Repayment = A
    And Verifikasi sorting kolom Status
    And Verifikasi sorting kolom Tanggal Pembayaran
    And Klik Next pada Pagination
    And Klik page tertentu pada Pagination
    And Klik Previous pada Pagination
    And Sorting pada kolom Status Note: variasi status>=3
    And Sorting pada kolom Tanggal Pembayaran Note: terdapat data hari H dan Hmin1 (approval expired)
    And Verifikasi tanggal pada menu Repayment
    And Verifikasi Total Nominal Approved
    And Verifikasi Total Nominal Pembayaran
    And Klik Bulk Approve Check beberapa data
    And Klik Bulk Approve Check beberapa data Uncheck beberapa data
    And Klik Bulk Approve Check All
    And Klik Bulk Approve Check All Klik Approve
    And Klik Bulk Approve Check All Klik Approve Klik Batal
    And Verifikasi card Hasil Approval setelah Bulk Approve data
    And Klik Bulk Approve Check beberapa data Klik Reject
    And Klik Bulk Approve Check beberapa data Klik Reject Klik Batal
    And Klik Bulk Approve Check beberapa data Klik Reject Klik Submit
    And Klik Bulk Approve Check All Klik Reject
    And Klik Bulk Approve Check All Klik Reject Klik Batal
    And Klik Bulk Approve Tidak Check Data Klik Approve
    And Klik Bulk Approve Tidak Check Data Klik Reject
    And Verifikasi card Hasil Approval setelah Bulk Reject data
    And Klik Bulk Edit Check pada beberapa data status Pending Batch Run
    And Klik Bulk Edit Check All
    And Klik Bulk Edit Check pada beberapa data status Pending Batch Run Klik Cancel
    And Klik Bulk Edit Check pada beberapa data status Pending Batch Run Klik Change Status
    And Klik Bulk Edit Check All Klik Cancel
    And Approve data yang telah di update statusnya
    And Reject data yang telah di update statusnya
  

#  @repaymentFile
#  Scenario: Repayment File
#    Given user open browser and user login application repaymentFile
##1
#    When Nomor Aplikasi diisi sesuai format
##2
#    Then Nomor Pembayaran diisi sesuai format
##3
#    And Tanggal Pembayaran diisi sesuai format ddmmyyyy
##4
#    And Nominal Pokok diisi15 13_2 digit dengan 2desimal dan bukan_0
##5
#    And Nominal Pokok diisi15 13_2 digit dengan 2desimal dan terisi_0
##6
#    And Nominal Bunga diisi15 13_2 digit dengan 2desimal dan bukan_0
##7
#    And Nominal Bunga diisi15 13_2 digit dengan 2desimal dan terisi_0
##8
#    And Nominal Denda diisi15 13_2 digit dengan 2desimal dan bukan_0
##9
#    And Nominal Denda diisi15 13_2 digit dengan 2desimal dan terisi_0
##10
#    And Pelunasan diisi Y
#    And Pelunasan diisi N
#    And Pelunasan diisi I
#    And Pelunasan diisiA
#    And Additional Interest diisi15 13_2 digit dengan 2desimal dan bukan_0
#    And Additional Interest diisi15 13_2 digit dengan 2desimal dan terisi_0
#    And Verifikasi Data File Berhasil Dari Fineract-loan_id
#    And Verifikasi Data File Berhasil Dari Fineract-company_code
#    And Verifikasi Data File Berhasil Dari Fineract-repayment_number
#    And Verifikasi Data File Berhasil Dari Fineract-Partner_Date
#    And Verifikasi Data File Berhasil Dari Fineract-Partner_Pokok
#    And Verifikasi Data File Berhasil Dari Fineract-Partner_Bunga
#    And Verifikasi Data File Berhasil Dari Fineract-Partner_Denda
#    And Verifikasi Data File Berhasil Dari Fineract-Partner_Pelunasan
#    And Verifikasi Data File Berhasil Dari Fineract-BCAD_Outstanding
#    And Verifikasi Data File Berhasil Dari Fineract-BCAD_Date
#    And Verifikasi Data File Berhasil Dari Fineract-BCAD_Pokok
#    And Verifikasi Data File Berhasil Dari Fineract-BCAD_Bunga
#    And Verifikasi Data File Berhasil Dari Fineract-Additional Interest
#    And Verifikasi Data File Gagal Dari Fineract-Nomor_Aplikasi
#    And Verifikasi Data File Gagal Dari Fineract-Nomor_Pembayaran
#    And Verifikasi Data File Gagal Dari Fineract-Tanggal_Pembayaran
#    And Verifikasi Data File Gagal Dari Fineract-Nominal_Pokok
#    And Verifikasi Data File Gagal Dari Fineract-Nominal_Bunga
#    And Verifikasi Data File Gagal Dari Fineract-Nominal_Denda
#    And Verifikasi Data File Gagal Dari Fineract-Pelunasan
#    And Verifikasi Data File Gagal Dari Fineract-Additional Interest
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi No Aplikasi kosong
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi No Pembayaran kosong
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Tanggal Pembayaran kosong
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Nominal Pokok kosong
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Nominal Bunga kosong
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Nominal Denda kosong
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Pelunasan kosong
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Additional Interest KOPNUS kosong
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length NoAplikasi kurang satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length No Pembayaran kurang satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Tanggal Pembayaran kurang satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Pokok kurang satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Bunga kurang satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Denda kurang satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi Pelunasan tidak sesuai (diisi selain N_ Y_ I_ danA)
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Additional Interest KOPNUS kurang satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length NoAplikasi lebih satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length No Pembayaran lebih satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Tanggal Pembayaran lebih satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Pokok lebih satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Bunga lebih satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Nominal Denda lebih satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length Additional Interest KOPNUS lebih satu
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length NoAplikasi tidak ditemukan
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length No Repayment sudah terdaftar
#    And Verifikasi Data File Gagal Dari Fineract-Error dengan kondisi length No Repayment terulang dalam 1file
#    And bandingin Extent

#  @repaymentReport
#  Scenario: Repayment Report
#    Given user open browser and user login application repaymentReport
#    When Verifikasi Format Report Berhasil Repayment
#    Then Verifikasi Data Laporan Berhasil Repayment-nomor aplikasi
#    And Verifikasi Data Laporan Berhasil Repayment-Repayment Number
#    And Verifikasi Data Laporan Berhasil Repayment-Nama Debitur
#    And Verifikasi Data Laporan Berhasil Repayment-Nominal Pembayaran Pokok
#    And Verifikasi Data Laporan Berhasil Repayment-Nominal Pembayaran Bunga
#    And Verifikasi Data Laporan Berhasil Repayment-Nominal Pembayaran Denda
#    And Verifikasi Data Laporan Berhasil Repayment-Status Berhasil
#    And Verifikasi Data Laporan Berhasil Repayment-Total_Data
#    And Verifikasi Data Laporan Berhasil Repayment-Total_Repayment_Pokok
#    And Verifikasi Data Laporan Berhasil Repayment-Total_Repayment_Bunga
#    And Verifikasi Data Laporan Berhasil Repayment-Total_Repayment_Denda
#    And Verifikasi Data Laporan Berhasil Repayment_Total_Amount sama dengan [total pokok + bunga + denda]
#    And Verifikasi Format Report Gagal Repayment
#    And Verifikasi Data Laporan Gagal Repayment-Cek List Laporan Gagal Repayment
#    And Verifikasi Data Laporan Gagal Repayment-Nomor Aplikasi
#    And Verifikasi Data Laporan Gagal Repayment-Repayment Number
#    And Verifikasi Data Laporan Gagal Repayment-Nama Debitur
#    And Verifikasi Data Laporan Gagal Repayment-Nominal Pembayaran Pokok
#    And Verifikasi Data Laporan Gagal Repayment-Nominal Pembayaran Bunga
#    And Verifikasi Data Laporan Gagal Repayment-Nominal Pembayaran Denda
#    And Verifikasi Data Laporan Gagal Repayment-Alasan Gagal