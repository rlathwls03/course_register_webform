package kr.ac.hansung.cse.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import kr.ac.hansung.cse.model.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    // Courses 테이블의 모든 수강 과목 조회
    public List<Course> getAllCourses() {
        return entityManager.createQuery("From Course", Course.class).getResultList();
    }

    // 특정 연도와 학기의 과목 리스트 반환
    public List<Course> getCoursesBySemester(int year, int semester) {
        return entityManager.createQuery("From Course WHERE year =:year AND semester = :semester", Course.class)
                .setParameter("year", year)
                .setParameter("semester", semester)
                .getResultList();
    }

    // 수강 신청 과목 DB에 저장
    public void insertCourse(Course course) {
        entityManager.persist(course);
    }

    //  연도/학기별 총 이수 학점을 그룹으로 집계하여 반환
    public List<Object[]> getCreditSummary() {
        return entityManager.createQuery(
                "SELECT c.year, c.semester, SUM(c.credit) FROM Course c GROUP BY c.year, c.semester ORDER BY c.year, c.semester",
                Object[].class
        ).getResultList();
    }

    // 전체 수강 과목의 이수 학점을 합산하여 반환
    public int getTotalCredit() {
        Long sum = entityManager.createQuery("SELECT SUM(credit) FROM Course", Long.class).getSingleResult();
        return sum != null ? sum.intValue() : 0;
    }
}