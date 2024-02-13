package org.personal.shopping.global.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageHandler {

    private int totalCnt; // 총 갯수
    private int pageSize; // 한 페이지당 크기
    private int naviSize = 5; // 페이지 내비게이션 크기
    private int totalPageSize; // 페이지 총 크기
    private int naviBegin; // 내비게이션 첫번째
    private int naviEnd; // 내비게이션 마지막
    private int page; // 현재 페이지
    private boolean showPrev; // 이전 페이지로 이동 보여줄지 여부
    private boolean showNext; // 다음 페이지로 이동 보여줄지 여부


    public PageHandler(int totalCnt, int page, int pageSize) {

        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPageSize = (int) Math.ceil(totalCnt / (double) pageSize);
        naviBegin = (page - 1) / naviSize * naviSize + 1;
        naviEnd = Math.min(naviBegin + naviSize - 1, totalPageSize);
        showPrev = naviBegin != 1;
        showNext = naviEnd != totalPageSize;
    }

    // 페이지 offest 계산
    public static int pageOffset(int page, int pageSize) {

        return Math.max((page - 1) * pageSize, 0);
    }
}
