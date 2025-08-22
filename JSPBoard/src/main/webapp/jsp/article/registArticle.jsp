<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/jsp/include/_head.jspf" %>
<%@ include file="/jsp/include/_nav.jspf" %>

<c:set var="isEdit" value="${not empty article}" />
<h4 class="mb-3"><c:out value="${isEdit ? '게시글 수정' : '게시글 등록'}" /></h4>
<div class="card shadow-sm">
  <div class="card-body">
    <form method="post" enctype="multipart/form-data" action="${cpath}/article/modifyArticle">
      <input type="hidden" name="bid" value="${param.bid != null ? param.bid : (isEdit ? article.bid : '')}" />
      <c:if test="${isEdit}">
        <input type="hidden" name="aid" value="${article.aid}" />
      </c:if>
      <div class="mb-3">
        <label class="form-label required">제목</label>
        <input type="text" name="atitle" class="form-control" required maxlength="2000" value="${isEdit ? article.atitle : ''}">
      </div>
      <div class="mb-3">
        <label class="form-label">내용</label>
        <textarea name="acontent" class="form-control" rows="10"><c:out value="${isEdit ? article.acontent : ''}"/></textarea>
      </div>
      <div class="row g-3">
        <div class="col-md-6">
          <label class="form-label">첨부파일</label>
          <input type="file" name="files" class="form-control" multiple />
        </div>
        <div class="col-md-6">
          <div class="form-check form-switch mt-4">
            <input class="form-check-input" type="checkbox" id="adelyn" name="adelyn" value="Y" <c:if test="${isEdit and article.adelyn eq 'Y'}">checked</c:if>>
            <label class="form-check-label" for="adelyn">삭제</label>
          </div>
        </div>
      </div>
      <div class="mt-3 d-flex gap-2">
        <button class="btn btn-primary" type="submit">등록</button>
        <a class="btn btn-outline-secondary" href="${cpath}/article/articleList?bid=${param.bid}">목록</a>
      </div>
    </form>
  </div>
</div>
<%@ include file="/jsp/include/_foot.jspf" %>
