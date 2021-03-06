<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="cri" value="${pageMaker.cri}" />

<head></head>

<title>공지사항</title>

<body>
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지사항</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
				        <li class="breadcrumb-item">
				        	<a href="list.do">
					        	<i class="fa fa-dashboard"></i>공지사항
					        </a>
				        </li>
				        <li class="breadcrumb-item active">
				        	목록
				        </li>		        
	    	  		</ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	
	<section class="content">
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" onclick="">글등록</button>
				<div id="keyword" class="card-tools" style="width:550px;">
					<div class="input-group row">
						<select class="form-control col-md-3 mr-3" name="perPageNum" id="perPageNum" onchange="list_go();">
							<option value="10">정렬개수</option>						
							<option value="2" ${cri.perPageNum == 2 ? 'selected':''}>2개씩</option>						
							<option value="3" ${cri.perPageNum == 3 ? 'selected':''}>3개씩</option>						
							<option value="5" ${cri.perPageNum == 5 ? 'selected':''}>5개씩</option>						
						</select>
						
						<select class="form-control col-md-3" name="searchType" id="searchType">
							<option value="" ${cri.searchType eq '' ? 'selected':''}>검색구분</option>						
							<option value="t" ${cri.searchType eq 't' ? 'selected':''}>제목</option>						
							<option value="c" ${cri.searchType eq 'c' ? 'selected':''}>내용</option>						
							<option value="i" ${cri.searchType eq 'i' ? 'selected':''}>작성자</option>						
						</select>
						
						<input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${cri.keyword }" />
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" id="searchBtn" data-card-widget="search" onclick="list_go(1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
			<div class="card-body" style="text-align:center">
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered">
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
							<c:forEach items="${noticeList }" var="notice">
							<tr>
								<td>${notice.nno }</td>
								<td>${notice.title }</td>
								<td>${notice.writer }</td>
								<td><fmt:formatDate value="${notice.regdate }" pattern="yy-MM-dd"/></td>
								<td>${notice.viewcnt }</td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="card-footer">
				<c:set var="list_url" value="list.do" />
				<%@ include file="/WEB-INF/views/common/pagination.jsp" %>
			</div>				
		</div>	
	</section>
<script src="/resources/js/common.js"></script>
</body>