<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/jsp/include/_head.jspf" %>
<%@ include file="/jsp/include/_nav.jspf" %>
<div class="d-flex justify-content-between align-items-center mb-3">
  <h4 class="mb-0">게시판 목록</h4>
  <a href="${cpath}/board/registBoard" class="btn btn-primary">게시판 등록</a>
</div>
<div class="card shadow-sm">
  <div class="table-responsive">
    <table class="table table-hover mb-0 align-middle">
      <thead class="table-light">
        <tr>
          <th scope="col">아이디</th>
          <th scope="col">게시판명</th>
          <th scope="col">등록일시</th>
          <th scope="col">삭제여부</th>
          <th scope="col" class="text-end">삭제</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="board" items="${boardList}" varStatus="st">
          <tr>
            <td>${board.bid}</td>
            <td><a href="${cpath}/article/listArticle?bid=${board.bid}">${board.bname}</a></td>
            <td><fmt:formatDate value="${board.bregdate}" pattern="yyyy-MM-dd HH:mm" /></td>
            <td><span class="badge ${board.bdelyn eq 'Y' ? 'bg-danger' : 'bg-success'}">${board.bdelyn}</span></td>
            <td class="text-end">
              <a class="btn btn-sm btn-outline-secondary" href="${cpath}/board/modifyBoard?bid=${board.bid}">[수정]</a>
              <a class="btn btn-sm btn-outline-danger" href="${cpath}/board/removeBoard?bid=${board.bid}" onclick="return confirm('삭제하시겠습니까?')">[삭제]</a>
            </td>
          </tr>
        </c:forEach>
        <c:if test="${empty boardList}">
          <tr><td colspan="5" class="text-center text-muted">등록된 게시판이 없습니다!</td></tr>
        </c:if>
      </tbody>
    </table>
  </div>
</div>
<%@ include file="/jsp/include/_foot.jspf" %>
