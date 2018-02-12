package com.acyl.jdbcsample.ViewAndController;

import java.sql.SQLException;

@FunctionalInterface
public interface Printable {
	void print() throws SQLException;
}
