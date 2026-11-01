package org.example.paylensebackendspring.dto;

import org.example.paylensebackendspring.entity.ReportSnapshot;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record ReportSnapshotResponse(
        UUID id,
        String reportType,
        LocalDate periodStart,
        LocalDate periodEnd,
        String currency,
        String reportData,
        Instant generatedAt
) {
    public static ReportSnapshotResponse from(ReportSnapshot e) {
        return new ReportSnapshotResponse(
                e.getId(),
                e.getReportType(),
                e.getPeriodStart(),
                e.getPeriodEnd(),
                e.getCurrency(),
                e.getReportData(),
                e.getGeneratedAt()
        );
    }
}
