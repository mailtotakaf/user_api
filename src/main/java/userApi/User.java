package userApi;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class User {

	@Id
	private long id;

	private String name;

	private Integer birth_year;

	private Integer birth_month;

	private Integer birth_day;

	private String sex;

	private String memo;

}