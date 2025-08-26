<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/jsp/include/_head.jspf" %>
<%@ include file="/jsp/include/_nav.jspf" %>

<c:set var="isModify" value="${not empty article}" />
<h4 class="mb-3"><c:out value="${isModify ? '게시글 수정' : '게시글 등록'}" /></h4>
<div class="card shadow-sm">
  <div class="card-body">
    <form method="post" enctype="multipart/form-data" action="${isModify ? '/article/modifyArticle.do' : '/article/registArticle.do'}">
      <c:if test="${isModify}">
      	<input type="hidden" name="aid" value="${article.aid}" />
      </c:if>
      <input type="hidden" name="mid" value="${sessionScope.loginMember.mid}" />
      <div class="mb-3">
        <select id="bid" name="bid" class="form-select" required>
          <option value="" ${empty param.bid && !(isModify) ? 'selected' : ''} disabled>게시판을 선택하세요</option>
      
          <c:forEach var="board" items="${boardList}">
            <option value="${board.bid}"
              <c:if test="${
                  (not empty param.bid and param.bid == board.bid) 
                  or (empty param.bid and isModify and article.bid == board.bid)
              }">selected</c:if>>
              <c:out value="${board.bname}"/>
            </option>
          </c:forEach>
        </select>
      </div>   
      <div class="mb-3">
        <label class="form-label required">제목</label>
        <input type="text" name="atitle" class="form-control" required maxlength="2000" 
         <c:if test="${isModify}">value="${article.atitle}"</c:if> />
      </div>
      <div class="mb-3">
        <label class="form-label">내용</label>
        <textarea name="acontent" class="form-control" rows="10"><c:if test="${isModify}">${article.acontent}</c:if></textarea>
      </div>
      <div class="row g-3">
        <div class="col-md-6">
          <label class="form-label">첨부파일</label>
          <input type="file" name="files" class="form-control" multiple />
        </div>
      </div>
      <div class="mt-3 d-flex gap-2">
        <button class="btn btn-primary" type="submit">${isModify ? '수정' : '등록'}</button>
        <a class="btn btn-outline-secondary" href="${cpath}/article/listArticle.do">목록</a>
      </div>
    </form>
  </div>
</div>
<%@ include file="/jsp/include/_foot.jspf" %>
