package cn.wa.net.formbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2015/6/8.
 */
public class PageVo<T> implements Serializable {

    //如果分页，设置总条数
    Integer total =0;
    //当前页
    Integer currentPage =0;
    //每页条数
    Integer rowNum =0;


    List<T> rows = new ArrayList<T>();


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
