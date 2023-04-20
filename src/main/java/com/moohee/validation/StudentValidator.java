package com.moohee.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.moohee.validation.dto.StudentDto;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { //������ ��ü(studentDto)�� Ŭ���� Ÿ�� ����
		// TODO Auto-generated method stub
		return StudentDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StudentDto studentDto = (StudentDto) target;
		//������ ��ü�� Ÿ������ ����(Object �� �̹Ƿ� ����ȯ �ʿ�)
		
		String studentId = studentDto.getId();
		System.out.println(studentId);
		String studentPw = studentDto.getPw();
		System.out.println(studentPw);		
		
//		if(studentId == null || studentId.trim().isEmpty()) {
//			errors.rejectValue("id", "trouble1");
//		} else if(studentPw == null || studentPw.trim().isEmpty()) {
//			errors.rejectValue("pw", "trouble2");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		
		if(studentPw == null || studentPw.trim().isEmpty()) {
			errors.rejectValue("pw", "trouble2");
		}
	}

}
