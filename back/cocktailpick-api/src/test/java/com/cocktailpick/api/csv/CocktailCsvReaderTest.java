package com.cocktailpick.api.csv;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.cocktailpick.api.cocktail.Fixtures;
import com.cocktailpick.core.cocktail.dto.CocktailRequest;

class CocktailCsvReaderTest {
	private MultipartFile multipartFile;

	@BeforeEach
	void setUp() {
		multipartFile = new MockMultipartFile("file", "태그.csv", "text/csv",
			Fixtures.THREE_COCKTAILS_CSV_CONTENT.getBytes());
	}

	@Test
	void getCocktailRequests() throws Exception {
		CocktailCsvReader cocktailCsvReader = new CocktailCsvReader(OpenCsvReader.from(multipartFile.getInputStream()));
		List<CocktailRequest> cocktailRequests = cocktailCsvReader.getCocktailRequests();

		Assertions.assertAll(
			() -> assertThat(cocktailRequests).hasSize(3),
			() -> assertThat(cocktailRequests.get(0).getTag()).containsExactly("아몬드",
				"부드러움"),
			() -> assertThat(cocktailRequests.get(2).getLiquor()).containsExactly(
				"크렘 드 멘트", "크렘 드 카카오", "우유"),
			() -> assertThat(cocktailRequests.get(0).isSweet()).isTrue(),
			() -> assertThat(cocktailRequests.get(0).isSour()).isFalse(),
			() -> assertThat(cocktailRequests.get(0).isBitter()).isTrue()
		);
	}
}