package com.medicineregistry;

import com.medicineregistry.google.SheetsServiceFacade;
import com.medicineregistry.model.MedicineItem;
import com.medicineregistry.model.MedicineType;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MedicineRegistryApplicationTests {

	@Autowired
	SheetsServiceFacade sheetsServiceFacade;

	@Test
	@SneakyThrows
	void contextLoads() {
		var medicine = sheetsServiceFacade.getAllMedicineItems(MedicineType.FOR_CHILDREN);
		for (MedicineItem item : medicine) {
			System.out.println(item);
		}	}

}
