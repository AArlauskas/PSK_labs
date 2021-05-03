package lt.vu.mybatis.model;

public class Movie {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MOVIE.ID
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MOVIE.RATING
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    private Integer rating;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MOVIE.REVENUE
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    private Double revenue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MOVIE.TITLE
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MOVIE.COMPANY_ID
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    private Integer companyId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MOVIE.ID
     *
     * @return the value of PUBLIC.MOVIE.ID
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MOVIE.ID
     *
     * @param id the value for PUBLIC.MOVIE.ID
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MOVIE.RATING
     *
     * @return the value of PUBLIC.MOVIE.RATING
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MOVIE.RATING
     *
     * @param rating the value for PUBLIC.MOVIE.RATING
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MOVIE.REVENUE
     *
     * @return the value of PUBLIC.MOVIE.REVENUE
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public Double getRevenue() {
        return revenue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MOVIE.REVENUE
     *
     * @param revenue the value for PUBLIC.MOVIE.REVENUE
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MOVIE.TITLE
     *
     * @return the value of PUBLIC.MOVIE.TITLE
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MOVIE.TITLE
     *
     * @param title the value for PUBLIC.MOVIE.TITLE
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MOVIE.COMPANY_ID
     *
     * @return the value of PUBLIC.MOVIE.COMPANY_ID
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MOVIE.COMPANY_ID
     *
     * @param companyId the value for PUBLIC.MOVIE.COMPANY_ID
     *
     * @mbg.generated Wed Mar 31 13:21:49 EEST 2021
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}