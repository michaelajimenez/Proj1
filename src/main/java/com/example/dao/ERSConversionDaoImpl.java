package com.example.dao;

import com.example.model.ERSReimbursementType;

public class ERSConversionDaoImpl implements ERSConversionDao {

	@Override
	public long convertRequest(String s) {
		ERSReimbursementType[] allTypes = ERSReimbursementType.values();

		if (s.toUpperCase().equals(allTypes[0].toString())) {
			return 1;
		} else if (s.toUpperCase().equals(allTypes[1].toString())) {
			return 2;
		} else if (s.toUpperCase().equals(allTypes[2].toString())) {
			return 3;
		} else if (s.toUpperCase().equals(allTypes[3].toString())) {
			return 4;
		} else {
			return 4;
		}
	}
}