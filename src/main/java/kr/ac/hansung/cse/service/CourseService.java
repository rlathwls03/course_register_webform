package kr.ac.hansung.cse.service;

import kr.ac.hansung.cse.dao.CourseDao;
import kr.ac.hansung.cse.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    // 전체 수강 과목 조회
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    // 특정 연도/학기의 수강 과목 리스트 반환
    public List<Course> getCoursesBySemester(int year, int semester) {
        return courseDao.getCoursesBySemester(year, semester);
    }

    // 신청한 수강 과목을 DB에 저장
    public void insertCourse(Course course) {
        courseDao.insertCourse(course);
    }

    // 연도/학기별 총 이수 학점을 집계하여 반환
    public List<Object[]> getCreditSummary() {
        return courseDao.getCreditSummary();
    }

    // 전체 이수 학점 총합을 계산하여 반환
    public int getTotalCredit() {
        return courseDao.getTotalCredit();
    }
}
