package kr.ac.hansung.cse.controller;

import jakarta.validation.Valid;
import kr.ac.hansung.cse.model.Course;
import kr.ac.hansung.cse.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController { // 요청을 처리하고 결과를 뷰로 전달
    //Controller -> Service -> Dao
    @Autowired
    private CourseService courseService; // CourseController는 CourseService를 통해 데이터를 가져옴

    // 메인 페이지 (home.jsp로 이동
    @GetMapping("/")
    public String home() {
        return "home";
    }

    // 전체 학기별 이수 학점을 조회하고 총 학점 계산
    @GetMapping("/credits")
    public String showCreditSummary(Model model) {
        List<Object[]> creditSummary = courseService.getCreditSummary();
        int total = courseService.getTotalCredit(); // 총 학점

        model.addAttribute("summary", creditSummary);
        model.addAttribute("totalCredit", total);
        return "credits";
    }

    // 특정 연도 학기의 수강 과목 리스트 상세 조회
    @GetMapping("/credits/{year}/{semester}")
    public String showCourseDetail(@PathVariable("year") int year, @PathVariable("semester") int semester, Model model) {
        List<Course> courses = courseService.getCoursesBySemester(year, semester);
        model.addAttribute("courses", courses);
        return "coursedetail";
    }

    // 수강 신청 입력 폼
    @GetMapping("/register")
    public String showForm(Model model) {
        Course course = new Course();
        course.setYear(2025); // 기본값으로 설정
        course.setSemester(2); // 기본값으로 설정
        model.addAttribute("course", course);
        return "register";
    }

    // 수강 신청 폼을 제출하면 유효성 검사 수행 후 Courses 테이블에 저장
    // 유효성 실패 시 입력 폼 다시 출력
    @PostMapping("/register")
    public String doRegister(@Valid @ModelAttribute("course") Course course, BindingResult result) {
        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "register"; // 오류 발생 시 다시 form으로
        }

        // 오류 검증에 성공하면
        // Controller -> Service -> Dao
        courseService.insertCourse(course);
        return "registered";
    }

    // 2025년 2학기 수강 신청한 과목 목록 조회하여 보여줌
    @GetMapping("registerView")
    public String showRegisterView(Model model) {
        List<Course> list = courseService.getCoursesBySemester(2025, 2);
        model.addAttribute("courses", list);
        return "registerView";
    }
}