package io.github.brightqin.personplan.entity;

import io.github.brightqin.personplan.util.DateCheckUtil;

import javax.persistence.*;
import java.util.Date;

/**
 * @author brightqin
 * @date 2018/6/12
 */
@Entity
public class Step {

    public static final String[] TBL_STEP_TITLE = {"编号", "名称", "计划开始时间", "计划完成时间", "实际开始时间", "实际完成时间", " 步骤创建时间"};
    /**
     * 请自行根据javabean的设计修改本函数代码，col表示界面表格中的列序号，0开始
     */
    /**
     * 步骤编号
     */

    private Long stepId;
    /**
     * 计划编号
     */
    private Plan plan;
    /**
     * 步骤名称
     */
    private String stepName;
    /**
     * 计划开始时间
     */
    private Date planStarDate;
    /**
     * 计划完成时间
     */
    private Date planFinishDate;
    /**
     * 实际开始时间
     */
    private Date actualStarDate;
    /**
     * 实际完成时间
     */
    private Date actualFinishDate;
    /**
     * 步骤创建时间
     */
    private Date stepCreateTime;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "planId")
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public Date getPlanStarDate() {
        return planStarDate;
    }

    public void setPlanStarDate(Date planStarDate) {
        this.planStarDate = planStarDate;
    }

    public Date getPlanFinishDate() {
        return planFinishDate;
    }

    public void setPlanFinishDate(Date planFinishDate) {
        this.planFinishDate = planFinishDate;
    }

    public Date getActualStarDate() {
        return actualStarDate;
    }

    public void setActualStarDate(Date actualStarDate) {
        this.actualStarDate = actualStarDate;
    }

    public Date getActualFinishDate() {
        return actualFinishDate;
    }

    public void setActualFinishDate(Date actualFinishDate) {
        this.actualFinishDate = actualFinishDate;
    }

    public Date getStepCreateTime() {
        return stepCreateTime;
    }

    public void setStepCreateTime(Date stepCreateTime) {
        this.stepCreateTime = stepCreateTime;
    }

    @Override
    public String toString() {
        return String.format("Step[stepId = %d,planId = %d,stepName = %s,planStarDate = %s," +
                        "planFinishDate = %s,actualStarDate = %s,actualFinishDate = %s,stepCreateTime = %s]",
                stepId, plan.getPlanId(), stepName, DateCheckUtil.convertDate(planStarDate), DateCheckUtil.convertDate(planFinishDate)
                , DateCheckUtil.convertDate(actualStarDate), DateCheckUtil.convertDate(actualFinishDate), DateCheckUtil.convertDate(stepCreateTime));
    }

    /**
     * "编号","名称","计划开始时间","计划完成时间","实际开始时间","实际完成时间","创建时间"
     */
    public String getCell(int col) {
        switch (col) {
            case 0:
                return String.valueOf(this.stepId);
            case 1:
                return String.valueOf(this.stepName);
            case 2:
                return String.valueOf(this.planStarDate);
            case 3:
                return String.valueOf(this.planFinishDate);
            case 4:
                return String.valueOf(this.actualStarDate);
            case 5:
                return String.valueOf(this.actualFinishDate);
            case 6:
                return String.valueOf(this.stepCreateTime);
            default:
                return "";
        }
    }
}
