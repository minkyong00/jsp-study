<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/jsp/include/_head.jspf" %>
<%@ include file="/jsp/include/_nav.jspf" %>

<div class="d-flex flex-wrap justify-content-between align-items-center gap-2 mb-3">
  <h4 class="mb-0">게시글 목록</h4>
  <div class="d-flex gap-2">
    <form class="d-flex" method="get" action="${cpath}/article/listArticle.do">
      <input type="hidden" name="bid" value="${param.bid}" />
      <input class="form-control me-2" type="search" name="q" value="${param.q}" placeholder="검색어를 입력하세요!">
      <button class="btn btn-outline-secondary" type="submit">🔍</button>
    </form>
    <a class="btn btn-primary" href="${cpath}/article/registArticle.do?bid=${param.bid}">게시글 등록</a>
  </div>
</div>
<div class="card shadow-sm">
  <div class="table-responsive">
    <table class="table table-hover mb-0 align-middle">
      <thead class="table-light">
        <tr>
          <th>번호</th>
          <th>게시판</th>
          <th>제목</th>
          <th>작성자</th>
          <th>등록일시</th>
          <th>댓글수</th>
          <th>첨부파일수</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="article" items="${articleList}">
          <tr>
            <td>${article.aid}</td>
            <td>${article.bname}</td>
            <td>
              <a href="${cpath}/article/getArticle.do?aid=${article.aid}">
                <c:out value="${article.atitle}"/>
              </a>
            </td>
            <td>${article.mid}</td>
            <td><fmt:formatDate value="${article.aregdate}" pattern="yyyy-MM-dd HH:mm"/></td>
            <td>${article.acount}</td>
            <td>${article.afcount}</td>
          </tr>
        </c:forEach>
        <c:if test="${empty articleList}">
          <tr><td colspan="7" class="text-center text-muted">등록된 게시물이 없습니다!</td></tr>
        </c:if>
      </tbody>
    </table>
  </div>
</div>
<%--
<c:if test="${page.totalPages > 1}">
  <nav class="mt-3">
    <ul class="pagination justify-content-center">
      <li class="page-item ${page.number == 1 ? 'disabled' : ''}">
        <a class="page-link" href="${cpath}/article/listArticle.do?bid=${param.bid}&page=${page.number-1}&q=${param.q}">[이전]</a>
      </li>
      <c:forEach var="p" begin="1" end="${page.totalPages}">
        <li class="page-item ${p == page.number ? 'active' : ''}"><a class="page-link" href="${cpath}/article/list?bid=${param.bid}&page=${p}&q=${param.q}">${p}</a></li>
      </c:forEach>
      <li class="page-item ${page.number == page.totalPages ? 'disabled' : ''}">
        <a class="page-link" href="${cpath}/article/list?bid=${param.bid}&page=${page.number+1}&q=${param.q}">[다음]</a>
      </li>
    </ul>
  </nav>
</c:if>
--%>
<%@ include file="/jsp/include/_foot.jspf" %>
