<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/jsp/include/_head.jspf" %>
<%@ include file="/jsp/include/_nav.jspf" %>

<div class="d-flex justify-content-between align-items-start mb-3">
  <div>
    <h4 class="mb-1"><c:out value="${article.atitle}"/></h4>
    <div class="text-muted">
      <p>아이디 : ${article.aid}
	      &nbsp;&nbsp;작성자 : ${article.mid}
	      &nbsp;&nbsp;댓글수 : ${article.acount}
	      &nbsp;&nbsp;첨부파일수 : ${article.afcount}
	      &nbsp;&nbsp;등록일시 : <fmt:formatDate value="${article.aregdate}" pattern="yyyy-MM-dd HH:mm"/>
      </p>
    </div>
  </div>
  <div class="btn-group">
    <a class="btn btn-outline-secondary btn-sm" href="${cpath}/article/modifyArticle.do?aid=${article.aid}">수정</a>
    <a class="btn btn-outline-danger btn-sm" href="${cpath}/article/removeArticle.do?aid=${article.aid}" onclick="return confirm('삭제 하시겠습니까?')">삭제</a>
  </div>
</div>

<div class="card shadow-sm mb-3">
  <div class="card-body">
    <pre class="mb-0"><c:out value="${article.acontent}"/></pre>
  </div>
</div>

<!-- Attach files -->
<%--
<div class="card shadow-sm mb-3">
  <div class="card-header bg-light">첨부파일</div>
  <ul class="list-group list-group-flush">
    <c:forEach var="f" items="${files}">
      <li class="list-group-item d-flex justify-content-between align-items-center">
        <span><i class="bi bi-paperclip"></i> <c:out value="${f.afcfname}"/></span>
        <a class="btn btn-sm btn-outline-primary" href="${cpath}/file/download?afid=${f.afid}">[다운로드]</a>
      </li>
    </c:forEach>
    <c:if test="${empty files}"><li class="list-group-item text-muted">첨부파일이 없습니다!</li></c:if>
  </ul>
</div>
 --%>
 
<!-- Replies -->
<%--
<div class="card shadow-sm">
  <div class="card-header bg-light">댓글</div>
  <div class="card-body">
    <form class="mb-3" method="post" action="${cpath}/reply/registReply">
      <input type="hidden" name="aid" value="${article.aid}" />
      <div class="input-group">
        <input type="text" name="rcontent" class="form-control" placeholder="댓글 내용을 입력해 주세요!" required maxlength="2000">
        <button class="btn btn-primary" type="submit">댓글 등록</button>
      </div>
    </form>
    <ul class="list-group">
      <c:forEach var="reply" items="${replieList}">
        <li class="list-group-item d-flex justify-content-between align-items-start">
          <div>
            <div><c:out value="${reply.rcontent}"/></div>
            <div class="text-muted small">${reply.mid}<fmt:formatDate value="${reply.rregdate}" pattern="yyyy-MM-dd HH:mm"/>
            </div>
          </div>
          <div class="btn-group btn-group-sm">
            <a class="btn btn-outline-secondary" href="${cpath}/reply/modifyReply?rid=${reply.rid}">[수정]</a>
            <a class="btn btn-outline-danger" href="${cpath}/reply/removeReply?rid=${reply.rid}&aid=${article.aid}" onclick="return confirm('삭제 하시겠습니까?')">[삭제]</a>
          </div>
        </li>
      </c:forEach>
      <c:if test="${empty replieList}"><li class="list-group-item text-muted">등록된 댓글이 없습니다!</li></c:if>
    </ul>
  </div>
</div>
 --%>
 
<div class="mt-3">
  <a class="btn btn-outline-secondary" href="${cpath}/article/listArticle.do">목록으로</a>
</div>

<%@ include file="/jsp/include/_foot.jspf" %>
