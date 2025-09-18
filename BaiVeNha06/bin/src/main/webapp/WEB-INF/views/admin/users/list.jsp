<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Users</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
<style>
    body {
        background: linear-gradient(135deg, #0f172a, #1e293b);
        color: #f1f5f9;
        font-family: 'Segoe UI', sans-serif;
        padding: 30px;
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

    table {
        color: #f1f5f9;
    }

    th, td {
        vertical-align: middle !important;
    }

    .btn-outline-warning:hover {
        background-color: #facc15;
        color: #1e293b;
    }

    .btn-outline-danger:hover {
        background-color: #ef4444;
        color: white;
    }

    .alert-primary {
        background-color: #3b82f6;
        color: white;
        border: none;
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
        <span><i class="fas fa-users"></i> List Users</span>
        <span>
            <a href="<c:url value='/admin/users/add'/>" class="btn btn-primary btn-sm"><i class="fas fa-plus"></i> Add</a>
            <a href="<c:url value='/admin/users/search'/>" class="btn btn-info btn-sm"><i class="fas fa-search"></i> Search</a>
        </span>
    </div>
    <div class="card-body">
        <c:if test="${message != null}">
            <div class="alert alert-primary" role="alert">
                <i>${message}</i>
            </div>
        </c:if>
        <div class="table-responsive">
        <table class="table table-hover align-middle">
            <thead class="table-dark">
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Full Name</th>
                    <th>Is Admin</th>
                    <th>Is Active</th>
                    <th>Create Date</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.fullname}</td>
                        <td>${user.isAdmin ? 'Yes' : 'No'}</td>
                        <td>${user.isActive ? 'Yes' : 'No'}</td>
                        <td>${user.createDate}</td>
                        <td>
                            <a href="/admin/users/edit/${user.id}" class="btn btn-outline-warning btn-sm"><i class="fa fa-edit"></i></a>
                            <a href="/admin/users/delete/${user.id}" class="btn btn-outline-danger btn-sm"><i class="fa fa-trash"></i></a>
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
