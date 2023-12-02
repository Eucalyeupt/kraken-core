/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package fun.bigtable.kraken.page.result;

import fun.bigtable.kraken.bean.ApiPrivacy;

import java.util.List;

/**
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class PageInfo<T>{

    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;
    //加密
    private List<ApiPrivacy> privacy;

    public PageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param list          page结果
     */
    private PageInfo(List<T> list) {
        this.list = list;
        if (list instanceof Page) {
            Page page = (Page) list;
            this.total = page.getTotal();
            this.pages = page.getPages();
        }
    }

    public static <T>PageInfo<T> get(List<T> list) {
        return new PageInfo(list);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<ApiPrivacy> getPrivacy() {
        return privacy;
    }

    public void setPrivacy(List<ApiPrivacy> privacy) {
        this.privacy = privacy;
    }
}
