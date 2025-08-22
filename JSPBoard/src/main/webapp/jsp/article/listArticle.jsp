<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/jsp/include/_head.jspf" %>
<%@ include file="/jsp/include/_nav.jspf" %>

<div class="d-flex flex-wrap justify-content-between align-items-center gap-2 mb-3">
  <h4 class="mb-0">게시글 목록</h4>
  <div class="d-flex gap-2">
    <form class="d-flex" method="get" action="${cpath}/article/listArticle">
      <input type="hidden" name="bid" value="${param.bid}" />
      <input class="form-control me-2" type="search" name="q" value="${param.q}" placeholder="검색어를 입력하세요!">
      <button class="btn btn-outline-secondary" type="submit">🔍</button>
    </form>
    <a class="btn btn-primary" href="${cpath}/article/registArticle?bid=${param.bid}">게시글 등록</a>
  </div>
</div>
<div class="card shadow-sm">
  <div class="table-responsive">
    <table class="table table-hover mb-0 align-middle">
      <thead class="table-light">
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>등록일시</th>
          <th>댓글수</th>
          <th>첨부파일수</th>
          <th>수정</th>
          <th>삭제</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="article" items="${articleList}">
          <tr>
            <td>${a.aid}</td>
            <td>
              <a href="${cpath}/article/getArticle?aid=${article.aid}">
                <c:out value="${article.atitle}"/>
              </a>
              <c:if test="${article.fileCount > 0}">
                <span class="badge text-bg-secondary">${article.fileCount}</span>
              </c:if>
            </td>
            <td>${article.mid}</td>
            <td>${article.acount}</td>
            <td>${article.afcount}</td>
            <td><fmt:formatDate value="${article.aregdate}" pattern="yyyy-MM-dd HH:mm"/></td>
            <td><span class="badge ${article.adelyn eq 'Y' ? 'bg-danger' : 'bg-success'}">${article.adelyn}</span></td>
          </tr>
        </c:forEach>
        <c:if test="${empty articleList}">
          <tr><td colspan="7" class="text-center text-muted">등록된 게시물이 없습니다!</td></tr>
        </c:if>
      </tbody>
    </table>
  </div>
</div>
<c:if test="${page.totalPages > 1}">
  <nav class="mt-3">
    <ul class="pagination justify-content-center">
      <li class="page-item ${page.number == 1 ? 'disabled' : ''}">
        <a class="page-link" href="${cpath}/article/listArticle?bid=${param.bid}&page=${page.number-1}&q=${param.q}">[이전]</a>
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
<%@ include file="/jsp/include/_foot.jspf" %>
