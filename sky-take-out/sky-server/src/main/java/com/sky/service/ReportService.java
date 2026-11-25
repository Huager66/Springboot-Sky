package com.sky.service;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ReportService {
    Object getTurnoverStatistics(LocalDate begin, LocalDate end);

    Object getUserStatistics(LocalDate begin, LocalDate end);

    Object getOrderStatistics(LocalDate begin, LocalDate end);

    Object getSalesTop10(LocalDate begin, LocalDate end);

    void exportBusinessData(HttpServletResponse response);
}
