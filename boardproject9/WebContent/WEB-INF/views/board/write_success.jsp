<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/" /> 
<script>
  alert("작성하신 게시글이 게시되었습니다");
  location.href = "${root}board/read?board_info_idx=${writeContentBean.content_idx=${writeContentBena.content_idx}";
</script>