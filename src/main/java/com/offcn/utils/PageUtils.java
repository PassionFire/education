package com.offcn.utils;


import java.util.List;

public class PageUtils<T> {
    //页量
    private int pageSize;
    //当前页码
    private int currentPage;
    //总记录数
    private int total;
    //当前页的数据
    private List<T> pageData;

    public PageUtils(int pageSize, int currentPage, int total, List<T> pageData) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.total = total;
        this.pageData = pageData;
    }

    public PageUtils(){

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
