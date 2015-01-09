package drax.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 应用管理
 * @author zhangdaihao
 * @date 2013-08-09 15:19:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dx_app", schema = "")
@SuppressWarnings("serial")
public class DxApp implements java.io.Serializable {
    /**主键*/
    private java.lang.String id;

    /**名称*/
    private java.lang.String name;

    /**描述*/
    private java.lang.String desp;

    /**创建人*/
    private java.lang.String createBy;

    private String createUser;

    /**建创时间*/
    private java.util.Date createDate;

    private String theme;

    private String themeName;

    private String type;

    private String createDept;

    private String createDeptName;

    private String contentName;

    @Transient
    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    @Column(name = "create_dept", nullable = true, length = 36)
    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    @Transient
    public String getCreateDeptName() {
        return createDeptName;
    }

    public void setCreateDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
    }

    @Column(name = "type", nullable = true, length = 36)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Transient
    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    @Column(name = "theme", nullable = true, length = 36)
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Column(name = "CREATE_USER", nullable = true, length = 36)
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
       *方法: 取得java.lang.String
       *@return: java.lang.String  主键
       */

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 36)
    public java.lang.String getId() {
        return this.id;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  主键
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  名称
     */
    @Column(name = "NAME", nullable = false, length = 200)
    public java.lang.String getName() {
        return this.name;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  名称
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     *方法: 取得java.lang.Object
     *@return: java.lang.Object  描述
     */
    @Column(name = "DESP", nullable = true, length = 65535)
    public java.lang.String getDesp() {
        return this.desp;
    }

    /**
     *方法: 设置java.lang.Object
     *@param: java.lang.Object  描述
     */
    public void setDesp(java.lang.String desp) {
        this.desp = desp;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  创建人
     */
    @Column(name = "CREATE_BY", nullable = true, length = 36)
    public java.lang.String getCreateBy() {
        return this.createBy;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  创建人
     */
    public void setCreateBy(java.lang.String createBy) {
        this.createBy = createBy;
    }

    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  建创时间
     */
    @Column(name = "CREATE_DATE", nullable = true)
    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  建创时间
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }
}
