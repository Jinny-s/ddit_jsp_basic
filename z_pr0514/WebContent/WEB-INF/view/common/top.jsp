<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>JINNY's Member CRUD</title>
  <style type="text/css">
  	@font-face {
	    font-family: 'gmMedium';
	    src: url('/member/resources/css/GmarketSansTTFMedium.ttf') format('truetype');
	}
	body {
		font-family: 'gmMedium' !important;
  </style>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap/plugins/fontawesome-free/css/all.min.css' />">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap/dist/css/adminlte.min.css' />">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css' />">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap/plugins/datatables-responsive/css/responsive.bootstrap4.min.css' />">
  <link rel="stylesheet" href="<c:url value='/resources/bootstrap/plugins/datatables-buttons/css/buttons.bootstrap4.min.css' />">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="<c:url value='/main' />" class="nav-link">Main</a>
      </li>
    </ul>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="#" role="button">
          <i class="fas fa-expand-arrows-alt"></i>
        </a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="<c:url value='/main' />" class="brand-link">
      <img src="/member/resources/bootstrap/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">JINNY</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="/member/resources/bootstrap/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Administrator</a>
        </div>
      </div>

      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <li class="nav-item">
            <a href="<c:url value='/main' />" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>메인 페이지</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="<c:url value='/register' />" class="nav-link">
              <i class="nav-icon fas fa-user-plus"></i>
              <p>회원 등록</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="<c:url value='/list' />" class="nav-link">
              <i class="nav-icon far fa-address-book"></i>
              <p>전체 회원 목록</p>
            </a>
          </li>
        </ul>
      </nav>
    </div>
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">