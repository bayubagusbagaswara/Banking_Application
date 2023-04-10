# Banking Application

Memiliki Fitur
- Pembukaan tabungan deposito
- Transfer
- Mutasi

# Technologies

- Java JDK 11
- Maven 3.8.6

# Metadata

- adalah object yang membawa informasi berkaitan dengan informasi umum dan wajib
- seperti userProfileId, deviceId, phoneType, appVersion, language, dan token

# Soft Delete
- False = 0, artinya data masih ada (belum dihapus)
- True = 1, (artinya data sudah terhapus)

# Register User

- User harus mendaftarkan dulu data dirinya

# Deposito

- Pembukaan deposito akan disimpan di table Account Deposito User

## Sequence ID

  @Id
  @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
  private Long id;


# Convert Date to String
response.setTransactionDate(DateUtil.convertDate(transaction.getTransactionDate().getTime(), "yyyy-MM-dd HH:mm:ss"));

# Inquiry

- tujuan inquiry adalah untuk mengecek dan mendapatkan data
- misal kita melakukan pembayaran via gopay, maka kita akan meminta data kita ke gopay
- misal juga pengecekan pelunasan haji, tujuannya untuk mengecek apakah sudah lunas atau belum
- saat inquiry pasti kita membawa data request, data request tersebut akan dicek, misal data request nya adalah nama nasabah dan nomor rekening, jadi apakah pembayaran atas nama dan rekening tersebut sudah lunas atau belum