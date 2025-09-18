<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Category</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #0f172a, #1e293b);
        min-height: 100vh;
        padding: 30px;
        color: #f1f5f9;
        font-family: 'Segoe UI', sans-serif;
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
    }

    .form-control {
        background: rgba(255,255,255,0.05);
        border: 1px solid rgba(255,255,255,0.2);
        border-radius: 10px;
        color: #f1f5f9;
        transition: all .2s;
    }

    .form-control:focus {
        border-color: #38bdf8;
        box-shadow: 0 0 0 3px rgba(56,189,248,0.3);
        background: rgba(255,255,255,0.08);
    }

    .btn {
        border-radius: 10px;
        transition: transform .2s ease, box-shadow .2s ease;
    }

    .btn:hover {
        transform: translateY(-2px);
        box-shadow: 0 6px 20px rgba(0,0,0,0.3);
    }

    .btn-primary {
        background: linear-gradient(90deg, #3b82f6, #2563eb);
        border: none;
    }

    .btn-secondary {
        background: linear-gradient(90deg, #6b7280, #4b5563);
        border: none;
    }

    table {
        color: #f1f5f9;
    }

    thead {
        background: rgba(255,255,255,0.05);
    }

    tbody tr {
        transition: background .2s;
    }

    tbody tr:hover {
        background: rgba(56,189,248,0.1);
    }

    .btn-outline-warning, .btn-outline-danger {
        border-radius: 8px;
        padding: 4px 10px;
        transition: transform .2s;
    }

    .btn-outline-warning:hover, .btn-outline-danger:hover {
        transform: scale(1.1);
    }

    @keyframes fadeInUp {
        from { opacity: 0; transform: translateY(20px); }
        to   { opacity: 1; transform: translateY(0); }
    }
</style>
</head>
<body>
<section class="container">
<div class="card">
    <div class="card-header">
        <i class="fas fa-search"></i> Search Category
    </div>
    <div class="card-body">
        <form action="<c:url value='/admin/categories/search' />" method="GET" class="mb-4">
            <div class="row g-2">
                <div class="col-md-8">
                    <input type="text" name="name" class="form-control" placeholder="Enter category name...">
                </div>
                <div class="col-md-4 d-flex gap-2">
                    <button type="submit" class="btn btn-primary flex-fill">
                        <i class="fas fa-search"></i> Search
                    </button>
                    <a href="<c:url value='/admin/categories' />" class="btn btn-secondary flex-fill">
                        <i class="fas fa-list"></i> All
                    </a>
                </div>
            </div>
        </form>

        <div class="table-responsive">
        <table class="table align-middle">
            <thead>
                <tr>
                    <th>Category ID</th>
                    <th>Category Name</th>
                    <th>Images</th>
                    <th class="text-center">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.categoryName}</td>
                    <td>${category.images}</td>
                    <td class="text-center">
                        <a href="/admin/categories/edit/${category.id}" class="btn btn-outline-warning btn-sm">
                            <i class="fa fa-edit"></i>
                        </a>
                        <a href="/admin/categories/delete/${category.id}" class="btn btn-outline-danger btn-sm">
                            <i class="fa fa-trash"></i>
                        </a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</div>
</section>
</body>
</html>
