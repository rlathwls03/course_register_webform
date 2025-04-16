package kr.ac.hansung.cse.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="수강년도")
    private int year;

    @Column(name="학기")
    private int semester;

    @NotBlank(message = "교과코드를 입력하세요.")
    @Column(name="교과코드")
    private String code;

    @NotBlank(message = "교과목명을 입력하세요.")
    @Column(name="교과목명")
    private String name;

    @NotBlank(message = "교과구분을 입력하세요. (예: 전필, 전선)")
    @Column(name="교과구분")
    private String type;

    @NotBlank(message = "담당교수를 입력하세요.")
    @Column(name="담당교수")
    private String professor;

    @Min(value = 1, message = "학점은 1 이상이어야 합니다.")
    @Max(value = 3, message = "학점은 3 이하이어야 합니다.")
    @Column(name="학점")
    private int credit;
}
