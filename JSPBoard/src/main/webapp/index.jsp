<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/jsp/include/_head.jspf" %>
<%@ include file="/jsp/include/_nav.jspf" %>

<div class="py-4">
  <div class="row g-4">
    <div class="col-md-6">
      <div class="card shadow-sm">
        <div class="card-body">
          <h5 class="card-title">:: JSPBOARD ::</h5>
          <p class="card-text">MVC패턴을 활용한 JSP게시판</p>
          <a class="btn btn-primary" href="${cpath}/board/listBoard">게시판 목록</a>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="card shadow-sm">
        <div class="card-body">
          <h5 class="card-title">최근 게시물</h5>
          <c:if test="${empty latestArticles}">
            <p class="text-muted">등록된 글이 없습니다.</p>
          </c:if>
          <ul class="list-group">
            <c:forEach var="article" items="${latestArticles}">
              <li class="list-group-item d-flex justify-content-between align-items-center">
                <a href="${cpath}/article/getArticle?aid=${article.aid}"><c:out value="${article.atitle}"/></a>
                <small class="text-muted"><fmt:formatDate value="${article.aregdate}" pattern="yyyy-MM-dd HH:mm"/></small>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="/jsp/include/_foot.jspf" %>
