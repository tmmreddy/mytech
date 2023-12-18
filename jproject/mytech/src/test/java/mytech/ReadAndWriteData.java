package mytech;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAndWriteData {

	public static void main(String[] args) {

		String file_dir = System.getProperty("user.dir");

		List<StudentData> studentList = readDataFromExcel(file_dir + "//src//test//resources//data//fee_details.xlsx");

		System.out.println("Name\tCourses\tFee");
		for (StudentData student : studentList) {
			System.out.println(student.getName() + "\t" + student.getCourses() + "\t" + student.getFee());
		}
	}

	private static List<StudentData> readDataFromExcel(String filePath) {
		List<StudentData> studentList = new ArrayList<>();

		try (FileInputStream file = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(file)) {

			XSSFSheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				if (row.getRowNum() == 0) {
					// Skip the header row
					continue;
				}

				String name = getCellValue(row.getCell(0));
				String courses = getCellValue(row.getCell(1));
				String fee = getCellValue(row.getCell(2));

				StudentData student = new StudentData(name, courses, fee);
				studentList.add(student);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return studentList;
	}

	private static String getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf((int) cell.getNumericCellValue());
		default:
			return "";
		}
	}

	private static class StudentData {
		private String name;
		private String courses;
		private String fee;

		public StudentData(String name, String courses, String fee) {
			this.name = name;
			this.courses = courses;
			this.fee = fee;
		}

		public String getName() {
			return name;
		}

		public String getCourses() {
			return courses;
		}

		public String getFee() {
			return fee;
		}
	}
}
