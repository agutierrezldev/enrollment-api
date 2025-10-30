package com.axlgutierrezl.enrollment_api.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(
        LocalDateTime datetime,
        String message,
        String path,
        int statusCode) {
}
