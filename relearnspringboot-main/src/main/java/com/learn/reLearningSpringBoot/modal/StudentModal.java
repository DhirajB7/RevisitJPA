package com.learn.reLearningSpringBoot.modal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class StudentModal {
	private int id;
	private String name;
}
