package com.bbb.bankingapplication;

import com.bbb.bankingapplication.dto.ziswaf.ZiswafProductDTO;
import com.bbb.bankingapplication.model.ZiswafProduct;
import com.jayway.jsonpath.internal.filter.ValueNodes;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class BankingApplicationTests {

	public static String formattedTransactionDescription(String soul, String totalMoney) {
		Integer soulInt = Integer.parseInt(soul);
		StringBuilder resultSoul = new StringBuilder();

		StringBuilder resultTotalMoney = new StringBuilder();
		StringBuilder resultString = new StringBuilder();

		if (soulInt > 0) {
			resultSoul.append(soulInt).append("Jiwa"); // 10Jiwa
		} else {
			resultSoul.append("0").append("Jiwa"); // 0Jiwa
		}

		if (totalMoney.length() <= 6) {
			resultTotalMoney.append("Rp").append(totalMoney, 0, totalMoney.length() - 3).append("Ribu");
		}

		if (totalMoney.length() > 6 ) {
			resultTotalMoney.append("Rp").append(totalMoney, 0, totalMoney.length() - 6).append("Juta");
		}

		// 10JiwaRp450Ribu-ZakatFitrah
		return String.valueOf(resultString.append(resultSoul).append(resultTotalMoney).append("-").append("ZakatFitrah"));
	}

	public static String formattedTransactionDescription2(String value) {
		// Format = Rp100.000-WartegMobile
		Integer valueInt = Integer.parseInt(value);
		StringBuilder resultTotalMoney = new StringBuilder();
		StringBuilder resultString = new StringBuilder();

		if (value.length() <= 6) {
			resultTotalMoney
					.append("Rp")
					.append(value, 0, value.length() - 3)
					.append(".")
					.append("000");
		}

		if (value.length() > 6) {
			// Format = Rp1.000.000-Warte
			resultTotalMoney
					.append("Rp")
					.append(value, 0, value.length() - 6)
					.append(".")
					.append("000")
					.append(".")
					.append("000");

		}

		return String.valueOf(
				resultString
						.append(resultTotalMoney)
						.append("-")
						.append("WartegMobile")
		);
	}

	@Test
	void testFormattedTransactionDescription() {
		// Format = 1JiwaRp50Ribu-ZakatFitrah
		String soul = "10";
		String money = "9000";
		System.out.println(formattedTransactionDescription(soul, money));
	}

	@Test
	void testFormattedTransactionDescription2() {
		// Format = Rp1.000.000-WartegMobile
		// Format = Rp50.000-WartegMobile
		// Input String = 50000
		String value = "50000";
		String value1 = "1000000";
		System.out.println(formattedTransactionDescription2(value));
		System.out.println(formattedTransactionDescription2(value1));
	}

	@Test
	void testFormattedTransactionDescription3() {
		// Format = Rp.10.000-DonasiBantuanCovid
		String raw = "Donasi Bantuan Covid";
		String value = "10000";

		StringBuilder a = new StringBuilder();
		a.append("Rp.")
				.append(value, 0, value.length() - 3)
				.append(".");

		System.out.println(String.valueOf(a));
	}

	@Test
	void convertBigDecimalToString() {
		BigDecimal amount = new BigDecimal(100000);
		String amountStr = String.valueOf(amount);

		System.out.println(amountStr);
	}

	@Test
	void replaceString() {
		// format = "BerbagiBerbukadanSahur;
		String raw = "Berbagi Berbuka & Sahur";
		String raw1 = "Berbagi Paket Lebaran";

		String resultRaw = getString(raw);
		String resultRaw1 = getString(raw1);

		System.out.println(resultRaw);
		System.out.println(resultRaw1);
	}

	@Test
	void testChangeToK() {
		String value = "2500000"; // 2.500k
		System.out.println(getStringK(value));

		String value1 = "2850000"; // 2.850k
		System.out.println(getStringK(value1));

		String value2 = "21500000"; // Rp.21.500K
		System.out.println(getStringK(value2));

		String value3 = "150000000"; // Rp. 150.000k
		System.out.println(getStringK(value3));

		String value4 = "1000000000000";
		System.out.println(getStringK(value4));
	}

	private static String getString(String raw) {
		StringBuilder stringBuilder = new StringBuilder();
		String s = raw.replaceAll("&", "dan").replaceAll("\\s", "");

		return String.valueOf(stringBuilder.append(s).append("-").append(s));
	}

	private static String getStringK(String raw) {
		StringBuilder a = new StringBuilder();
		a.append(raw, 0, raw.length() - 3);

		StringBuilder b = new StringBuilder();
		b
				.append("Rp.")
				.append(a, 0, a.length() - 3)
				.append(".")
				.append(a, a.length() - 3, a.length())
				.append("k");

		return String.valueOf(b);
	}

	@Test
	void testStringToJson() throws JSONException {
		// {"bobot":"190 - 230 Kg", "email":"reza.fajar@rumahzakat.org;erma.zulhijjah@rumahzakat.org", "flag":"LIST_SAPI_KERBAU"}
		String input = "{\"bobot\":\"190 - 230 Kg\", \"email\":\"reza.fajar@rumahzakat.org;erma.zulhijjah@rumahzakat.org\", \"flag\":\"LIST_SAPI_KERBAU\"}";

		String string = "{\"name\": \"Sam Smith\", \"technology\": \"Python\"}";
		JSONObject json = new JSONObject(string);
		System.out.println(json.toString());
		String technology = json.getString("technology");
		System.out.println(technology);

		JSONObject inputJson = new JSONObject(input);
		System.out.println(inputJson.toString());
		String bobot = inputJson.getString("bobot").toLowerCase().replaceAll("\\s", "");
		System.out.println(bobot);
	}

	@Test
	void testWakaf() {
		ZiswafProductDTO ziswafProductDto = new ZiswafProductDTO();
		ziswafProductDto.setTransactionCategory("ZISWAF_WAKAF_SELAMANYA");

		ZiswafProductDTO ziswafProductDto1 = new ZiswafProductDTO();
		ziswafProductDto1.setTransactionCategory("ZISWAF_WAKAF_UANG");

		ZiswafProductDTO ziswafProductDTO2 = new ZiswafProductDTO();
		ziswafProductDTO2.setTransactionCategory("WAKAF");

		System.out.println(checkTransactionCategory(ziswafProductDto));
		System.out.println(checkTransactionCategory(ziswafProductDto1));
		System.out.println(checkTransactionCategory(ziswafProductDTO2));
	}

	private static String checkTransactionCategory(ZiswafProductDTO ziswafProductDto) {
		String transactionDescription;
		if ("ZISWAF_WAKAF_SELAMANYA".equalsIgnoreCase(ziswafProductDto.getTransactionCategory())) {
			transactionDescription = "Wakaf Uang Selamanya";
		} else if ("ZISWAF_WAKAF_UANG".equalsIgnoreCase(ziswafProductDto.getTransactionCategory())) {
			transactionDescription = "Wakaf Melalui Uang";
		} else {
			transactionDescription = "Wakaf Uang Temporer";
		}
		return transactionDescription;
	}

	public static String splitTransactionDescription(String transaction) {
		// cek dulu jika lengthnya > 35, maka split data.subString(0, length)
		// check length transactionDescription
		int length = 35;
		String subString;

		if (transaction.length() > length) {
			subString = transaction.substring(0, length);
		} else {
			subString = transaction;
		}
		return subString;
	}

	@Test
	void testSplit() {
		String raw = "keluargaArianiKhairunnisaNasution-RumahZakatIndonesia-DesakuBerqurbanSapiRetail(1/7)190-230kgRp.2.500k";
		String raw1 = "keluargaArianiKhairunnisaNasution-R";
		System.out.println(splitTransactionDescription(raw));
		System.out.println(splitTransactionDescription(raw1));
	}
}
