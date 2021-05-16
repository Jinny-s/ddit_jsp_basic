<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/top.jsp" %>

 <!-- Content Header (Page header) -->
 <div class="content-header">
   <div class="container-fluid">
     <div class="row mb-2">
       <div class="col-sm-6 mt-2">
         <h1 class="m-0">관리자 메인 페이지</h1>
       </div><!-- /.col -->
       <div class="col-sm-6">
         <ol class="breadcrumb float-sm-right">
           <li class="breadcrumb-item active"><a href="<c:url value='/main' />">Home</a></li>
         </ol>
       </div><!-- /.col -->
     </div><!-- /.row -->
   </div><!-- /.container-fluid -->
 </div>
 <!-- /.content-header -->

 <!-- Main content -->
 <div class="content">
   <div class="container-fluid">
     <div class="row">
       <div class="col-3 mt-2">
         <div class="info-box">
           <span class="info-box-icon bg-info"><i class="fas fa-users"></i></span>
           <div class="info-box-content">
             <span class="info-box-text">회원수</span>
             <span class="info-box-number"><c:out value="${fn:length(list) }"></c:out>&nbsp;명</span>
           </div>
           <!-- /.info-box-content -->
         </div>
       </div>  
       <div class="col-3 mt-2">
         <div class="info-box">
           <span class="info-box-icon bg-info"><i class="fas fa-user-plus"></i></span>
           <div class="info-box-content">
             <a href="<c:url value='/register' />">회원등록</a>
           </div>
           <!-- /.info-box-content -->
         </div>
       </div>  
     </div>
     <div class="row">
       <div class="col-6 mt-2">
         <div class="card">
           <div class="card-header">
             <h3 class="card-title"><a href="<c:url value='/list' />">전체목록관리</a></h3>
           </div>
           <!-- /.card-header -->
           <div class="card-body">
             <table id="example1" class="table table-bordered table-hover text-center">
               <thead>
               <tr>
                 <th>아이디</th>
                 <th>이메일</th>
                 <th>전화번호</th>
                 <th></th>
               </tr>
               </thead>
               <tbody>
               <c:if test="${empty list }">
				<tr>
					<td colspan="4">등록된 회원이 없습니다.</td>
				</tr>
			   </c:if>
			   <c:forEach items="${list }" var="list">
               <tr>
                 <td>${list.memId }</td>
                 <td>${list.memEmail }</td>
				 <td>${list.memHp }</td>
                 <td><a class="btn btn-outline-info btn-sm" onclick="fn_detail('${list.memId }');">관리</a></td>
               </tr>
               </c:forEach>           
               </tbody>
             </table>
           </div>
           <!-- /.card-body -->
         </div>
         <!-- /.card -->
       </div>
       <div id="ready" class="col-6 mt-2">
         <div class="card card-info">
           <div class="card-header">
             <h3 class="card-title">회원 정보</h3>
           </div>
           <!-- /.card-header -->
           <!-- form start -->
             <div class="card-body d-flex align-items-center justify-content-center" style="height: 300px;">
               <h5>조회할 회원의 관리 버튼을 눌러주세요.</h5>
             </div>
         </div>
       </div>
       <div id="detail" class="col-6 mt-2" style="display:none;">
         <div class="card card-info">
           <div class="card-header">
             <h3 class="card-title">회원 정보</h3>
           </div>
           <!-- /.card-header -->
           <!-- form start -->
           <form id="fm" class="form-horizontal" method="post">
             <div class="card-body">
               <div class="form-group row">
                 <label for="memId" class="col-sm-2 col-form-label">아이디</label>
                 <div class="col-sm-10">
                   <input type="text" class="form-control form-control-border" id="memId" name="memId" readonly="readonly" />
                 </div>
               </div>
               <div class="form-group row">
                 <label for="memPw" class="col-sm-2 col-form-label">비밀번호</label>
                 <div class="col-sm-10">
                   <input type="text" class="form-control form-control-border"  id="memPw" name="memPw" readonly="readonly" />
                 </div>
               </div>
               <div class="form-group row">
                 <label for="memEmail" class="col-sm-2 col-form-label">이메일</label>
                 <div class="col-sm-10">
                   <input type="email" class="form-control form-control-border" id="memEmail" name="memEmail" readonly="readonly" />
                 </div>
               </div>
               <div class="form-group row">
                 <label for="memHp" class="col-sm-2 col-form-label">전화번호</label>
                 <div class="col-sm-10">
                   <input type="text" class="form-control form-control-border" id="memHp" name="memHp" readonly="readonly" />
                 </div>
               </div>
             </div>
             <!-- /.card-body -->
             <div class="card-footer">
               <a class="btn btn-outline-info btn-sm" onclick="fn_update();">수정</a>
			   <a class="btn btn-outline-danger btn-sm" onclick="fn_delete();">삭제</a>
               <button type="button" class="btn btn-outline-secondary btn-sm float-right" onclick="fn_exit();">닫기</button>
             </div>
             <!-- /.card-footer -->
           </form>
         </div>
       </div>
     </div>
     <!-- /.row -->
   </div><!-- /.container-fluid -->
 </div>
 <!-- /.content -->

  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="float-right d-none d-sm-inline">
      DDIT 2021.01 #403
    </div>
    Copyright &copy; 2021 <a href="https://github.com/Jinny-s">Jinny Jeong</a> All rights reserved.
  </footer>
</div>

<script src="<c:url value='/resources/bootstrap/plugins/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/dist/js/adminlte.min.js' />"></script>
<!-- DataTables  & Plugins -->
<script src="<c:url value='/resources/bootstrap/plugins/datatables/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-responsive/js/dataTables.responsive.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-responsive/js/responsive.bootstrap4.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/dataTables.buttons.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/buttons.bootstrap4.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/jszip/jszip.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/pdfmake/pdfmake.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/pdfmake/vfs_fonts.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/buttons.html5.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/buttons.print.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/buttons.colVis.min.js' />"></script>
<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
  
  var list = [
	  <c:forEach items="${list}" var="member">
	  	{
			memId: '${member.memId}'
	  		, memPw: '${member.memPw}'
	  		, memEmail: '${member.memEmail}'
	  		, memHp: '${member.memHp}'
	  	},
	  </c:forEach>
  ];
  
  function fn_detail(memId) {
	  $('#ready').hide();
	  $.each(list, function(idx, member){
		  console.log(member);
		  if(member.memId === memId) {
			  $('#memId').val(member.memId);
			  $('#memPw').val(member.memPw);
			  $('#memEmail').val(member.memEmail);
			  $('#memHp').val(member.memHp);
		  }
	  });
	  $('#detail').show('fast');
	  
  }
  
  function fn_update() {
		$('#fm').attr('method', 'get');
		$('#fm').attr('action', "<c:url value='/update'/>");
		$('#fm').submit();
	  }

  function fn_delete() {
	if(confirm('회원정보를 삭제하시겠습니까?')) {
		$('#fm').attr('action', "<c:url value='/delete'/>");
		$('#fm').submit();
	}
  }
  
  function fn_exit() {
	  $('#detail').hide('fast', function(){
	  	$('#ready').show();
	  });
  }
  
</script>
</body>
</html>