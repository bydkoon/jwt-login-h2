//package com.es.api.exception;
//
//@Override
//public Map<String, Object> getErrorAttributes(WebRequest request, boolean includeStackTrace) {
//        Map<String, Object> errorAttributes = new LinkedHashMap<>();
//        errorAttributes.put("timestamp", new Date()); // timestamp 생성
//        addStatus(errorAttributes, request); // status 생성
//        addErrorDetails(errorAttributes, request, includeStackTrace); // 오류 상세 내용
//        addPath(errorAttributes, request); // path 생성
//        return errorAttributes;
//        }
