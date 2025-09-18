<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Video</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
<style>
    body {
        background: linear-gradient(135deg, #0f172a, #1e293b);
        color: #f1f5f9;
        font-family: 'Segoe UI', sans-serif;
        padding: 20px;
        min-height: 100vh;
    }
    .card {
        background: rgba(30,41,59,0.95);
        border-radius: 16px;
        border: none;
        box-shadow: 0 12px 40px rgba(0,0,0,0.4);
        animation: fadeInUp .6s ease;
    }
    .card-header {
        background: linear-gradient(90deg, #3b82f6, #2563eb);
        border-radius: 16px 16px 0 0;
        color: white;
        padding: 15px 20px;
        font-weight: 600;
        font-size: 1.5rem;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    .card-header a {
        margin-left: 10px;
        color: white;
        transition: transform .2s, box-shadow .2s;
    }
    .card-header a:hover {
        transform: translateY(-2px);
        box-shadow: 0 4px 10px rgba(0,0,0,0.3);
    }
    .table {
        color: #f1f5f9;
    }
    .table thead {
        background: #1e293b;
    }
    .table tbody tr:hover {
        background: rgba(59,130,246,0.2);
        transition: background .3s;
    }
    .btn-outline-warning:hover {
        background-color: #facc15;
        color: black;
    }
    .btn-outline-danger:hover {
        background-color: #ef4444;
        color: white;
    }
    @keyframes fadeInUp {
        from { opacity: 0; transform: translateY(20px); }
        to   { opacity: 1; transform: translateY(0); }
    }
</style>
</head>
<body>
<section class="row">
<div class="col mt-4">
<div class="card">
    <div class="card-header">
        <span><i class="fas fa-search"></i> Search Video</span>
        <span>
            <a href="<c:url value='/admin/videos'/>" class="btn btn-secondary btn-sm"><i class="fas fa-list"></i> All Videos</a>
        </span>
    </div>
    <div class="card-body">
        <form action="<c:url value='/admin/videos/search' />" method="GET">
            <div class="row mb-3">
                <div class="col-md-8">
                    <input type="text" name="keyword" class="form-control" placeholder="Enter title or description to search">
                </div>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-primary"><i class="fas fa-search"></i> Search</button>
                </div>
            </div>
        </form>
        <hr>
        <div class="table-responsive">
        <table class="table table-striped table-hover align-middle">
            <thead>
                <tr>
                    <th>Video ID</th>
                    <th>Title</th>
                    <th>Category</th>
                    <th>Views</th>
                    <th>Shares</th>
                    <th>Is Active</th>
                    <th>Create Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${videos}" var="video">
                <tr>
                    <td>${video.id}</td>
                    <td>${video.title}</td>
                    <td>${video.category.categoryName}</td>
                    <td>${video.views}</td>
                    <td>${video.shares}</td>
                    <td>${video.isActive ? 'Yes' : 'No'}</td>
                    <td>${video.createDate}</td>
                    <td>
                        <a href="/admin/videos/edit/${video.id}" class="btn btn-outline-warning btn-sm"><i class="fa fa-edit"></i></a>
                        <a href="/admin/videos/delete/${video.id}" class="btn btn-outline-danger btn-sm"><i class="fa fa-trash"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>
</div>
</section>
</body>
</html>
