<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head></head>s

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
				<div id="keyword" class="card-tools" style="width:550px;">
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum" onchange="list_go();">
							<option value="10">정렬개수</option>						
							<option value="2">2개씩</option>						
							<option value="3">3개씩</option>						
							<option value="5">5개씩</option>						
						</select>
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
		</div>	
	</section>
<form id="pagination">
	<input type="hidden" name="page" value="" />
	<input type="hidden" name="perPageNum" value="" />
</form>	
<script type="text/javascript">

function list_go() {
	$('input[name="perPageNum"]').val($('select#perPageNum').val());
	
	$('form#pagination').attr({
		action:'list.do',
		method:'get'
	}).submit();
}

</script>
</body>