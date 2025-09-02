package com.authservice.authservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer headache;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer sleepQuality;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer breathingProblems;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer noiseLevel;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer livingConditions;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer safety;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer basicNeeds;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer academicPerformance;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer studyLoad;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer teacherStudentRelationship;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer futureCareerConcerns;

    @Min(0)
    @Max(3)
    @NotNull
    @Column(nullable = false)
    private Integer socialSupport;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer peerPressure;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer extracurricularActivities;

    @Min(0)
    @Max(5)
    @NotNull
    @Column(nullable = false)
    private Integer bullying;

    public Session() {}

    public Session(User user, Integer headache, Integer sleepQuality, Integer breathingProblems,
                Integer noiseLevel, Integer livingConditions, Integer safety, Integer basicNeeds,
                Integer academicPerformance, Integer studyLoad, Integer teacherStudentRelationship,
                Integer futureCareerConcerns, Integer socialSupport, Integer peerPressure,
                Integer extracurricularActivities, Integer bullying) {
        this.user = user;
        this.headache = headache;
        this.sleepQuality = sleepQuality;
        this.breathingProblems = breathingProblems;
        this.noiseLevel = noiseLevel;
        this.livingConditions = livingConditions;
        this.safety = safety;
        this.basicNeeds = basicNeeds;
        this.academicPerformance = academicPerformance;
        this.studyLoad = studyLoad;
        this.teacherStudentRelationship = teacherStudentRelationship;
        this.futureCareerConcerns = futureCareerConcerns;
        this.socialSupport = socialSupport;
        this.peerPressure = peerPressure;
        this.extracurricularActivities = extracurricularActivities;
        this.bullying = bullying;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getHeadache() {
        return headache;
    }

    public void setHeadache(Integer headache) {
        this.headache = headache;
    }

    public Integer getSleepQuality() {
        return sleepQuality;
    }

    public void setSleepQuality(Integer sleepQuality) {
        this.sleepQuality = sleepQuality;
    }

    public Integer getBreathingProblems() {
        return breathingProblems;
    }

    public void setBreathingProblems(Integer breathingProblems) {
        this.breathingProblems = breathingProblems;
    }

    public Integer getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(Integer noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public Integer getLivingConditions() {
        return livingConditions;
    }

    public void setLivingConditions(Integer livingConditions) {
        this.livingConditions = livingConditions;
    }

    public Integer getSafety() {
        return safety;
    }

    public void setSafety(Integer safety) {
        this.safety = safety;
    }

    public Integer getBasicNeeds() {
        return basicNeeds;
    }

    public void setBasicNeeds(Integer basicNeeds) {
        this.basicNeeds = basicNeeds;
    }

    public Integer getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(Integer academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    public Integer getStudyLoad() {
        return studyLoad;
    }

    public void setStudyLoad(Integer studyLoad) {
        this.studyLoad = studyLoad;
    }

    public Integer getTeacherStudentRelationship() {
        return teacherStudentRelationship;
    }

    public void setTeacherStudentRelationship(Integer teacherStudentRelationship) {
        this.teacherStudentRelationship = teacherStudentRelationship;
    }

    public Integer getFutureCareerConcerns() {
        return futureCareerConcerns;
    }

    public void setFutureCareerConcerns(Integer futureCareerConcerns) {
        this.futureCareerConcerns = futureCareerConcerns;
    }

    public Integer getSocialSupport() {
        return socialSupport;
    }

    public void setSocialSupport(Integer socialSupport) {
        this.socialSupport = socialSupport;
    }

    public Integer getPeerPressure() {
        return peerPressure;
    }

    public void setPeerPressure(Integer peerPressure) {
        this.peerPressure = peerPressure;
    }

    public Integer getExtracurricularActivities() {
        return extracurricularActivities;
    }

    public void setExtracurricularActivities(Integer extracurricularActivities) {
        this.extracurricularActivities = extracurricularActivities;
    }

    public Integer getBullying() {
        return bullying;
    }

    public void setBullying(Integer bullying) {
        this.bullying = bullying;
    }
}