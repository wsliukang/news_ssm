package cn.lk.newsssm.entity;

import java.util.Date;

/**
 * @author CharlesLiu
 *
 */
public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.Id
     *
     * @mbggenerated
     */
    private Integer id;
    
    private int floor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.news_id
     *
     * @mbggenerated
     */
    private Integer newsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.nickname
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.favour
     *
     * @mbggenerated
     */
    private int favour;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.disfavour
     *
     * @mbggenerated
     */
    private int disfavour;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column comment.comment_time
     *
     * @mbggenerated
     */
    private Date commentTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.Id
     *
     * @return the value of comment.Id
     *
     * @mbggenerated
     */
    public int getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.Id
     *
     * @param id the value for comment.Id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.news_id
     *
     * @return the value of comment.news_id
     *
     * @mbggenerated
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.news_id
     *
     * @param newsId the value for comment.news_id
     *
     * @mbggenerated
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.user_id
     *
     * @return the value of comment.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.user_id
     *
     * @param userId the value for comment.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.nickname
     *
     * @return the value of comment.nickname
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.nickname
     *
     * @param nickname the value for comment.nickname
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.content
     *
     * @return the value of comment.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.content
     *
     * @param content the value for comment.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.favour
     *
     * @return the value of comment.favour
     *
     * @mbggenerated
     */
    public int getFavour() {
        return favour;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.favour
     *
     * @param favour the value for comment.favour
     *
     * @mbggenerated
     */
    public void setFavour(int favour) {
        this.favour = favour;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.disfavour
     *
     * @return the value of comment.disfavour
     *
     * @mbggenerated
     */
    public int getDisfavour() {
        return disfavour;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.disfavour
     *
     * @param disfavour the value for comment.disfavour
     *
     * @mbggenerated
     */
    public void setDisfavour(Integer disfavour) {
        this.disfavour = disfavour;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column comment.comment_time
     *
     * @return the value of comment.comment_time
     *
     * @mbggenerated
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column comment.comment_time
     *
     * @param commentTime the value for comment.comment_time
     *
     * @mbggenerated
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

	public int getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}
    
    
}