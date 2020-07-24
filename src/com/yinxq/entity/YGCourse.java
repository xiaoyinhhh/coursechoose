package com.yinxq.entity;

public class YGCourse {
    private int id;
    private String courseNo;
    private String courseName;
    private double score;
    private double courseHour;
    private int termId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(double courseHour) {
        this.courseHour = courseHour;
    }

    public int getTermId() {
        return termId;
    }

    public void setTermId(int termId) {
        this.termId = termId;
    }
}
