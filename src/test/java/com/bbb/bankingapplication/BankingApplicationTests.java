package com.bbb.bankingapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

	@Test
	void testFormattedTransactionDescription() {
		// Format = 1JiwaRp50Ribu-ZakatFitrah
		String soul = "10";
		String money = "9000";
		System.out.println(formattedTransactionDescription(soul, money));
	}
}
