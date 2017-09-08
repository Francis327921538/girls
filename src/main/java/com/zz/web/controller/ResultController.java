package com.zz.web.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultController {

    public Map<String, Object> resultMap(Boolean success, String message, Object entity) {
        Map<String, Object> resultMap = new HashMap<>();

        resultMap.put("success", success);
        resultMap.put("message", message);
        resultMap.put("entity", entity);
        return resultMap;
    }

    public Map<String, Object> resultMap(Boolean success, Object entity) {
        return this.resultMap(success, null, entity);
    }

    public Map<String, Object> resultMap(Boolean success, List entity, boolean emptyNotify) {
        String message = null;
        if ((null == entity || 0 == entity.size()) && emptyNotify) {
            message = "未查询到相关数据";
        }
        return this.resultMap(success, message, entity);
    }

    /**
     * 返回实体类型一般都为query, 默认提醒没有数据时提醒
     * 对于Map类型的数据放在客户端判断有无记录
     */
    public Map<String, Object> resultMap(Boolean success, List entity) {
        return resultMap(success, entity, true);
    }

    public Map<String, Object> resultMap(Boolean success, String message) {
        return this.resultMap(success, message, null);
    }
//
//    @ExceptionHandler
//    public void exp(HttpServletResponse response, Exception e) throws IOException {
////        未取得授权异常
//    	response.setContentType("text/html;charset=UTF-8");
//        if (e instanceof UnauthenticatedException || e instanceof UnauthorizedException) {
//
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getWriter().write(new Gson().toJson(resultMap(false, "您没有权限", e.getMessage())));
//        } else if (e instanceof OverTimesException) {
//			response.setStatus(9001);
//			response.getWriter().write(new Gson().toJson(resultMap(false, "系统异常", e.getMessage())));
//		} else {
////            其他异常
//            response.setStatus(9999);
//            response.getWriter().write(new Gson().toJson(resultMap(false, "系统异常", "系统异常")));
//        }
//    }

    
}
