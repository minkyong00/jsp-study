<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<%@ include file="/jsp/include/_head.jspf" %>
<%@ include file="/jsp/include/_nav.jspf" %>

<c:set var="cpath" value="${pageContext.request.contextPath}" />

<style>
  /* 타이틀 배너 */
  .title-banner {
    height: 200px;
    border: 1px solid #dcdcdc;
    border-radius: .5rem;
    background: #f8f9fa url('${bannerUrl}') center/cover no-repeat;
    display: flex; align-items: center; justify-content: center;
    font-size: 1.5rem; color: #666;
  }
  /* 우측 사진 썸네일 고정 비율 */
  .photo-tile {
    width: 100%; aspect-ratio: 4 / 3;
    object-fit: cover; border-radius: .5rem; border:1px solid #e9ecef;
    background: #f1f3f5;
  }
  /* 리스트 카드 공통 */
  .section-card .card-header {
    font-weight: 600;
    background: #f8f9fa;
  }
  footer.site-footer {
    border-top: 1px solid #e9ecef; color:#666;
  }
</style>

<div class="container py-4">

  <!-- 타이틀 배너 -->
  <div class="title-banner mb-4">
    <span>타이틀 배너 이미지</span>
  </div>

  <!-- 3열 레이아웃 -->
  <div class="row g-4">

    <!-- 좌측: 등록된 게시판 목록 -->
    <div class="col-lg-3">
      <div class="card shadow-sm section-card h-100">
        <div class="card-header text-center">등록된 게시판 목록</div>
        <div class="card-body">
          <c:if test="${empty boardList}">
            <p class="text-muted mb-0">등록된 게시판이 없습니다.</p>
          </c:if>

          <div class="list-group list-group-flush">
            <c:forEach var="board" items="${boardList}">
              <div class="list-group-item d-flex justify-content-between align-items-center px-0">
                <span class="me-2"><c:out value="${board.bname}"/></span>
                <a class="btn btn-sm btn-outline-secondary"
                   href="${cpath}/article/listArticle.do?bid=${board.bid}">
                   게시물목록
                </a>
              </div>
            </c:forEach>
          </div>

          <div class="d-grid mt-3">
            <a class="btn btn-light border" href="${cpath}/board/listBoard.do">… 전체 보기</a>
          </div>
        </div>
      </div>
    </div>

    <!-- 가운데: 최근 게시물 + 최근 가입 회원 -->
    <div class="col-lg-6">
      <!-- 최근 게시물 -->
      <div class="card shadow-sm section-card mb-4">
        <div class="card-header text-center">최근 게시물</div>
        <div class="card-body p-0">
          <c:if test="${empty latestArticles}">
            <p class="text-muted p-3 mb-0">등록된 글이 없습니다.</p>
          </c:if>
          <ul class="list-group list-group-flush">
            <c:forEach var="article" items="${latestArticles}">
              <li class="list-group-item d-flex justify-content-between align-items-center">
                <div class="me-3 text-truncate" style="max-width: 70%;">
                  <c:if test="${not empty article.bname}">
                    <small class="text-muted"> [<c:out value="${article.bname}"/>]</small>
                  </c:if>
                  <a class="text-decoration-none"
                     href="${cpath}/article/getArticle.do?aid=${article.aid}&bid=${article.bid}&searchWord=${searchWord}&currPageNum=${currPageNum}">
                    <c:out value="${article.atitle}"/>
                  </a>
                </div>
                <small class="text-muted">
                  <fmt:formatDate value="${article.aregdate}" pattern="M/d HH:mm"/>
                </small>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>

      <!-- 최근 가입 회원 -->
      <div class="card shadow-sm section-card">
        <div class="card-header text-center">최근 가입 회원</div>
        <div class="card-body p-0">
          <c:if test="${empty latestMembers}">
            <p class="text-muted p-3 mb-0">최근 가입한 회원이 없습니다.</p>
          </c:if>
          <ul class="list-group list-group-flush">
            <c:forEach var="member" items="${latestMembers}">
              <li class="list-group-item d-flex justify-content-between align-items-center">
                <div class="text-truncate" style="max-width:70%;">
                  [<c:out value="${member.mid}"/>] <c:out value="${member.mname}"/>
                </div>
                <small class="text-muted">
                  <fmt:formatDate value="${member.mregdate}" pattern="M/d HH:mm"/>
                </small>
              </li>
            </c:forEach>
          </ul>
        </div>
      </div>
    </div>

    <!-- 우측: 최근 등록 사진 -->
    <div class="col-lg-3">
      <div class="card shadow-sm section-card h-100">
        <div class="card-header text-center">최근 등록 사진</div>
        <div class="card-body">
          <c:if test="${empty latestPhotos}">
            <p class="text-muted mb-0">등록된 사진이 없습니다.</p>
          </c:if>
		 
          <!-- 2열 썸네일 그리드 -->
          <div class="row row-cols-2 g-3">
            <c:forEach var="p" items="${latestPhotos}">
              <div class="col">
                <a href="${cpath}/article/getArticle.do?aid=${p.aid}&bid=${bid}&searchWord=${searchWord}&currPageNum=${currPageNum}" class="d-block">
                  <img class="photo-tile" src="${p.imgUrl}" alt="${p.title}" />
                </a>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </div>

  </div><!-- /row -->
</div><!-- /container -->

<%@ include file="/jsp/include/_foot.jspf" %>