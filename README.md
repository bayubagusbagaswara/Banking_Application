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